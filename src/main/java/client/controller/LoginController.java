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
        ResultSet resultSet = userDB.getUserByUserId(userID);
        try {
            if (resultSet != null && resultSet.next()){
                true_password = resultSet.getString("password");
                resultSet.previous();
            }
            else {
                return Message.NON_EXISTENT_USERID;
            }
        }
        catch (Exception e){
            System.out.println("Error while getting password with userID");
            e.printStackTrace();
        }
        if(!password.equals(true_password))
            return Message.MISMATCH_PASSWORD;
        setUserInfo(resultSet, user);


        return Message.SUCCESS;
    }

}
