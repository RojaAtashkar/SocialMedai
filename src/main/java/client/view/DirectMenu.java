package client.view;

import client.controller.DirectController;
import client.enums.Message;
import client.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class DirectMenu extends ChatMenu {
    private static Scene scene;
    private static DirectMenu instance;
    public TextField findUerIDTextField;
    public Label finUserIdLabel;
    private User oderUser;
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

    }
    @Override
    public void run() {
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(DirectMenu.class.getResource("/fxml/chatMenu.fxml"));
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

    }
    @Override
    public void sendPicture(ActionEvent event) {

    }
    @Override
    public void sendTextMessage(ActionEvent event) {

    }
    public void findUser(ActionEvent event) {
        String userID = findUerIDTextField.getText();
        Message message =  directController.handleFindUser(userID, oderUser);
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
        ArrayList<User> directUsers = directController.getAllDirects();
    }
}
