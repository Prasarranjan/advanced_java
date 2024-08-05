package jdbc;

import java.sql.*;
import java.util.*;
public class jjddbbcc {
    public static  Connection getConnection(){
        Connection con =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prasar","root","prasar123");
     if (con !=null){
         System.out.println("database connected");
     }
     else{
         System.out.println("database not connected");
     }
        }
        catch (Exception e  ){
            e.printStackTrace();

        }
        return con;
    }
    public static void saveDetails(){
        int result =0;
        try {
            Connection con = getConnection();
            String query = "insert into details values (01,'prasar','talcher',2314)";
            Statement st = con.createStatement();
            result=st.executeUpdate(query);
            if(result>0){
                System.out.println("data inserted");
            }
            else {
                System.out.println("data not inserted");
            }

        }
        catch(Exception e ) {
            e.printStackTrace();
        }
        }
        public static void enterDetails(String slno,String name ,String adress,String idno){
        int result =0;
        try {
         Connection con = getConnection();
         String query = "insert into details values ("+slno+",'"+name+"','"+adress+"',"+idno+")";
         Statement st = con.createStatement();
         result= st.executeUpdate(query);
                if(result >0){
                    System.out.println("data inserted");
                }
                else{
                    System.out.println("data not inserted");
                }
        }
        catch (Exception e ){
e.printStackTrace();
        }
        }
//        public static void showDetails(){
//        try {
//            Connection con = getConnection();
//            String query = "select * from details";
//            Statement st = con.createStatement();
//            st.executeUpdate(query);
//            System.out.println("go to database and cheak details");
//        }
//        catch(Exception e ){
//            e.printStackTrace();
//        }
    //    }
    public static void viewDetails(){
try {
    Connection con = getConnection();
    String query = "select slno,name,adress,idno from details";
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(query);
    while (rs.next()) {
        System.out.println("**************************************");
        System.out.println("slno - " + rs.getInt(1));
        System.out.println("name - " + rs.getString(2));
        System.out.println("adress - " + rs.getString(3));
        System.out.println("idno - " + rs.getInt(4));
        System.out.println("**************************************");
        System.out.println();
    }
}
catch (Exception e){
    e.printStackTrace();
}

    }
    public static int updateDetails(String name,String adress,int idno,int slno){
        Connection con =getConnection();
        int result =0;
        try{
            String Query ="update details set name='"+name+"',adress='"+adress+"',idno="+idno+" where slno="+slno;
            Statement st= con.createStatement();
            result = st.executeUpdate(Query);
            if (result>0){
                System.out.println("sucessfully updated");
            }
            else {
                System.out.println("not updated");
            }
        }
        catch (Exception e){
            System.out.println("problem arise");
            e.printStackTrace();
        }
        return result;

    }
    public static  int deleteDetails(int slno){
       int  result=0;
       try{
           Connection con = getConnection();
           String query="delete from details where slno ="+slno;
           Statement st = con.createStatement();
           result= st.executeUpdate(query);
           if (result>0){
               System.out.println("sucessfully deleted");
           }
           else {
               System.out.println("not deleted");
           }
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return result;
    }
    public static void main(String[] args) {
       // jjddbbcc.getConnection();
       // jjddbbcc.saveDetails();
//        Scanner sc =new Scanner(System.in);
//        System.out.println("enter serial no :" );
//        String slno= sc.next();
//        System.out.println("enter your name :" );
//        String name= sc.next();
//        System.out.println("enter your adress :" );
//        String adress= sc.next();
//        System.out.println("enter your id no :" );
//        String idno= sc.next();
        //jjddbbcc.enterDetails(slno,name,adress,idno);
      //  jjddbbcc.showDetails();
      // jjddbbcc.viewDetails();
      //  updateDetails("harapriya","bdk",6454,4);
        //deleteDetails(6);
  //saveDetails();


    }

}
