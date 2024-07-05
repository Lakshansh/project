package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class Marks extends JFrame implements ActionListener {

    String rollno;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5;
    JButton cancel;

    Marks(String rollno){
      setSize(500,600);
      setLocation(500,100);
      setLayout(null);

      getContentPane().setBackground(Color.WHITE);
      
        JLabel heading = new JLabel("IIT Kanpur");
        heading.setBounds(200, 15, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        add(heading);

        JLabel subheading = new JLabel("Examination Results");
        subheading.setBounds(170, 40, 400, 50);
        subheading.setFont(new Font("Serif", Font.BOLD, 18));
        add(subheading);
        

        JLabel lblrollno = new JLabel("Roll Number" + rollno);
        lblrollno.setBounds(60, 100, 500, 20);
        lblrollno.setFont(new Font("Serif", Font.BOLD, 18));
        add(lblrollno);

        JLabel lblsemester = new JLabel("semester");
        lblsemester.setBounds(60, 130, 500, 20);
        lblsemester.setFont(new Font("Serif", Font.BOLD, 18));
        add(lblsemester);


        JLabel sub1 = new JLabel();
        sub1.setBounds(60, 160, 500, 20);
        sub1.setFont(new Font("Serif", Font.BOLD, 18));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(60, 190, 500, 20);
        sub2.setFont(new Font("Serif", Font.BOLD, 18));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(60, 220, 500, 20);
        sub3.setFont(new Font("Serif", Font.BOLD, 18));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(60, 250, 500, 20);
        sub4.setFont(new Font("Serif", Font.BOLD, 18));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(60, 280, 500, 20);
        sub5.setFont(new Font("Serif", Font.BOLD, 18));
        add(sub5);

        
        try {
           Conn c = new Conn();
           
           ResultSet rs1 = c.s.executeQuery("select*from subject where rollno = '"+   rollno+"'");

           while(rs1.next()){
            sub1.setText(rs1.getString("subject1"));
            sub2.setText(rs1.getString("subject2"));
            sub3.setText(rs1.getString("subject3"));
            sub4.setText(rs1.getString("subject4"));
            sub5.setText(rs1.getString("subject5"));
           }


           ResultSet rs2 = c.s.executeQuery("select*from marks where rollno = '" + rollno+"'");

           while(rs2.next()){
            sub1.setText(sub1.getText() + "________"+ rs2.getString("marks1"));
            sub2.setText(sub2.getText() + "________"+ rs2.getString("marks2"));
            sub3.setText(sub3.getText() + "________"+ rs2.getString("marks3"));
            sub4.setText(sub4.getText() + "________"+ rs2.getString("marks4"));
            sub5.setText(sub5.getText() + "________"+ rs2.getString("marks5"));
            lblsemester.setText("Semester" + rs2.getString("semester"));
           }

        } catch (Exception e) {
          e.printStackTrace();
        }

        //cancel button
        cancel = new JButton("Back");
        cancel.setBounds(180,400,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);//click event
        cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(cancel);




      setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[] args){
         new Marks("");
    }

}
