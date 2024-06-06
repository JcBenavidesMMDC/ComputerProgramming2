import javax.swing.*;
import javax.swing.SpringLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SalarySheet extends JFrame {
    private JTextArea textArea;
    private EmployeeDetails ed;

    public SalarySheet(EmployeeDetails ed, double calculateSalary) {
        super("MotorPH Salary Sheet");
        setSize(400, 600);

        textArea = new JTextArea(
                "Employee ID: " + ed.getEmployeeId() + "\n" +
                        "Last Name: " + ed.getEmployeeLName() + "\n" +
                        "First Name: " + ed.getEmployeeFName() + "\n" +
                        "Birthday: " + ed.getEmployeeBday() + "\n" +
                        "Address: " + ed.getEmployeeAddr() + "\n" +
                        "Phone Number: " + ed.getEmployeePhNo() + "\n" +
                        "SSS: " + ed.getEmployeeSss() + "\n" +
                        "PhilHealth: " + ed.getEmployeePhHealth() + "\n" +
                        "TIN: " + ed.getEmployeeTin() + "\n" +
                        "PagIbig: " + ed.getEmployeePagIbig() + "\n" +
                        "Salary: " + ed.getEmployeeSalary() + "\n" +
                        "Semi-Monthly Rate: " + ed.getEmployeeSemiMonthlyRate() + "\n" +
                        "Hourly Rate: " + ed.getEmployeeHourlyRate() + "\n" +
                        "---------------------------------------------------" + "\n" +
                        "Total of Hours Worked Salary: " + calculateSalary + "\n"
        );
        textArea.setEditable(false);

        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        panel.add(textArea);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textArea, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, textArea, 0, SpringLayout.VERTICAL_CENTER, panel);

        textArea.setRows(34);
        textArea.setColumns(34);

        add(panel);
        ed.resetEmployeeDetails(); //Needs to reset employee Id. Otherwise, in second attempt if you entered invalid input, previous data will display.

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
