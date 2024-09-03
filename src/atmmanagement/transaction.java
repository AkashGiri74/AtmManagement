package atmmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class transaction extends JFrame implements ActionListener {
    JButton deposit, withdraw, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinNumber;
    
    transaction(String pinNumber) {
        this.pinNumber = pinNumber;
        getContentPane().setLayout(null);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBackground(Color.YELLOW);
        text.setForeground(new Color(25, 25, 112));
        text.setBounds(80, 95, 589, 49);
        text.setFont(new Font("Arial Black", Font.BOLD, 32));
        getContentPane().add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 250, 150, 30);
        deposit.addActionListener(this);
        getContentPane().add(deposit);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 250, 150, 30);
        withdraw.addActionListener(this);
        getContentPane().add(withdraw);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170, 300, 150, 30);
        fastCash.addActionListener(this);
        getContentPane().add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 300, 150, 30);
        miniStatement.addActionListener(this);
        getContentPane().add(miniStatement);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170, 350, 150, 30);
        pinChange.addActionListener(this);
        getContentPane().add(pinChange);
        
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355, 350, 150, 30);
        balanceEnquiry.addActionListener(this);
        getContentPane().add(balanceEnquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(355, 400, 150, 30);
        exit.addActionListener(this);
        getContentPane().add(exit);
        
        setSize(887, 737);
        setLocation(300, 0);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setForeground(new Color(255, 0, 0));
      //  lblNewLabel.setIcon(new ImageIcon("F:\\project\\AtmManagement\\images\\atm.jpg"));
        lblNewLabel.setIcon(new ImageIcon("/images/atm.jpg"));
        lblNewLabel.setBounds(-18, 0, 859, 727);
        getContentPane().add(lblNewLabel);
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
