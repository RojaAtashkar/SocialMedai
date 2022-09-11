package server.database;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE user_id=? ");
            preparedStatement.setString(1, userId);
            resultSet = preparedStatement.executeQuery();

        }catch (Exception e){
            System.out.println("User Search By User Id Failed!");
            e.printStackTrace();
        }
        return resultSet;
    }
    public void createUser(String userId, String username, String password, String email
          , String imageAddress, String phoneNumber, String gender, String bio){
        try {
            String joinDate = LocalDate.now().toString() + "T"+ LocalTime.now().toString();
            String sql = "INSERT INTO `user` (user_id, user_name, password, join_date, email," +
                    "  image_address, phone_number, gender, bio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString (1, userId);
            preparedStmt.setString (2, username);
            preparedStmt.setString (3, password);
            preparedStmt.setString (4, joinDate);
            preparedStmt.setString (5, email);
            preparedStmt.setString (6, imageAddress);
            preparedStmt.setString (7, phoneNumber);
            preparedStmt.setString (8, gender);
            preparedStmt.setString (9, bio);
            preparedStmt.execute();
        }
        catch(Exception e){
            System.out.println("User Creation Failed!");
            e.printStackTrace();
        }

    }


}
