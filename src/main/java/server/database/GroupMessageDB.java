package server.database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

public class GroupMessageDB extends MainDB{
    private static GroupMessageDB instance = null;

    private static void setInstance(GroupMessageDB groupMessageDB){
        GroupMessageDB.instance = groupMessageDB;
    }

    public GroupMessageDB getInstance(){
        if(GroupMessageDB.instance == null){
            GroupMessageDB.setInstance(new GroupMessageDB());
        }

        return GroupMessageDB.instance;
    }

    private ResultSet  getGroupMessagesByGroupId(int groupId){

        try{
            Statement statement = connection.createStatement();
            return statement.executeQuery("SELECT * FROM `group_message` WHERE  group_id = "
                    + groupId);
        } catch (Exception e){
            System.out.println("Group Message Search By Group Id Failed!");
            e.printStackTrace();
        }
        return null;
    }

    private ResultSet getGroupMessagesByGroupIdAndUserId(int groupId, int senderId){
        try{
            Statement statement = connection.createStatement();
            return statement.executeQuery("SELECT * FROM `group_message` WHERE group_id = " + groupId +
                    " AND sender_id = " + senderId);
        } catch(Exception e){
            System.out.println("Group Message Search By Group Id and User Id Failed!");
            e.printStackTrace();
        }
        return null;
    }

    private void createGroupMessage(int senderId, int groupId, String mediaAddress, LocalDateTime createDate,
                                    String type, int forwardedFrom, int replyTo){
        try{
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO 'group_message' VALUES(sender_id, group_id, media_address, create_date," +
                    " type, forwarded_from, reply_to) (" + senderId + ", " + groupId + ", " + mediaAddress + ", "
                    + createDate + ", " + type + ", " + forwardedFrom + ", " + replyTo + ");");
        }catch (Exception e){
            System.out.println("Group Message Creation Failed!");
            e.printStackTrace();
        }
    }
}
