package atmmanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener {
    JButton withdraw100, withdraw500, withdraw1000, withdraw2000, withdraw5000, withdraw10000, back;
    String pinNumber;
    
    FastCash(String pinNumber) {
        this.pinNumber = pinNumber;
        getContentPane().setLayout(null);
        
        // Set up buttons and their properties
        withdraw100 = new JButton("Rs 100");
        withdraw100.setBounds(170, 100, 150, 30);
        getContentPane().add(withdraw100);
        withdraw100.addActionListener(this);
        
        withdraw500 = new JButton("Rs 500");
        withdraw500.setBounds(170, 150, 150, 30);
        getContentPane().add(withdraw500);
        withdraw500.addActionListener(this);
        
        withdraw1000 = new JButton("Rs 1000");
        withdraw1000.setBounds(170, 200, 150, 30);
        getContentPane().add(withdraw1000);
        withdraw1000.addActionListener(this);
        
        withdraw2000 = new JButton("Rs 2000");
        withdraw2000.setBounds(170, 250, 150, 30);
        getContentPane().add(withdraw2000);
        withdraw2000.addActionListener(this);
        
        withdraw5000 = new JButton("Rs 5000");
        withdraw5000.setBounds(170, 300, 150, 30);
        getContentPane().add(withdraw5000);
        withdraw5000.addActionListener(this);
        
        withdraw10000 = new JButton("Rs 10000");
        withdraw10000.setBounds(170, 350, 150, 30);
        getContentPane().add(withdraw10000);
        withdraw10000.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(170, 410, 150, 30);
        getContentPane().add(back);
        back.addActionListener(this);
        
        setSize(800, 600);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String amountStr = ((JButton)ae.getSource()).getText().substring(3);
        int amount = Integer.parseInt(amountStr);
        
        // Perform fast cash withdrawal logic here
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false", "root", "747288");
            Statement statement = connection.createStatement();
            
            // Assuming there's a balance check before allowing the transaction
            String checkBalanceQuery = "SELECT amount FROM bank WHERE pin = '" + pinNumber + "'";
            ResultSet resultSet = statement.executeQuery(checkBalanceQuery);
            if (resultSet.next()) {
                int balance = resultSet.getInt("amount");
                if (balance >= amount) {
                    String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('" + pinNumber + "', CURRENT_TIMESTAMP, 'Withdrawal', '" + amount + "')";
                    statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
                    
                    // Update balance after successful withdrawal
                    String updateBalanceQuery = "UPDATE bank SET amount = amount- " + amount + " WHERE pin = '" + pinNumber + "'";
                    statement.executeUpdate(updateBalanceQuery);
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
            
            setVisible(false);
            new transaction(pinNumber).setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new FastCash("1234").setVisible(true); // Replace with a valid PIN for testing
    }
}
