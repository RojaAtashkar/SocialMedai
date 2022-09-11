package client.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public abstract class ChatMenu extends Menu {
    private static Scene scene;
    public void newGroupMenu(ActionEvent event) {
    }

    public void sendVideo(ActionEvent event) {
    }

    public void sendPicture(ActionEvent event) {
    }

    public void sendTextMessage(ActionEvent event) {
    }

    public void runChatSetting(ActionEvent event) {
    }

    @Override
    public  void run(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginMenu.class.getResource("/social_media_javafx/chatMenu.fxml"));
            scene = new Scene(fxmlLoader.load());
            if(this instanceof DirectMenu){
                Menu.stage.setTitle("Directs");
            }
            else {
                Menu.stage.setTitle("Groups");
            }
            Menu.stage.setScene(scene);
            Menu.stage.show();
        } catch (Exception e) {
            System.out.println("Error while rendering chatMenu.fxml in ChatMenu.");
            e.printStackTrace();
        }
    }
}
