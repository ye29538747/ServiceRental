package APP.Panel;

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

public class EmployeeMassageController {
    @FXML
    private TextField name;
    @FXML
    private TextField sex;
    @FXML
    private TextField year;
    @FXML
    private TextField speciality;
    @FXML
    private TextField phone;
    @FXML
    private TextArea selfIntroduce;


    @FXML
    public void EnterButtonClick(ActionEvent actionEvent) throws SQLException, IOException {
        Employee employee=new Employee();
        employee.id=MainController.user.no;
        employee.name=name.getText();
        employee.sex=sex.getText();
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
        employee.year=Integer.parseInt(year.getText());
        employee.specialty=speciality.getText();
        employee.phone=phone.getText();
        employee.introduction=selfIntroduce.getText();
        if(DBTools.UpdateEmployee(employee.id,employee)){
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
        Employee employee=Utils.GetEmployee(MainController.user.no);
        if(employee==null)return;
        name.setText(employee.name);
        sex.setText(employee.sex);
        year.setText(String.valueOf(employee.year));
        speciality.setText(employee.specialty);
        phone.setText(employee.phone);
        selfIntroduce.setText(employee.introduction);
    }


}
