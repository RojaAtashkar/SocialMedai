package client.view;
import client.controller.LoginController;
import client.enums.Message;
import client.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginMenu extends Menu {
    private static LoginMenu instance;
    private static Scene scene;
    public TextField userIDTextBox;
    public TextField passWordTextBox;
    public Label passwordLabel;
    public Label userIDLabel;

    private static User user;
    private LoginController loginController = LoginController.getInstance();
    private static void setInstance(LoginMenu loginMenu){
        instance = loginMenu;
    }
    public static LoginMenu getInstance(){
        if (instance == null){
            setInstance(new LoginMenu());
        }
        return instance;
    }
    @Override
    public void run() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginMenu.class.getResource("/social_media_javafx/loginMenu.fxml"));
            scene = new Scene(fxmlLoader.load());
            Menu.stage.setTitle("SocialMedia");
            Menu.stage.setScene(scene);
            Menu.stage.show();
        } catch (Exception e) {
            System.out.println("Error while rendering loginMenu.fxml in login Menu.");
            e.printStackTrace();
        }
    }
    public void runSignUp(ActionEvent event) {
        SignUpMenu.getInstance().run();
    }
    public void login(ActionEvent event) {
        if (user == null){
            user = new User();
        }
        String userID = userIDTextBox.getText();
        String password = passWordTextBox.getText();

       Message message =  loginController.handleLogin(userID, password, user);
       if(message == Message.SUCCESS){
           //go to main menu
       }
       else if (message == Message.EMPTY_USERNAME || message == Message.NON_EXISTENT_USERNAME){
           userIDLabel.setText(message.toString());
       }
       else {
           passwordLabel.setText(message.toString());
       }
    }
    public void cancel(ActionEvent event) {
    }
    public void setTheme(ActionEvent event) {
    }
}
