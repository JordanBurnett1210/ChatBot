package chat.view;

import javax.swing.JOptionPane;

public class ChatView
{
	public String chatInput(String popupText)
	{
		String returnedText = JOptionPane.showInputDialog(null, popupText);
		return returnedText;
	}

}
