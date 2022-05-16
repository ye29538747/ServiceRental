package APP.Panel;

import APP.Entity.Item;
import APP.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ItemMassageController {
    @FXML
    private TextField name;
    @FXML
    private TextField beginTime;
    @FXML
    private TextField endTime;
    @FXML
    private TextArea message;
    @FXML
    private TextField state;

    private Item item;

    public void SetItem(Item item){
        this.item=item;
    }

    public void ShowMassage(){
        if(item==null)return;
        name.setText(item.name);
        beginTime.setText(item.beginTime);
        endTime.setText(item.endTime);
        message.setText(item.information);
        if(item.state==0)
        {
            state.setText("招募中");
        }
        else if(item.state==1){
            state.setText("执行中");
        }
        else if(item.state==2){
            state.setText("已完成");
        }
    }
    public void ContractButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ContractChargePanel.fxml"));
        Parent root=fxmlLoader.load();
        ContractChargeController controller=fxmlLoader.getController();
        controller.setItem(this.item);
        controller.ShowContract();
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
    public void ApplyListButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ApplyListPanel.fxml"));
        Parent root=fxmlLoader.load();
        ApplyListController controller=fxmlLoader.getController();
        controller.setItem(this.item);
        controller.ShowList();
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

    }
}
