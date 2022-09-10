package server.database;


import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

    public ResultSet getUserById(int id){

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

    public ResultSet getUserByUserId(String userId){
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

    public void createUser(String userId, String username, String password, String email
            , String imageAddress, String phoneNumber, String gender, String bio){
        String joinDate = LocalDate.now().toString() + "T"+ LocalTime.now().toString();
        try{
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO `user` VALUES(user_id, user_name, password, join_date, email," +
                    " image_address, phone_number, gender, bio) (" + userId + ", " + username + ", " + password + ", "
                    + joinDate + ", " + email + ", " + imageAddress + ", " + phoneNumber + ", " + gender + ", " + bio
                    + ") ;");
        } catch(Exception e){
            System.out.println("User Creation Failed!");
            e.printStackTrace();
        }
    }

}
