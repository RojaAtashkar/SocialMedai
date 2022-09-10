package client.view;

import java.io.File;
import java.text.ParseException;
import java.util.Scanner;

import client.enums.Message;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public abstract class  Menu {
    public static Stage stage;
    public static boolean Theme = false;
    private static final Scanner scanner = new Scanner(System.in);

    protected static Scanner getScanner() {
        return scanner;
    }
    public abstract  void run();
    public String fileChooser(Scene scene, String location, String title) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        fileChooser.setInitialDirectory(new File(location));
        File file = null;
        try {
            file = fileChooser.showOpenDialog(scene.getWindow());
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in fileChooser " + title);
        }
        if(file != null)
            return file.getAbsolutePath();
        else
            return null;
    }
    public void setDefaultProfileImage(Circle circle){
        try {
            Image image = new Image(new File("src/main/resources/assets/icons/user.png").toURI().toString());
             circle.setFill(new ImagePattern(image));
        }
        catch (Exception e){

        }
    }
    public void setProfileImage(Circle circle, String address){
        try {
            Image image = new Image(new File(address).toURI().toString());
            circle.setFill(new ImagePattern(image));
        }
        catch (Exception e){

        }
    }
}
