package InnerJoin;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
    static Connection con =null;
    public  static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","prasar123");

            if (con!=null){
                System.out.println("db connected");
            }
        } catch (Exception e) {
e.printStackTrace();
        }
        return con;
    }
}
