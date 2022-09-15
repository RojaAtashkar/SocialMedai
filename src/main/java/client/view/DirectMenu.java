package client.view;

import client.controller.DirectController;
import client.enums.Message;
import client.model.DirectMessage;
import client.model.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.File;
import java.util.ArrayList;

public class DirectMenu extends ChatMenu {
    private static Scene scene;
    private static DirectMenu instance;
    public TextField findUerIDTextField;
    public Label finUserIdLabel;
    public VBox optionsVbox;
    private  User oderUser;
    private DirectController directController = DirectController.getInstance();
    private static void setInstance(DirectMenu directMenu){
        DirectMenu.instance =directMenu;
    }
    public static DirectMenu getInstance(){
        if (DirectMenu.instance == null)
            setInstance(new DirectMenu());
        return DirectMenu.instance;
    }
    public DirectMenu(){
    }
    @FXML
    public void initialize(){
    updateDirects();
    showDirectMessages();
    }
    @Override
    public void run() {
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(DirectMenu.class.getResource("/fxml/directChat.fxml"));
            scene = new Scene(fxmlLoader.load());
            Menu.stage.setTitle("Directs");
            Menu.stage.setScene(scene);
            Menu.stage.show();
        } catch (Exception e) {
            System.out.println("Error while rendering chatMeu.fxml in direct Menu.");
            System.out.println(e);
            e.printStackTrace();
        }

    }

    @Override
    public void runChatSetting(ActionEvent event) {

    }
    @Override
    public void sendVideo(ActionEvent event) {
     String address = this.fileChooser(scene, "src/main/resources/videos/", "videos");
     if(address != null){
         directController.addNewMessage(address, loggedInUser, "V");
         //TODO change when connected to server
         showDirectMessages();
     }
    }
    @Override
    public void sendPicture(ActionEvent event) {
        String address = this.fileChooser(scene, "src/main/resources/images/", "images");
        if(address != null){
            directController.addNewMessage(address, loggedInUser, "I");
            //TODO change when connected to server
            showDirectMessages();
        }

    }
    @Override
    public void sendTextMessage(ActionEvent event) {
        //String text =

    }
    public void findUser(ActionEvent event) {
        String userID = findUerIDTextField.getText();
        if (oderUser == null){
            oderUser = new User();
        }
        Message message =  directController.handleFindUser(userID, oderUser, loggedInUser);
        if(message != Message.SUCCESS){
            finUserIdLabel.setText(message.toString());
        }
        else {
            findUerIDTextField.setText("");
            // TODO change when connect to server
            updateDirects();
        }
    }

    private void updateDirects() {
        ArrayList<User> directUsers = directController.getAllDirects(Menu.loggedInUser);
        for (User userTmp : directUsers){
            HBox hBox = new HBox();
            hBox.setBackground(new Background(new BackgroundFill(Color.DARKGRAY,
                    CornerRadii.EMPTY,
                    Insets.EMPTY)));
            hBox.setPadding(new Insets(5,5,5, 5));
            Circle circle = new Circle();
            Image image = new Image(new File(userTmp.getImageAddress()).toURI().toString());
            circle.setFill(new ImagePattern(image));
            circle.setRadius(20);
            VBox vBox = new VBox();
            Text username = new Text(userTmp.getUsername());
            Text userId = new Text("@"+userTmp.getUserId());
            vBox.setPadding(new Insets(1,1,1, 1));
            vBox.getChildren().addAll(username, userId);
            hBox.getChildren().addAll(circle, vBox);
            hBox.setOnMouseClicked((e) ->{
                this.oderUser = userTmp;
                //TODO CHANGE AFTER CONNECTING TO SERVER
                showDirectMessages();
            });
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    optionsVbox.getChildren().add(hBox);
                }
            });

        }
    }

    private void showDirectMessages() {
        ArrayList<DirectMessage> directMessages = directController.getAllDirectMessages(loggedInUser.getId(), oderUser.getId());

    }
}
