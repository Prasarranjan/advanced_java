package InnerJoinPractice;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
    public static Connection getConnection(){
        Connection con = null ;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","prasar123");
            if (con != null) {
                System.out.println("connected");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return con ;
    }
}
