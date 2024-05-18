import javax.swing.*;
import java.awt.event.*;
import javax.swing.SpringLayout;

public class Login extends JFrame {
    // Declare private variables for the Swing components
    private JLabel lblUserName, lblPassword;
    private JTextField txtUserName, txtPassword;
    private JButton loginButton;


    public Login() {
        // Set up the frame
        super("MotorPh Login");
        setSize(300, 160);


        // Create the components
        // Create labels and textfields
        lblUserName = new JLabel("Username:");
        txtUserName = new JTextField(15); //length of textbox
        lblPassword = new JLabel("Password:");
        txtPassword = new JTextField(15);
        loginButton = new JButton("Login");

        // Define the panel to hold the components
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setSize(300, 300);
        panel.setLayout(layout);

        // Add the components to the frame
        panel.add(lblUserName);
        panel.add(txtUserName);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(loginButton);

        // Put constraint on components
        // Set label position: left
        layout.putConstraint(SpringLayout.WEST, lblUserName, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lblPassword, 6, SpringLayout.WEST, panel);

        // Set label and textfield position: top and bottom
        layout.putConstraint(SpringLayout.NORTH, lblUserName, 6, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, txtUserName, 6, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, lblPassword, 10, SpringLayout.SOUTH, lblUserName);
        layout.putConstraint(SpringLayout.NORTH, txtPassword, 6, SpringLayout.SOUTH, txtUserName);

        // Set textfield position: right
        layout.putConstraint(SpringLayout.WEST, txtUserName, 8, SpringLayout.EAST, lblUserName);
        layout.putConstraint(SpringLayout.WEST, txtPassword, 11, SpringLayout.EAST, lblPassword);

        // Set button position
        layout.putConstraint(SpringLayout.NORTH, loginButton, 30, SpringLayout.SOUTH, txtPassword);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, loginButton, 0, SpringLayout.HORIZONTAL_CENTER, panel);


        //Add panel to frame
        add(panel);


        // Add an ActionListener to the button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WorkTimeCalculator wtc = new WorkTimeCalculator(); //review (stud) from Grade Calculator
                wtc.setVisible(true);
                // Close the current frame
                dispose();
            }
        });

        // Center the frame on the screen. When null is passed as the argument, it positions the window in the center of the screen.
        setLocationRelativeTo(null);

        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
