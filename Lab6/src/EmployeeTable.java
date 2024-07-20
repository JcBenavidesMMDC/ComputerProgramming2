import com.opencsv.CSVReader;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTable extends JFrame {
    private JTable table;
    private JButton viewButton, deleteButton;
    private DefaultTableModel tableModel;
    private List<Employee> employees;


    public EmployeeTable() {
        super("Employee Table");
        setSize(800, 400);

        // CSV file path
        String csvFile = "employee_data.csv";

        // Initialize header names
        String[] columnNames = {"Employee #", "Last Name", "First Name", "SSS #", "Philhealth #", "TIN #", "Pag-ibig #", "Basic Salary", "Hourly Rate"};
        // Read data from CSV file
        employees = readCSVData(csvFile);

        // Initialize data for JTable
        String[][] data = new String[employees.size()][columnNames.length];
        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            data[i][0] = emp.getEmployeeNumber();
            data[i][1] = emp.getLastName();
            data[i][2] = emp.getFirstName();
            data[i][3] = emp.getSssNumber();
            data[i][4] = emp.getPhilhealthNumber();
            data[i][5] = emp.getTinNumber();
            data[i][6] = emp.getPagIbigNumber();
            // "%.2f" constrain decimal digits into 2 digits only.
            data[i][7] = String.format("%.2f", emp.getBasicSalary());
            data[i][8] = String.format("%.2f", emp.getHourlyRate());
        }

        // Initialize the table with data and column names
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(table);

        // Initialize the buttons
        viewButton = new JButton("View Employee");
        deleteButton = new JButton("N/A");

        // Define the panel to hold the components
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setSize(800, 400);
        panel.setLayout(layout);

        // Add components to the panel
        panel.add(scroll);
        panel.add(viewButton);
        panel.add(deleteButton);

        // Set the constraints for the JScrollPane and buttons
        layout.putConstraint(SpringLayout.NORTH, scroll, 5, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, scroll, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.EAST, scroll, -5, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.SOUTH, scroll, -50, SpringLayout.SOUTH, panel);

        layout.putConstraint(SpringLayout.NORTH, viewButton, 10, SpringLayout.SOUTH, scroll);
        layout.putConstraint(SpringLayout.WEST, viewButton, 283, SpringLayout.WEST, scroll);

        layout.putConstraint(SpringLayout.NORTH, deleteButton, 10, SpringLayout.SOUTH, scroll);
        layout.putConstraint(SpringLayout.WEST, deleteButton, 10, SpringLayout.EAST, viewButton);

        add(panel);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Frame Visible = true
        setVisible(true);
        JOptionPane.showMessageDialog(null, "Delete button reserved for the next activity" , "Info", JOptionPane.INFORMATION_MESSAGE);

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                //If the user selected a row, selectedRow will hold the index of that row. If no row is selected, it will be -1.
                if (selectedRow != -1) {
                    // Get the selected employee details
                    Employee selectedEmployee = employees.get(selectedRow);

                    // Open the EmployeeDetails2 frame with the selected employee's details
                    EmployeeDetails detailsFrame = new EmployeeDetails(selectedEmployee);
                    detailsFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(EmployeeTable.this, "Please select an employee.", "No Employee Selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private ArrayList<Employee> readCSVData(String csvFile)  {
        //reminder: arraylist only hold objects or classes
        ArrayList<Employee> dataList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            reader.readNext(); // Skips the first line (header row)

            // Reads the remaining lines and store the data in arraylist
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Employee employee = new Employee();
                employee.setEmployeeNumber(nextLine[0]);
                employee.setLastName(nextLine[1]);
                employee.setFirstName(nextLine[2]);
                employee.setSssNumber(nextLine[3]);
                employee.setPhilhealthNumber(nextLine[4]);
                employee.setTinNumber(nextLine[5]);
                employee.setPagIbigNumber(nextLine[6]);
                employee.setBasicSalary(Double.parseDouble(nextLine[7].replace(",", "")));
                employee.setHourlyRate(Double.parseDouble(nextLine[8].replace(",", "")));
                dataList.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading CSV file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return dataList;
    }

    protected void writeEmployeeDataToCSV(Employee employee) {
        String csvFile = "employee_data.csv"; // Your CSV file path
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
            writer.write(employee.getEmployeeNumber() + "," +
                    employee.getLastName() + "," +
                    employee.getFirstName() + "," +
                    employee.getSssNumber() + "," +
                    employee.getPhilhealthNumber() + "," +
                    employee.getTinNumber() + "," +
                    employee.getPagIbigNumber() + "," +
                    String.format("%.2f", employee.getBasicSalary()) + "," +
                    String.format("%.2f", employee.getHourlyRate()));
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to CSV file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}