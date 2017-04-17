
package Java;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class analyseSentence extends JFrame
{
	private String sentence;
	
	private int numBadWords = 0;
	private int numSlangWords = 0;
	private int numFancyWords = 0;
	
	private File badWordFile;
	private Scanner badWordScanner;
	private File slangWordFile;
	private Scanner slangWordScanner;
	private File fancyWordFile;
	private Scanner fancyWordScanner;
	
	private int numOfWords;
	private int avgWordLenght;
	
	public analyseSentence(String sentence)
	{
		this.sentence = sentence.toLowerCase();
		
		this.initFileReaders();
		this.analyse();
		this.decide();
	}
	
	
	public void analyse()
	{
		while(badWordScanner.hasNextLine())
		{
			if (this.sentence
					.contains(badWordScanner.nextLine()
					.toLowerCase().replaceAll("\\s+","")))
			{
				this.numBadWords++;
			}
		}
		while(slangWordScanner.hasNextLine())
		{
			if (this.sentence
					.contains(slangWordScanner.nextLine()
					.toLowerCase().replaceAll("\\s+","")))
			{
				this.numSlangWords++;
			}
		}
		while(fancyWordScanner.hasNextLine())
		{
			if(this.sentence
					.contains(fancyWordScanner.nextLine()
					.toLowerCase().replaceAll("\\s+","")))
			{
				this.numFancyWords++;
			}
		}
		this.numOfWords = this.sentence.split("\\s+").length;
		this.avgWordLenght = this.sentence.replaceAll("\\s+","").length() / numOfWords;
	}
	
	public void initFileReaders()
	{
		try
		{
			badWordFile = new File("resources\\badWords.txt");
			badWordScanner = new Scanner(badWordFile);
			
			slangWordFile = new File("resources\\slangWords.txt");
			slangWordScanner = new Scanner(slangWordFile);
			
			fancyWordFile = new File("resources\\fancyWords.txt");
			fancyWordScanner = new Scanner(fancyWordFile);
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,
	    		    "Missing file/files.\nPlease restore the Resources folder",
	    		    "File Error",
	    		    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void decide()
	{
		if (this.numBadWords > 0)
		{
			JOptionPane.showMessageDialog(null, 
										  "This sentence contains vulgar words and is not formal language."
										  ,"Sentence Analyser", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(this.numFancyWords > 0)
		{
			JOptionPane.showMessageDialog(null, 
					  "This sentence contains sophisticated words and is most likely formal."
					  ,"Sentence Analyser", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(numSlangWords);
		}
		else if(this.numSlangWords > 2)
		{
			JOptionPane.showMessageDialog(null, 
					  					  "This sentence contains slang words and is not formal language."
					  					 ,"Sentence Analyser", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(numSlangWords);
		}
		else if (avgWordLenght < 4)
		{
			JOptionPane.showMessageDialog(null, 
					  "This sentences average word lenght is short. This is most likely an informal sentence."
					 ,"Sentence Analyser", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, 
					  "This sentence is most likely formal."
					 ,"Sentence Analyser", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}