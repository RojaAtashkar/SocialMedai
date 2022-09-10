package server.database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

public class GroupDB extends MainDB {
    private static GroupDB instance = null;

    private static void setInstance(GroupDB groupDB) {
        GroupDB.instance = groupDB;
    }

    public static GroupDB getInstance() {
        if (GroupDB.instance == null)
            setInstance(new GroupDB());
        return GroupDB.instance;
    }

     private ResultSet getGroupById(int id){

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `group` WHERE  id = " + id + ";");
            resultSet.next();
            return resultSet;
        } catch (Exception e){
            System.out.println("Group Search By Id Failed!");
            e.printStackTrace();
        }
        return null;
     }

     private ResultSet getGroupByGroupId(String groupId){
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `group` WHERE group_id = " + groupId + ";");
            resultSet.next();
            return resultSet;
        } catch (Exception e){
            System.out.println("Group Search By Group Id Failed!");
            e.printStackTrace();
        }
        return null;
     }

     private void createGroup( String groupId, String groupName, int adminId,
                              LocalDateTime createDate, String description, String imageAddress){

        try{
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO `group` VALUES(" + groupId + ", " + groupName + ", " + adminId + ", "
                   + createDate + ", " + description + ", " + imageAddress + ";");
        }catch (Exception e){
            System.out.println("Group Creation Failed!");
            e.printStackTrace();
        }

     }

     // setting a column in group should be handled with enums(for setting the right column)

}
