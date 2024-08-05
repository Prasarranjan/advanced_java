package InnerJoin;

import java.sql.Date;

public class emp {

    private String name01;
    private String name02;
    private String mail;
    private int salary;
    private String deptName;
    private Date startDate;
    private Date endDate;
    private String endTittle;

    public String getName01(String string) {
        return name01;
    }

    public void setName01(String name01) {
        this.name01 = name01;
    }

    public String getName02(String string) {
        return name02;
    }

    public void setName02(String name02) {
        this.name02 = name02;
    }

    public String getMail(String string) {
        return mail;
    }

    // Setter for mail
    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getSalary(int anInt) {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDeptName(String string) {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getStartDate(Date date) {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate(Date date) {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEndTittle(String string) {
        return endTittle;
    }

    public void setEndTittle(String endTittle) {
        this.endTittle = endTittle;
    }

    @Override
    public String toString() {
        return "emp {" +
                "emp first name ='" + name01 + '\'' +
                ", emp last name='" + name02 + '\'' +
                ", mail='" + mail + '\'' +
                ", salary=" + salary +
                ", deptName='" + deptName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", endTittle='" + endTittle + '\'' +
                '}';
    }
}
