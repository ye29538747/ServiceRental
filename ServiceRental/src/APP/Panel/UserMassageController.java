package APP.Panel;

import APP.Entity.User;
import APP.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;

import java.io.IOException;

public class UserMassageController {
    @FXML
    private Text name;
    @FXML
    private Text password;

    public void initialize(){
        name.setText(MainController.user.name);
        password.setText(MainController.user.password);
    }

    @FXML
    public void ReturnButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainPanel.fxml"));
        Scene scene=new Scene(root);
        Main.ChanceScene(scene);
    }
}
