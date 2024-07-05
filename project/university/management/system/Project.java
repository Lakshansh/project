package university.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

    public class Project extends JFrame implements ActionListener {

    Project() {
        setSize(1540, 850);

        // Background image
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpeg"));
        Image i2 = il.getImage().getScaledInstance(1540, 790, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();

        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);

        JMenu facultyInfo = new JMenu("New Faculty");
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenu studentInfo = new JMenu("New Student");
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        JMenu details = new JMenu("Details");
        details.setForeground(Color.BLUE);
        mb.add(details);

        JMenu facultydetails = new JMenu("Faculty Details");
        details.add(facultydetails);

        JMenu studentdetails = new JMenu("Student Details");
        details.add(studentdetails);

        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);

        JMenu facultyLeave = new JMenu("Faculty Leave");
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenu studentLeave = new JMenu("Student Leave");
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLUE);
        mb.add(leaveDetails);

        JMenu facultyLeaveDetails = new JMenu("Faculty Leave Details");
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenu studentLeaveDetails = new JMenu("Student Leave Details");
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);

        JMenu result = new JMenu("Exam Results");
        exam.add(result);

        JMenu marks = new JMenu("Enter Marks");
        marks.addActionListener(this);
        exam.add(marks);

        JMenu update = new JMenu("Update Information");
        update.setForeground(Color.BLUE);
        mb.add(update);

        JMenu updatefaculty = new JMenu("Faculty Information");
        updatefaculty.addActionListener(this);
        update.add(updatefaculty);

        JMenu updatestudent = new JMenu("Student Information");
        studentdetails.addActionListener(this);
        update.add(updatestudent);

        JMenu fee = new JMenu("Fees");
        fee.setForeground(Color.BLUE);
        mb.add(fee);

        JMenu feeSt = new JMenu("Fees Structure");
        updatefaculty.addActionListener(this);
        fee.add(feeSt);

        JMenu feeFoam = new JMenu("Fees Formation");
        feeFoam.addActionListener(this);
        fee.add(feeFoam);

        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Note Pad");
        utility.add(notepad);
        notepad.addActionListener(this);

        JMenuItem calc = new JMenuItem("Calculator");
        utility.add(calc);
        calc.addActionListener(this);

        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);

        JMenuItem ab = new JMenuItem("About");
        ab.addActionListener(this);
        about.add(ab);
        

        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.addActionListener(this);
        exit.add(ex);
       

        setJMenuBar(mb);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String s = ae.getActionCommand();
       
        if (s.equals("Exit")) {
            setVisible(false);
        } else if (s.equals("Calculator")) {
            try {
                Desktop.getDesktop().open(new java.io.File("calc.exe"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (s.equals("Note Pad")) {
            try {
                Desktop.getDesktop().open(new java.io.File("notepad.exe"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (s.equals("New Student")) {
            setVisible(false);
            new AddStudent();
        }else if(s.equals("New Faculty")){
            setVisible(false);
            new AddTeacher();
        }else if( s.equals("Faculty Details")){
            new TeacherDetails();
        }else if(s.equals("Student Details")){
            new StudentDetails();
        }else if(s.equals("Student Leave")){
            new StudentLeave();
        }else if(s.equals("Faculty Leave")){
            new TeacherLeave();
        }else if(s.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }else if(s.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        }else if(s.equals("Student Information")){
            new UpdateStudent();
        }else if(s.equals("Faculty Information")){
            new UpdateTeacher();
        }else if(s.equals("Enter Marks")){
            new EnterMarks();
        }else if(s.equals("Exam Results")){
            new ExaminationDetails();
        }else if(s.equals("Fees Structure")){
            new FeeStructure();
        }else if(s.equals("Fees Formation")){
            new StudentFeeForm();
        }else if(s.equals("About")){
            new About();
        }
        
    }

    public static void main(String[] args) {
        new Project();
    }
}
