package atmmanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BalanceEnq extends JFrame implements ActionListener {
    String pin;
    
    BalanceEnq(String pin) {
        this.pin = pin;
        setLayout(null);
        
        JLabel text = new JLabel("Your Current Balance is Rs ");
        text.setBounds(190, 200, 400, 35);
        add(text);
        
        int balance = 0;
        
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false", "root", "747288");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            
            text.setText("Your Current Balance is Rs " + balance);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JButton back = new JButton("Back");
        back.setBounds(355, 388, 150, 35);
        add(back);
        back.addActionListener(this);
        
        setSize(800, 800);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new transaction(pin).setVisible(true);
    }
    
    public static void main(String[] args) {
        new BalanceEnq("").setVisible(true);
    }
}

