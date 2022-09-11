package client.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class ChatMenu extends Menu{
    private static Scene scene;
    public ImageView timeLineImageView;
    public ImageView exploreImageView;
    public ImageView directImageView;
    public ImageView groupImageView;
    public ImageView newGroupImageView;
    public ImageView profileImageView;
    public ImageView SettingImageView;
    public ImageView searchImageview;
    public ImageView imoJImageView;
    public Circle profileImage;

    @FXML
    public void initialize(){
        setBarIcons(timeLineImageView,exploreImageView, directImageView, groupImageView, newGroupImageView, profileImageView, searchImageview);
        setProfileImage(profileImage);
    };
    @Override
    public void run(){  try {
        FXMLLoader fxmlLoader = new FXMLLoader(DirectMenu.class.getResource("/fxml/chatMenu.fxml"));
        scene = new Scene(fxmlLoader.load());
        Menu.stage.setTitle("Directs");
        Menu.stage.setScene(scene);
        Menu.stage.show();
    } catch (Exception e) {
        System.out.println("Error while rendering chatMeu.fxml in direct Menu.");
        System.out.println(e);
        e.printStackTrace();
    }};
    public void newGroupMenu(ActionEvent event){};
    public void runChatSetting(ActionEvent event){};
    public void sendVideo(ActionEvent event){};
    public void sendPicture(ActionEvent event){};
    public void sendTextMessage(ActionEvent event){};
}
