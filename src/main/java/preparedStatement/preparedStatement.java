package preparedStatement;

import java.sql.*;

public class preparedStatement {
    public static Connection getConnection(){
        Connection Con =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","prasar123");
            if (Con!=null){
                System.out.println("database successfully connected");
            }
            else {
                System.out.println("database connection failed");
            }
        }
        catch (Exception e ){
            e.printStackTrace();
        }

        return Con;
    }
    public static int saveDetails(int slno,String name,String email,String address,int token_no,Boolean Status){
        int result=0;
        Connection con =getConnection();


        try {
            String query="insert into prasar(slno,name,email,address,token_no,result) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,slno);
            ps.setString(2,name);
            ps.setString(3,email);
            ps.setString(4,address);
            ps.setInt(5,token_no);
            ps.setBoolean(6,Status);
            result=ps.executeUpdate();



            if (result>0){
                System.out.println("data successfully inserted");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public static void showDetails(){
        Connection con = getConnection();
        try {
            String query = "select slno,name,email,address,token_no,result  from prasar;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                System.out.println("*********************************************");
                System.out.println("serial no : "+rs.getInt(1));
                System.out.println("---------------");
                System.out.println("name : "+rs.getString(2));
                System.out.println("email : "+rs.getString(3));
                System.out.println("address : "+rs.getString(4));
                System.out.println("token_no : "+rs.getInt(5));
                System.out.println("result : "+rs.getBoolean(6));
                System.out.println("*********************************************");
                System.out.println();
            }
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }
    public static void getEmployeebyid(String email,Integer token_no){
        Connection con = getConnection();
        try{
            Statement st = con.createStatement();
            String query ="select slno,name,email,address,token_no,result from prasar where email = ? and token_no =?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,email);
            ps.setInt(2,token_no);
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                System.out.println("******************************************");
                System.out.println("serial no : "+rs.getInt(1));
                System.out.println("-----------------------------------------");
                System.out.println("name : "+rs.getString(2));
                System.out.println("email : "+rs.getString(3));
                System.out.println("address : "+rs.getString(4));
                System.out.println("token_no : "+rs.getInt(5));
                System.out.println("result : "+rs.getBoolean(6));
                System.out.println("------------------------------------------");
                System.out.println();
            }
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }
    public static  void updateDetails(String name,String email,String address,int token_no,boolean status,int slno){
        int result =0;
        Connection con = getConnection();
        try{
            String query ="update prasar set name =?,email=?,address=?,token_no=?,result=? where slno =?";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,address);
            ps.setInt(4,token_no);
            ps.setBoolean(5,status);
            ps.setInt(6,slno);

            result=ps.executeUpdate();
            if (result>0){
                System.out.println("successfully updated");
            }
            else{
                System.out.println("not updated");
            }
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }
    public static int deletegetemployeebyId(int slno){
        int result =0;
        Connection con =getConnection();
        try{
            String query="delete from prasar where slno=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,slno);
            result =ps.executeUpdate();
            if (result > 0) {
                System.out.println("data deleted");
            }
            else {
                System.out.println("data not deleted");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    }