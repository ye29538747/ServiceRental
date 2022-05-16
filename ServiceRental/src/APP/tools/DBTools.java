package APP.tools;
import APP.Entity.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTools {
    private static DBConnet db1;

    public static ResultSet CheckUser(String name,String password) throws SQLException {
        db1=new DBConnet();
        ResultSet rst=null;
        String sql;
        sql="select* from user where user_name=? and user_password=?";
        PreparedStatement pst=db1.conn.prepareStatement(sql);
        pst.setString(1,name);
        pst.setString(2,password);
        rst= pst.executeQuery();
        if(rst.next())
        {
            return rst;
        }
        else return null;
    }
    public static ResultSet CheckUser(String name) throws SQLException {
        db1=new DBConnet();
        ResultSet rst=null;
        String sql;
        sql="select* from user where user_name=?";
        PreparedStatement pst=db1.conn.prepareStatement(sql);
        pst.setString(1,name);
        rst= pst.executeQuery();
        if(rst.next())
        {
            return rst;
        }
        else return null;
    }

    public static boolean InsertNewUser(String name,String password) throws SQLException {
        db1=new DBConnet();
        ResultSet rst=null;
        String sql;
        PreparedStatement pst;
        if(CheckUser(name)!=null)
        {
            return false;
        }
        sql="insert into user values (?,?,?)";
        pst=db1.conn.prepareStatement(sql);
        pst.setString(1,"0");
        pst.setString(2,name);
        pst.setString(3,password);
        pst.execute();
        return  true;
    }

    public static ResultSet GetEmployee(int id) throws SQLException {
        db1=new DBConnet();
        ResultSet rst=null;
        String sql;
        sql="select* from employee where e_no=?";
        PreparedStatement pst=db1.conn.prepareStatement(sql);
        pst.setString(1,String.valueOf(id));
        rst= pst.executeQuery();
        if(rst.next())
        {
            return rst;
        }
        else return null;
    }
    public static ResultSet GetCustomer(int id) throws SQLException {
        db1=new DBConnet();
        ResultSet rst=null;
        String sql;
        sql="select* from customer where c_no=?";
        PreparedStatement pst=db1.conn.prepareStatement(sql);
        pst.setString(1,String.valueOf(id));
        rst= pst.executeQuery();
        if(rst.next())
        {
            return rst;
        }
        else return null;
    }
    public static ResultSet GetItems(int id) throws SQLException {
        db1=new DBConnet();
        ResultSet rst=null;
        String sql;
        sql="select* from item where i_chargeperson_no=?";
        PreparedStatement pst=db1.conn.prepareStatement(sql);
        pst.setString(1,String.valueOf(id));
        rst= pst.executeQuery();
        if(rst.next())
        {
            return rst;
        }
        else return null;
    }
    public static ResultSet GetContract(int id) throws SQLException {
        db1=new DBConnet();
        ResultSet rst=null;
        String sql;
        sql="select* from contract where co_item_no=?";
        PreparedStatement pst=db1.conn.prepareStatement(sql);
        pst.setString(1,String.valueOf(id));
        rst= pst.executeQuery();
        if(rst.next())
        {
            return rst;
        }
        else return null;
    }
    public static ResultSet GetSchedule(int id) throws SQLException {
        db1=new DBConnet();
        ResultSet rst=null;
        String sql;
        sql="select* from schedule where s_employee=?";
        PreparedStatement pst=db1.conn.prepareStatement(sql);
        pst.setString(1,String.valueOf(id));
        rst= pst.executeQuery();
        if(rst.next())
        {
            return rst;
        }
        else return null;
    }
    public static ResultSet GetApplyList(int id) throws SQLException {
        db1=new DBConnet();
        ResultSet rst=null;
        String sql;
        sql="select* from applyitem where item_no=?";
        PreparedStatement pst=db1.conn.prepareStatement(sql);
        pst.setString(1,String.valueOf(id));
        rst= pst.executeQuery();
        if(rst.next())
        {
            return rst;
        }
        else return null;
    }
    public static ResultSet SearchItem(String str) throws SQLException {
        db1=new DBConnet();
        ResultSet rst=null;
        String sql;
        sql="select* from item where i_name regexp ?";
        PreparedStatement pst=db1.conn.prepareStatement(sql);
        pst.setString(1,String.valueOf(str));
        rst= pst.executeQuery();
        if(rst.next())
        {
            return rst;
        }
        else return null;
    }
    public  static boolean InsertNewEmployee(int id) throws SQLException {
        db1=new DBConnet();
        String sql;
        PreparedStatement pst;

        sql="insert into employee values (?,?,?,?,?,?,?)";
        pst=db1.conn.prepareStatement(sql);
        pst.setString(1,String.valueOf(id));
        pst.setString(2,"");
        pst.setString(3,"");
        pst.setString(4,"0");
        pst.setString(5,"");
        pst.setString(6,"");
        pst.setString(7,"");
        pst.execute();
        return  true;
    }
    public  static boolean UpdateEmployee(int no, Employee employee) throws SQLException {
        db1=new DBConnet();
        String sql;
        PreparedStatement pst;

        sql="update employee set e_name=?,e_sex=?,e_year=?,e_specialty=?,e_phone=?,e_introduction=? where e_no=?";
        pst=db1.conn.prepareStatement(sql);
        pst.setString(1,employee.name);
        pst.setString(2,employee.sex);
        pst.setString(3,String.valueOf(employee.year));
        pst.setString(4,employee.specialty);
        pst.setString(5,employee.phone);
        pst.setString(6,employee.introduction);
        pst.setString(7,String.valueOf(no));
        pst.execute();
        return  true;
    }
    public static boolean InsertNewCustomer(int id) throws SQLException {
        db1=new DBConnet();
        String sql;
        PreparedStatement pst;

        sql="insert into customer values (?,?,?,?,?,?)";
        pst=db1.conn.prepareStatement(sql);
        pst.setString(1,String.valueOf(id));
        pst.setString(2,"");
        pst.setString(3,"");
        pst.setString(4,"0");
        pst.setString(5,"");
        pst.setString(6,"");
        pst.execute();
        return  true;
    }
    public static boolean UpdateCustomer(int no, Customer customer) throws SQLException {
        db1=new DBConnet();
        String sql;
        PreparedStatement pst;

        sql="update customer set c_name=?,c_sex=?,c_year=?,c_phone=?,c_introduction=? where c_no=?";
        pst=db1.conn.prepareStatement(sql);
        pst.setString(1, customer.name);
        pst.setString(2, customer.sex);
        pst.setString(3, String.valueOf(customer.year));
        pst.setString(4,customer.phone);
        pst.setString(5, customer.introduction);
        pst.setString(6,String.valueOf(no));
        pst.execute();
        return  true;
    }
    public static boolean InsertNewItem(Item item) throws SQLException {
        db1=new DBConnet();
        ResultSet rst=null;
        String sql;
        PreparedStatement pst;
        sql="insert into item values (?,?,?,?,?,?,?)";
        pst=db1.conn.prepareStatement(sql);
        pst.setString(1,"0");
        pst.setString(2,item.name);
        pst.setString(3, item.beginTime);
        pst.setString(4, item.endTime);
        pst.setInt(5, item.chargePerson_no);
        pst.setString(6, item.information);
        pst.setInt(7,item.state);
        pst.execute();
        return  true;
    }
    public static boolean InsertApply(int item,int employee) throws SQLException {
        db1=new DBConnet();
        ResultSet rst=null;
        String sql;
        PreparedStatement pst;
        sql="insert into applyitem values (?,?)";
        pst=db1.conn.prepareStatement(sql);
        pst.setInt(1,item);
        pst.setInt(2,employee);
        pst.execute();
        return true;
    }


}
