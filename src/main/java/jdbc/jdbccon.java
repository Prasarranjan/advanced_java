package jdbc;
import javax.imageio.stream.ImageInputStream;
import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class jdbccon {

    public static Connection getconnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hp", "root", "prasar123");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void saveEmployee() {
        int result = 0;
        try {
            Connection con = getconnection();
            String query = "insert into emp values(02,'hararpiya',3433)";
            Statement st = con.createStatement();
            result = st.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        jdbccon.getconnection();
        jdbccon.saveEmployee();
    }
}