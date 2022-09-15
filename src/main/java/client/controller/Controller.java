package client.controller;

import client.model.User;
import server.database.UserDB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Scanner;

public abstract class  Controller {
    protected UserDB userDB = UserDB.getInstance();
    protected void setUserInfo(ResultSet resultSet, User user){
        try {
            while (resultSet.next()){
                System.out.println(resultSet.getString("user_name"));
                user.setUsername(resultSet.getString("user_name"));
                user.setUserId(resultSet.getString("user_id"));
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setBio(resultSet.getString("bio"));
                user.setGender(resultSet.getString("gender"));
                user.setImageAddress(resultSet.getString("image_address"));
                System.out.println("here");
            }
        }
        catch (Exception e){
            System.out.println("Error while setting user info in setUserInfo in Controller.");
            e.printStackTrace();
        }
    }


    protected ResultSet getUserByUserID(String userID){
        try {
            ResultSet resultSet = userDB.getUserByUserId(userID);
            while (resultSet != null && resultSet.next()){
                resultSet.previous();
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
