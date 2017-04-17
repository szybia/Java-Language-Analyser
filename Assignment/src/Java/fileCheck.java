package Java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class fileCheck extends JFrame implements ActionListener
{
	private JLabel mylab;
	private JLabel badWordsLabel;
	private JLabel slangWordsLabel;
	private JLabel fancyWordsLabel;
	private JLabel numOfWordsLabel;
	private JLabel avgWordLenghtLabel;
	
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
   
	private JFileChooser fileChooser;	
	
	private analyseFile fileAnalyser;
	
	private ImageIcon img;													//Open Icon 
	
	public fileCheck(String title, ImageIcon img, File location)
	{
		super(title);														//Set title of window
	    setSize(850, 500);													//Set size of window
	    setLayout(new FlowLayout());										//Select Layout
	    setIconImage(img.getImage());										//Set the icon of the window
	    this.setLocationRelativeTo(null);									//Center the window when it appears
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);						//Terminates program when closed
	    this.img = img;
			
	    fileAnalyser = new analyseFile(location);
	    this.initMenu();
	    this.initLabels();
	    fileAnalyser.dispose();
	    setVisible(true);
	    
	}
	
	public void actionPerformed (ActionEvent e)
    {
		if (e.getSource().equals(openFile))
			   {
				   this.initFileChooser();
				   if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
				   {
					    String temp = fileChooser.getSelectedFile().getAbsolutePath();
					    temp = temp.substring(temp.length()- 3);
					    if (temp.equals("txt"))
					    {
					    	new analyseFile(fileChooser.getSelectedFile()).decide();
					    	this.dispose();
					    	new fileCheck(this.getTitle(), img, fileChooser.getSelectedFile());
					    }
					    else
					    {
					    	JOptionPane.showMessageDialog(null,
					    		    "Invalid file extension.\nPlease select a .txt file",
					    		    "File Error",
					    		    JOptionPane.ERROR_MESSAGE);
					    }
				   }
			   }
			   else if (e.getSource().equals(openSentence))
			   {
				   this.dispose();
				   new SentenceScreen(this.getTitle(), img);
			   }
			   else if (e.getSource().equals(editBadWords))
			   {
				   this.dispose();
				   new BadWordsEdit(this.getTitle(), img);
			   }
			   else if (e.getSource().equals(editSlangWords))
			   {
				   this.dispose();
				   new SlangWordsEdit(this.getTitle(), img);
			   }
			   else if (e.getSource().equals(editFancyWords))
			   {
				   this.dispose();
				   new FancyWordsEdit(this.getTitle(), img);
			   }
			   else if (e.getSource().equals(exit))
			   {
				   int input = JOptionPane.showConfirmDialog(null,
						   	"Are you sure you want to quit the program?"
						   	+ "\nAll Progress will be lost.", "Exit",
				   			JOptionPane.YES_OPTION);
				   if (input == 0)
				   {
					   this.dispose();
				   }
			   }
		
    }
	
	public void initLabels()
	{
		mylab = new JLabel("File Statistics", SwingConstants.CENTER);
		mylab.setPreferredSize(new Dimension(850, 100));				//Set size
	    mylab.setFont(new Font("Helvetica", Font.BOLD, 14));			//Set Font, weight and size
	    
	    
	    avgWordLenghtLabel = new JLabel("The average lenght of a word:         "
	    								+ fileAnalyser.getAvgWordLenght());
	    avgWordLenghtLabel.setPreferredSize(new Dimension(750, 35));
	    avgWordLenghtLabel.setFont(new Font("Helvetica", Font.PLAIN, 16));
	    
	    numOfWordsLabel = new JLabel("The number of words in the file:      "
	    								+ fileAnalyser.getNumOfWords());
	    numOfWordsLabel.setPreferredSize(new Dimension(750, 35));
	    numOfWordsLabel.setFont(new Font("Helvetica", Font.PLAIN, 16));
	    
	    
	    
	    slangWordsLabel = new JLabel("Slang words:                    "
				+ fileAnalyser.getNumSlangWords());
	    slangWordsLabel.setPreferredSize(new Dimension(750, 35));
	    slangWordsLabel.setFont(new Font("Helvetica", Font.PLAIN, 16));
	    
	    badWordsLabel = new JLabel("Bad words:                       "
				+ fileAnalyser.getNumBadWords());
	    badWordsLabel.setPreferredSize(new Dimension(750, 35));
	    badWordsLabel.setFont(new Font("Helvetica", Font.PLAIN, 16));
	    
	    fancyWordsLabel = new JLabel("Sophisticated words:      "
				+ fileAnalyser.getNumFancyWords());
	    fancyWordsLabel.setPreferredSize(new Dimension(750, 35));
	    fancyWordsLabel.setFont(new Font("Helvetica", Font.PLAIN, 16));
	    
	    
	    this.add(mylab);
	    this.add(avgWordLenghtLabel);
	    this.add(numOfWordsLabel);
	    this.add(badWordsLabel);
	    this.add(slangWordsLabel);
	    this.add(fancyWordsLabel);
	}
	
	public void initMenu()
	   {
		   menubar = new JMenuBar();											//Creating the menu
		   
		   UIManager.put("Button.background", new Color(108, 122, 137));
		   UIManager.put("Button.foreground", new Color(255, 255, 255));
		   UIManager.put("Button.focuspainted", Boolean.FALSE);
		   
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
