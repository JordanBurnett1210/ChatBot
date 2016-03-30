package chat.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		String punctuation = ".,'?!:;\"(){}^[]<>_-$%&*";
		
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
	
	public String topResult()
	{
		String tweetResults = "";
		
		int topWordLocation = 0;
		int topCount = 0;
		
		for(int index = 0; index < wordList.size(); index++)
		{
			int wordUseCount = 1;
			
			for(int spot = index+1;spot < wordList.size(); spot++)
			{
				if(wordList.get(index).equals(wordList.get(spot)))
				{
					wordUseCount++;
				}
				if(wordUseCount > topCount)
				{
					topCount = wordUseCount;
					topWordLocation = index;
				}
			}
		}
		
		tweetResults = "The top word in the tweets was " + wordList.get(topWordLocation) + " and it was used "+ topCount + " times.";
		
		return tweetResults;
	}
	
	private String[] importWordsToArray()
	{
		String[] boringWords;
		int wordCount = 0;
		Scanner wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
		while(wordFile.hasNext())
		{
		wordCount++;
		wordFile.next();
		}
		wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
		boringWords = new String[wordCount];
		int boringWordsCount = 0;
		while(wordFile.hasNext())
		{
			boringWords[boringWordsCount] = wordFile.next();
			boringWordsCount++;
		}
		wordFile.close();

		return boringWords;
	}
	
	private List removeCommonEnglishWords(List<String> tweets)
	{
		String[] boringWords = importWordsToArray();
		
		for(int count = 0; count < tweetTexts.size(); count++)
		{
			for(int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if(tweetTexts.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					tweetTexts.remove(count);
					count--;
					removeSpot = boringWords.length;
				}
			}
		}
		
		return tweets;
	}


	public String investigation()
	{
		String results = "";
		
		Query query = new Query("dinosaur");
		query.setCount(100);
		query.setGeoCode(new GeoLocation(40.587521, -111.960178), 5, Query.KILOMETERS);
		query.setSince("2016-1-1");
		try
		{
			QueryResult result = chatbotTwitter.search(query);
			results += "Count : " + result.getTweets().size() + "\n";
			for(Status tweet : result.getTweets())
			{
				results.concat("@" + tweet.getUser().getName() + ": " + tweet.getText() + "\n");
			}
		}
		catch(TwitterException error)
		{
			error.printStackTrace();
		}
		
		return results;
	}
	
	
	
}
