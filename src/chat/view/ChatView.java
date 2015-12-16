package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Now useless with addition of GUI :(
 * @author jbur0473
 * @version 1.3 A now outdated method for displaying Chatbot to user.
 */
public class ChatView
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	/**
	 * Greets user, assigns an icon for the popup.
	 */
	public ChatView()
	{
		windowMessage = "Hello from your friendly chatbot:D";
		chatIcon = new ImageIcon(getClass().getResource("images/Ichigo_Hollow_Mask_Close_Up.png"));
	}
	
	/**
	 * Causes a prompt of "Answer here" to be automatically generated in the response field.
	 * @param popupText
	 * @return
	 */
	public String chatInput(String popupText)
	{
		String returnedText = "";
		
		returnedText = JOptionPane.showInputDialog(null, popupText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon, null, "Answer here :)").toString();
		
		return returnedText;
	}
	
	/**
	 * Creates a window with no response option.
	 * @param displayText
	 */
	public void displayText(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon);
	}

}
