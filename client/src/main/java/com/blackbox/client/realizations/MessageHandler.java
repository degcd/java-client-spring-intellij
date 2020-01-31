package com.blackbox.client.realizations;


import javax.annotation.Resource;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessageHandler implements MessageListener {

    private Context ctx;

    @Resource(lookup="java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    private JMSContext jmsContext;

    //topic for publish/subscribe
    @Resource(lookup="java:global/jms/MessageTopic")
    private Topic messageTopic;

    private Topic answers;


    //TODO List/Queue mit Messages, aus die sich Controller dann holt?

    public MessageHandler(){
        try {
            this.ctx = new InitialContext();
            this.initializeJmsConnections();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    /* stellt JMS-Verbindung mit Queue her*/
    private void initializeJmsConnections(){
        try {
            jmsContext = connectionFactory.createContext();
            this.messageTopic = (Topic) this.ctx.lookup("java:global/jms/MessageTopic");
            this.jmsContext.createConsumer(this.messageTopic).setMessageListener(this);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    /* wird automatisch aufgerufen, sobald Server Nachricht schickt*/
    @Override
    public void onMessage(Message message) {
        //TODO: testen mit Int-Property?
        try {
            System.out.println("destination: " + message.getJMSDestination() + "=MessageTopic?");
            System.out.println("object: " + message.toString());
            if(message.getJMSDestination().equals(messageTopic)){
                System.out.println("destination = messageTopic");
                //message.getObjectProperty? --> Message-Objekt kann Bild etc sein
                //put it in own Queue?
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
