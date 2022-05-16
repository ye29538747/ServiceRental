package APP.Panel;

import APP.Entity.*;
import APP.tools.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ApplyListController {
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn sex;
    @FXML
    private TableColumn year;
    @FXML
    private TableColumn phone;
    @FXML
    private TableColumn introduction;
    @FXML
    private TableView tableView;

    private Item item;
    private EmployeeData employeeData=null;

    ArrayList<EmployeeData> employeeDatas;
    ArrayList<ApplyItem> applyItems;
    public void setItem(Item item){
        this.item=item;
    }

    public void ShowList() throws SQLException {
        applyItems= Utils.GetApplyItem(item.no);
        if(applyItems==null)return;
        employeeDatas=new ArrayList<>();
        for(ApplyItem applyItem:applyItems){
            Employee employee=Utils.GetEmployee(applyItem.getEmployee());
            EmployeeData employeeData=new EmployeeData(employee.id,employee.name,employee.sex,employee.year,employee.specialty,employee.phone,employee.introduction);
            employeeDatas.add(employeeData);
        }
        ObservableList<EmployeeData> data= FXCollections.observableArrayList(employeeDatas);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        sex.setCellValueFactory(new PropertyValueFactory<>("sex"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        introduction.setCellValueFactory(new PropertyValueFactory<>("introduction"));
        tableView.setItems(data);
        tableView.setRowFactory(tv->{
            TableRow<EmployeeData> row=new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(event.getClickCount()==1 && (!row.isEmpty())){
                    EmployeeData rowData=row.getItem();
                    employeeData=rowData;

                }
            });
            return row;
        });

    }

    public void EnterButton(ActionEvent actionEvent){
        if(employeeData==null)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("错误");
            alert.setHeaderText("请选中对象");
            alert.showAndWait();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("成功");
        alert.setHeaderText("操作成功");
        alert.showAndWait();
    }
}
