package com.blackbox.client.rest_controller;

import com.blackbox.client.realizations.ServiceHandler;
import com.blackbox.client.realizations.helper.StringObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    ////--> welche Request-Methoden braucht Frontend? --> Liste gemacht
    private ServiceHandler serviceHandler = ServiceHandler.getInstance();

    @GetMapping(value="/")
    public String test(){
        this.serviceHandler.sendMsgToServer(123);
        return "test";
    }

    @PostMapping({"/send/scenarioId"})
    public void startScenario(@RequestBody long scenarioId){
        //leite Id weiter
    }

    @PostMapping({"/send/message"})
    public void sendResponseToServer(@RequestBody StringObject response){
        this.serviceHandler.sendMsgToServer(response.getText());
        //---> Id ist eindeutiger und leichter zu handhaben!
    }

    @PostMapping({"/send/messageId"})
    public void sendResponseToServer(@RequestBody long messageId){
        this.serviceHandler.sendMsgToServer(messageId);// oder zu JMS senden? -> Bsp anschauen!
    }

    @GetMapping
    public void getNextMessageFromQueue(){
        //JMS
    }


}
