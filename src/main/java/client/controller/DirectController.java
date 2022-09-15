package client.controller;

import client.enums.Message;
import client.model.DirectMessage;
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
        if(userID == thisUser.getUserId())
            return Message.ANOTHER_USERID;

        ResultSet resultSet = userDB.getUserByUserId(userID);
        setUserInfo(resultSet, oderUser);
        try {
            if(resultSet != null && resultSet.next()){
                if(directExists(String.valueOf(oderUser.getId()),String.valueOf(thisUser.getId()))){
                    return Message.DIRECT_EXISTS;
                }
                else {
                    directDB.createDirect(String.valueOf(thisUser.getId()), String.valueOf(oderUser.getId()));
                    directDB.createDirect(String.valueOf(oderUser.getId()), String.valueOf(thisUser.getId()));
                    return Message.SUCCESS;
                }
            }
            else {
                return Message.NON_EXISTENT_USERID;
            }
        }
        catch (Exception e){
            System.out.println("error in checking if a userExist");
        }

      return Message.ERROR;
    }

    private boolean directExists(String user1_id,String user2_id) {
        ResultSet resultSet = directDB.getDirectByUserIDs(user1_id, user2_id);
        try {
            if (resultSet.next())
                return true;
        }
        catch (Exception e){
            System.out.println("Error in directExists");
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<User> getAllDirects(User user) {
        ArrayList<User> users = new ArrayList<>();
        ResultSet resultSet = directDB.getDirectByID(String.valueOf(user.getId()));
        try {
            while (resultSet.next()){
                User tmp = new User();
                resultSet.previous();
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

    public ArrayList<DirectMessage> getAllDirectMessages(int thisID, int oderID) {
        ArrayList<DirectMessage> directMessages = new ArrayList<>();
        ResultSet resultSet = directDB.getDirectByUserIDs(String.valueOf(thisID), String.valueOf(oderID));
        return directMessages;
    }

    public void addNewMessage(String address, User loggedInUser, String v) {
    }
}
