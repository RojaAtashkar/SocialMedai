package client.controller;

import server.database.UserDB;

import java.sql.ResultSet;

public abstract class  Controller {
    protected UserDB userDB = UserDB.getInstance();
    protected ResultSet getUserByUserID(String userID){
        try {
            ResultSet resultSet = userDB.getUserByUserId(userID);
            if(resultSet.next()){
               return resultSet;
            }
            return null;
        }
        catch (Exception e){
            System.out.println("Error while checking if a userID exist.");
            e.printStackTrace();
        }
        return null;
    }
}
