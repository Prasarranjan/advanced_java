package sqlInjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sqlinjection {
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
    public static void getEmployeebyid(String email,Integer token_no){
         Connection con = getConnection();
         try{
             Statement st = con.createStatement();
             String query ="select slno,name,email,address,token_no,result from prasar where email ='"+email+"' and token_no ="+token_no;
             ResultSet rs =st.executeQuery(query);
             while (rs.next()){
                 System.out.println("-----------------------------------------");
                 System.out.println("serial no : "+rs.getInt(1));
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

    public static void main(String[] args) {
       // getConnection();
        getEmployeebyid("harapriya@gamil.com",76);
    }
}

