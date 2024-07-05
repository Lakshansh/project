package university.management.system;

import javax.swing.*;
import java.awt.*; 

public class About extends JFrame {

    About(){
        setSize(700, 500);
        setLocation(401, 150);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = il.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,300,200);
        add(image);

       JLabel heading = new JLabel("<html>University<br/>Management<br/> System</html>");
       heading.setBounds(70, 20, 300, 130);
       heading.setFont(new Font("Serif", Font.BOLD, 20));
       add(heading);

       JLabel name = new JLabel("Developed by Lakshash");
       name.setBounds(70, 150, 300, 40);
       name.setFont(new Font("Serif", Font.BOLD, 20));
       add(name);

       JLabel mail = new JLabel("E-mail = lakshanshchouhan42@gmail.com");
       mail.setBounds(70, 200, 550, 40);
       mail.setFont(new Font("Serif", Font.BOLD, 20));
       add(mail);


        

        setVisible(true);
    }


    public static void main(String[] args) {
        new About();
    }
}
