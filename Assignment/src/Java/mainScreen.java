package Java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class mainScreen extends JFrame implements ActionListener
{
	private JLabel mylab;													//Top Text Jlabel
	private JLabel label1;                                                   //Left Empty JLabel
	private JLabel label2;													//Right Empty JLabel
	private JLabel label3;													//Bottom Empty JLabel
   
	private JButton button;													//Main central button
	   
	private JFileChooser fileChooser;										//FileChooser to open files
	
	private JMenuBar menubar;												//Creating the menu
	   
	private JMenu choice_file;												//Main menu choice
	private JMenuItem openFile;												//Sub main menu choices
	private JMenuItem openSentence;
	
	private JMenu choice_exit;
	private JMenuItem exit;
   
	private JMenu choice_edit;												//Main menu choice 2
	private JMenu editDictionary;											//Sub main menu menu
	private JMenuItem editSlangWords;										//Sub menu choices
	private JMenuItem editBadWords;
	private JMenuItem editFancyWords;
	
   ImageIcon img = new ImageIcon("icon.png");						//Open Icon 

   
   public mainScreen(String title)
   {	
	   super(title);
	   setSize(850, 500);
	   setLayout(new BorderLayout());
	   setIconImage(img.getImage());
	   this.setLocationRelativeTo(null);
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   this.initLabels();
	   this.initButton();
	   this.initMenu();
	   
	   setVisible(true);
   }
   
   public void actionPerformed (ActionEvent e)
   {
	   if (e.getSource().equals(button))
		   {
			   this.initFileChooser();
			   if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
			   {
				   
			   }
		   }
		   
   }
	   
   public void initLabels()
   {
	   mylab = new JLabel("Welcome to the Language "						//Create welcome message and center it
						   + "Analyser.",
						   SwingConstants.CENTER);
	   label1 = new JLabel();
	   label2 = new JLabel();
	   label3 = new JLabel();
	   
	   mylab.setPreferredSize(new Dimension(650, 160));						//Set size
	   mylab.setFont(new Font("Helvetica", Font.BOLD, 14));					//Set Font, weight and size
	   this.add(mylab, BorderLayout.PAGE_START);							//Add to window
	   												
	   label1.setPreferredSize(new Dimension(300, 150));					//Set boundaries of the center by
	   this.add(label1, BorderLayout.LINE_START);							//using	empty JLabel's
	   
	   label2.setPreferredSize(new Dimension(300, 100));
	   this.add(label2, BorderLayout.LINE_END);
	   
	   label3.setPreferredSize(new Dimension(1, 175));
	   this.add(label3, BorderLayout.PAGE_END);
   }
   
   public void initMenu()
   {
	   menubar = new JMenuBar();											//Creating the menu
	   
	   choice_file = new JMenu("File");										//Instantiating Main Menu Choice
	   choice_file.setPreferredSize(new Dimension(60, 35));
	   choice_file.setFont(new Font("Helvetica", Font.PLAIN, 18));
	   
	   openFile = new JMenuItem("Open File");
	   openFile.setPreferredSize(new Dimension(100, 35));
	   openFile.setFont(new Font("Helvetica", Font.PLAIN, 14));
	   
	   openSentence = new JMenuItem("Enter sentence");
	   openSentence.setPreferredSize(new Dimension(130, 35));
	   openSentence.setFont(new Font("Helvetica", Font.PLAIN, 14));
	   
	   choice_edit = new JMenu("Edit");
	   choice_edit.setPreferredSize(new Dimension(60, 35));
	   choice_edit.setFont(new Font("Helvetica", Font.PLAIN, 18));
	   
	   editDictionary = new JMenu("Edit Dictionary");
	   editDictionary.setPreferredSize(new Dimension(130, 35));
	   editDictionary.setFont(new Font("Helvetica", Font.PLAIN, 14));
	   
	   editSlangWords = new JMenuItem("Slang words");
	   editSlangWords.setPreferredSize(new Dimension(130, 35));
	   editSlangWords.setFont(new Font("Helvetica", Font.PLAIN, 14));
	   
	   editBadWords = new JMenuItem("Bad words");
	   editBadWords.setPreferredSize(new Dimension(130, 35));
	   editBadWords.setFont(new Font("Helvetica", Font.PLAIN, 14));
	   
	   editFancyWords = new JMenuItem("Sophisticated words");
	   editFancyWords.setPreferredSize(new Dimension(150, 35));
	   editFancyWords.setFont(new Font("Helvetica", Font.PLAIN, 14));
	   
	   choice_exit = new JMenu("Exit");										//Instantiating Main Menu Choice
	   choice_exit.setPreferredSize(new Dimension(60, 35));
	   choice_exit.setFont(new Font("Helvetica", Font.PLAIN, 18));
	   
	   exit = new JMenuItem("Exit Program");
	   exit.setPreferredSize(new Dimension(100, 35));
	   exit.setFont(new Font("Helvetica", Font.PLAIN, 14));
	   
	   menubar.add(choice_file);
	   menubar.add(choice_edit);
	   menubar.add(choice_exit);
	   this.setJMenuBar(menubar);											//Creating the menu
	   
	   openFile.addActionListener(this);
	   openSentence.addActionListener(this);
	   editBadWords.addActionListener(this);
	   editSlangWords.addActionListener(this);
	   editFancyWords.addActionListener(this);
	   exit.addActionListener(this);
	   choice_file.add(openFile);
	   choice_file.add(openSentence);
	   choice_edit.add(editDictionary);
	   editDictionary.add(editBadWords);
	   editDictionary.add(editSlangWords);
	   editDictionary.add(editFancyWords);
	   choice_exit.add(exit);
   }
   
   public void initButton()
   {
	   button = new JButton("Choose a file.");	
	   
	   button.addActionListener(this);										//Create action listener for button
       this.add(button, BorderLayout.CENTER);								//Add to center box in BorderLayout
       button.setBackground(new Color(108, 122, 137));						//Set box colour
       button.setForeground(new Color(255, 255, 255));						//Set text colour
       button.setFocusPainted(false);
   }
   
   public void initFileChooser()
   {
	   String[] arr = {"txt"};
	   fileChooser = new JFileChooser();
	   fileChooser.setDialogTitle("Open File");
	   fileChooser.setCurrentDirectory(new java.io.File(
			   									"C:\\Users\\" 
			   									+ System.getProperty("user.name")
			   									+ "\\Desktop"));
	   fileChooser.setFileFilter(new FileNameExtensionFilter("Text files", arr));
   }
   
}
