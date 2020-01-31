package com.blackbox.client.interfaces;

public interface UserManagementHandler {
    boolean registerUser(String email, String password);
    boolean changePassword(String email, String oldPW, String newPW);
    boolean logIn(String email, String password);
    boolean logOut(String email);
}
