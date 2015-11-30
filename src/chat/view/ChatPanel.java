package chat.view;

import javax.swing.*;
import java.awt.*;
import chat.controller.ChatbotController;

public class ChatPanel extends JPanel
{
	private ChatbotController baseController;
	private JTextArea chatArea;
	private JTextField typingField;
	private SpringLayout baseLayout;
	private JButton submitButton;
	private JLabel promptLabel;
	
	public ChatPanel(ChatbotController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(10,30);
		typingField = new JTextField(30);
		submitButton = new JButton("Submit");
		promptLabel = new JLabel("Chat with me");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.BLUE);
		this.add(chatArea);
		this.add(typingField);
		this.add(submitButton);
		this.add(promptLabel);
		typingField.setToolTipText("Type here for the chatbot");
		chatArea.setEnabled(false);
	}
	
	public ChatbotController getBaseController()
	{
		return baseController;
	}

	public void setBaseController(ChatbotController baseController)
	{
		this.baseController = baseController;
	}

	public JTextArea getChatArea()
	{
		return chatArea;
	}

	public void setChatArea(JTextArea chatArea)
	{
		this.chatArea = chatArea;
	}

	public JTextField getTextField()
	{
		return typingField;
	}

	public void setTypingField(JTextField typingField)
	{
		this.typingField = typingField;
	}

	public SpringLayout getBaseLayout()
	{
		return baseLayout;
	}

	public void setBaseLayout(SpringLayout baseLayout)
	{
		this.baseLayout = baseLayout;
	}

	public JButton getSubmitButton()
	{
		return submitButton;
	}

	public void setSubmitButton(JButton submitButton)
	{
		this.submitButton = submitButton;
	}

	public JLabel getPromptLabel()
	{
		return promptLabel;
	}

	public void setPromptLabel(JLabel promptLabel)
	{
		this.promptLabel = promptLabel;
	}

	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}

}
