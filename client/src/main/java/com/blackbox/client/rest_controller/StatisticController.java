package com.blackbox.client.rest_controller;

import blackbox.usermanagement.common.entities.User;
import com.blackbox.client.realizations.ServiceHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statistic")
public class StatisticController {

    private ServiceHandler serviceHandler = ServiceHandler.getInstance();

    //Statistik-Objekt!!!!?????
//    public void getStatistic(@RequestBody User user){
    @GetMapping
        public void getStatistic(){
        //---> keine Id übergeben sondern User mit Email, die PK ist?
        //this.serviceHandler.getStatistics(user);
        System.out.println("STAAAAAAAAAAAAAAAAAAAAAAAAAAAATISTIK");
        this.serviceHandler.sendMsgToServer(123);
    }

}
