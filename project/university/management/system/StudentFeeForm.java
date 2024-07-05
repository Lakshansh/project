package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener{

    Choice crollno;
    @SuppressWarnings("rawtypes")
    JComboBox cbcourse,cbbranch,cbsemester;
    JLabel labeltotal;
    JButton pay,update,back;

    StudentFeeForm(){
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);


        getContentPane().setBackground(Color.WHITE);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = il.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,50,500,300);
        add(image);


        JLabel rollnumber  = new JLabel("Select Roll no");
        rollnumber.setBounds(20,40,150,20);
        rollnumber.setFont(new Font("Tahoma", Font.PLAIN,15));
        add(rollnumber);

        crollno = new Choice();
        crollno.setBounds(20,60,150,20);
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


        JLabel name = new JLabel("Name:");
        name.setBounds(40, 100, 150, 20);
        add(name);

       

        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 150, 20);
        add(lblname);


        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(40, 140, 150, 20);
        add(fname);

        JLabel lblfname = new JLabel();
        lblfname.setBounds(200, 140, 150, 20);
        add(lblfname);


        try {
            Conn c = new Conn();
            String query = "select * from student where srollno = '" +crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
               lblname.setText(rs.getString("sname"));
               lblfname.setText(rs.getString("sfname"));  
                
            }
        } catch (Exception e) {
           e.printStackTrace();
        }


        crollno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
               
                try {
                    Conn c = new Conn();
                    String query = "select * from student where srollno = '" +crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                       lblname.setText(rs.getString("sname"));
                       lblfname.setText(rs.getString("sfname"));  
                       
                    }
                } catch (Exception e) {
                   e.printStackTrace();
                }
                
            }
        });


        JLabel lblcourse = new JLabel("Course:");
        lblcourse.setBounds(40, 180, 150, 20);
        add(lblcourse);

        String[] programs = {"B.tech", "BSc", "MSc", "BBA", "M.tech", "MBA"};
        cbcourse = new JComboBox<>(programs);
        cbcourse.setBounds(200, 180, 150, 20);
        add(cbcourse);

        JLabel branch = new JLabel("Department:");
        branch.setBounds(40, 220, 150, 20);
        add(branch);

        String[] departments = {"Civil", "Chemical", "MNC", "CSE", "MSE", "Electrical"};
        cbbranch = new JComboBox<>(departments);
        cbbranch.setBounds(200, 220, 150, 20);
        add(cbbranch);


        JLabel lblsemester  = new JLabel("Semester");
        lblsemester.setBounds(40,260,150,20);
        add(lblsemester);

        String semester[] = {"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};


        cbsemester = new JComboBox<>(semester);
        cbsemester.setBounds(200, 260,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(40, 300, 150, 20);
        lbltotal.setFont(new Font("Serif", Font.BOLD, 18));
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(200, 300, 150, 20);
        labeltotal.setFont(new Font("Serif", Font.BOLD, 18));
        add(labeltotal);


     //cancel button
     pay = new JButton("Pay Fee");
     pay.setBounds(150, 380, 100, 25);
     pay.setBackground(Color.BLACK);
     pay.setForeground(Color.WHITE);
     pay.addActionListener(this);//click event
     pay.setFont(new Font("Tahoma", Font.BOLD, 12));
     add(pay);

     update = new JButton("Update");
     update.setBounds(30, 380, 100, 25);
     update.setBackground(Color.BLACK);
     update.setForeground(Color.WHITE);
     update.addActionListener(this);//click event
     update.setFont(new Font("Tahoma", Font.BOLD, 12));
     add(update);

     back = new JButton("Back");
     back.setBounds(270, 380, 100, 25);
     back.setBackground(Color.BLACK);
     back.setForeground(Color.WHITE);
     back.addActionListener(this);//click event
     back.setFont(new Font("Tahoma", Font.BOLD, 12));
     add(back);



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
           String course = (String)cbbranch.getSelectedItem();
           String semester = (String)cbsemester.getSelectedItem();


           try {
            Conn c = new Conn();
            

            ResultSet rs = c.s.executeQuery("select * from fees where course = '" + course + "'");

            while(rs.next()){
                labeltotal.setText(rs.getString(semester));
            }
           } catch (Exception e) {
          e.printStackTrace();
           }
        }else if(ae.getSource() == pay){
            String rollno = crollno.getSelectedItem();
            String course = (String)cbcourse.getSelectedItem();
            String semester = (String)cbsemester.getSelectedItem();

            String branch = (String)cbbranch.getSelectedItem();
            String total = labeltotal.getText();

            try {
                Conn c = new Conn();
                
                String query ="insert into collagefee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "collage fee submitted successfully");
               
                setVisible(false);
               } catch (Exception e) {
              e.printStackTrace();
               }
        }else{
              setVisible(false);
        }
    }
    public static void main(String[] args) {
        new StudentFeeForm();
    }


}
