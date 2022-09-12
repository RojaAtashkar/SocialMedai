package client.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class ChatMenu extends Menu {
    private static Scene scene;
    @FXML
    public  abstract void runChatSetting(ActionEvent event);
    @FXML
    public abstract void sendVideo(ActionEvent event);
    @FXML
    public abstract void sendPicture(ActionEvent event);
    @FXML
    public abstract void sendTextMessage(ActionEvent event);
}