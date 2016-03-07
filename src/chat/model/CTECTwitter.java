package chat.model;

import twitter4j.*;
import java.util.ArrayList;
import chat.controller.ChatbotController;

/**
 * @version 0.2.6
 * @author jbur0473
 * Class for all twitter related aspects of chatbot.
 */

public class CTECTwitter
{
	//declaration
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;
	private ChatbotController baseController;
	
	public CTECTwitter(ChatbotController baseController)
	{
		this.baseController = baseController;
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
		chatbotTwitter = TwitterFactory.getSingleton();
	}
	
	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus("");
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}
	
}
