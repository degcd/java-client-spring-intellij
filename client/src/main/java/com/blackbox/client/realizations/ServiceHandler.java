package com.blackbox.client.realizations;

import blackbox.usermanagement.common.interfaces.UserManagementRemote;
import com.blackbox.client.interfaces.GamePlayManagementHandler;
import com.blackbox.client.interfaces.StatisticCalculatorHandler;
import com.blackbox.client.interfaces.UserManagementHandler;
import interfaces.GameplayManagementRemote;
import interfaces.StatisticCalculatorRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceHandler implements GamePlayManagementHandler, StatisticCalculatorHandler, UserManagementHandler {

    private static ServiceHandler instance;
    private Context ctx;
    private GameplayManagementRemote gameplayManagement;
    private StatisticCalculatorRemote statisticCalculator;
    private UserManagementRemote userManagement;

    private ServiceHandler(){

        try {
//            Properties h = new Properties();
//            h.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
//            h.put(Context.PROVIDER_URL, "localhost:9990");
//            h.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
            this.ctx = new InitialContext();
            this.ctx.addToEnvironment("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
            ctx.addToEnvironment("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
            ctx.addToEnvironment(Context.PROVIDER_URL,"jnp://localhost:1099");
            this.gameplayManagement = (GameplayManagementRemote) ctx.lookup("java:global/Game-ear/Game-ejb/GameplayManagementBean!interfaces.GameplayManagementRemote");
//            DataSource datasource = (DataSource) initialContext.lookup("java:comp/env/jdbc/myJndiResource");
//            this.statisticCalculator = (StatisticCalculatorRemote) ctx.lookup("");
//            this.userManagement = (UserManagementRemote) ctx.lookup("");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static ServiceHandler getInstance(){
        if(instance == null){
            instance = new ServiceHandler();
        }
        return instance;
    }

    //////////////GAMEPLAY-AREA//////////////////////
    @Override
    public void sendMsgToServer(String pMsg) {
//        this.gameplayManagement.receiveMsgFromClient(pMsg);
    }

    @Override
    public void sendMsgToServer(long pID) {
        this.gameplayManagement.receiveMsgFromClient(pID);
    }

    //////////////STATISTIC-AREA//////////////////////
    @Override /////////return Value ! auch in Interface
    public void getStatistics(long userId) {
//        this.statisticCalculator.getStatistics(userId);
    }

    //////////////USER-MANAGEMENT-AREA//////////////////////
    @Override
    public boolean registerUser(String email, String password) {// warum long zurück??
        long x = this.userManagement.register(email, password);
        if( x == 0){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean changePassword(String email, String oldPw, String newPw) {
        return this.userManagement.changePassword(email, oldPw, newPw);
    }

    @Override
    public boolean logIn(String email, String password) {
        return this.userManagement.logIn(email, password);
    }

    @Override
    public boolean logOut(String email) {
        return this.userManagement.logOut(email);
    }


}
