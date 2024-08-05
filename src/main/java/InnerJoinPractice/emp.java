package InnerJoinPractice;
import java.sql.*;
public class emp {
    private String name01;
    private String name02;
    private String phone;
    private String email;
    private Date startDate;
    private Date endDate;
    private String jobTitle;

    // Getter and Setter methods
    public String getName01() {
        return name01;
    }

    public void setName01(String name01) {
        this.name01 = name01;
    }

    public String getName02() {
        return name02;
    }

    public void setName02(String name02) {
        this.name02 = name02;
    }

    public String getPhone(String Stringa) {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.sql.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public java.sql.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    // toString method
    @Override
    public String toString() {
        return
                "emp {" +
                "name01='" + name01 + '\'' +
                ", name02='" + name02 + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
