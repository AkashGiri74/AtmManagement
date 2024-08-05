package atmmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class transaction extends JFrame implements ActionListener {
    JButton deposit, withdraw, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinNumber;
    
    transaction(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setFont(new Font("System", Font.BOLD, 38));
        text.setBounds(100, 100, 700, 40);
        add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 250, 150, 30);
        deposit.addActionListener(this);
        add(deposit);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 250, 150, 30);
        withdraw.addActionListener(this);
        add(withdraw);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170, 300, 150, 30);
        fastCash.addActionListener(this);
        add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 300, 150, 30);
        miniStatement.addActionListener(this);
        add(miniStatement);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170, 350, 150, 30);
        pinChange.addActionListener(this);
        add(pinChange);
        
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355, 350, 150, 30);
        balanceEnquiry.addActionListener(this);
        add(balanceEnquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(355, 400, 150, 30);
        exit.addActionListener(this);
        add(exit);
        
        setSize(800, 800);
        setLocation(300, 0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            new deposit(pinNumber).setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == withdraw) {
            new withdraw(pinNumber).setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == fastCash) {
            new FastCash(pinNumber).setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == miniStatement) {
            new MiniStatement(pinNumber).setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == pinChange) {
            new PinChange(pinNumber).setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == balanceEnquiry) {
            new BalanceEnq(pinNumber).setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == exit) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new transaction("").setVisible(true);
    }
}
