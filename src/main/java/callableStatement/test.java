package callableStatement;

import callableStatement.Employee;
public class test {
    public static void main(String[] args) {
//
//        Employee emp = new Employee();
//  emp.setEmpAdd("Khorda");//  emp.setEmpEmail("rahul@gmail.com");
//  emp.setEmpName("Rahul");//  emp.setEmpPass("989887");
//  int empId=Statement.getEmpId(emp);//  System.out.println("EmpId : "+empId);
      Employee emp =new Employee();
      emp.setName("surajit");
      emp.setAddress("nbrgpr");
      emp.setEmail("sura@gmail.com");
      emp.setToken_no(89);
      emp.setResult(false);
      int empid =Statement.getEmployeeID(emp);
        System.out.println("empId ="+empid);
    }
}
