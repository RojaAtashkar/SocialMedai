package client.view;

import java.io.File;
import java.text.ParseException;
import java.util.Scanner;

import client.enums.Message;
import client.model.User;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public abstract class  Menu {
    public static Stage stage;
    public static boolean Theme = false;
    private static final Scanner scanner = new Scanner(System.in);
    public static User loggedInUser = null;
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
        if(file != null){
            return file.getAbsolutePath();
        }
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
    public void setBarIcons(ImageView timeLineImageView, ImageView exploreImageView, ImageView directImageView
    , ImageView groupImageView, ImageView newGroupImageView, ImageView profileImageView,ImageView settingImageView){
        Image timeLineImage = new Image("/assets/icons/timeLine.png");
        timeLineImageView.setImage(timeLineImage);
        Image exploreImage = new Image("/assets/icons/explore.png");
        exploreImageView.setImage(exploreImage);
        Image directImage = new Image("/assets/icons/direct.png");
        directImageView.setImage(directImage);
        Image groupImage = new Image("/assets/icons/group.png");
        groupImageView.setImage(groupImage);
        Image groupSettingImage = new Image("/assets/icons/groupSetting.png");
        newGroupImageView.setImage(groupSettingImage);
        Image profileImage = new Image("/assets/icons/profile.png");
        profileImageView.setImage(profileImage);
        Image settingImage = new Image("/assets/icons/setting.png");
        settingImageView.setImage(settingImage);
    }
    public void setProfileImage(Circle circle){
        try {
            //System.out.println(loggedInUser.getImageAddress());
            Image image = new Image(new File(loggedInUser.getImageAddress()).toURI().toString());
            circle.setFill(new ImagePattern(image));
        }
        catch (Exception e){
            System.out.println("Error in setting profile image in main.");
            e.printStackTrace();
        }
    }
}
