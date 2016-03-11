package chat.view;

import chat.controller.*;
import chat.view.*;
import java.awt.*;
import javax.swing.*;

/**
 * Generates all information for the frame of the window.
 * @author jbur0473
 * @version 1.3 Resized the window. Again.
 */
public class ChatFrame extends JFrame
{
	private ChatbotController baseController;
	private ChatPanel basePanel;
	
	/**
	 * Declares the baseController, calls the setupFrame method.
	 * @param baseController
	 */
	public ChatFrame(ChatbotController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		setupFrame();
	}
	
	/**
	 * Sets the content, size, title, resizablility, and visibility of the frame.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(1000, 1000);
		this.setTitle("ChatBot");
		this.setResizable(true);
		this.setVisible(true);
	}
	
	public ChatbotController getBaseController()
	{
		return baseController;
	}

}
