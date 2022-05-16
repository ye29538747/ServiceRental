package APP.Entity;

import javafx.beans.property.SimpleIntegerProperty;

public class ApplyItem {
    private final SimpleIntegerProperty item;
    private final SimpleIntegerProperty employee;

    public ApplyItem(int item, int employee) {
        this.item =new SimpleIntegerProperty(item);
        this.employee = new SimpleIntegerProperty(employee);
    }

    public int getItem() {
        return item.get();
    }

    public SimpleIntegerProperty itemProperty() {
        return item;
    }

    public void setItem(int item) {
        this.item.set(item);
    }

    public int getEmployee() {
        return employee.get();
    }

    public SimpleIntegerProperty employeeProperty() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee.set(employee);
    }
}
