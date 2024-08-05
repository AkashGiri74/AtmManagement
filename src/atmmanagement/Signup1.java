 package atmmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Signup1 extends JFrame implements ActionListener {
    // Declare the components
    JTextField nameField, dobField, genderField, emailField, maritalField, addressField;
    JButton nextButton;

    public Signup1() {
        // Set up the frame
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
        setSize(761, 583);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the components
        nameField = new JTextField();
        nameField.setBounds(128, 71, 503, 24);
        dobField = new JTextField();
        dobField.setBounds(128, 118, 512, 30);
        genderField = new JTextField();
        genderField.setBounds(128, 170, 512, 30);
        emailField = new JTextField();
        emailField.setBounds(128, 229, 512, 30);
        maritalField = new JTextField();
        maritalField.setBounds(128, 290, 512, 24);
        addressField = new JTextField();
        addressField.setBounds(128, 358, 512, 24);
        nextButton = new JButton("Next");
        nextButton.setBounds(549, 416, 79, 36);

        // Add action listener for the "Next" button
        nextButton.addActionListener(this);

        // Create labels
        JLabel titleLabel = new JLabel("APPLICATION FORM NO.", JLabel.CENTER);
        titleLabel.setBounds(173, 11, 239, 24);
        JLabel pageLabel = new JLabel("Page 1: Personal Details", JLabel.CENTER);
        pageLabel.setBounds(204, 41, 177, 19);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        pageLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        // Create labels for each field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 74, 50, 24);
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(16, 121, 84, 27);
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(44, 173, 56, 27);
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(52, 232, 48, 27);
        JLabel maritalLabel = new JLabel("Marital Status:");
        maritalLabel.setBounds(27, 297, 73, 17);
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(33, 361, 85, 21);

        // Use GroupLayout for flexible layout
        JPanel panel = new JPanel();

        getContentPane().add(panel);
        panel.setLayout(null);
        panel.add(titleLabel);
        panel.add(pageLabel);
        panel.add(nameLabel);
        panel.add(dobLabel);
        panel.add(genderLabel);
        panel.add(emailLabel);
        panel.add(maritalLabel);
        panel.add(addressLabel);
        panel.add(nameField);
        panel.add(dobField);
        panel.add(genderField);
        panel.add(emailField);
        panel.add(maritalField);
        panel.add(addressField);
        panel.add(nextButton);
        
        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            // Collect data from fields
            String name = nameField.getText();
            String dob = dobField.getText();
            String gender = genderField.getText();
            String email = emailField.getText();
            String marital = maritalField.getText();
            String address = addressField.getText();

            // Validate all required fields are filled
            if (name.trim().isEmpty() || dob.trim().isEmpty() || gender.trim().isEmpty() ||
                email.trim().isEmpty() || marital.trim().isEmpty() || address.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill all the required fields");
                return;
            }

            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false", "root", "747288");

                // Insert data into the signup table
                String sql = "INSERT INTO signup (name, dob, gender, email, marital, address) VALUES (?, ?, ?, ?, ?, ?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setString(2, dob);
                pstmt.setString(3, gender);
                pstmt.setString(4, email);
                pstmt.setString(5, marital);
                pstmt.setString(6, address);

                pstmt.executeUpdate();

                // Open Signup2
                new Signup2().setVisible(true);

                // Optionally, close the current frame
                this.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Signup1());
    }
}
