package APP;

import APP.Entity.User;
import APP.Panel.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage stage;
    private Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Panel/LoginPanel.fxml"));

        primaryStage.setTitle("服务租凭系统");
        primaryStage.setScene(new Scene(root,700,500));
        primaryStage.show();

    }

    public static void ChanceScene(Scene scene) throws IOException {
        stage.setScene(scene);
    }

    public static void main(String[] args) {

        launch(args);
    }
}
