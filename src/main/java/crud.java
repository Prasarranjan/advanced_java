import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class crud {
    public static Connection getConnection(){
      Connection Con =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","prasar123");
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
    public static int saveDetails(String name,String email,String address,int token_no,Boolean Status){
        int result=0;
        Connection con =getConnection();


        try {
            String query="insert into prasar(name,email,address,token_no,result) values ('"+name+"','"+email+"','"+address+"',"+token_no+","+Status+");";
            Statement st = con.createStatement();
            result=st.executeUpdate(query);
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
    public static  void updateDetails(String name,String email,String address,int token_no,boolean status,int slno){
        int result =0;
        Connection con = getConnection();
        try{
            String query ="update prasar set name ='"+name+"',email='"+email+"',address='"+address+"',token_no="+token_no+",result="+status+" where slno ="+slno;
            Statement st = con.createStatement();
            result=st.executeUpdate(query);
            if (result>0){
                System.out.println("successfully deleted");
            }
            else{
                System.out.println("not deleted");
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
            String query="delete from prasar where slno="+slno+";";
            Statement st = con.createStatement();
            result =st.executeUpdate(query);
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

    public static void main(String[] args) {
        //getConnection();

//        Scanner sc =new Scanner(System.in);
//        System.out.println("enter your name :");
//        String name = sc.nextLine();
//        System.out.println("enter your email :");
//        String email = sc.next();
//        System.out.println("enter your city :");
//        String address = sc.next();
//        System.out.println("enter your token number :");
//        int token_no = sc.nextInt();
//        System.out.println("enter your status :");
//        Boolean Status = sc.nextBoolean();
//    saveDetails(name,email,address,token_no,Status);
        //showDetails();
        //deletegetemployeebyId(1);
       // updateDetails("sambit mohanty","sambit@gmail.com","puri",73,false,7);

    }
}
