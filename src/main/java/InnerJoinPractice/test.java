package InnerJoinPractice;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        //  connection.getConnection();
        List<emp> list=employee.saveDetails();
        for (emp emp :list){
            System.out.println(emp.toString());
        }
    }
}
