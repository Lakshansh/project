package university.management.system;


import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread t;

    Splash() {
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg")); // Corrected the image file extension
        Image i2 = il.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // Use the scaled image icon
        add(image);
        setVisible(true); // Make the splash screen visible

        t = new Thread(this);
        t.start();

        // Set size and other properties of the splash screen
        setLocation(200,50);
        for(int i=0;i<1000;i++){
           
             // Center the splash screen
            setSize(i,200+(i/2)); // Adjust the size as needed 
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                
            }
        }

        
    }

    public void run() {
        try {
            Thread.sleep(5000); // Splash screen display time
            setVisible(false);
            new Login(); // Close the splash screen after display time
        } catch (Exception e) {
           
        }
    }

    public static void main(String[] args) {
        // Ensure the splash screen is created on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Splash();
            }
        });
    }
}
