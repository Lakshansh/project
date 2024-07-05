package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, cancel;
    JTextField username;
    JPasswordField password;

    Login() {
        getContentPane().setBackground(Color.WHITE); // set background color
        setLayout(null); // set layout to null

        // username
        JLabel idusername = new JLabel("Username"); // for visibility of text
        idusername.setBounds(20, 30, 100, 20); // location of text in frame
        add(idusername); // add text

        username = new JTextField(); // input text
        username.setBounds(105, 30, 100, 20); // location of text in frame
        add(username);

        // password
        JLabel idpassword = new JLabel("Password"); // for visibility of text
        idpassword.setBounds(20, 60, 100, 20); // location of text in frame
        add(idpassword); // add text

        password = new JPasswordField(); // input text
        password.setBounds(105, 60, 100, 20); // location of text in frame
        add(password);

        // login button
        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this); // click event
        login.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(login);

        // cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this); // click event
        cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(cancel);

        // image on login frame
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg")); // Corrected the image file extension
        Image i2 = il.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // Use the scaled image icon
        add(image);
        image.setBounds(400, 50, 100, 100);
        setVisible(true); // Make the splash screen visible

        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String user = username.getText();
            char[] pass = password.getPassword(); // Use getPassword() to retrieve password as char array
            String passString = new String(pass); // Convert char array to String

            String query = "SELECT * FROM login WHERE user = ? AND pass = ?";

            try (Conn c = new Conn(); PreparedStatement pst = c.s.prepareStatement(query)) {
                pst.setString(1, user);
                pst.setString(2, passString);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    setVisible(false);
                    new Project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
