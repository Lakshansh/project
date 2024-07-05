package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class AddTeacher extends JFrame implements ActionListener {
    JTextField tfname, tffname, tfadress, tfphone, tfclassX, tfclassXII, tfadhar, tfemail;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox<String> cbcourse, cbbranch;
    JButton submit,cancel;
    String sname, sfname, sempid, sdob,sadhar,semail,sClassX,sClassXII,sadress,sphone,scourse,sbranch;


    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong()%9000) + 1000);

    AddTeacher() {
        setSize(1000, 700);
        setLocation(350, 50);
        setLayout(null);

        // Labels
        JLabel heading = new JLabel("New Teacher Detail");
        heading.setBounds(380, 40, 500, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        add(heading);

        JLabel name = new JLabel("Name:");
        name.setBounds(100, 100, 80, 20);
        add(name);

        tfname = new JTextField();
        tfname.setBounds(230, 100, 150, 20);
        add(tfname);


        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(450, 100, 120, 20);
        add(fname);

        tffname = new JTextField();
        tffname.setBounds(600, 100, 150, 20);
        add(tffname);


        JLabel empid = new JLabel("Employ  ID:");
        empid.setBounds(100, 150, 80, 20);
        add(empid);

        labelempid = new JLabel("101"+first4);// for visible of text;
        labelempid.setBounds(230, 150, 150, 20);//location of text in frame
        labelempid.setFont(new Font("serif",Font.BOLD,20));
        add(labelempid);


        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(450, 150, 120, 20);
        add(dob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600, 150, 150, 20);
        add(dcdob);

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

        tfclassX = new JTextField();
        tfclassX.setBounds(230, 250, 150, 20);
        add(tfclassX);


        JLabel classXII = new JLabel("Class 12th (%):");
        classXII.setBounds(450, 250, 120, 20);
        add(classXII);

        tfclassXII = new JTextField();
        tfclassXII.setBounds(600, 250, 150, 20);
        add(tfclassXII);

        JLabel email = new JLabel("E-mail:");
        email.setBounds(100, 300, 80, 20);
        add(email);

        tfemail = new JTextField();
        tfemail.setBounds(230, 300, 150, 20);
        add(tfemail);

        JLabel adhar = new JLabel("Adhar:");
        adhar.setBounds(450, 300, 80, 20);
        add(adhar);

        tfadhar = new JTextField();
        tfadhar.setBounds(600, 300, 150, 20);
        add(tfadhar);


        JLabel course = new JLabel("Qualification:");
        course.setBounds(100, 350, 80, 20);
        add(course);

        String[] programs = {"B.tech", "MBA", "Bsc", "Msc", "BBA", "Phd"};
        cbcourse = new JComboBox<>(programs);
        cbcourse.setBounds(230, 350, 150, 20);
        add(cbcourse);

        JLabel branch = new JLabel("Department:");
        branch.setBounds(450, 350, 120, 20);
        add(branch);

        String[] departments = {"Civil", "Chemical", "MNC", "CSE", "MSE", "Electrical"};
        cbbranch = new JComboBox<>(departments);
        cbbranch.setBounds(600, 350, 150, 20);
        add(cbbranch);

         //cancel button
     cancel = new JButton("Cancel");
     cancel.setBounds(450, 400, 150, 20);
     cancel.setBackground(Color.BLACK);
     cancel.setForeground(Color.WHITE);
     cancel.addActionListener(this);//click event
     cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
     add(cancel);

     submit = new JButton("Submit");
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
            sname = tfname.getText();
            sfname = tffname.getText();
            sempid = labelempid.getText();
            sdob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText(); 
            sadhar = tfadhar.getText();
            sadress = tfadress.getText();
            sClassX = tfclassX.getText();
            sClassXII = tfclassXII.getText();
            sphone = tfphone.getText();
            scourse = (String)cbcourse.getSelectedItem();
            sbranch = (String)cbbranch.getSelectedItem();
            semail = tfemail.getText();


            try {
                String query = "insert into teacher values('" + sname + "','" + sfname + "','" + sempid + "','" + sdob + "','" + sadress + "','" + sphone + "','" + semail + "','" + sClassX + "','" + sClassXII + "','" + sadhar + "','" + scourse + "' , '" + sbranch + "')";
                
                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Inserted succesfully");
                setVisible(false);


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new AddTeacher();
    }
}
