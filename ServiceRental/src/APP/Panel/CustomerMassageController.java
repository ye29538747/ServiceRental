package APP.Panel;

import APP.Entity.Customer;
import APP.Entity.Employee;
import APP.Main;
import APP.tools.DBTools;
import APP.tools.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerMassageController {
    @FXML
    private TextField name;
    @FXML
    private TextField sex;
    @FXML
    private TextField year;
    @FXML
    private TextField phone;
    @FXML
    private TextArea selfIntroduce;


    @FXML
    public void EnterButtonClick(ActionEvent actionEvent) throws SQLException, IOException {
        Customer customer= new Customer();
        customer.id=MainController.user.no;
        customer.name=name.getText();
        customer.sex=sex.getText();
        if(!Utils.isNumeric(year.getText())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("错误");
            alert.setHeaderText("年龄必须为数字");
            alert.showAndWait();
            return;
        }
        else if(year.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("错误");
            alert.setHeaderText("年龄不能为空");
            alert.showAndWait();
            return;
        }
        customer.year=Integer.parseInt(year.getText());
        customer.phone=phone.getText();
        customer.introduction=selfIntroduce.getText();
        if(DBTools.UpdateCustomer(customer.id,customer)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("成功");
            alert.setHeaderText("信息更新成功");
            alert.showAndWait();
        }
    }
    @FXML
    public void ReturnButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainPanel.fxml"));
        Scene scene=new Scene(root);
        Main.ChanceScene(scene);
    }
    public void initialize() throws SQLException {
        Customer customer=Utils.GetCustomer(MainController.user.no);
        if(customer==null)return;
        name.setText(customer.name);
        sex.setText(customer.sex);
        year.setText(String.valueOf(customer.year));
        phone.setText(customer.phone);
        selfIntroduce.setText(customer.introduction);
    }


}
