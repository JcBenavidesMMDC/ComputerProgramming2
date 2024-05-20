import javax.swing.*;
import javax.swing.SpringLayout;

public class SalarySheet extends JFrame {
    // Declare private variables for the Swing components
    private JTextArea textArea;

    public SalarySheet(EmployeeSalary es) { //^
        // Set up the frame
        super("MotorPH Salary Sheet");
        setSize(400, 600);

        //

        // Create the components
        textArea = new JTextArea("Employee ID: " + es.getEmployeeId() + "\n"); //^






        textArea.setEditable(false);

        // Define the panel to hold the components
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        // Add the components to the frame
        panel.add(textArea);

        // Put constraints on components
        // Set label position

        // Set textArea position: centered horizontally and vertically
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textArea, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, textArea, 0, SpringLayout.VERTICAL_CENTER, panel);

        // Set size for JTextArea
        textArea.setRows(34);
        textArea.setColumns(34);

        // Add panel to frame
        add(panel);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Set default close operation

    }
}

