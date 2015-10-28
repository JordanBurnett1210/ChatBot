package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;

/**
 * Application controller for the Chatbot project.
 * @author jbur0473
 * @version 1.1 10/21/15 added a reference to display and got an error :(
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
		chat();
	}
	
	private void chat()
	{
		String conversation = myDisplay.chatInput("What would you like to talk about today?");
		while(myBot.lengthChecker(conversation))
		{
//			if(!myBot.quitChecker(conversation))
//			{
//				conversation = myBot.processInput(conversation);
//			}
//			else
//			{
//				shutDown();
//			}
			
			if(myBot.contentChecker(conversation))
			{
				myDisplay.chatInput("Wow, I had no idea you were interted in " + myBot.getContent());
			}
			
			conversation = myDisplay.chatInput(conversation);
		}
	}
	
	private void shutDown()
	{
		
	}
	
}
