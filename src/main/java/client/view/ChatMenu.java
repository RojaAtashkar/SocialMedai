package client.view;

import client.controller.Controller;
import client.controller.TextFileController;
import client.model.Message;
import client.model.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.File;

public abstract class ChatMenu extends Menu {
    private static Scene scene;
    private TextFileController textFileController = TextFileController.getInstance();
    @FXML
    public  abstract void runChatSetting(ActionEvent event);
    @FXML
    public abstract void sendVideo(ActionEvent event);
    @FXML
    public abstract void sendPicture(ActionEvent event);
    @FXML
    public abstract void sendTextMessage(ActionEvent event);
    protected void showMessage(Message message, boolean thisUser, VBox messageVBox){
        VBox root = new VBox();
        HBox headerHBox = new HBox();
        root.getChildren().add(headerHBox);
        addHeader(headerHBox, message.getSenderUser());
        if(message.getType() == "T")
        {
            showTextMessage(message.getAddress(), root, thisUser);
        }
        else if(message.toString() == "I"){
            showImageMessage(message.getAddress(), root,  thisUser);
        }
        else if(message.getType() == "V"){
            showVideoMessage(message.getAddress() ,root,  thisUser);
        }
        addFooter(root);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                messageVBox.getChildren().add(root);
            }
        });
    }
    private void addHeader(HBox headerHBox, User user){
        VBox infoVBox = new VBox();
        Text usernameText = new Text(user.getUsername());
        Text userIDText = new Text(user.getUserId());
        infoVBox.getChildren().addAll(usernameText, userIDText);
        Circle circle = new Circle(25);
        Image image = new Image(new File(user.getImageAddress()).toURI().toString());
        circle.setFill(new ImagePattern(image));
        headerHBox.getChildren().addAll(circle, infoVBox);
    }

    private void showVideoMessage(String address, VBox root, boolean thisUser) {
        Media media = new Media (new File(address).toURI().toString());
        MediaPlayer player = new MediaPlayer (media);
        player.setAutoPlay(true);
        MediaView view = new MediaView (player);
        view.setPreserveRatio(true);
        view.setFitHeight(100);
        view.setFitWidth(100);
        root.getChildren().add(view);
    }

    private void showImageMessage(String address, VBox root, boolean thisUser) {
        Image image = new Image(new File(address).toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        root.getChildren().add(imageView);
    }

    private void showTextMessage(String address, VBox root, boolean thisUser) {
        String message = textFileController.readFile(address);
        Text text = new Text(message);
        TextFlow textFlow = new TextFlow(text);
        root.getChildren().add(textFlow);
    }
    private void addFooter(VBox root){
        HBox hBox = new HBox();
        Button forwardedBtn = new Button("Forward");
        Button replyBtn = new Button("Reply");
        Button deleteBtn = new Button("Delete");
        Button editBtn = new Button("Edit");
        hBox.getChildren().addAll(forwardedBtn, replyBtn, editBtn, deleteBtn);
        root.getChildren().add(hBox);
    }
}