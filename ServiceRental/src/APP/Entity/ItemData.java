package APP.Entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ItemData {
    private final SimpleIntegerProperty no;
    private final SimpleStringProperty name;
    private final SimpleStringProperty beginTime;
    private final SimpleStringProperty endTime;
    private final SimpleStringProperty state;


    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
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

    public String getState() {
        return state.get();
    }

    public SimpleStringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public int getNo() {
        return no.get();
    }

    public SimpleIntegerProperty noProperty() {
        return no;
    }

    public void setNo(int no) {
        this.no.set(no);
    }

    public ItemData(int no, String name, String beginTime, String endTime, int state) {
        this.no=new SimpleIntegerProperty(no);
        this.name = new SimpleStringProperty(name);
        this.beginTime = new SimpleStringProperty(beginTime);
        this.endTime = new SimpleStringProperty(endTime);
        if(state==0)
        {
            this.state = new SimpleStringProperty("招募中");
        }
        else if(state==1)
        {
            this.state=new SimpleStringProperty("进行中");
        }
        else{
            this.state=new SimpleStringProperty("已完成");
        }



    }
}
