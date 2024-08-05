package callableStatementPractice;

public class test {
    public static void main(String[] args) {
      // Statement.getConnection();
        Employee emp = new Employee();
        emp.setName("gulu");
        emp.setMail("gulu@gmail.com");
        emp.setAddress("bdk");
        emp.setToken_no(88);
        emp.setResult(true);
        int empid=Statement.getEmpid(emp);
        System.out.println("emp id = "+empid);

    }
}
