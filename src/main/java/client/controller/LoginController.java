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

        if(!password.equals(true_password))
            return Message.MISMATCH_PASSWORD;
        setUserInfo(resultSet, user);
        return Message.SUCCESS;
    }
   private void setUserInfo(ResultSet resultSet, User user){
        try {
            user.setUsername(resultSet.getString("user_name"));
            user.setUserId(resultSet.getString("user_id"));
            user.setId(Integer.parseInt(resultSet.getString("id")));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setPhoneNumber(resultSet.getString("phone_number"));
            user.setBio(resultSet.getString("bio"));
            user.setGender(resultSet.getString("gender"));
            user.setImageAddress(resultSet.getString("image_address"));
        }
        catch (Exception e){
            System.out.println("Error while setting user info in setUserInfo in loginController.");
            e.printStackTrace();
        }

   }
}
