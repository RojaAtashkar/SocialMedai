package server.database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

public class PostDB extends MainDB{
    private static PostDB instance = null;

    private static void setInstance(PostDB postDB){
        PostDB.instance = postDB;
    }

    public static PostDB getInstance(){
        if(PostDB.instance == null){
            PostDB.setInstance(new PostDB());
        }
        return PostDB.instance;
    }

    private ResultSet getPostById(int id){

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `post` WHERE  id = " + id + ";");
            resultSet.next();
            return resultSet;
        } catch (Exception e){
            System.out.println("Group Search By Id Failed!");
            e.printStackTrace();
        }
        return null;
    }

    private ResultSet getPostByUserId(String userId){
        try{
            Statement statement = connection.createStatement();
            return statement.executeQuery("SELECT * FROM `post` WHERE user_id = " + userId + ";");
        } catch (Exception e){
            System.out.println("Post Search By User Id Failed!");
            e.printStackTrace();
        }
        return null;
    }

    private void createPost(int userId, String mediaAddress, LocalDateTime createDate,
                            String description, String type){
        try{
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO `post` VALUES(user_id, media_address, create_date, description, type) " +
                    "("+ userId + ", " + mediaAddress + ", " + createDate + ", " + description + ", " + type);
        } catch (Exception e){
            System.out.println("Post Creation Failed!");
            e.printStackTrace();
        }

    }
}
