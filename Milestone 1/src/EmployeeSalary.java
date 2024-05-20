// https://stackoverflow.com/questions/53116921/matching-user-input-against-a-string-array-in-java
// use this in the future
public class EmployeeSalary extends  EmployeeDetails{
    private String employeeId;

    public String getEmployeeId() {
        return employeeId;
    }

//    public String setEmployeeId(String employeeId) {
//        return employeeId;
//    }

    public void setEmployeeId(String inputId){ //^
        for(int i=0; i<empId.length; i++){
            if(inputId.equals(empId[i])) { //REMINDER if you remove the {} of "If" statement it will only read one line below it.
                employeeId = inputId;
                System.out.println(inputId);
            }
        }
    }

}
