package APP.tools;

import APP.Entity.*;
import APP.Panel.MainController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Utils {
    public static User Login(String name,String password){
        ResultSet rst;
        try {
            if((rst=DBTools.CheckUser(name,password))!=null){
                User user=new User();
                user.no=rst.getInt("user_no");
                user.name=rst.getString("user_name");
                user.password=rst.getString("user_password");
                return user;
            }
            else return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  null;
    }

    public static boolean Register(String name,String password) throws SQLException {
        return DBTools.InsertNewUser(name,password);
    }


    public static boolean isNumeric(String str){
        for(int i=str.length();--i>=0;){
            int chr=str.charAt(i);
            if(chr<48 || chr>57)
                return false;
        }
        return true;
    }

    public static Employee GetEmployee(int id) throws SQLException {
        ResultSet rst=DBTools.GetEmployee(id);
        Employee employee=new Employee();
        if(rst!=null)
        {
            employee.id=id;
            employee.name=rst.getString("e_name");
            employee.sex=rst.getString("e_sex");
            employee.year=rst.getInt("e_year");
            employee.specialty= rst.getString("e_specialty");
            employee.phone=rst.getString("e_phone");
            employee.introduction= rst.getString("e_introduction");
        }
        else return null;
        return employee;
    }
    public static Customer GetCustomer(int id) throws SQLException {
        ResultSet rst=DBTools.GetCustomer(id);
        Customer customer=new Customer();
        if(rst!=null)
        {

            customer.id=id;
            customer.name=rst.getString("c_name");
            customer.sex=rst.getString("c_sex");
            customer.year=rst.getInt("c_year");
            customer.phone=rst.getString("c_phone");
            customer.introduction= rst.getString("c_introduction");
        }
        else return null;
        return customer;
    }
    public static ArrayList<Item> GetUserItems(int id) throws SQLException {
        ResultSet rst=DBTools.GetItems(id);
        ArrayList<Item> items=new ArrayList<Item>();
        if(rst==null)return null;

        do{
            Item item=new Item();
            item.no=rst.getInt("i_no");
            item.name=rst.getString("i_name");
            item.beginTime=rst.getString("i_begin_time");
            item.endTime=rst.getString("i_end_time");
            item.chargePerson_no=rst.getInt("i_chargeperson_no");
            item.information=rst.getString("i_information");
            item.state=rst.getInt("i_state");
            items.add(item);
        }while(rst.next());
        return items;
    }
    public static ArrayList<ApplyItem> GetApplyItem(int id) throws SQLException {
        ResultSet rst=DBTools.GetApplyList(id);
        ArrayList<ApplyItem> applyItems=new ArrayList<>();
        if(rst==null)return null;
        do{
            ApplyItem applyItem=new ApplyItem(rst.getInt("item_no"),rst.getInt("employee_no"));
            applyItems.add(applyItem);
        }while (rst.next());
        return applyItems;
    }
    public static ArrayList<Contract> GetItemsContract(int id) throws SQLException {
        ResultSet rst=DBTools.GetContract(id);

        ArrayList<Contract> contracts=new ArrayList<Contract>();
        if(rst==null)
        {
            return null;
        }
        do{
            int no=rst.getInt("co_no");
            String time=rst.getString("co_time");
            int itemno=rst.getInt("co_item_no");
            String information=rst.getString("co_information");
            int first=rst.getInt("co_firstParty");
            int second=rst.getInt("co_secondParty");
            String fname=Utils.GetCustomer(first).name;
            String sname=Utils.GetEmployee(second).name;
            Contract contract=new Contract(no,time,itemno,information,first,second,fname, sname);
            contracts.add(contract);

        }while(rst.next());
        return contracts;
    }
    public static boolean CreateNewItem(Item item) throws SQLException {
       return DBTools.InsertNewItem(item);
    }
    public static ArrayList<Schedule> GetSchedule(int id) throws SQLException {
        ResultSet rst=DBTools.GetSchedule(id);
        ArrayList<Schedule> schedules=new ArrayList<>();
        if(rst==null)return null;
        do{
            Schedule schedule=new Schedule(rst.getString("s_begin_time"),rst.getString("s_end_time"),
                    rst.getString("s_itemname"),rst.getInt("s_item"),rst.getInt("s_employee"));
            schedules.add(schedule);

        }while (rst.next());
        return schedules;
    }
    public static ArrayList<Item> SearchItems(String str) throws SQLException {
        ResultSet rst=DBTools.SearchItem(str);
        if(rst==null)return null;

        ArrayList<Item> items = new ArrayList<>();
        do{
            Item item=new Item();
            item.no=rst.getInt("i_no");
            item.name=rst.getString("i_name");
            item.beginTime=rst.getString("i_begin_time");
            item.endTime=rst.getString("i_end_time");
            item.chargePerson_no=rst.getInt("i_chargeperson_no");
            item.information=rst.getString("i_information");
            item.state=rst.getInt("i_state");
            items.add(item);
        }while(rst.next());
        return items;
    }
    public static boolean ApplyItem(int item) throws SQLException {

        return DBTools.InsertApply(item,MainController.user.no);

    }
}
