package chat.view;

import chat.controller.*;
import chat.view.*;
import java.awt.*;
import javax.swing.*;

public class ChatFrame extends JFrame
{
	private ChatbotController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame(ChatbotController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(450, 450);
		this.setTitle("ChatBot");
		this.setResizable(true);
		this.setVisible(true);
	}
	
	public ChatbotController getBaseController()
	{
		return baseController;
	}

}
