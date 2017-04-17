package Java;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class SentenceLimit extends PlainDocument
{
	private int char_limit;
	
	public SentenceLimit(int char_limit)
	{
		super();
		this.char_limit = char_limit;
	}
	
	public void insertString(int offset, String str, AttributeSet attr)
	{
		if(str.equals(null))
		{
			return;
		}
		else if ( ( getLength() + str.length()) <= char_limit)
		{
			try
			{
				str = str.replaceAll("\\t", "").replaceAll("\\n", "");
				super.insertString(offset, str, attr);
			}
			catch (BadLocationException e)
			{
				System.out.println("Invalid JTextArea.");;
			}
		}
	}
}
