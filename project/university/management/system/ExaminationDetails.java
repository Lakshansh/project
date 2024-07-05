package university.management.system;

import net.proteanit.sql.DbUtils;
import java.awt.*;  
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ExaminationDetails extends JFrame implements ActionListener{

    JTextField search;
    JButton submit,cancel;
    JTable table;

ExaminationDetails(){

  setSize(1000,475);
  setLocation(300,100);

  
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80, 15, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        add(heading);


        search = new JTextField();
        search.setBounds(50,90,200,30);
        add(search);


           //cancel button
           cancel = new JButton("Back");
           cancel.setBounds(300,90,200,30);
           cancel.setBackground(Color.BLACK);
           cancel.setForeground(Color.WHITE);
           cancel.addActionListener(this);//click event
           cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
           add(cancel);

           //update
           submit = new JButton("Result");
           submit.setBounds(440,90,200,30);
           submit.setBackground(Color.BLACK);
           submit.setForeground(Color.WHITE);
           submit.addActionListener(this);//click event
           submit.setFont(new Font("Tahoma", Font.BOLD, 12));
           add(submit);

           table = new JTable();
           table.setFont(new Font("Tohoma",Font.PLAIN,16));


           JScrollPane jsp = new JScrollPane(table);
           jsp.setBounds(0,130,1000,110);
           add(jsp);


           try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));

           } catch (Exception e) {
              e.printStackTrace();
           }

          table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
          });


  setVisible(true);
}

    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == submit){
        setVisible(false);

        new Marks(search.getText());
      }else{
        setVisible(false);
      }
    }
    public static void main(String[] args){
        new ExaminationDetails();
    }

}
