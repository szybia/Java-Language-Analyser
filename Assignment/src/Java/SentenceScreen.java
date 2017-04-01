package Java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SentenceScreen extends JFrame implements ActionListener
{
	private JLabel topLabel;
	private JLabel emptyLabel;
	private JLabel emptyLabel2;
	private JLabel emptyLabel3;

	private JTextArea mainfield;
	private JButton submitbutton;
	
	private JMenuBar menubar;																	//Creating the menu
   
	private JMenu choice_exit;
	private JMenuItem exit;
	
	private JMenu choice_file;																	//Main menu choice
	private JMenuItem openFile;																	//Sub main menu choices
	private JMenuItem openSentence;
   
	private JMenu choice_edit;																	//Main menu choice 2
	private JMenu editDictionary;																//Sub main menu choices
	private JMenuItem editSlangWords;
	private JMenuItem editBadWords;
	private JMenuItem editFancyWords;
    
	private JFileChooser fileChooser;															//FileChooser to open files
	
	private ImageIcon img;																		//Open Icon 
	
	public SentenceScreen(String title, ImageIcon img)
	{
		super(title);
		setSize(850, 500);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.img = img;	
		setIconImage(img.getImage());
		this.initLabel();
		this.initTextField();
		this.initButton();
		this.initMenu();
		setVisible(true);
		
	}
	
	public void actionPerformed (ActionEvent e)
	{
		if (e.getSource().equals(openFile))
	    {
		   this.initFileChooser();
		   if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
		   {
			    
		   }
	    }
	}
	
	public void initLabel()
	{
		topLabel = new JLabel("Please enter your sentence", SwingConstants.CENTER);
		topLabel.setPreferredSize(new Dimension(850, 100));
		topLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
		
		emptyLabel = new JLabel("", SwingConstants.CENTER);
		emptyLabel.setPreferredSize(new Dimension(275, 100));
		
		emptyLabel2 = new JLabel("", SwingConstants.CENTER);
		emptyLabel2.setPreferredSize(new Dimension(275, 100));
		
		emptyLabel3 = new JLabel("", SwingConstants.CENTER);
		emptyLabel3.setPreferredSize(new Dimension(850, 20));
		
		this.add(topLabel);
		
	}
	
	public void initTextField()
	{
		mainfield = new JTextArea(5, 20);
		mainfield.setLineWrap(true);
		mainfield.setWrapStyleWord(true);
		mainfield.setDocument(new SentenceLimit(260));
		
		this.add(emptyLabel);
		this.add(mainfield);
	}
	
	public void initButton()
	{
		submitbutton = new JButton("Submit");
		submitbutton.setPreferredSize(new Dimension(200, 50));
		submitbutton.addActionListener(this);
        submitbutton.setBackground(new Color(108, 122, 137));									//Set box colour
        submitbutton.setForeground(new Color(255, 255, 255));		
		submitbutton.setFocusPainted(false);
		
		this.add(emptyLabel2);
		this.add(emptyLabel3);
		this.add(submitbutton);
	}
	
	public void initMenu()
	   {
		   menubar = new JMenuBar();															//Creating the menu
		   
		   UIManager.put("Button.background", new Color(108, 122, 137));
		   UIManager.put("Button.foreground", new Color(255, 255, 255));
		   
		   choice_file = new JMenu("File");														//Instantiating Main Menu Choice
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
		   
		   choice_exit = new JMenu("Exit");														//Instantiating Main Menu Choice
		   choice_exit.setPreferredSize(new Dimension(60, 35));
		   choice_exit.setFont(new Font("Helvetica", Font.PLAIN, 18));
		   
		   exit = new JMenuItem("Exit Program");
		   exit.setPreferredSize(new Dimension(100, 35));
		   exit.setFont(new Font("Helvetica", Font.PLAIN, 14));
		   
		   menubar.add(choice_file);
		   menubar.add(choice_edit);	
		   menubar.add(choice_exit);
		   this.setJMenuBar(menubar);															//Creating the menu
		   
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
