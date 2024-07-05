package university.management.system;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener  {

    Choice crollno;
    @SuppressWarnings("rawtypes")
    JComboBox cbsemester;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
    JButton submit,cancel;


        EnterMarks(){
            setSize(1000,500);
            setLocation(300,150);
            setLayout(null);

            getContentPane().setBackground(Color.WHITE);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = il.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,40,400,300);
        add(image);

        JLabel heading = new JLabel("Update Student Detail");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        add(heading);

        JLabel rollnumber  = new JLabel("Select Roll no");
        rollnumber.setBounds(50,70,150,20);
        heading.setFont(new Font("Tahoma", Font.PLAIN,15));
        add(rollnumber);

        crollno = new Choice();
        crollno.setBounds(200,70,150,20);
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

        JLabel lblsemester  = new JLabel("Select Roll no");
        lblsemester.setBounds(50,110,150,20);
        add(lblsemester);

        String semester[] = {"1st semester","2nd semester","3rd semester","4th semester","5th semester","6th semester","7th semester","8th semester"};


        cbsemester = new JComboBox<>(semester);
        cbsemester.setBounds(200, 110,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        JLabel lblentersubject  = new JLabel("Enter Subject");
        lblentersubject.setBounds(50,150,200,40);
        add(lblentersubject);

        JLabel lblentermarks  = new JLabel("Enter Marks");
        lblentermarks.setBounds(320,150,200,40);
        add(lblentermarks);

        tfsub1 = new JTextField();
        tfsub1.setBounds(50,200,200,20);
        add(tfsub1);

        tfsub2 = new JTextField();
        tfsub2.setBounds(50,230,200,20);
        add(tfsub2);

        tfsub3 = new JTextField();
        tfsub3.setBounds(50,260,200,20);
        add(tfsub3);

        tfsub4 = new JTextField();
        tfsub4.setBounds(50,290,200,20);
        add(tfsub4);
        
        tfsub5 = new JTextField();
        tfsub5.setBounds(50,320,200,20);
        add(tfsub5);

        tfmarks1 = new JTextField();
        tfmarks1.setBounds(250,200,200,20);
        add(tfmarks1);

        tfmarks2 = new JTextField();
        tfmarks2.setBounds(250,230,200,20);
        add(tfmarks2);

        tfmarks3 = new JTextField();
        tfmarks3.setBounds(250,260,200,20);
        add(tfmarks3);

        tfmarks4 = new JTextField();
        tfmarks4.setBounds(250,290,200,20);
        add(tfmarks4);

        tfmarks5 = new JTextField();
        tfmarks5.setBounds(250,320,200,20);
        add(tfmarks5);


         //cancel button
           cancel = new JButton("Back");
           cancel.setBounds(70, 360, 150, 25);
           cancel.setBackground(Color.BLACK);
           cancel.setForeground(Color.WHITE);
           cancel.addActionListener(this);//click event
           cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
           add(cancel);

           //update
           submit = new JButton("Submit");
           submit.setBounds(280, 360, 150, 25);
           submit.setBackground(Color.BLACK);
           submit.setForeground(Color.WHITE);
           submit.addActionListener(this);//click event
           submit.setFont(new Font("Tahoma", Font.BOLD, 12));
           add(submit);


           


            setVisible(true);
        }

        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == submit){

                try {
                    Conn c = new Conn();
                    
                    String query1 = "insert into subject values('"+crollno.getSelectedItem()+"','"+crollno.getSelectedItem()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"')";
                    String query2 = "insert into marks values('"+crollno.getSelectedItem()+"','"+crollno.getSelectedItem()+"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"')";

                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Marks Inserted succesfully");
                    setVisible(false);

                } catch (Exception e) {
                   e.printStackTrace();
                }

            }else{
                setVisible(false);
            }
        }


    public static void main(String[] args){
        new EnterMarks();

    }

}
