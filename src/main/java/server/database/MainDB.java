package server.database;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class MainDB {
    protected Connection connection;

    protected MainDB() {
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/social_media_test1", "root", "2581537299");
            connection.createStatement();
            System.out.println("connection");
        }
        catch (Exception e){
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
    }
}
