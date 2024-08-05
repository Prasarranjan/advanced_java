package callableStatement;

//import callableStatement.Employee;

import java.sql.*;

public class Statement {
    static Connection con =null;
    public  static Connection getConnection() {
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
public static int getEmployeeID(Employee e){
        int status =0;
        Connection con = getConnection();
        try {
            String q1 = "insert into prasar(name,email,address,token_no,result) values (?,?,?,?,?)";
            String q2 = "select slno from prasar where slno = last_insert_id();";
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(q1);

            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getAddress());
            ps.setInt(4, e.getToken_no());
            ps.setBoolean(5, e.isResult());
            ps.executeUpdate();
            ps = con.prepareStatement(q2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                status=rs.getInt(1);
            }
            con.commit();

        }
        catch(Exception f ){
            f.printStackTrace();
        }
        return status;
}

//public static int getEmpId(Employee e) {
//        int empId = 0;
//        try {
//            Connection con = getConnection();
//            String q1 = "insert into Employee(empName,empEmail,empPass,empAdd) values(?,?,?,?)";
//            String q2 = "select empId from employee where empId=Last_insert_id()";
//            con.setAutoCommit(false);
//            PreparedStatement ps = con.prepareStatement(q1);
//            ps.setString(1, e.getEmpName());
//            ps.setString(2, e.getEmpEmail());
//            ps.setString(3, e.getEmpPass());
//            ps.setString(4, e.getEmpAdd());
//            ps.executeUpdate();
//            ps = con.prepareStatement(q2);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                empId = rs.getInt(1);
//            }
//            con.commit();
//            ps.close();
//            con.close();
//        } catch (Exception e2) {
//            e2.printStackTrace();
//        }
//        return empId;
//    }

//    public static void viewEmployeeByCall() {
//        try {
//            Connection con = getConnection();
//            String query = "{call advjava.getEmployee()}";
//            CallableStatement cs = con.prepareCall(query);
//            ResultSet rs = cs.executeQuery();
//            while (rs.next()) {
//                System.out.println("EmpId : " + rs.getInt(1));
//                System.out.println("EmpName : "+rs.getString(2));
//                System.out.println("EmpEmail" + rs.getString(3));
//                System.out.println("EmpPass" + rs.getString(4));
//                System.out.println("EmpAdd : " + rs.getString(5));
//                System.out.println("---------------------------");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

