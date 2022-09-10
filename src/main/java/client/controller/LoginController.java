package client.controller;

import client.enums.Message;
import client.model.User;

public class LoginController {
    private static LoginController instance;
    private static void setInstance(LoginController loginController){
        instance = loginController;
    }
    public static LoginController getInstance(){
        if(instance == null){
            setInstance(new LoginController());
        }
        return instance;
    }
    private LoginController(){

    }
    public Message handleLogin(String username, String password, User user){
        // check with sql if username exists
        // check with sql if password mach
        return Message.SUCCESS;
    }
}
