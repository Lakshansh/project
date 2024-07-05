package university.management.system;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;




public class StudentLeave extends JFrame implements ActionListener{

    Choice crollno,timechoose;
    JDateChooser datechooser;
    JButton cancel,submit;

    StudentLeave(){
    setSize(500,550);
    setLocation(550,100);
    setLayout(null);

    getContentPane().setBackground(Color.WHITE);
    
        JLabel heading = new JLabel("Apply Leave(Student)");
        heading.setBounds(170,35,300,30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(heading);


        JLabel rollno  = new JLabel("Search by Roll Number");
        rollno.setBounds(20,70,150,20);
        heading.setFont(new Font("Tahoma", Font.PLAIN,15));
        add(rollno);

        crollno = new Choice();
        crollno.setBounds(20,100,150,20);
        add(crollno);



        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select*from student");
            while(rs.next()){
                crollno.add(rs.getString("srollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel date  = new JLabel("Date");
        date.setBounds(20,130,150,20);
        date.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(date);

        datechooser = new JDateChooser();
        datechooser.setBounds(20, 160, 150, 20);
        add(datechooser);

        JLabel time  = new JLabel("Duration");
        time.setBounds(20,190,150,20);
        time.setFont(new Font("Tahoma", Font.PLAIN,15));
        add(time);

        timechoose = new Choice();
        timechoose.setBounds(20,220,150,20);
        timechoose.add("Full Day");
        timechoose.add("Half Day");
        add(timechoose);


     cancel = new JButton("Cancel");
     cancel.setBounds(130,250,100,20);
     cancel.setBackground(Color.BLACK);
     cancel.setForeground(Color.WHITE);
     cancel.addActionListener(this);//click event
     cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
     add(cancel);

     submit = new JButton("Submit");
     submit.setBounds(20,250,100,20);
     submit.setBackground(Color.BLACK);
     submit.setForeground(Color.WHITE);
     submit.addActionListener(this);//click event
     submit.setFont(new Font("Tahoma", Font.BOLD, 12));
     add(submit);




    setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            setVisible(false);
        }else{
            String srllno = crollno.getSelectedItem();
            String Date = ((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
            String Duration = timechoose.getSelectedItem();

            String qurey = "insert into studentleave values('"+srllno+"','"+Date+"','"+Duration+"')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(qurey);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);
            } catch (Exception e) {
             e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new StudentLeave();
    }
}
