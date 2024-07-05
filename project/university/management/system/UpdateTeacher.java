package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;





public class UpdateTeacher extends JFrame implements ActionListener {
    JTextField  tfadress, tfphone,tfbranch, tfemail,tfcourse;
    JLabel labelempid;
    Choice cempid;
    
    JButton submit,cancel;
    String sname, sfname, sempid, sdob,sadhar,semail,sClassX,sClassXII,sadress,sphone,scourse,sbranch;


    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong()%9000) + 1000);

    UpdateTeacher() {
        setSize(1000, 700);
        setLocation(350, 50);
        setLayout(null);

        // Labels
        JLabel heading = new JLabel("Update Teacher Detail");
        heading.setBounds(380, 40, 500, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        add(heading);

        JLabel employeeid  = new JLabel("Select Employee ID");
        employeeid.setBounds(20,40,150,20);
        employeeid.setFont(new Font("Tahoma", Font.PLAIN,15));
        add(employeeid);

        cempid = new Choice();
        cempid.setBounds(20,60,150,20);
        add(cempid);



        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select*from teacher");
            while(rs.next()){
                cempid.add(rs.getString("sempid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name:");
        name.setBounds(100, 100, 80, 20);
        add(name);

       

        JLabel lblname = new JLabel();
        lblname.setBounds(230, 100, 150, 20);
        add(lblname);


        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(450, 100, 120, 20);
        add(fname);

        JLabel lblfname = new JLabel();
        lblfname.setBounds(600, 100, 150, 20);
        add(lblfname);


        JLabel empid = new JLabel("Roll no:");
        empid.setBounds(100, 150, 80, 20);
        add(empid);

        labelempid = new JLabel();// for visible of text;
        labelempid.setBounds(230, 150, 150, 20);//location of text in frame
        labelempid.setFont(new Font("serif",Font.BOLD,20));
        add(labelempid);//add text
   


        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(450, 150, 120, 20);
        add(dob);

        JLabel lbldob = new JLabel();
        lbldob.setBounds(600, 150, 120, 20);
        add(lbldob);

        

        JLabel address = new JLabel("Address:");
        address.setBounds(100, 200, 80, 20);
        add(address);

        tfadress = new JTextField();
        tfadress.setBounds(230, 200, 150, 20);
        add(tfadress);

        JLabel phone = new JLabel("Phone no:");
        phone.setBounds(450, 200, 80, 20);
        add(phone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 200, 150, 20);
        add(tfphone);


        JLabel classX = new JLabel("Class 10th (%):");
        classX.setBounds(100, 250, 120, 20);
        add(classX);

        JLabel lblclassX = new JLabel();
        lblclassX.setBounds(230, 250, 150, 20);
        add(lblclassX);


        JLabel classXII = new JLabel("Class 12th (%):");
        classXII.setBounds(450, 250, 120, 20);
        add(classXII);

        JLabel lblclassXII = new JLabel();
        lblclassXII.setBounds(600, 250, 150, 20);
        add(lblclassXII);

        JLabel email = new JLabel("E-mail:");
        email.setBounds(100, 300, 80, 20);
        add(email);

        tfemail = new JTextField();
        tfemail.setBounds(230, 300, 150, 20);
        add(tfemail);

        JLabel adhar = new JLabel("Adhar:");
        adhar.setBounds(450, 300, 80, 20);
        add(adhar);

        JLabel lbladhar = new JLabel();
        lbladhar.setBounds(600, 300, 150, 20);
        add(lbladhar);


        JLabel course = new JLabel("Education:");
        course.setBounds(100, 350, 80, 20);
        add(course);

        tfcourse = new JTextField();
        tfcourse.setBounds(230, 350, 150, 20);
        add(tfcourse);

      

        JLabel branch = new JLabel("Department:");
        branch.setBounds(450, 350, 120, 20);
        add(branch);

        
        tfbranch = new JTextField();
        tfbranch.setBounds(600, 350, 150, 20);
        add(tfbranch);

        try {
            Conn c = new Conn();
            String query = "select * from teacher where sempid = '" +cempid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
               lblname.setText(rs.getString("sname"));
               lblfname.setText(rs.getString("sfname"));  
               lbldob.setText(rs.getString("sdob"));  
               tfadress.setText(rs.getString("sadress")); 
               tfphone.setText(rs.getString("sphone")); 
               tfemail.setText(rs.getString("semail")); 
               lblclassX.setText(rs.getString("sClassX")); 
               lblclassXII.setText(rs.getString("sClassXII")); 
               labelempid.setText(rs.getString("sempid")); 
               tfcourse.setText(rs.getString("scourse")); 
               tfbranch.setText(rs.getString("sbranch")); 
               lbladhar.setText(rs.getString("sadhar")); 
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        try {
            Conn c = new Conn();
            String query = "select * from teacher where sempid = '" +cempid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
               lblname.setText(rs.getString("sname"));
               lblfname.setText(rs.getString("sfname"));  
               lbldob.setText(rs.getString("sdob")); 
               tfadress.setText(rs.getString("sadress")); 
               tfphone.setText(rs.getString("sphone")); 
               tfemail.setText(rs.getString("semail")); 
               lblclassX.setText(rs.getString("sClassX")); 
               lblclassXII.setText(rs.getString("sClassXII")); 
               labelempid.setText(rs.getString("sempid")); 
               tfcourse.setText(rs.getString("scourse")); 
               tfbranch.setText(rs.getString("sbranch")); 
               lbladhar.setText(rs.getString("sadhar")); 
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        cempid.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
               
                try {
                    Conn c = new Conn();
                    String query = "select * from teacher where sempid = '" +cempid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                       lblname.setText(rs.getString("sname"));
                       lblfname.setText(rs.getString("sfname"));  
                       lbldob.setText(rs.getString("sdob")); 
                       tfadress.setText(rs.getString("sadress")); 
                       tfphone.setText(rs.getString("sphone")); 
                       tfemail.setText(rs.getString("semail")); 
                       lblclassX.setText(rs.getString("sClassX")); 
                       lblclassXII.setText(rs.getString("sClassXII")); 
                       labelempid.setText(rs.getString("sempid")); 
                       tfcourse.setText(rs.getString("scourse")); 
                       tfbranch.setText(rs.getString("sbranch")); 
                       lbladhar.setText(rs.getString("sadhar")); 
                    }
                } catch (Exception e) {
                   e.printStackTrace();
                }
                
            }
        });

           //cancel button
           cancel = new JButton("Cancel");
           cancel.setBounds(450, 400, 150, 20);
           cancel.setBackground(Color.BLACK);
           cancel.setForeground(Color.WHITE);
           cancel.addActionListener(this);//click event
           cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
           add(cancel);

           //update
           submit = new JButton("Update");
           submit.setBounds(230, 400, 150, 20);
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
        }else if(ae.getSource() == submit){
           
                sempid = labelempid.getText();
                sadress = tfadress.getText();
                sphone = tfphone.getText();
                scourse = tfcourse.getText();
                sbranch = tfbranch.getText();
                semail = tfemail.getText();

            try {
                String query = "update teacher set sadress ='" + sadress + "', sphone = '" + sphone + "',semail = '" + semail + "',scourse = '" + scourse + "' ,sbranch = '" + sbranch + "'  where sempid = '"+sempid+"'";
                
                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Teacher Details Updated succesfully");
                setVisible(false);


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }
}