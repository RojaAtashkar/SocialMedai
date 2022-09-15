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

    public Message handleFindUser(String userID, User oderUser, User thisUser) {
        if (userID.isEmpty())
            return Message.EMPTY_USERID;
        ResultSet resultSet = this.getUserByUserID(userID);
        if(resultSet != null){
            oderUser = new User();
            setUserInfo(resultSet, oderUser);
            directDB.createDirect(String.valueOf(thisUser.getId()), String.valueOf(oderUser.getId()));
            directDB.createDirect(String.valueOf(oderUser.getId()), String.valueOf(thisUser.getId()));
            return Message.SUCCESS;
        }
        return Message.NON_EXISTENT_USERID;
    }

    public ArrayList<User> getAllDirects(User user) {
        ArrayList<User> users = new ArrayList<>();
        ResultSet resultSet = directDB.getDirectByUserID(String.valueOf(user.getId()));
        try {
            while (resultSet.next()){
                User tmp = new User();
                this.setUserInfo(resultSet, tmp);
                users.add(tmp);
            }
        }
        catch (Exception e){
            System.out.println("Error in getting all directs in directController");
            e.printStackTrace();
        }
        return users;
    }
}
