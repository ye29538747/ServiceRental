package APP.Panel;

import APP.Main;
import APP.tools.DBTools;
import APP.tools.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RegisterController {
    @FXML
    private TextField name;
    @FXML
    private TextField password;
    @FXML
    private TextField repassword;
    @FXML
    private Text repeat_check;
    @FXML
    private Text name_check;
    @FXML
    private Text password_check;

    @FXML
    public void RegisterButtonClick(ActionEvent actionEvent) throws SQLException, IOException {
        name_check.setText("");
        password_check.setText("");
        repeat_check.setText("");
        String sname=name.getText();
        String spassword=password.getText();
        String srepassword=repassword.getText();
        if(sname.equals("") || spassword.equals("") || repassword.equals("")) {
            if (sname.equals("")) {
                name_check.setText("帐号不能为空");
            }
            if (spassword.equals("")) {
                password_check.setText("密码不能为空");
            }
            if (srepassword.equals("")) {
                repeat_check.setText("重复密码不能为空");
            }
            return;
        }
        if(!spassword.equals(srepassword)) {
            repeat_check.setText("两次密码不一致");
            return;
        }
        if(Utils.Register(sname,spassword)){
            ResultSet rst= DBTools.CheckUser(sname);
            int id=rst.getInt(1);
            DBTools.InsertNewCustomer(id);
            DBTools.InsertNewEmployee(id);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("注册");
            alert.setHeaderText("注册成功");
            alert.showAndWait();
            Parent root = FXMLLoader.load(getClass().getResource("LoginPanel.fxml"));
            Scene scene=new Scene(root);
            Main.ChanceScene(scene);
            return;
        }
        else{
             name_check.setText("账号已存在");
        }

    }

    @FXML
    public void Return(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginPanel.fxml"));
        Scene scene=new Scene(root);
        Main.ChanceScene(scene);
    }
}
