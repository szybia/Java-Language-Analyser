package Java;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class mainScreen extends JFrame implements ActionListener
{
   ImageIcon img = new ImageIcon("icon.png");						//Open Icon 

   
   public mainScreen(String title)
   {	
	   super(title);
	   setSize(850, 500);
	   setLayout(new BorderLayout());
	   setIconImage(img.getImage());
	   this.setLocationRelativeTo(null);
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   setVisible(true);
   }
   
   public void actionPerformed (ActionEvent e)
   {
	   
   }
   
}
