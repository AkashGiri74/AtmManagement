package atmmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JComboBox<String> religionComboBox, categoryComboBox, incomeComboBox;
    JTextField t5, t6, t7, t8;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton rdbtnNewRadioButton;
    private JRadioButton rdbtnNewRadioButton_1;
    private JButton btnNewButton;

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
        
        // Religion ComboBox
        religionComboBox = new JComboBox<>();
        religionComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "--select--", "Hinduism", "Islam", "Christianity", "Sikhism", "Buddhism", 
            "Jainism", "Zoroastrianism (Parsi)", "Judaism", "Bahá'í Faith", 
            "Tribal Religions", "Shinto", "Taoism", "Confucianism", "Druze", 
            "Yazidism", "Tenrikyo", "Cao Dai", "Vodou (Voodoo)", "Santería", 
            "Rastafarianism", "Atheism", "Agnosticism", "Humanism", "Scientology", 
            "Unitarian Universalism", "Wicca", "Paganism", "Druidry", 
            "Shamanism", "Spiritism", "Eckankar", "Raelism", "Thelema", 
            "Church of the Flying Spaghetti Monster (Pastafarianism)", "Falun Gong", 
            "Hare Krishna (ISKCON)", "Bön", "Sikh Dharma", "Gnosticism", 
            "Sufism", "Candomblé", "Ifá", "Hermeticism", "Zoroastrianism (Mazdaism)", 
            "Alawite", "Ayyavazhi", "Catharism", "Manichaeism", "Nestorianism", 
            "Sabianism", "Samaritanism", "Mandaeism", "Ashurism", "Tengriism", 
            "Ancient Egyptian Religion", "Mesopotamian Religion", 
            "Ancient Greek Religion", "Ancient Roman Religion", 
            "Norse Religion (Asatru)", "Celtic Polytheism", "Slavic Native Faith", 
            "Baltic Religion (Romuva)", "Tengrism", "Korean Shamanism (Muism)", 
            "African Traditional Religions", "Zulu Religion", "Yoruba Religion", 
            "Akan Religion", "Oromo Religion", "Igbo Religion", 
            "Native American Religions", "Australian Aboriginal Religions", 
            "Maori Religion", "Inuit Religion", "Shona Religion", 
            "Voodoo (Haitian Vodou)", "Tumbuka Religion", "Aztec Religion", 
            "Inca Religion", "Maya Religion", "Shaktiism", "Tantrism", 
            "Vaishnavism", "Shaivism", "Smarta Tradition", "Lingayatism", 
            "Aghori", "Radha Soami", "Ramakrishna Mission", "Vedanta", 
            "Sant Mat", "Kabir Panth", "Gaudiya Vaishnavism", "Arya Samaj", 
            "Brahmo Samaj", "Satya Sai Organization", "Ananda Marga", 
            "Zailmukhi (Godianism)"
        }));
        religionComboBox.setFont(new Font("Raleway", Font.BOLD, 14));

        // Category ComboBox
        categoryComboBox = new JComboBox<>();
        categoryComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "--select--", "Brahmin", "Kshatriya", "Vaishya", "Shudra", "Rajput", 
            "Maratha", "Jat", "Yadav", "Kayastha", "Baniya", "Koli", "Gujjar", 
            "Dalit (Scheduled Castes)", "Scheduled Tribes (ST)", "Lingayat", "Nair", 
            "Ezhava", "Reddy", "Patel", "Kamma", "Bhumihar", "Chamar", "Ahir", 
            "Kurmi", "Lodhi", "Goud", "Vanniyar", "Balija", "Thakur", "Lohana", 
            "Saini", "Nadar", "Mudaliar", "Iyer", "Iyengar", "Khatri", "Meena", 
            "Agrawal", "Sindhi", "Kori", "Kamma", "Gounder", "Nadars", "Ezhavas", 
            "Kammas", "Kolis", "Yadavas", "Reddis", "Kurubas", "OBC (Other Backward Classes)", 
            "Brahmo Samaj", "Vishwakarma", "Bhandari", "Ror", "Mali", "Sunar", 
            "Maheshwari", "Arain", "Gorkha", "Bhil", "Kol", "Mahajan", "Kapu", 
            "Devanga", "Panjabi Khatri", "Banjaras", "Khatik", "Meo", "Madiga", 
            "Mahar", "Balija", "Shetty", "Baghel", "Banias", "Charan", "Damor", 
            "Dhobi", "Gadariya", "Gaud Saraswat Brahmin", "Ghosh", "Golla", 
            "Gowda", "Gurjar", "Harijan", "Holeya", "Irula", "Jangid Brahmin", 
            "Kaibarta", "Koch", "Kuruba", "Lambadi", "Linga Balija", "Mudiraj", 
            "Muslim Sheikh", "Vaddera"
        }));
        categoryComboBox.setFont(new Font("Raleway", Font.BOLD, 14));

        // Income ComboBox
        incomeComboBox = new JComboBox<>();
        incomeComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "--select--", "Below 1 Lakh", "1 Lakh - 2.5 Lakhs", "2.5 Lakhs - 5 Lakhs", 
            "5 Lakhs - 10 Lakhs", "10 Lakhs - 20 Lakhs", "Above 20 Lakhs"
        }));
        incomeComboBox.setFont(new Font("Raleway", Font.BOLD, 14));

        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t6 = new JTextField();
        t6.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t7 = new JTextField();
        t7.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t8 = new JTextField();
        t8.setFont(new Font("Raleway", Font.BOLD, 14));
        
        getContentPane().setLayout(null);
        
        l1.setBounds(290, 30, 600, 30);
        getContentPane().add(l1);
        
        l2.setBounds(100, 80, 150, 30);
        getContentPane().add(l2);
        
        l3.setBounds(100, 130, 150, 30);
        getContentPane().add(l3);
        
        l4.setBounds(100, 180, 150, 30);
        getContentPane().add(l4);
        
        l5.setBounds(100, 230, 150, 30);
        getContentPane().add(l5);
        
        l6.setBounds(100, 280, 150, 30);
        getContentPane().add(l6);
        
        l7.setBounds(100, 330, 150, 30);
        getContentPane().add(l7);
        
        l8.setBounds(100, 380, 173, 39);
        getContentPane().add(l8);
        
        l9.setBounds(100, 430, 150, 30);
        getContentPane().add(l9);
        
        religionComboBox.setBounds(300, 80, 400, 30);
        getContentPane().add(religionComboBox);
        
        categoryComboBox.setBounds(300, 130, 400, 30);
        getContentPane().add(categoryComboBox);
        
        incomeComboBox.setBounds(300, 180, 400, 30);
        getContentPane().add(incomeComboBox);
        
        t5.setBounds(300, 230, 400, 30);
        getContentPane().add(t5);
        
        t6.setBounds(300, 280, 400, 30);
        getContentPane().add(t6);
        
        t7.setBounds(300, 330, 400, 30);
        getContentPane().add(t7);
        
        t8.setBounds(300, 380, 400, 30);
        getContentPane().add(t8);
        
        rdbtnNewRadioButton = new JRadioButton("yes");
        buttonGroup.add(rdbtnNewRadioButton);
        rdbtnNewRadioButton.setBounds(300, 438, 111, 23);
        getContentPane().add(rdbtnNewRadioButton);
        
        rdbtnNewRadioButton_1 = new JRadioButton("No");
        buttonGroup.add(rdbtnNewRadioButton_1);
        rdbtnNewRadioButton_1.setBounds(443, 438, 111, 23);
        getContentPane().add(rdbtnNewRadioButton_1);
        
        btnNewButton = new JButton("Next");
        btnNewButton.setBounds(572, 438, 89, 25);
        getContentPane().add(btnNewButton);
        btnNewButton.addActionListener(this);
        
        setSize(850, 550);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String religion = (String) religionComboBox.getSelectedItem();
        String category = (String) categoryComboBox.getSelectedItem();
        String income = (String) incomeComboBox.getSelectedItem();
        String qualification = t5.getText();
        String occupation = t6.getText();
        String panNumber = t7.getText();
        String aadharNumber = t8.getText();
        
        // Perform input validation
        if (religion.equals("--select--") || category.equals("--select--") || income.equals("--select--") || 
            qualification.isEmpty() || occupation.isEmpty() || panNumber.isEmpty() || aadharNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required.");
            return;
        }

        if (aadharNumber.length() != 12) {
            JOptionPane.showMessageDialog(this, "Invalid aadhar number");
            return;
        } 

        if (panNumber.length() != 10) {
            JOptionPane.showMessageDialog(this, "Invalid pan number");
            return;
        }
        
        Connection c = null;
        PreparedStatement pstmt = null;
        
        try {
            // Create a mysql object to handle database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false", "root", "747288");

            // Insert data into the signuptwo table
            String sql = "INSERT INTO signuptwo (religion, category, income, qualification, occupation, pan_number, aadhar_number) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = c.prepareStatement(sql);
            
            pstmt.setString(1, religion);
            pstmt.setString(2, category);
            pstmt.setString(3, income);
            pstmt.setString(4, qualification);
            pstmt.setString(5, occupation);
            pstmt.setString(6, panNumber);
            pstmt.setString(7, aadharNumber);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Details saved successfully.");
                if(ae.getSource() == btnNewButton) {
                    setVisible(false);
                    new Signup3().setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "An error occurred while saving details.");
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while connecting to the database.");
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (c != null) c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    

    public static void main(String[] args) {
        new Signup2();
    }
}
