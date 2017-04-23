package Java;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class analyseFile extends JFrame
{
	private int numBadWords = 0;
	private int numSlangWords = 0;
	private int numFancyWords = 0;
	
	private File userFile;
	private Scanner userScanner;
	
	private File badWordFile; 
	private Scanner badWordScanner;
	private File slangWordFile;
	private Scanner slangWordScanner;
	private File fancyWordFile;
	private Scanner fancyWordScanner;
	
	private int numOfWords;
	private int avgWordLenght;
	
	
	public analyseFile(File location)
	{
		this.initFileReaders(location);
		this.analyse();
	}
	

	public void initFileReaders(File location)
	{
		try
		{
			badWordFile = new File("resources\\badWords.txt");
			badWordScanner = new Scanner(badWordFile);
			
			slangWordFile = new File("resources\\slangWords.txt");
			slangWordScanner = new Scanner(slangWordFile);
			
			fancyWordFile = new File("resources\\fancyWords.txt");
			fancyWordScanner = new Scanner(fancyWordFile);
			
			userFile = location;
			userScanner = new Scanner(userFile);
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,
	    		    "Missing file/files.\nPlease restore the Resources folder",
	    		    "File Error",
	    		    JOptionPane.ERROR_MESSAGE);
		}
	}

	public void reinitFileReaders()
	{
		try
		{
			slangWordScanner.close();
			fancyWordScanner.close();
			badWordScanner.close();
			
			badWordScanner = new Scanner(badWordFile);
			slangWordScanner = new Scanner(slangWordFile);
			fancyWordScanner = new Scanner(fancyWordFile);
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,
	    		    "Scanner reinitialising error",
	    		    "Programming Error",
	    		    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void analyse()
	{
		String temp;
		while(userScanner.hasNextLine())
		{
			temp = userScanner.nextLine()
					.toLowerCase();
			
			while(badWordScanner.hasNextLine())
			{
				if (temp
						.contains(badWordScanner.nextLine()
						.toLowerCase().replaceAll("\\s+","")))
				{
					this.numBadWords++;
				}
			}
			while(slangWordScanner.hasNextLine())
			{
				if (temp
						.contains(slangWordScanner.nextLine()
						.toLowerCase().replaceAll("\\s+","")))
				{
					this.numSlangWords++;
				}
			}
			while(fancyWordScanner.hasNextLine())
			{
				if(temp
						.contains(fancyWordScanner.nextLine()
						.toLowerCase().replaceAll("\\s+","")))
				{
					this.numFancyWords++;
				}
			}
			this.numOfWords += temp.split("\\s+").length;
			this.avgWordLenght += temp.replaceAll("\\s+","").length();
			
			this.reinitFileReaders();
		}
		this.avgWordLenght = this.avgWordLenght / this.numOfWords;
	}
	
	public void decide()
	{
		if (this.numBadWords > 0)
		{
			JOptionPane.showMessageDialog(null, 
										  "This file contains vulgar words and is not formal language."
										  ,"File Analyser", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(this.numFancyWords > 0)
		{
			JOptionPane.showMessageDialog(null, 
					  "This sentence contains sophisticated words and is most likely formal."
					  ,"File Analyser", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(this.numSlangWords > 2)
		{
			JOptionPane.showMessageDialog(null, 
					  					  "This sentence contains slang words and is not formal language."
					  					 ,"File Analyser", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (avgWordLenght < 4)
		{
			JOptionPane.showMessageDialog(null, 
					  "This files average word lenght is short. This is most likely an informal sentence."
					 ,"File Analyser", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, 
					  "The files contents is most likely formal."
					 ,"File Analyser", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public int getNumBadWords() {
		return numBadWords;
	}


	public int getNumSlangWords() {
		return numSlangWords;
	}


	public int getNumFancyWords() {
		return numFancyWords;
	}


	public int getNumOfWords() {
		return numOfWords;
	}


	public int getAvgWordLenght() {
		return avgWordLenght;
	}
}
