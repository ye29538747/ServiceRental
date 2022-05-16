package APP.Panel;

import APP.Entity.Item;
import APP.Entity.ItemData;
import APP.Main;
import APP.tools.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchResultController {
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn begintime;
    @FXML
    private TableColumn endtime;
    @FXML
    private TableColumn state;
    @FXML
    private TableColumn no;
    @FXML
    private TableView<ItemData> tableView;
    @FXML
    private TextField search;

    public ArrayList<Item> items;
    public void ShowItem(String str) throws SQLException {
        items= Utils.SearchItems(str);
        if(items==null)return;
        ArrayList<ItemData> itemDatas=new ArrayList<ItemData>();
        for(Item item:items)
        {
            ItemData itemData=new ItemData(item.no,item.name,item.beginTime,item.endTime, item.state);
            itemDatas.add(itemData);
        }
        ObservableList<ItemData> data= FXCollections.observableArrayList(itemDatas);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        begintime.setCellValueFactory(new PropertyValueFactory<>("beginTime"));
        endtime.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        state.setCellValueFactory(new PropertyValueFactory<>("state"));
        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        tableView.setItems(data);
        tableView.setRowFactory(tv->{
            TableRow<ItemData> row=new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(event.getClickCount()==2 && (!row.isEmpty())){
                    ItemData rowData=row.getItem();
                    Item oitem = null;
                    for (Item item:items){
                        if(rowData.getNo()==item.no){
                            oitem=item;
                            break;
                        }
                    }
                    try {
                        OpenItemStage(oitem);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row;
        });

    }

    public void OpenItemStage(Item item) throws IOException {
        Stage stage=new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ApplyItemPanel.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene=new Scene(root,700,500);
        ApplyItemController controller=fxmlLoader.getController();
        controller.SetItem(item);
        controller.ShowMassage();
        stage.setTitle("项目信息");
        stage.setScene(scene);
        stage.show();

    }
    public void initialize() throws SQLException {

    }

    public void ReturnButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainPanel.fxml"));
        Scene scene=new Scene(root);
        Main.ChanceScene(scene);
    }
    public void SearchButton(ActionEvent actionEvent) throws SQLException {
        ShowItem(search.getText());
    }
}
