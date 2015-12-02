package chat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

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
		promptLabel = new JLabel("Chat me up like one of your french bots.");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(chatArea);
		this.add(typingField);
		this.add(submitButton);
		this.add(promptLabel);
		typingField.setToolTipText("Type here for the chatbot");
		chatArea.setEnabled(false);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, typingField, -2, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 6, SpringLayout.EAST, typingField);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, promptLabel, 171, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, promptLabel, -33, SpringLayout.NORTH, typingField);
		
	}
	
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = typingField.getText();					//Grab user typed answer
				chatArea.append("\nUser: " + userText);						//display typed answer
				typingField.setText("");									//send the text to chatbot
				String response = baseController.userToChatbot(userText);	//chatbot will process
				chatArea.append("\nChatbot: " + response);					//display the response
			}
			
		});
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

}
