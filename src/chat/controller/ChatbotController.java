package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;
import chat.view.ChatFrame;

/**
 * Application controller for the Chatbot project.
 * @author jbur0473
 * @version 1.5 10/21/15 Now full GUI!
 */


public class ChatbotController
{

	private Chatbot myBot;
	private ChatView myDisplay;
	private ChatFrame baseFrame;
	
	/**
	 * Creates values for variables used in this class.
	 */
	public ChatbotController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.chatInput("What is your name?");
		myBot = new Chatbot(userName);
		baseFrame = new ChatFrame(this);
	}
	
	/**
	 * Greets the user, initializes the chat method.
	 */
	public void start()
	{
		myDisplay.chatInput("Hello " + myBot.getUserName());
		chat();
	}
	
	/**
	 * Initializes the first question, and starts the chatting process.
	 */
	private void chat()
	{
		String conversation = myDisplay.chatInput("What would you like to talk about today?");
		//while(myBot.lengthChecker(conversation))
		//{
		//	conversation = myDisplay.chatInput(myBot.processConversation(conversation));
		//}
	}
	
	/**
	 * Allows for the chatbot to process conversation, and runs quitchecker.
	 * @param conversation
	 * @return
	 */
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

	/**
	 * Creates a shutdown method.
	 */
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
