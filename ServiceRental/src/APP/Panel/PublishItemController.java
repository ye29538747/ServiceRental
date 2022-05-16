package APP.Panel;

import APP.Entity.Item;
import APP.Main;
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

public class PublishItemController {
    @FXML
    private TextField name;
    @FXML
    private TextField beginTime;
    @FXML
    private TextField endTime;
    @FXML
    private TextArea message;

    @FXML
    public void EnterButtonClick(ActionEvent actionEvent) throws SQLException, IOException {
        if(name.equals("")||beginTime.getText().equals("")||endTime.getText().equals("")||message.getText().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("警告");
            alert.setHeaderText("有信息为空");
            alert.showAndWait();
            return;
        }
        Item item=new Item();
        item.no=0;
        item.name=name.getText();
        item.beginTime=beginTime.getText();
        item.endTime=endTime.getText();
        item.information=message.getText();
        item.chargePerson_no=MainController.user.no;
        item.state=0;
        if(Utils.CreateNewItem(item)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("成功");
            alert.setHeaderText("成功发布");
            alert.showAndWait();
            Parent root = FXMLLoader.load(getClass().getResource("MainPanel.fxml"));
            Scene scene=new Scene(root);
            Main.ChanceScene(scene);
        }

    }

    @FXML
    public void ReturnButtonClick(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainPanel.fxml"));
        Scene scene=new Scene(root);
        Main.ChanceScene(scene);
    }
}
