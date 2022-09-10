package client.controller;

import client.enums.Message;
import client.model.User;

import java.sql.ResultSet;

public class LoginController extends Controller{
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
    public Message handleLogin(String userID, String password, User user){
        String true_password = null;
        if(userID.isEmpty())
            return Message.EMPTY_USERID;
        if(password.isEmpty())
            return Message.EMPTY_PASSWORD;
        ResultSet resultSet = getUserByUserID(userID);
        if( resultSet == null)
            return Message.NON_EXISTENT_USERID;
        try {
            true_password = resultSet.getString("password");
        }
        catch (Exception e){
            System.out.println("Error while getting password with userID");
            e.printStackTrace();
        }
        if(password != true_password)
            return Message.MISMATCH_PASSWORD;
        return Message.SUCCESS;
    }

}
