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

    Connection connection;
    PreparedStatement preparedStatement;

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

        JLabel lblNewLabel = new JLabel("");
       // lblNewLabel.setIcon(new ImageIcon("F:\\project\\AtmManagement\\images\\bank.jpg"));
        lblNewLabel.setIcon(new ImageIcon("/images/bank.jpg"));
        lblNewLabel.setBounds(-32, -54, 1301, 783);
        getContentPane().add(lblNewLabel);

        setSize(800, 800);
        setLocation(300, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b1) {
                String cardno = tf1.getText();
                String pin = new String(pf2.getPassword());

                if (cardno.isEmpty() || pin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Card Number or PIN cannot be empty");
                    return;
                }

                // Load the MySQL JDBC driver 
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish connection
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false", "root", "747288");

                // Query to validate card number and pin
                String query = "SELECT * FROM signupthree WHERE atm_card_no = ? AND pin = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, cardno);
                preparedStatement.setString(2, pin);

                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    // Insert login data into the login table
                    String insertQuery = "INSERT INTO login (formno, cardNumber, PinNumber) VALUES (?, ?, ?)";
                    PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
                    insertStmt.setString(1, rs.getString("form_no")); // Fetching form_no from signupthree table
                    insertStmt.setString(2, cardno);
                    insertStmt.setString(3, pin);
                    insertStmt.executeUpdate();
                    insertStmt.close();

                    new transaction(pin).setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                } 

                // Close connections
                rs.close();
                preparedStatement.close();
                connection.close();

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
