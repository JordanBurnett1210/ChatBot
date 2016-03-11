package chat.model;

import twitter4j.*;
import java.util.ArrayList;
import chat.controller.ChatbotController;

/**
 * @version 0.5 March 7, 2016 - Changed the sendTweet method to handle errors.
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
			chatbotTwitter.updateStatus("Jordan just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen");
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}
	
}
