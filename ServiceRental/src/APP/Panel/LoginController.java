package APP.Panel;

import APP.Entity.User;
import APP.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import APP.tools.Utils;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField nameTextfield;
    @FXML
    private TextField passwordTextfield;
    @FXML
    private AnchorPane rootPane;


    public void LoginButtonClick(ActionEvent actionEvent) throws IOException {
        String name=nameTextfield.getText();
        String password=passwordTextfield.getText();
        if(name.equals("") || password.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("错误");
            alert.setHeaderText("帐号或密码为空");
            alert.showAndWait();
        }
        else if((MainController.user=Utils.Login(name,password))!=null)
        {
            Parent root = FXMLLoader.load(getClass().getResource("MainPanel.fxml"));
            Scene scene=new Scene(root);
            Main.ChanceScene(scene);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("错误");
            alert.setHeaderText("用户名或密码错误");
            alert.showAndWait();
        }

    }
    @FXML
    private void RegisterButtonClick(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RegisterPanel.fxml"));
        Scene scene=new Scene(root);
        Main.ChanceScene(scene);
    }

}
