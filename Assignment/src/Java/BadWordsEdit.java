package Java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BadWordsEdit extends JFrame implements ActionListener
{
	private JLabel mylab;
	
	private JTextArea wordArea;
	private FileReader fileRead;
	private JScrollPane TextAreaScroll;
	
	private JMenuBar menubar;												//Creating the menu
	   
	private JMenu choice_file;												//Main menu choice
	private JMenu choice_edit;												//Main menu choice 2
	private JMenu editDictionary;											//Sub main menu choices
	
	private JMenu choice_exit;
	private JMenuItem exit;
	
	private JMenuItem editSlangWords;
	private JMenuItem editBadWords;
    private JMenuItem openFile;												//Sub main menu choices
	private JMenuItem openSentence;
	private JMenuItem editFancyWords;
	
	private JFileChooser fileChooser;										//FileChooser to open files
    
	private JButton addWord;
	private JButton removeWord;
	private JButton resetList;
    
	private JLabel emptyLabel;
	private JLabel emptyLabel2;
	private JLabel emptyLabel3;
	
	private ImageIcon img;
	
	public BadWordsEdit(String title, ImageIcon img)
	{
		super(title);
		setSize(850, 500);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(img.getImage());

		this.initLabels();
		this.initFileReader();
		this.initTextField();
		this.initMenu();
		this.initButtons();
		
		this.img = img;
		
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
		else if (e.getSource().equals(openSentence))
		   {
			   this.dispose();
			   new SentenceScreen(this.getTitle(), img);
		   }
	}
	
	public void initLabels()
	{
		mylab = new JLabel("Curse Word Dictionary", SwingConstants.CENTER);
		emptyLabel = new JLabel("", SwingConstants.CENTER);
		emptyLabel2 = new JLabel("", SwingConstants.CENTER);
		emptyLabel3 = new JLabel("", SwingConstants.CENTER);
		
		mylab.setPreferredSize(new Dimension(850, 100));				//Set size
	    mylab.setFont(new Font("Helvetica", Font.BOLD, 14));			//Set Font, weight and size
	    
	    emptyLabel.setPreferredSize(new Dimension(50, 10));
	    emptyLabel2.setPreferredSize(new Dimension(10, 1));
	    emptyLabel3.setPreferredSize(new Dimension(10, 1));
	    
	    this.add(mylab);
	}
	
	public void initFileReader()
	{
		try
		{
			fileRead = new FileReader("resources\\badWords.txt");
		}
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,
	    		    "Missing file/files.\nPlease restore the Resources folder",
	    		    "File Error",
	    		    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void initTextField()
	{
		
		wordArea = new JTextArea(16, 15);
		wordArea.setLineWrap(true);
		wordArea.setWrapStyleWord(true);
		wordArea.setDocument(new SentenceLimit(400));
		wordArea.setEditable(false);
		try
		{
			wordArea.read(fileRead, "Resources\\badWords.txt");
			fileRead.close();
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null,
	    		    "Missing file/files.\nPlease restore the Resources folder",
	    		    "File Error",
	    		    JOptionPane.ERROR_MESSAGE);
		}
		TextAreaScroll = new JScrollPane(wordArea);
		
		this.add(TextAreaScroll);
	}
	
	public void initMenu()
	   {
		   menubar = new JMenuBar();									//Creating the menu
		   
		   UIManager.put("Button.background", new Color(108, 122, 137));
		   UIManager.put("Button.foreground", new Color(255, 255, 255));
		   
		   choice_file = new JMenu("File");								//Instantiating Main Menu Choice
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
		   this.setJMenuBar(menubar);									//Creating the menu
		   
		   openFile.addActionListener(this);
		   openSentence.addActionListener(this);
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
	
    public void initButtons()
    {
		addWord = new JButton("Add Word");
		addWord.setPreferredSize(new Dimension(150, 50));
		addWord.addActionListener(this);
        addWord.setBackground(new Color(108, 122, 137));				//Set box colour
        addWord.setForeground(new Color(255, 255, 255));		
		addWord.setFocusPainted(false);
		
		removeWord = new JButton("Remove Word");
		removeWord.setPreferredSize(new Dimension(150, 50));
		removeWord.addActionListener(this);
        removeWord.setBackground(new Color(108, 122, 137));				//Set box colour
        removeWord.setForeground(new Color(255, 255, 255));		
		removeWord.setFocusPainted(false);
		
		resetList = new JButton("Restore Default List");
		resetList.setPreferredSize(new Dimension(150, 50));
		resetList.addActionListener(this);
        resetList.setBackground(new Color(108, 122, 137));				//Set box colour
        resetList.setForeground(new Color(255, 255, 255));		
		resetList.setFocusPainted(false);
		
		this.add(emptyLabel);
		this.add(addWord);
		this.add(emptyLabel2);
		this.add(removeWord);
		this.add(emptyLabel3);
		this.add(resetList);
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