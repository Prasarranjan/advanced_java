package InnerJoinPractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class employee {
    public static List<emp> saveDetails(){
        ArrayList<emp> listitem =new ArrayList<>();
        Connection con = connection.getConnection();
        try {
            String query="select e.first_name,e.last_name,e.phone_number,e.email,jh.start_date,jh.end_date,j.job_title,d.department_name from employees as e inner join job_history as jh on e.employee_id=jh.employee_id inner join jobs as j on e.job_id=j.job_id inner join departments as d on e.department_id=d.department_id;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                emp empp = new emp();
                empp.setName01(rs.getString(1));
                empp.setName02(rs.getString(2));
                empp.setPhone(rs.getString(3));
                empp.setEmail(rs.getString(4));
                empp.setStartDate(rs.getDate(5));
                empp.setEndDate(rs.getDate(6));
                empp.setJobTitle(rs.getString(7));
                listitem.add(empp);
            }
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        return listitem;
    }
}
