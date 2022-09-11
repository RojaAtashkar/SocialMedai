package client.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;


public class NewGroupMenu extends Menu{
    private static NewGroupMenu instance = null;
    private static Scene scene;
    public Label groupNameLabel;
    public Label groupIDLabel;
    public Circle profile;
    public TextField groupNameTextField;
    public TextField groupIDTextField;
    public Circle profileImage;

    private static void setInstance(NewGroupMenu instance) {
        NewGroupMenu.instance = instance;
    }
    public static NewGroupMenu getInstance() {
        if (instance == null) {
            setInstance(new NewGroupMenu());
        }
        return instance;
    }
    @Override
    public void run() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginMenu.class.getResource("/social_media_javafx/newGroupMenu.fxml"));
            scene = new Scene(fxmlLoader.load());
            Menu.stage.setTitle("New Group Menu");
            Menu.stage.setScene(scene);
            Menu.stage.show();
        } catch (Exception e) {
            System.out.println("Error while rendering newGroupMenu.fxml in NewGroupMenu.");
            e.printStackTrace();
        }
    }

    public void createNewGroup(ActionEvent event) {
    }

    public void addGroupProfileImage(ActionEvent event) {
    }
}
