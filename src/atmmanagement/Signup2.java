package atmmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JTextField t1, t2, t3, t5, t6, t7, t8, t9;
    JButton b;

    Signup2() {
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        l1 = new JLabel("Page 2: Additional Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l2 = new JLabel("Religion:");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l3 = new JLabel("Category:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l4 = new JLabel("Income:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l5 = new JLabel("Qualification:");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l6 = new JLabel("Occupation:"); 
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l7 = new JLabel("PAN Number:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l8 = new JLabel("Aadhar Number:");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l9 = new JLabel("Senior Citizen:");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t6 = new JTextField();
        t6.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t7 = new JTextField();
        t7.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t8 = new JTextField();
        t8.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t9 = new JTextField();
        t9.setFont(new Font("Raleway", Font.BOLD, 14));
        
        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        setLayout(null);
        
        l1.setBounds(290, 30, 600, 30);
        add(l1);
        
        l2.setBounds(100, 80, 150, 30);
        add(l2);
        
        t1.setBounds(300, 80, 400, 30);
        add(t1);
        
        l3.setBounds(100, 130, 150, 30);
        add(l3);
        
        t2.setBounds(300, 130, 400, 30);
        add(t2);
        
        l4.setBounds(100, 180, 150, 30);
        add(l4);
        
        t3.setBounds(300, 180, 400, 30);
        add(t3);
        
        l5.setBounds(100, 230, 150, 30);
        add(l5);
        
        t5.setBounds(300, 230, 400, 30);
        add(t5);
        
        l6.setBounds(100, 280, 150, 30);
        add(l6);
        
        t6.setBounds(300, 280, 400, 30);
        add(t6);
        
        l7.setBounds(100, 330, 150, 30);
        add(l7);
        
        t7.setBounds(300, 330, 400, 30);
        add(t7);
        
        l8.setBounds(100, 380, 150, 30);
        add(l8);
        
        t8.setBounds(300, 380, 400, 30);
        add(t8);
        
        l9.setBounds(100, 430, 150, 30);
        add(l9);
        
        t9.setBounds(300, 430, 400, 30);
        add(t9);
        
        b.setBounds(620, 500, 80, 30);
        add(b);
        
        b.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 600); // Adjusted size to fit all components
        setLocation(400, 20);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String religion = t1.getText();
        String category = t2.getText();
        String income = t3.getText();
        String qualification = t5.getText();
        String occupation = t6.getText();
        String panNumber = t7.getText();
        String aadharNumber = t8.getText();
        String seniorCitizen = t9.getText();
        
        // Validate all required fields are filled
        if (religion.trim().isEmpty() || category.trim().isEmpty() || income.trim().isEmpty() || 
            qualification.trim().isEmpty() || occupation.trim().isEmpty() || panNumber.trim().isEmpty() || 
            aadharNumber.trim().isEmpty() || seniorCitizen.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill all the required fields");
            return;
        }
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false", "root", "747288");
            
            // Insert data into the `signuptwo` table
            String sql = "INSERT INTO signuptwo (religion, category, income, qualification, occupation, pan_number, aadhar_number, senior_citizen) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, religion);
            pstmt.setString(2, category);
            pstmt.setString(3, income);
            pstmt.setString(4, qualification);
            pstmt.setString(5, occupation);
            pstmt.setString(6, panNumber);
            pstmt.setString(7, aadharNumber);
            pstmt.setString(8, seniorCitizen);
            
            pstmt.executeUpdate();
            new Signup3().setVisible(true); // Assuming this is the next page
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        new Signup2().setVisible(true);
    }
}
