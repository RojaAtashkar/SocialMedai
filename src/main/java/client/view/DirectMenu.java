package client.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class DirectMenu extends ChatMenu{
    private static Scene scene;
    private static DirectMenu instance;
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
    public void initialize() {

    }

    @Override
    public void newGroupMenu(ActionEvent event) {

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
}
