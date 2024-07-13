import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SpringLayout;


public class EmployeeDetails extends JFrame {
    // Declare private variables for the Swing components
    private JLabel lblEmployeeNumber, lblLastName, lblFirstName, lblSssNumber, lblPhealthNumber, lblTinNumber, lblPagibigNumber, lblBasicSalary, lblHourlyRate, lblComputedSalary;
    private JTextField txtEmployeeNumber, txtLastName, txtFirstName, txtSssNumber, txtPhealthNumber, txtTinNumber, txtPagibigNumber, txtBasicSalary, txtHourlyRate;
    private JComboBox<String> monthComboBox;
    private JButton computeButton, editButton, deleteButton;


    public EmployeeDetails(Employee selectedEmployee) {
        // Set up the frame
        super("Employee Details");
        setSize(405, 510);
        Employee emp = new Employee();

        // Create the components
        // Create labels
        lblEmployeeNumber = new JLabel("Employee#:");
        lblLastName = new JLabel("Last Name:");
        lblFirstName = new JLabel("First Name:");
        lblSssNumber = new JLabel("SSS#:");
        lblPhealthNumber = new JLabel("Philhealth#:");
        lblTinNumber = new JLabel("TIN Number:");
        lblPagibigNumber = new JLabel("Pagibig#:");
        lblBasicSalary = new JLabel("Basic Salary:");
        lblHourlyRate = new JLabel("Hourly Rate:");
        lblComputedSalary = new JLabel("Computed Monthly Salary:");

        // Employee Number textfield
        txtEmployeeNumber = new JTextField(15);
        txtEmployeeNumber.setEnabled(false);
        txtEmployeeNumber.setText(selectedEmployee.getEmployeeNumber());

        // Last Name textfield
        txtLastName = new JTextField(15);
        txtLastName.setEnabled(false);
        txtLastName.setText(selectedEmployee.getLastName());

        // First Name textfield
        txtFirstName = new JTextField(15);
        txtFirstName.setEnabled(false);
        txtFirstName.setText(selectedEmployee.getFirstName());

        // SSS Number textfield
        txtSssNumber = new JTextField(18);
        txtSssNumber.setEnabled(false);
        txtSssNumber.setText(selectedEmployee.getSssNumber());

        // PhilHealth Number textfield
        txtPhealthNumber = new JTextField(15);
        txtPhealthNumber.setEnabled(false);
        txtPhealthNumber.setText(selectedEmployee.getPhilhealthNumber());

        // TIN Number textfield
        txtTinNumber = new JTextField(14);
        txtTinNumber.setEnabled(false);
        txtTinNumber.setText(selectedEmployee.getTinNumber());

        // Pagibig textfield
        txtPagibigNumber = new JTextField(16);
        txtPagibigNumber.setEnabled(false);
        txtPagibigNumber.setText(selectedEmployee.getPagIbigNumber());

        // Basic Salary textfield
        txtBasicSalary = new JTextField(14);
        txtBasicSalary.setEnabled(false);
        txtBasicSalary.setText(String.format("%.2f", selectedEmployee.getBasicSalary()));

        // Basic Salary textfield
        txtHourlyRate = new JTextField(14);
        txtHourlyRate.setEnabled(false);
        txtHourlyRate.setText(String.format("%.2f", selectedEmployee.getHourlyRate()));

        // Combobox for months
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        monthComboBox = new JComboBox<>(months);

        // buttons
        computeButton = new JButton("Compute");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");

        // Define the panel to hold the components
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setSize(300, 300);
        panel.setLayout(layout);

        // Add the components to the frame
        panel.add(lblEmployeeNumber);
        panel.add(txtEmployeeNumber);
        panel.add(lblLastName);
        panel.add(txtLastName);
        panel.add(lblFirstName);
        panel.add(txtFirstName);
        panel.add(lblSssNumber);
        panel.add(txtSssNumber);
        panel.add(lblPhealthNumber);
        panel.add(txtPhealthNumber);
        panel.add(lblTinNumber);
        panel.add(txtTinNumber);
        panel.add(lblPagibigNumber);
        panel.add(txtPagibigNumber);
        panel.add(lblBasicSalary);
        panel.add(txtBasicSalary);
        panel.add(lblHourlyRate);
        panel.add(txtHourlyRate);
        panel.add(lblComputedSalary);
        panel.add(monthComboBox);
        panel.add(computeButton);
        panel.add(editButton);
        panel.add(deleteButton);

        // These buttons are disabled for this activity
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);

        // Put constraint on components
        // Set label position: left
        layout.putConstraint(SpringLayout.WEST, lblEmployeeNumber, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblLastName, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblFirstName, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblSssNumber, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblPhealthNumber, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblTinNumber, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblPagibigNumber, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblBasicSalary, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblHourlyRate, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblComputedSalary, 6, SpringLayout.WEST, panel);

        // Set label and textfield position: top and bottom
        layout.putConstraint(SpringLayout.NORTH, lblEmployeeNumber, 6, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, txtEmployeeNumber, 6, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, lblLastName, 10, SpringLayout.SOUTH, lblEmployeeNumber);
        layout.putConstraint(SpringLayout.NORTH, txtLastName, 6, SpringLayout.SOUTH, txtEmployeeNumber);
        layout.putConstraint(SpringLayout.NORTH, lblFirstName, 10, SpringLayout.SOUTH, lblLastName);
        layout.putConstraint(SpringLayout.NORTH, txtFirstName, 6, SpringLayout.SOUTH, txtLastName);
        layout.putConstraint(SpringLayout.NORTH, lblSssNumber, 10, SpringLayout.SOUTH, lblFirstName);
        layout.putConstraint(SpringLayout.NORTH, txtSssNumber, 6, SpringLayout.SOUTH, txtFirstName);
        layout.putConstraint(SpringLayout.NORTH, lblPhealthNumber, 10, SpringLayout.SOUTH, lblSssNumber);
        layout.putConstraint(SpringLayout.NORTH, txtPhealthNumber, 6, SpringLayout.SOUTH, txtSssNumber);
        layout.putConstraint(SpringLayout.NORTH, lblTinNumber, 10, SpringLayout.SOUTH, lblPhealthNumber);
        layout.putConstraint(SpringLayout.NORTH, txtTinNumber, 6, SpringLayout.SOUTH, txtPhealthNumber);
        layout.putConstraint(SpringLayout.NORTH, lblPagibigNumber, 10, SpringLayout.SOUTH, lblTinNumber);
        layout.putConstraint(SpringLayout.NORTH, txtPagibigNumber, 6, SpringLayout.SOUTH, txtTinNumber);
        layout.putConstraint(SpringLayout.NORTH, lblBasicSalary, 10, SpringLayout.SOUTH, lblPagibigNumber);
        layout.putConstraint(SpringLayout.NORTH, txtBasicSalary, 6, SpringLayout.SOUTH, txtPagibigNumber);
        layout.putConstraint(SpringLayout.NORTH, lblHourlyRate, 10, SpringLayout.SOUTH, lblBasicSalary);
        layout.putConstraint(SpringLayout.NORTH, txtHourlyRate, 6, SpringLayout.SOUTH, txtBasicSalary);
        layout.putConstraint(SpringLayout.NORTH, lblComputedSalary, 12, SpringLayout.SOUTH, txtHourlyRate);

        // Set textfield position: right
        layout.putConstraint(SpringLayout.WEST, txtEmployeeNumber, 4, SpringLayout.EAST, lblEmployeeNumber);
        layout.putConstraint(SpringLayout.WEST, txtLastName, 7, SpringLayout.EAST, lblLastName);
        layout.putConstraint(SpringLayout.WEST, txtFirstName, 5, SpringLayout.EAST, lblFirstName);
        layout.putConstraint(SpringLayout.WEST, txtSssNumber, 5, SpringLayout.EAST, lblSssNumber);
        layout.putConstraint(SpringLayout.WEST, txtPhealthNumber, 3, SpringLayout.EAST, lblPhealthNumber);
        layout.putConstraint(SpringLayout.WEST, txtTinNumber, 8, SpringLayout.EAST, lblTinNumber);
        layout.putConstraint(SpringLayout.WEST, txtPagibigNumber, 8, SpringLayout.EAST,lblPagibigNumber);
        layout.putConstraint(SpringLayout.WEST, txtBasicSalary, 8, SpringLayout.EAST,lblBasicSalary);
        layout.putConstraint(SpringLayout.WEST, txtHourlyRate, 9, SpringLayout.EAST,lblHourlyRate);

        //Set combobox position
        layout.putConstraint(SpringLayout.NORTH, monthComboBox, 6, SpringLayout.SOUTH, lblComputedSalary);
        layout.putConstraint(SpringLayout.WEST, monthComboBox, 6, SpringLayout.WEST, panel);
        monthComboBox.setPreferredSize(new Dimension(190, monthComboBox.getPreferredSize().height)); // Set the preferred width of the combo box

        // Set button position
        layout.putConstraint(SpringLayout.NORTH, computeButton, 10, SpringLayout.SOUTH, monthComboBox);
        layout.putConstraint(SpringLayout.WEST, computeButton, 60, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, editButton, 30, SpringLayout.SOUTH, computeButton);
        layout.putConstraint(SpringLayout.EAST, editButton, -20, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.NORTH, deleteButton, 10, SpringLayout.SOUTH, editButton);
        layout.putConstraint(SpringLayout.EAST, deleteButton, -20, SpringLayout.EAST, panel);
        Dimension buttonSize = new Dimension(145, 35);
        editButton.setPreferredSize(buttonSize);
        deleteButton.setPreferredSize(buttonSize);

        //Add panel to frame
        add(panel);
        setLocationRelativeTo(null);


        // Add an ActionListener to the button
        computeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedMonth = monthComboBox.getSelectedIndex() + 1; // January is 0, so add 1

                // Compute the monthly salary
                double monthlySalary = selectedEmployee.computeMonthlySalary(selectedMonth);

                // Update lblComputedSalary with the computed monthly salary
                lblComputedSalary.setText("Computed Monthly Salary: " + String.format("%.2f", monthlySalary));
            }
        });
    }
}
