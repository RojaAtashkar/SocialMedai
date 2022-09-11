package client.view;

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
    @FXML
    public void initialize(){

    }
}
