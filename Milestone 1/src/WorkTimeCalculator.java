import javax.swing.*;
import java.awt.event.*;
import javax.swing.SpringLayout;

public class WorkTimeCalculator extends JFrame {
    // Declare private variables for the Swing components
    private JLabel lblEmployeeId, lblLoginTime, lblLogOutTime;
    private JTextField txtEmployeeId, txtLoginTime, txtLogOutTime;
    private JButton calculateButton;


    public WorkTimeCalculator() {
        // Set up the frame
        super("Grade Calculator");
        setSize(300, 200);


        // Create the components
        // Create labels and textfields
        lblEmployeeId = new JLabel("Employee Id:");
        txtEmployeeId = new JTextField(18); //length of textbox
        lblLoginTime = new JLabel("Log-in Time:");
        txtLoginTime = new JTextField(18);
        lblLogOutTime = new JLabel("Log-out Time:");
        txtLogOutTime = new JTextField(18);
        calculateButton = new JButton("Calculate");

        // Define the panel to hold the components
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setSize(300, 300);
        panel.setLayout(layout);

        // Add the components to the frame
        panel.add(lblEmployeeId);
        panel.add(txtEmployeeId);
        panel.add(lblLoginTime);
        panel.add(txtLoginTime);
        panel.add(lblLogOutTime);
        panel.add(txtLogOutTime);
        panel.add(calculateButton);

        // Put constraint on components
        // Set label position: left
        layout.putConstraint(SpringLayout.WEST, lblEmployeeId, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblLoginTime, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblLogOutTime, 6, SpringLayout.WEST, panel);

        // Set label and textfield position: top and bottom
        layout.putConstraint(SpringLayout.NORTH, lblEmployeeId, 6, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, txtEmployeeId, 6, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, lblLoginTime, 10, SpringLayout.SOUTH, lblEmployeeId);
        layout.putConstraint(SpringLayout.NORTH, txtLoginTime, 6, SpringLayout.SOUTH, txtEmployeeId);
        layout.putConstraint(SpringLayout.NORTH, lblLogOutTime, 10, SpringLayout.SOUTH, lblLoginTime);
        layout.putConstraint(SpringLayout.NORTH, txtLogOutTime, 6, SpringLayout.SOUTH, txtLoginTime);

        // Set textfield position: right
        layout.putConstraint(SpringLayout.WEST, txtEmployeeId, 11, SpringLayout.EAST, lblEmployeeId);
        layout.putConstraint(SpringLayout.WEST, txtLoginTime, 13, SpringLayout.EAST, lblLoginTime);
        layout.putConstraint(SpringLayout.WEST, txtLogOutTime, 6, SpringLayout.EAST, lblLogOutTime);


        // Set button position and size
        layout.putConstraint(SpringLayout.NORTH, calculateButton, 25, SpringLayout.SOUTH, txtLogOutTime);
        layout.putConstraint(SpringLayout.WEST, calculateButton, 40, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.EAST, calculateButton, -40, SpringLayout.EAST, panel);


        //Add panel to frame
        add(panel);


        // Add an ActionListener to the button
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Instantiate Student class
//                Student stud = new Student();
//
//                // Assign textfield values to stud object
//                stud.setStudentName(txtStudentName.getText());
//                stud.setStudentNumber(txtStudentNo.getText());
//                stud.setQuiz1(Float.parseFloat(txtQuiz1.getText()));
//                stud.setQuiz2(Float.parseFloat(txtQuiz2.getText()));
//                stud.setQuiz3(Float.parseFloat(txtQuiz3.getText()));
//
//                // Instantiate and call GradeOutput class
//                GradeOutput output = new GradeOutput(stud);
//                output.setVisible(true);
            }
        });
        setLocationRelativeTo(null);// Center the frame on the screen. When null is passed as the argument, it positions the window in the center of the screen.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
