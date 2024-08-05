package InnerJoin;

import java.util.List;

public class test {
    public static void main(String[] args) {
        connection.getConnection();
        List<emp> listitem= Employee.getEmployee();

        for(emp emp :listitem){
            System.out.println(emp.toString());
        }
    }
}
