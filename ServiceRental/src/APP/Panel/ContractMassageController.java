package APP.Panel;

import APP.Entity.Contract;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class ContractMassageController {
    @FXML
    Text no;
    @FXML
    Text time;
    @FXML
    Text item_no;
    @FXML
    Text first;
    @FXML
    Text second;
    @FXML
    TextArea information;

    private Contract contract=null;

    public void ShowContract(){
        if(contract==null)return;
        no.setText(String.valueOf(contract.getNo()));
        time.setText(contract.getTime());
        item_no.setText(String.valueOf(contract.getItem_no()));
        first.setText(contract.getFname());
        second.setText(contract.getSname());
        information.setText(contract.getInformation());
    }

    public void setContract(Contract contract){
        this.contract=contract;
    }
}
