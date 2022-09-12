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
            System.out.println("Error while setting user info in setUserInfo in Controller.");
            e.printStackTrace();
        }
    }
    protected ResultSet getUserByUserID(String userID){
        try {
            ResultSet resultSet = userDB.getUserByUserId(userID);
           while (resultSet != null && resultSet.next()){
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
    public String writeFile(String text, String fileName, String dirAddress) {
        String fileAddress = dirAddress + fileName + ".txt";
        File myObj = new File(fileAddress);
        try {
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter(fileAddress);
                myWriter.write(text);
                myWriter.close();
            }
        }
        catch (Exception e){
            System.out.println("Error while creating or writing in to file in controller.Controller :" + fileAddress);
           e.printStackTrace();
        }
        return fileAddress;
    }
    public String readFile(String fileAddress){
        String text = "";
        try {
            File myObj = new File(fileAddress);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                text += data + "\n";
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error while reading from file :" + fileAddress);
            e.printStackTrace();
        }
        return text;
    }
}
