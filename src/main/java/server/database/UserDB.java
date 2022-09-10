package server.database;


import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

public class UserDB  extends MainDB{
    private static UserDB instance = null;

    private static void setInstance(UserDB userDB){
        UserDB.instance = userDB;
    }

    public static UserDB getInstance(){
        if(UserDB.instance == null){
            UserDB.setInstance(new UserDB());
        }
        return UserDB.instance;
    }

    private ResultSet getUserById(int id){

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `user` WHERE id = " + id + ";");
            resultSet.next();
            return resultSet;
        } catch(Exception e){
            System.out.println("User Search By Id Failed!");
            e.printStackTrace();
        }

        return null;
    }

    private ResultSet getUserByUserId(String userId){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `user` WHERE user_id = " + userId + ";");
            resultSet.next();
            return resultSet;
        }catch (Exception e){
            System.out.println("User Search By User Id Failed!");
            e.printStackTrace();
        }
        return null;
    }

    private void createUser(String userId, String username, String password, LocalDateTime joinDate, String email
            , String imageAddress, String phoneNumber, String gender, String bio){
        try{
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO `user` VALUES(user_id, username, password, join_date, email," +
                    " image_address, phone_number, gender, bio) (" + userId + ", " + username + ", " + password + ", "
                    + joinDate + ", " + email + ", " + imageAddress + ", " + phoneNumber + ", " + gender + ", " + bio
                    + ") ;");
        } catch(Exception e){
            System.out.println("User Creation Failed!");
            e.printStackTrace();
        }
    }

}
