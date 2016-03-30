package chat.controller;

import twitter4j.TwitterException;
import chat.view.ChatView;
import chat.model.Chatbot;
import chat.model.CTECTwitter;
import chat.view.ChatFrame;

/**
 * Application controller for the Chatbot project.
 * @author jbur0473
 * @version 1.6 10/21/15 Now full GUI!
 */


public class ChatbotController
{
	private CTECTwitter chatTwitter;
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
		chatTwitter = new CTECTwitter(this);
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
	
	public void sendTweet(String tweetText)
	{
		chatTwitter.sendTweet(tweetText);
	}
	
	public void handleErrors(String errorMessage)
	{
		myDisplay.displayText(errorMessage);
	}
	
	public String analyze(String userName)
	{
		String userAnalysis = "The Twitter user " + userName + " has many tweets. ";
		try
		{
			chatTwitter.loadTweets(userName);
		}
		catch (TwitterException error)
		{
			handleErrors(error.getErrorMessage());
		}
		userAnalysis += chatTwitter.topResult();
		
		return userAnalysis;
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
