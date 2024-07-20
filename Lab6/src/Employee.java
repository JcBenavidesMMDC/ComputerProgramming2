public class Employee {
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private String sssNumber;
    private String philhealthNumber;
    private String tinNumber;
    private String pagIbigNumber;
    private double basicSalary;
    private double hourlyRate;

    //Getter methods
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSssNumber() {
        return sssNumber;
    }

    public String getPhilhealthNumber() {
        return philhealthNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public String getPagIbigNumber() {
        return pagIbigNumber;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    // Setter methods
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSssNumber(String sssNumber) {
        this.sssNumber = sssNumber;
    }

    public void setPhilhealthNumber(String philhealthNumber) {
        this.philhealthNumber = philhealthNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public void setPagIbigNumber(String pagIbigNumber) {
        this.pagIbigNumber = pagIbigNumber;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    //methods
    public double computeMonthlySalary(int month) {
        int workingDays = getWorkingDaysInMonth(month);
        return basicSalary + (hourlyRate * workingDays * 8); // Assuming 8 hours per working day
    }

    /*
     Method only accessible once computeMonthlySalary is initiated
     some Months have different duration of working days due to the fact that February contains 28-29 days.
     */
    private int getWorkingDaysInMonth(int month) {
        switch (month) {
            case 2: // February
                return 20;
            default: // Other months
                return 22;
        }
    }
}