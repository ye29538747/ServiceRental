package APP.Entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Schedule {
    private final SimpleStringProperty beginTime;
    private final SimpleStringProperty endTime;
    private final SimpleStringProperty item_name;
    private final SimpleIntegerProperty item_no;
    private final SimpleIntegerProperty employee_no;

    public Schedule(String beginTime, String endTime, String item_name, int item_no, int employee_no) {
        this.beginTime = new SimpleStringProperty(beginTime);
        this.endTime = new SimpleStringProperty(endTime);
        this.item_name = new SimpleStringProperty(item_name);
        this.item_no = new SimpleIntegerProperty(item_no);
        this.employee_no = new SimpleIntegerProperty(employee_no);
    }

    public String getBeginTime() {
        return beginTime.get();
    }

    public SimpleStringProperty beginTimeProperty() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime.set(beginTime);
    }

    public String getEndTime() {
        return endTime.get();
    }

    public SimpleStringProperty endTimeProperty() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime.set(endTime);
    }

    public String getItem_name() {
        return item_name.get();
    }

    public SimpleStringProperty item_nameProperty() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name.set(item_name);
    }

    public int getItem_no() {
        return item_no.get();
    }

    public SimpleIntegerProperty item_noProperty() {
        return item_no;
    }

    public void setItem_no(int item_no) {
        this.item_no.set(item_no);
    }

    public int getEmployee_no() {
        return employee_no.get();
    }

    public SimpleIntegerProperty employee_noProperty() {
        return employee_no;
    }

    public void setEmployee_no(int employee_no) {
        this.employee_no.set(employee_no);
    }
}
