package example.SpringBootRestfulClient.model;

public class Employee {
    private String empNo;
    private String empName;
    private String position;

    public Employee(){}

    public Employee(String empNo, String empName, String position){
        this.empNo = empNo;
        this.empName = empName;
        this.position = position;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public String getPosition() {
        return position;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
