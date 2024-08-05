package InnerJoin;

import com.sun.source.tree.BreakTree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Employee {
public static List<emp> getEmployee(){
    ArrayList<emp> itemList=new ArrayList<>();
    Connection con=connection.getConnection();
    try{
        String query="SELECT  e.first_name, e.last_name, e.email, e.salary, d.department_name, jh.start_date, jh.end_date, j.job_title FROM employees e INNER JOIN departments d ON e.department_id = d.department_id INNER JOIN job_history jh ON e.employee_id = jh.employee_id INNER JOIN jobs j ON e.job_id = j.job_id";
        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            emp emp = new emp();
            emp.setName01(rs.getString(1));
            emp.setName02(rs.getString(2));
            emp.setMail(rs.getString(3));
            emp.setSalary(rs.getInt(4));
            emp.setDeptName(rs.getString(5));
            emp.setStartDate(rs.getDate(6));
            emp.setEndDate(rs.getDate(7));
            emp.setEndTittle(rs.getString(8));
            itemList.add(emp);
            System.out.println();
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return itemList;
}
}
