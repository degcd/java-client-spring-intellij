package com.blackbox.client.rest_controller;

import blackbox.usermanagement.common.entities.User;
import com.blackbox.client.realizations.ServiceHandler;
import com.blackbox.client.realizations.helper.StringObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")

public class UserController {

    private ServiceHandler serviceHandler = ServiceHandler.getInstance();

    @PostMapping({"/registerUser"})
    public boolean registerUser(@RequestBody User userInfo){
        return this.serviceHandler.registerUser(userInfo.email(), userInfo.password());
    }
    @PutMapping({"/changePassword"})
    public boolean changePassword(@RequestBody User userInfo, @RequestBody StringObject newPassword){
        return this.serviceHandler.changePassword(userInfo.email(), userInfo.password(), newPassword.getText());
    }

    @PostMapping({"/login"})
    public boolean login(@RequestBody User userInfo){
        return this.serviceHandler.logIn(userInfo.email(), userInfo.password());
    }
    @PostMapping({"/logout"})
    public boolean logout(@RequestBody User userInfo){
        return this.serviceHandler.logOut(userInfo.email());
    }
}
