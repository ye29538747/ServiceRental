package APP.Panel;

import APP.Entity.Contract;
import APP.Entity.Item;
import APP.Entity.ItemData;
import APP.tools.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContractChargeController {
    @FXML
    private TableColumn no;
    @FXML
    private TableColumn time;
    @FXML
    private TableColumn first;
    @FXML
    private TableColumn second;
    @FXML
    private TableView<Contract> tableView;

    private ArrayList<Contract> contracts;

    public Item item;

    public void ShowContract() throws SQLException {
        contracts=Utils.GetItemsContract(item.no);
        if(contracts==null)return;
        ObservableList<Contract> data= FXCollections.observableArrayList(contracts);
        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        first.setCellValueFactory(new PropertyValueFactory<>("fname"));
        second.setCellValueFactory(new PropertyValueFactory<>("sname"));
        tableView.setItems(data);
        tableView.setRowFactory(tv->{
            TableRow<Contract> row=new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(event.getClickCount()==2 && (!row.isEmpty())){
                    Contract rowData=row.getItem();
                    System.out.println(rowData);
                    try {
                        OpenContractStage(rowData);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
            return row;
        });

    }
    public void setItem(Item item){
        this.item=item;
    }
    public void OpenContractStage(Contract contract) throws IOException {
        Stage stage=new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ContractMassagePanel.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene=new Scene(root,700,500);
        ContractMassageController controller=fxmlLoader.getController();
        controller.setContract(contract);
        controller.ShowContract();
        stage.setTitle("合同信息");
        stage.setScene(scene);
        stage.show();

    }
}
