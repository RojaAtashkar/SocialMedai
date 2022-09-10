package client.view;

import client.controller.SignUpController;
import client.enums.Message;
import client.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class SignUpMenu extends Menu {
    private static SignUpMenu instance = null;
    public TextField userIDTextBox;
    public TextField passwordTextBox;
    public TextField repeatedPasswordTextBox;
    public Label userIDLabel;
    public Label passwordLabel;
    public Label repeatedPasswordLabel;
    public CheckBox lightThemeCheckBox;
    private static User user = new User();
    public RadioButton femaleRadioButton;
    public RadioButton maleRadioButton;
    public RadioButton otherRadioButton;
    public Circle profileImageCircle;
    public TextField emailTextBox;
    public Label phoneNumberLabel;
    public TextField phoneNumberTextBox;
    public TextField usernameTextBox;
    public Label usernameLabel;
    private SignUpController signUpController = SignUpController.getInstance();
    public static Scene scene;
    private String address;
    private String gender = "F";
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
    @Override
    public void run() {
      runScene1();
    }
    @FXML
    private void runScene1(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginMenu.class.getResource("/social_media_javafx/signUpMenuScene1.fxml"));scene = new Scene(fxmlLoader.load());
            Menu.stage.setTitle("SocialMedia");
            Menu.stage.setScene(scene);
            Menu.stage.show();
        } catch (Exception e) {
            System.out.println("Error while rendering scene1 in signUp Menu.");
            e.printStackTrace();
        }
    }
    public void runScene2() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginMenu.class.getResource("/social_media_javafx/signUpMenuScene2.fxml"));
            scene = new Scene(fxmlLoader.load());
            Menu.stage.setTitle("SocialMedia");
            Menu.stage.setScene(scene);
            Menu.stage.show();
        } catch (Exception e) {
            System.out.println("Error while rendering scene2 in signUp Menu.");
            e.printStackTrace();
        }
    }
    public void runSignUpWithPhoneNumber() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginMenu.class.getResource("/social_media_javafx/SignUpPhoneNumber.fxml"));
            scene = new Scene(fxmlLoader.load());
            Menu.stage.setTitle("SocialMedia");
            Menu.stage.setScene(scene);
            Menu.stage.show();
        } catch (Exception e) {
            System.out.println("Error while rendering signUpPhoneNumber in signUp Menu.");
            e.printStackTrace();
        }
    }
    public void runSignInWithEmail() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginMenu.class.getResource("/social_media_javafx/signUpEmail.fxml"));
            scene = new Scene(fxmlLoader.load());
            Menu.stage.setTitle("SocialMedia");
            Menu.stage.setScene(scene);
            Menu.stage.show();
        } catch (Exception e) {
            System.out.println("Error while rendering SignUpEmail in signUp Menu.");
            e.printStackTrace();
        }
    }
    public void nextScene2(ActionEvent event) {
        String userID = userIDTextBox.getText();
        String password = passwordTextBox.getText();
        String repeatedPassword = repeatedPasswordTextBox.getText();
        Message message = signUpController.handleSignUpScene1(userID, password, repeatedPassword, user);
        System.out.println(message.toString());
        if(message == Message.SUCCESS){
            runScene2();
            return;
        }
        if(message == Message.EMPTY_USERID|| message == Message.USERID_EXIST)
            userIDLabel.setText(message.toString());
        if(message == Message.MISMATCH_PASSWORD || message == Message.EMPTY_REPEATED_PASSWORD)
            repeatedPasswordLabel.setText(message.toString());
        else
            passwordLabel.setText(message.toString());
    }

    public void nextSignInWithEmail(ActionEvent event) {
        String username = usernameTextBox.getText();
        Message message = signUpController.handleSignUpScene2(username, gender, address, user);
        if(message == Message.SUCCESS)
            runSignInWithEmail();
        else
        {
            usernameLabel.setText(message.toString());
        }
    }
    public void logInMenu(ActionEvent event) {
       LoginMenu.getInstance().run();
    }
    public void cancel(ActionEvent event) {
        System.exit(0);
    }
    public void setProfileImage(ActionEvent event) {
         this.address = fileChooser(scene, "src/main/resources/assets/profiles/", "profileImage");
    }
    public void signUpWithEmail(ActionEvent event) {
        String email = emailTextBox.getText();
        Message message = signUpController.handleSignInWithEmail(email, user);
    }
    public void signUpWithPhoneNumber(ActionEvent event) {
        String number = phoneNumberTextBox.getText();
        Message message = signUpController.handleSignInWithPhoneNumber(number, user);
        if(message != message.SUCCESS)
            phoneNumberLabel.setText(message.toString());
    }
    public void backScene1(ActionEvent event) {
        userIDTextBox.setText(user.getUsername());
        passwordTextBox.setText(user.getPassword());
        passwordTextBox.setText(user.getPassword());
        runScene1();
    }

    public void backScene2(ActionEvent event) {
        runScene2();
        femaleRadioButton.setSelected(false);
        if(user.getGender() == "F") femaleRadioButton.setSelected(true);
        else if(user.getGender() == "M") maleRadioButton.setSelected(true);
        else otherRadioButton.setSelected(true);

    }

    public void setGender(ActionEvent event) {
        if (femaleRadioButton.isSelected()){
            gender = "F";
            femaleRadioButton.setSelected(true);
            maleRadioButton.setSelected(false);
            otherRadioButton.setSelected(false);
        }
       else if (maleRadioButton.isSelected()){
            gender = "M";
            maleRadioButton.setSelected(true);
            femaleRadioButton.setSelected(false);
            otherRadioButton.setSelected(false);
        }
        else if (otherRadioButton.isSelected()){
            gender = "O";
            maleRadioButton.setSelected(false);
            femaleRadioButton.setSelected(false);
            otherRadioButton.setSelected(true);
        }
    }
}

