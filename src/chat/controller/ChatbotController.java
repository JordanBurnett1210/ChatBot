package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;

/**
 * Application controller for the Chatbot project.
 * @author jbur0473
 * @version 1.1 10/21/15 added a referance to display and got an error :(
 */


public class ChatbotController
{

	private Chatbot myBot;
	private ChatView myDisplay;
	
	public ChatbotController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.chatInput("What is your name?");
		myBot = new Chatbot(userName);
	}
	
	public void start()
	{
		myDisplay.chatInput("Hello " + myBot.getUserName());
	}
	
}
