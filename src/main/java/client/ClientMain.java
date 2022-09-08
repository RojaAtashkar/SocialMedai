package client;
import client.view.Menu;
import client.view.SignUpMenu;
import javafx.application.Application;
import javafx.stage.Stage;

import java.lang.reflect.Member;
public class ClientMain extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Menu.stage = primaryStage;
    SignUpMenu.getInstance().run();
    }

}
