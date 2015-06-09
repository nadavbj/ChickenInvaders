import java.awt.event.*;

import javax.swing.*;

import java.awt.*;
 
public class BackgroundLayered extends JFrame
{
     private Timer movingTimer;
     JLabel foreground;
     int startY = 10;
     int startX = 0;
     int DELAY = 20;
     
     public BackgroundLayered()
     {
 
          ImageIcon image = (new ImageIcon(EntryWindow.class.getResource("/Chicken_Invaders_resources/backGround.jpeg")));
          JLabel background = new JLabel(image);
          background.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
          getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
          
          JPanel panel = new JPanel();
          ImageIcon back = (new ImageIcon(EntryWindow.class.getResource("/Chicken_Invaders_resources/backGround.jpeg")));
  		
          foreground = new JLabel(back);
          
          foreground.setSize(10, 10000);
          move();
          movingTimer = new Timer(DELAY,new TimerHandler());
          movingTimer.start();
          
         getLayeredPane().add(foreground);
         // panel.setBounds(50, 50, 500, 325);
         // getContentPane().add(panel);
          panel.setBounds(0, 0, back.getIconWidth(), back.getIconHeight());
          getLayeredPane().add(panel, new Integer(Integer.MAX_VALUE));
           
          panel.setOpaque(false);
          setContentPane(panel);
          panel.setLayout(null);
          pack();
     }
 
     public static void main(String [] args)
     {
          BackgroundLayered frame = new BackgroundLayered();
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(500, 325);
          frame.setVisible(true);
     }
     
     private class TimerHandler implements ActionListener
     {
          public void actionPerformed(ActionEvent actionEvent)
          {
               move();
          }
     }
     
     public void move()
     {
          foreground.setBounds(startY, startX, 20, 20);
          startX = startX+1;
     }
     
}