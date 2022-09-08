package client.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.text.ParseException;

public class SignUpMenu extends Menu {
    private static SignUpMenu instance = null;

    private static void setSignUpMenu(SignUpMenu instance) {
        SignUpMenu.instance = instance;
    }

    public static SignUpMenu getInstance() {
        if (instance == null) {
            setSignUpMenu(new SignUpMenu());
        }
        return instance;
    }

    public SignUpMenu() {

    }


    public Scene scene1;

    @Override
    public void run() {
      runScene1();
    }
    @FXML
    private void runScene1(){
        try {
            if (scene1 == null) {
                FXMLLoader fxmlLoader = new FXMLLoader(LoginMenu.class.getResource("/social_media_javafx/signUpMenuScene1.fxml"));
                scene1 = new Scene(fxmlLoader.load());
            }
            Menu.stage.setTitle("SocialMedia");
            Menu.stage.setScene(scene1);
            Menu.stage.show();
        } catch (Exception e) {
            System.out.println("Error while rendering scene1 in signUp Menu.");
            e.printStackTrace();
        }
    }

    public void logInMenu(ActionEvent event) {
        //LoginMenu.getInstance.run();
    }

    public void runScene2(ActionEvent event) {
        try {
            if (scene1 == null) {
                FXMLLoader fxmlLoader = new FXMLLoader(LoginMenu.class.getResource("/social_media_javafx/signUpMenuScene2.fxml"));
                scene1 = new Scene(fxmlLoader.load());
            }
            Menu.stage.setTitle("SocialMedia");
            Menu.stage.setScene(scene1);
            Menu.stage.show();
        } catch (Exception e) {
            System.out.println("Error while rendering scene2 in signUp Menu.");
            e.printStackTrace();
        }
    }

    public void cancel(ActionEvent event) {
    }

    public void runSignInWithEmail(ActionEvent event) {
    }

    public void setType(ActionEvent event) {
    }

    public void setGender(ActionEvent event) {
    }

    public void setProfileImage(ActionEvent event) {
    }
}

