package client.controller;

import client.enums.Message;
import client.model.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import server.database.DirectDB;
public class DirectController extends  Controller{
    private static DirectController instance = null;
    private DirectDB directDB = DirectDB.getInstance();
    private static void setInstance(DirectController directController){
        DirectController.instance = directController;
    }
    public static DirectController getInstance(){
        if(DirectController.instance == null){
            setInstance(new DirectController());
        }
        return instance;
    }

    public Message handleFindUser(String userID, User oderUser) {
        if (userID.isEmpty())
            return Message.EMPTY_USERID;
        ResultSet resultSet = this.getUserByUserID(userID);
        if(resultSet != null){
            setUserInfo(resultSet, oderUser);
            return Message.SUCCESS;
        }
        return Message.NON_EXISTENT_USERID;
    }

    public ArrayList<User> getAllDirects() {
        ArrayList<User> users = new ArrayList<>();
        //ResultSet resultSet = directDB.
        return users;
    }
}
