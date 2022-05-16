package APP.Entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Contract {
    private final SimpleIntegerProperty no;
    private final SimpleStringProperty time;
    private final SimpleIntegerProperty item_no;
    private final SimpleStringProperty information;
    private final SimpleIntegerProperty first;
    private final SimpleIntegerProperty second;
    private final SimpleStringProperty fname;
    private final SimpleStringProperty sname;

    public int getNo() {
        return no.get();
    }

    public SimpleIntegerProperty noProperty() {
        return no;
    }

    public void setNo(int no) {
        this.no.set(no);
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
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

    public String getInformation() {
        return information.get();
    }

    public SimpleStringProperty informationProperty() {
        return information;
    }

    public void setInformation(String information) {
        this.information.set(information);
    }

    public int getFirst() {
        return first.get();
    }

    public SimpleIntegerProperty firstProperty() {
        return first;
    }

    public void setFirst(int first) {
        this.first.set(first);
    }

    public int getSecond() {
        return second.get();
    }

    public SimpleIntegerProperty secondProperty() {
        return second;
    }

    public void setSecond(int second) {
        this.second.set(second);
    }

    public String getFname() {
        return fname.get();
    }

    public SimpleStringProperty fnameProperty() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname.set(fname);
    }

    public String getSname() {
        return sname.get();
    }

    public SimpleStringProperty snameProperty() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname.set(sname);
    }

    public Contract(int no, String time, int item_no, String information, int first, int second, String fname, String sname) {
        this.no = new SimpleIntegerProperty(no);
        this.time = new SimpleStringProperty(time);
        this.item_no = new SimpleIntegerProperty(item_no);
        this.information = new SimpleStringProperty(information);
        this.first = new SimpleIntegerProperty(first);
        this.second = new SimpleIntegerProperty(second);
        this.fname=new SimpleStringProperty(fname);
        this.sname=new SimpleStringProperty(sname);
    }
}
