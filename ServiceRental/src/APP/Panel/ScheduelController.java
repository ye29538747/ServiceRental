package APP.Panel;

import APP.Entity.Contract;
import APP.Entity.Schedule;
import APP.Main;
import APP.tools.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduelController {
    @FXML
    TableColumn beginTime;
    @FXML
    TableColumn endTime;
    @FXML
    TableColumn item_no;
    @FXML
    TableColumn item_name;
    @FXML
    TableView tableView;

    private ArrayList<Schedule> schedules;

    public void ShowSchedule() throws SQLException {
        schedules= Utils.GetSchedule(MainController.user.no);
        if(schedules==null)return;
        ObservableList<Schedule> data=FXCollections.observableArrayList(schedules);
        beginTime.setCellValueFactory(new PropertyValueFactory<>("beginTime"));
        endTime.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        item_no.setCellValueFactory(new PropertyValueFactory<>("item_no"));
        item_name.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        tableView.setItems(data);
    }


    public void initialize() throws SQLException {
        ShowSchedule();
    }

    @FXML
    public void ReturnButtonClick(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainPanel.fxml"));
        Scene scene=new Scene(root);
        Main.ChanceScene(scene);
    }
}
