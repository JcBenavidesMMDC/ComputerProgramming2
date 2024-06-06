import javax.swing.*;
import javax.swing.SpringLayout;

public class SalarySheet extends JFrame {
    private JTextArea textArea;

    public SalarySheet(EmployeeDetails es) {
        super("MotorPH Salary Sheet");
        setSize(400, 600);

        textArea = new JTextArea(
                "Employee ID: " + es.getEmployeeId() + "\n" +
                        "Last Name: " + es.getEmployeeLName() + "\n" +
                        "First Name: " + es.getEmployeeFName() + "\n" +
                        "Birthday: " + es.getEmployeeBday() + "\n" +
                        "Address: " + es.getEmployeeAddr() + "\n" +
                        "Phone Number: " + es.getEmployeePhNo() + "\n" +
                        "SSS: " + es.getEmployeeSss() + "\n" +
                        "PhilHealth: " + es.getEmployeePhHealth() + "\n" +
                        "TIN: " + es.getEmployeeTin() + "\n" +
                        "PagIbig: " + es.getEmployeePagIbig() + "\n" +
                        "Salary: " + es.getEmployeeSalary() + "\n" +
                        "Semi-Monthly Rate: " + es.getEmployeeSemiMonthlyRate() + "\n" +
                        "Hourly Rate: " + es.getEmployeeHourlyRate()
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

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
