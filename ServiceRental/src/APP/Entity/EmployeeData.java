package APP.Entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmployeeData {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty sex;
    private final SimpleIntegerProperty year;
    private final SimpleStringProperty specialty;
    private final SimpleStringProperty phone;
    private final SimpleStringProperty introduction;

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSex() {
        return sex.get();
    }

    public SimpleStringProperty sexProperty() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public int getYear() {
        return year.get();
    }

    public SimpleIntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public String getSpecialty() {
        return specialty.get();
    }

    public SimpleStringProperty specialtyProperty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty.set(specialty);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getIntroduction() {
        return introduction.get();
    }

    public SimpleStringProperty introductionProperty() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction.set(introduction);
    }

    public EmployeeData(int id, String name, String sex, int year, String specialty, String phone, String introduction) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.sex = new SimpleStringProperty(sex);
        this.year = new SimpleIntegerProperty(year);
        this.specialty = new SimpleStringProperty(specialty);
        this.phone = new SimpleStringProperty(phone);
        this.introduction = new SimpleStringProperty(introduction);
    }
}
