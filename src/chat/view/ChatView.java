package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class ChatView
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windowMessage = "Hello from your friendly chatbot:D";
		chatIcon = new ImageIcon(getClass().getResource("images/Ichigo_Hollow_Mask_Close_Up.png"));
		
	}
	
	public String chatInput(String popupText)
	{
		String returnedText = "";
		
		returnedText = JOptionPane.showInputDialog(null, popupText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon, null, "Answer here :)").toString();
		
		return returnedText;
	}
	
	public void displayText(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon);
	}

}
