package client.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class DirectMenu extends ChatMenu {
    private static Scene scene;
    private static DirectMenu instance;
    private Text userIDText;
    private TextField userIDTextField;
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
    protected void addFindUser(){
        userIDTextField= new TextField();
        Text text = new Text("Enter UserID:  ");
        Button button = new Button();
        button.setText("Find user");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(text, userIDTextField);
        userIDText = new Text("");
        VBox vBox = new VBox();
        vBox.getChildren().add(userIDText);
        vBox.getChildren().addAll(userIDText, hBox);
        optionsVbox.getChildren().add(vBox);
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
