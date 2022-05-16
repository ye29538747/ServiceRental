package APP.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBConnet {
    public static final String url = "jdbc:mysql://127.0.0.1/servicerental";
    public static final String name = "com.mysql.cj.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "29538747";

    public Connection conn = null;

    public DBConnet() {
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url,user,password);//获取连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
