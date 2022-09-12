package server.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DirectDB extends MainDB{
    private static DirectDB instance = null;

    private static void setInstance(DirectDB directDB){
        DirectDB.instance = directDB;
    }

    public static DirectDB getInstance(){
        if(DirectDB.instance == null){
            DirectDB.setInstance(new DirectDB());
        }
        return DirectDB.instance;
    }
    private ResultSet getDirectMessageById(int id){
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `direct_message` WHERE id = " + id + ";");
            resultSet.next();
            return resultSet;
        } catch(Exception e){
            System.out.println("Direct Message Search Failed!");
            e.printStackTrace();
        }
        return null;
    }
    private void createDirectMessage(int senderId, int receiverId, String mediaAddress,
                                     LocalDateTime createDate, String type, int forwardedFrom, int replyTo){
        try{
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO `direct_message` VALUES(sender_id, reciver_id, media_address, create_date"
                    +" ,type ,forwarded_from ,reply_to) (" +  senderId + ", " + receiverId + ", " + mediaAddress + ", "
                    + createDate + ", " + type + ", " + forwardedFrom + ", " + replyTo + " );");
        }catch(Exception e){
            System.out.println("Direct Message Creation Failed!");
            e.printStackTrace();
        }
    }
    public void createDirect(String user1_id, String user2_id){
        String sql = " insert into direct (user1_id, user2_id)" + " values (?, ?)";
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString (1, user1_id);
            preparedStmt.setString (2, user2_id);
            preparedStmt.execute();
        }
        catch (Exception e){
            System.out.println("Error while creating direct");
            e.printStackTrace();
        }
    }
    public ResultSet  getDirectByUserID(String userId){
        ResultSet resultSet = null;
        try {
            String sql = "SELECT *  FROM direct WHERE user1_id= ? or user2_id =?";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString (1, userId);
            preparedStmt.setString (2, userId);
            preparedStmt.execute();
        }
        catch(Exception e){
            System.out.println("User Creation Failed!");
            e.printStackTrace();
        }
        return resultSet;
    }
}
