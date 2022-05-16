package APP.Panel;

import APP.Entity.User;
import APP.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class MainController {
    public static User user;
    @FXML
    private TextField textField;


    @FXML
    public void EmployeeMassageButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EmployeeMassagePanel.fxml"));
        Scene scene=new Scene(root);
        Main.ChanceScene(scene);
    }
    @FXML
    public void EmployeeItemButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainPanel.fxml"));
        Scene scene=new Scene(root);
        Main.ChanceScene(scene);
    }
    @FXML
    public void EmployeeSchduleButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ScheduelPanel.fxml"));
        Scene scene=new Scene(root);
        Main.ChanceScene(scene);
    }
    @FXML
    public void CustomerMassageButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CustomerMassagePanel.fxml"));
        Scene scene=new Scene(root);
        Main.ChanceScene(scene);
    }
    @FXML
    public void CustomerItemButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ItemChargePanel.fxml"));
        Scene scene=new Scene(root);
        Main.ChanceScene(scene);
    }
    @FXML
    public void CustomerPublishItem(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PublishItemPanel.fxml"));
        Scene scene=new Scene(root);
        Main.ChanceScene(scene);
    }
    @FXML
    public void UserMassage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserMassagePanel.fxml"));
        Scene scene=new Scene(root);
        Main.ChanceScene(scene);
    }
    @FXML
    public void SearchButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("SearchResultPanel.fxml"));
        Parent root = fxmlLoader.load();
        SearchResultController controller=fxmlLoader.getController();
        controller.ShowItem(textField.getText());
        Scene scene=new Scene(root);
        Main.ChanceScene(scene);
    }

    }
