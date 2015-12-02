package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;
import chat.view.ChatFrame;

/**
 * Application controller for the Chatbot project.
 * @author jbur0473
 * @version 1.1 10/21/15 added a reference to display and got an error :(
 */


public class ChatbotController
{

	private Chatbot myBot;
	private ChatView myDisplay;
	private ChatFrame baseFrame;
	
	public ChatbotController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.chatInput("What is your name?");
		myBot = new Chatbot(userName);
		baseFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		myDisplay.chatInput("Hello " + myBot.getUserName());
		chat();
	}
	
	private void chat()
	{
		String conversation = myDisplay.chatInput("What would you like to talk about today?");
		//while(myBot.lengthChecker(conversation))
		//{
		//	conversation = myDisplay.chatInput(myBot.processConversation(conversation));
		//}
	}
	
	public String userToChatbot(String conversation)
	{
		String response = "";
		
		if(myBot.quitChecker(conversation))
		{
			shutDown();
		}
		
		response = myBot.processConversation(conversation);
		
		return response;
	}

	
	private void shutDown()
	{
		myDisplay.displayText("Goodbye, " + myBot.getUserName() + " it has been my pleasure to talk with you");
		System.exit(0);
	}
	
	public ChatView getChatView()
	{
		return myDisplay;
	}
	
	public Chatbot getChatbot()
	{
		return myBot;
	}
	
	public ChatFrame getChatFrame()
	{
		return baseFrame;
	}
	
}
