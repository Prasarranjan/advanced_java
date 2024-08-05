package callableStatementPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import callableStatementPractice.Employee;

public class Statement {
    public  static Connection getConnection() {
        Connection con =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","prasar123");

            if (con!=null){
                System.out.println("db connected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public static int getEmpid(Employee e){
        int status=0;
        Connection con = getConnection();
        try {
            String q1="insert into prasar(name,email,address,token_no,result) values (?,?,?,?,?)";
            String q2="select slno from prasar where slno=last_insert_id()";
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(q1);
            ps.setString(1,e.getName());
            ps.setString(2,e.getMail());
            ps.setString(3,e.getAddress());
            ps.setInt(4,e.getToken_no());
            ps.setBoolean(5,e.getResult());
            ps.executeUpdate();
            ps= con.prepareStatement(q2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
               status= rs.getInt(1);
            }
            con.commit();
        }
        catch (Exception f ){
              f.printStackTrace();
        }
        return status;
    }
}
