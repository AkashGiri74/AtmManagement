package atmmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup3 extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5;
    JButton b;

    Signup3() {
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
         
        l4 = new JLabel("PIN:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l5 = new JLabel("Services Required:");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l6 = new JLabel("Form Number:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));
        
        b = new JButton("Submit");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        setLayout(null);
        
        l1.setBounds(290, 80, 600, 30);
        add(l1);
        
        l2.setBounds(100, 140, 200, 30);
        add(l2);
        
        t1.setBounds(300, 140, 400, 30);
        add(t1);
        
        l3.setBounds(100, 190, 200, 30);
        add(l3);
        
        t2.setBounds(300, 190, 400, 30);
        add(t2);
        
        l4.setBounds(100, 240, 200, 30);
        add(l4);
        
        t3.setBounds(300, 240, 400, 30);
        add(t3);
        
        l5.setBounds(100, 290, 200, 30);
        add(l5);
        
        t4.setBounds(300, 290, 400, 30);
        add(t4);
        
        l6.setBounds(100, 340, 200, 30);
        add(l6);
        
        t5.setBounds(300, 340, 400, 30);
        add(t5);
        
        b.setBounds(620, 500, 80, 50);
        add(b);
        
        b.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(400, 20);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String accountType = t1.getText();
        String cardNumber = t2.getText();
        String pin = t3.getText();
        String services = t4.getText();
        String formno = t5.getText();
        
        try {
            if (accountType.equals("") || cardNumber.equals("") || pin.equals("") || services.equals("") || formno.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                mysql conn = new mysql();
                String query = "INSERT INTO signupthree (account_type, card_number, pin_number, facilities, formno) VALUES ('" + accountType + "','" + cardNumber + "','" + pin + "','" + services + "','" + formno + "')";
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                new LoginPage().setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Signup3().setVisible(true);
    }
}
