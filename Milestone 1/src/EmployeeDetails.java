// https://stackoverflow.com/questions/53116921/matching-user-input-against-a-string-array-in-java
// use this in the future
public class EmployeeDetails extends EmployeeData {
    private String employeeId;
    private String employeeLName;
    private String employeeFName;
    private String employeeBday;
    private String employeeAddr;
    private String employeePhNo;
    private String employeeSss;
    private String employeePhHealth;
    private String employeeTin;
    private String employeePagIbig;
    private double employeeSalary;
    private double employeeSemiMonthlyRate;
    private double employeeHourlyRate;

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeLName() {
        return employeeLName;
    }

    public String getEmployeeFName() {
        return employeeFName;
    }

    public String getEmployeeBday() {
        return employeeBday;
    }

    public String getEmployeeAddr() {
        return employeeAddr;
    }

    public String getEmployeePhNo() {
        return employeePhNo;
    }

    public String getEmployeeSss() {
        return employeeSss;
    }

    public String getEmployeePhHealth() {
        return employeePhHealth;
    }

    public String getEmployeeTin() {
        return employeeTin;
    }

    public String getEmployeePagIbig() {
        return employeePagIbig;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public double getEmployeeSemiMonthlyRate() {
        return employeeSemiMonthlyRate;
    }

    public double getEmployeeHourlyRate() {
        return employeeHourlyRate;
    }

    //I prefer combining all the setters into one set method
    public void setEmployeeDetails(String inputId) {
        for (int i = 0; i < empId.length; i++) {
            if (inputId.equals(empId[i])) {
                employeeId = inputId;
                employeeLName = empLname[i];
                employeeFName = empFname[i];
                employeeBday = empBday[i];
                employeeAddr = empAddr[i];
                employeePhNo = empPhNo[i];
                employeeSss = empSss[i];
                employeePhHealth = empPhHealth[i];
                employeeTin = empTin[i];
                employeePagIbig = empPagIbig[i];
                employeeSalary = empSalary[i];
                employeeSemiMonthlyRate = empSemiMonthlyRate[i];
                employeeHourlyRate = empHourlyRate[i];
                break;
            }
        }
    }
}
