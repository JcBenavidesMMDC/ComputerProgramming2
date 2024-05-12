import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SpringLayout;

public class MilestoneCalculator extends JFrame implements ActionListener {
    private JTextField m1Field, m2Field, taField,resultField;


    public MilestoneCalculator() {
        super("Milestone Calculator");
        setSize(210, 210);

// Create the UI components
        JLabel m1Label = new JLabel("Milestone 1:");
        JLabel m2Label = new JLabel("Milestone 2:");
        JLabel taLabel = new JLabel("Terminal Assessment:");
        JLabel resultLabel = new JLabel("Result:");
        m1Field = new JTextField(5);
        m2Field = new JTextField(5);
        taField = new JTextField(5);
        resultField = new JTextField(5);
        resultField.setEditable(false);
        JButton totalButton = new JButton("Total");
        totalButton.addActionListener(this);

        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setSize(300, 300);
        panel.setLayout(layout);


// Add the components to the content pane
        panel.add(m1Label);
        panel.add(m1Field);
        panel.add(m2Label);
        panel.add(m2Field);
        panel.add(taLabel);
        panel.add(taField);
        panel.add(resultLabel);
        panel.add(resultField);
        panel.add(new JLabel());
        panel.add(totalButton);

        // Put constraint on components
        // Set label position: left
        layout.putConstraint(SpringLayout.WEST, m1Label, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, m2Label, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, taLabel, 6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, resultLabel, 6, SpringLayout.WEST, panel);

        // Set label and textfield position: top and bottom
        layout.putConstraint(SpringLayout.NORTH, m1Label, 6, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, m1Field, 6, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, m2Label, 10, SpringLayout.SOUTH, m1Label);
        layout.putConstraint(SpringLayout.NORTH, m2Field, 6, SpringLayout.SOUTH, m1Field);
        layout.putConstraint(SpringLayout.NORTH, taLabel, 10, SpringLayout.SOUTH, m2Label);
        layout.putConstraint(SpringLayout.NORTH, taField, 6, SpringLayout.SOUTH, m2Field);
        layout.putConstraint(SpringLayout.NORTH, resultLabel, 10, SpringLayout.SOUTH, taLabel);
        layout.putConstraint(SpringLayout.NORTH, resultField, 6, SpringLayout.SOUTH, taField);

        // Set textfield position: right
        layout.putConstraint(SpringLayout.WEST, m1Field, 57, SpringLayout.EAST, m1Label);
        layout.putConstraint(SpringLayout.WEST, m2Field, 57, SpringLayout.EAST, m2Label);
        layout.putConstraint(SpringLayout.WEST, taField, 2, SpringLayout.EAST, taLabel);
        layout.putConstraint(SpringLayout.WEST, resultField, 86, SpringLayout.EAST, resultLabel);

        // Set button position
        layout.putConstraint(SpringLayout.NORTH, totalButton, 30, SpringLayout.SOUTH, resultField);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, totalButton, 0, SpringLayout.HORIZONTAL_CENTER, panel);

        add(panel);


// Set the window size and make it visible
//        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Total")) {
            try {
                boolean isValid = true; // Flag to track validity
                int m1Score = Integer.parseInt(m1Field.getText());
                if (m1Score < 0 || m1Score > 25)
                {
                    // Code To popup an ERROR_MESSAGE Dialog.
                    isValid = false; // Set flag to false if input is invalid
                    JOptionPane.showMessageDialog(this, "Enter a number not lower than 0 or greater than 25 (M1: 25 max)",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                int m2Score = Integer.parseInt(m2Field.getText());
                if (m2Score < 0 || m2Score > 40)
                {
                    // Code To popup an ERROR_MESSAGE Dialog.
                    isValid = false; // Set flag to false if input is invalid
                    JOptionPane.showMessageDialog(this, "Enter a number not lower than 0 or greater than 40 (M2: 40 max)",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                int taScore = Integer.parseInt(taField.getText());
                if (taScore < 0 || taScore > 35)
                {
                    // Code To popup an ERROR_MESSAGE Dialog.
                    isValid = false; // Set flag to false if input is invalid
                    JOptionPane.showMessageDialog(this, "Enter a number not lower than 0 or greater than 35 (TA: 35 max)",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                if (isValid) { // Only calculate and set text if all inputs are valid
                    int result = m1Score + m2Score + taScore;
                    resultField.setText(Integer.toString(result) + "%");
                } else {
                    resultField.setText(""); // Clear result field if inputs are invalid
                }

            } catch (NumberFormatException | ArithmeticException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage() + " \"Invalid Input\"",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
//                resultField.setText("Error: " + ex.getMessage());
            }
        }
    }
}