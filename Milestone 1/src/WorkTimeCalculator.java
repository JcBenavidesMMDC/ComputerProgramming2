import javax.swing.*;
import java.awt.event.*;
import java.time.format.DateTimeParseException;
import javax.swing.SpringLayout;

public class WorkTimeCalculator extends JFrame {
    private JLabel lblEmployeeId, lblLoginTime, lblLogOutTime;
    private JTextField txtEmployeeId, txtLoginTime, txtLogOutTime;
    private JButton calculateButton, viewSalaryButton;
    private EmployeeDetails ed;

    public WorkTimeCalculator() {
        super("Hours Work Calculator");
        setSize(300, 200);

        ed = new EmployeeDetails();

        lblEmployeeId = new JLabel("Employee Id:");
        txtEmployeeId = new JTextField(18);
        lblLoginTime = new JLabel("Log-in Time:");
        txtLoginTime = new JTextField(18);
        lblLogOutTime = new JLabel("Log-out Time:");
        txtLogOutTime = new JTextField(18);
        calculateButton = new JButton("Calculate");
        viewSalaryButton = new JButton("View Salary");

        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setSize(300, 300);
        panel.setLayout(layout);

        panel.add(lblEmployeeId);
        panel.add(txtEmployeeId);
        panel.add(lblLoginTime);
        panel.add(txtLoginTime);
        panel.add(lblLogOutTime);
        panel.add(txtLogOutTime);
        panel.add(calculateButton);
        panel.add(viewSalaryButton);

        layout.putConstraint(SpringLayout.WEST, lblEmployeeId, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblLoginTime, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblLogOutTime, 6, SpringLayout.WEST, panel);

        layout.putConstraint(SpringLayout.NORTH, lblEmployeeId, 6, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, txtEmployeeId, 6, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, lblLoginTime, 10, SpringLayout.SOUTH, lblEmployeeId);
        layout.putConstraint(SpringLayout.NORTH, txtLoginTime, 6, SpringLayout.SOUTH, txtEmployeeId);
        layout.putConstraint(SpringLayout.NORTH, lblLogOutTime, 10, SpringLayout.SOUTH, lblLoginTime);
        layout.putConstraint(SpringLayout.NORTH, txtLogOutTime, 6, SpringLayout.SOUTH, txtLoginTime);

        layout.putConstraint(SpringLayout.WEST, txtEmployeeId, 11, SpringLayout.EAST, lblEmployeeId);
        layout.putConstraint(SpringLayout.WEST, txtLoginTime, 13, SpringLayout.EAST, lblLoginTime);
        layout.putConstraint(SpringLayout.WEST, txtLogOutTime, 6, SpringLayout.EAST, lblLogOutTime);

        layout.putConstraint(SpringLayout.NORTH, calculateButton, 15, SpringLayout.SOUTH, txtLogOutTime);
        layout.putConstraint(SpringLayout.WEST, calculateButton, 70, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.EAST, calculateButton, -70, SpringLayout.EAST, panel);

        layout.putConstraint(SpringLayout.NORTH, viewSalaryButton, 7, SpringLayout.SOUTH, calculateButton);
        layout.putConstraint(SpringLayout.WEST, viewSalaryButton, 90, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.EAST, viewSalaryButton, -90, SpringLayout.EAST, panel);

        add(panel);


        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ed.setEmployeeDetails(txtEmployeeId.getText());
                    ed.setLogInTime(txtLoginTime.getText());
                    ed.setLogOutTime(txtLogOutTime.getText());

                    if (ed.getEmployeeId() == null) {
                        JOptionPane.showMessageDialog(null, "Please, input a valid employee ID", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else if (ed.getLogInInput() == null){
                        JOptionPane.showMessageDialog(null, "Please, input Log-In Time", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else if (ed.getLogOutInput() == null){
                        JOptionPane.showMessageDialog(null, "Please, input a valid Log-Out Time", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Calculated", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        viewSalaryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ed.getEmployeeId() == null || ed.getLogInInput() == null || ed.getLogOutInput() == null) {
                        JOptionPane.showMessageDialog(null, "Please fill up the following labels", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }else if (!(ed.getEmployeeId() == null) || !(ed.getLogInInput() == null) || !(ed.getLogOutInput() == null)){
                        double calculatedSalary = ed.calculateSalary();
                        SalarySheet ss = new SalarySheet(ed, calculatedSalary);
                        ss.setVisible(true);
                        clearTextFields();
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }catch (DateTimeParseException tpe) {
                JOptionPane.showMessageDialog(null, "Invalid Input (Log-In Time, Log-Out Time)", "Error", JOptionPane.ERROR_MESSAGE);
            }
            }
        });

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private void clearTextFields() {
        txtEmployeeId.setText("");
        txtLoginTime.setText("");
        txtLogOutTime.setText("");
    }
}
