package atmmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1, b2, b3;
    
    LoginPage() {
        setTitle("ATM MANAGEMENT SYSTEM");
        
        l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        
        l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
         
        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        
        tf1 = new JTextField(15);
        pf2 = new JPasswordField(15);
        
        b1 = new JButton("SIGN IN");
        b2 = new JButton("CLEAR");
        b3 = new JButton("SIGN UP");
        
        getContentPane().setLayout(null);
        
        l1.setBounds(175, 50, 450, 200);
        getContentPane().add(l1);
        
        l2.setBounds(125, 150, 375, 200);
        getContentPane().add(l2);
        
        l3.setBounds(125, 225, 375, 200);
        getContentPane().add(l3);
        
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        tf1.setBounds(300, 235, 230, 30);
        getContentPane().add(tf1);
        
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300, 310, 230, 30);
        getContentPane().add(pf2);
        
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300, 400, 100, 30);
        getContentPane().add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430, 400, 100, 30);
        getContentPane().add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300, 450, 230, 30);
        getContentPane().add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 800);
        setLocation(350, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b1) {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false", "root", "747288");
                Statement statement = connection.createStatement();
                String cardno = tf1.getText();
                String pin = pf2.getText();
                String query = "SELECT * FROM signupthree WHERE card_number = '" + cardno + "' AND pin_number = '" + pin + "'";
                ResultSet rs = statement.executeQuery(query);
                
                if (rs.next()) {
                    new transaction(pin).setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } else if (ae.getSource() == b2) {
                tf1.setText("");
                pf2.setText("");
            } else if (ae.getSource() == b3) {
                new Signup1().setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new LoginPage().setVisible(true);
    }
}
