package client.controller;

import client.enums.Message;
import client.model.User;
import client.view.Menu;

import java.sql.ResultSet;

public class SignUpController  extends Controller{
    private static SignUpController instance;

    private static void setSignUpController(SignUpController signUpController){
        SignUpController.instance = signUpController;
    }
    public static SignUpController getInstance(){
        if (SignUpController.instance == null){
            setSignUpController(new SignUpController());
        }
        return SignUpController.instance;
    }
    private SignUpController(){

    }
    public Message handleSignUpScene1(String userID, String password, String repeatedPassword, User user) {
        if (userID.isEmpty())
            return Message.EMPTY_USERID;
        if (password.isEmpty())
            return Message.EMPTY_PASSWORD;
        if (repeatedPassword.isEmpty())
            return Message.EMPTY_REPEATED_PASSWORD;
        if (this.getUserByUserID(userID) != null){
            return Message.USERID_EXIST;
        }
        Message message = this.validatePassword(password, repeatedPassword);
        if (message  != Message.SUCCESS)
            return message;
        user.setUserId(userID);
        user.setPassword(password);
        return Message.SUCCESS;
    }
    private Message validatePassword(String password, String repeatedPassword){
        if (!password.equals(repeatedPassword))
            return Message.MISMATCH_PASSWORD;
        if (password.length() < 8)
            return Message.SHORT_PASSWORD;
        if (password.length() > 30)
            return Message.LONG_PASSWORD;
        if(!isAlphaNumeric(password))
            return Message.NON_ALPHANUMERIC_PASSWORD;
        return Message.SUCCESS;
    }
    public boolean isAlphaNumeric (String password){
        return password.matches("[a-zA-z0-9]+");
    }

    public Message handleSignUpScene2(String username,String gender, String address, User user) {
        if (username.isEmpty())
            return Message.EMPTY_USERNAME;
        user.setUsername(username);
        user.setGender(gender);
        user.setImageAddress(address.toString());
        return Message.SUCCESS;
    }
    public Message handleSignInWithEmail(String email, User user) {
        user.setEmail(email);
        userDB.createUser(user.getUserId(), user.getUsername(), user.getPassword(),user.getEmail(),user.getImageAddress(),
        user.getPhoneNumber(), user.getGender(), user.getBio());
        Menu.loggedInUser = user;
        return Message.SUCCESS;
    }

    public Message handleSignInWithPhoneNumber(String number, User user) {
        if(isNumeric(number))
            return Message.NON_NUMERIC_PHONE_NUMBER;
        userDB.createUser(user.getUserId(), user.getUsername(), user.getPassword(),user.getEmail(),user.getImageAddress(),
                user.getPhoneNumber(), user.getGender(), user.getBio());
        Menu.loggedInUser = user;
        return Message.SUCCESS;
    }
    private boolean isNumeric(String number){
        return number.matches("[0-9]+");
    }
}
