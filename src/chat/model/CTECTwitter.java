package chat.model;

import java.util.ArrayList;
import java.util.List;
import twitter4j.*;
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
	private List<Status> statuses;
	private List<String> tweetTexts;
	
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
	
	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while (page<=10)
		{
			statusPage.setPage(page);
			statuses.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		for(Status currentStatus : statuses)
		{
			String[] tweetText = currentStatus.getText().split(" ");
			for(String word : tweetTexts)
			{
				tweetTexts.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(tweetTexts);
		removeEmptyText();
	}
	
	private void removeEmptyText()
	{
		//loops over all the spots in a string and removes all of the spaces!!
		for(int spot = 0; spot < tweetTexts.size(); spot++)
		{
			if(tweetTexts.get(spot).equals(" "))
			{
				tweetTexts.remove(spot);
				spot--;
			}
		}
	}
	
	private String removePunctuation(String word)
	{
		String punctuation = ".,'?!:;\"(){}^[]<>_-@#$%&*";
		
		String scrubbedString = "";
		for(int i = 0; i < word.length(); i++)
		{
			if(punctuation.indexOf(word.charAt(i)) == -1)
			{
				scrubbedString += word.charAt(i);
			}
		}
		return scrubbedString;
	}
	
	private List removeCommonEnglishWords(List<String> tweets)
	{
		return tweets;
	}
}
