package server.database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

public class DirectMessageDB extends MainDB {
    private static DirectMessageDB instance = null;

    private static void setInstance(DirectMessageDB directMessageDB){
        DirectMessageDB.instance = directMessageDB;
    }

    public static DirectMessageDB getInstance(){
        if(DirectMessageDB.instance == null){
            DirectMessageDB.setInstance(new DirectMessageDB());
        }
        return DirectMessageDB.instance;
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
}

