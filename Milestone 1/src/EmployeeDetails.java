// https://stackoverflow.com/questions/53116921/matching-user-input-against-a-string-array-in-java
// use this in the future
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
//reference for DateTimeFormatter https://www.baeldung.com/java-datetimeformatter

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

    private String logInTime;
    private String logOutTime;

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

    public String getLogInInput() {
        return logInTime;
    }

    public String getLogOutInput() {
        return logOutTime;
    }

    //Setters
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
            }
        }
    }

    public void setLogInTime(String logInInput) {
        logInTime = logInInput;
    }

    public void setLogOutTime(String logOutInput) {
        logOutTime = logOutInput;
    }

    public double calculateSalary() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        //sets input to HH:mm format
        LocalTime login = LocalTime.parse(logInTime, formatter);
        LocalTime logout = LocalTime.parse(logOutTime, formatter);

        Duration duration = Duration.between(login, logout);
        long hoursWorked = duration.toHours(); //convert to hours HH
        return hoursWorked * employeeHourlyRate;
    }

    public void resetEmployeeDetails() {
        employeeId = null;
    }
}
