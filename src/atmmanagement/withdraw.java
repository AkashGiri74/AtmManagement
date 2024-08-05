package atmmanagement;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class withdraw extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdraw, back;
    String pinNumber;
    
    withdraw(String pinNumber) {
        this.pinNumber = pinNumber;
        
        // Set up the JFrame
        setLayout(null);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(190, 200, 400, 35);
        add(text);
        
        amount = new JTextField();
        amount.setBounds(190, 260, 320, 25);
        add(amount);
        
        withdraw = new JButton("Withdraw"); 
        withdraw.setBounds(355, 388, 150, 35);
        add(withdraw);
        withdraw.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(355, 433, 150, 35);
        add(back);
        back.addActionListener(this);
        
        setSize(800, 800);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String number = amount.getText();
            // Perform withdrawal logic here
            
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false", "root", "747288");
                Statement statement = connection.createStatement();
                String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('" + pinNumber + "', CURRENT_TIMESTAMP, 'Withdrawal', '" + number + "')";
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + number + " Debited Successfully");
                
                setVisible(false);
                new transaction(pinNumber).setVisible(true);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new transaction(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new withdraw("").setVisible(true);
    }
}
