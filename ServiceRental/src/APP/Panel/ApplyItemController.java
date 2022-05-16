package APP.Panel;

import APP.Entity.Item;
import APP.tools.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ApplyItemController {
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

    public void ApplyItem(ActionEvent actionEvent) throws SQLException {
        System.out.println(item.no);
        if(Utils.ApplyItem(item.no)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("成功");
            alert.setHeaderText("申请成功");
            alert.showAndWait();
        }

    }
}
