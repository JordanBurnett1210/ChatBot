package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Jordan Burnett
 * @version 1.0 10/21/15
 */

public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicsList;
	private ArrayList<String> notKeyboardMash;
	private String userName;
	private String content;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicsList = new ArrayList<String>();
		this.notKeyboardMash = new ArrayList<String>();
		this.userName = userName;
		this.content = "Motivational Sign!";
		
		buildMemesList();
		buildPoliticalTopicsList();
		buildNotKeyboardMash();
	}
	
	private void buildMemesList()
	{
		this.memesList.add("ALIENS.");
		this.memesList.add("Ninjas an't touch you if...");
		this.memesList.add("doge");
		this.memesList.add("cats");
		this.memesList.add("cute animals");
		this.memesList.add("spoderman");
		this.memesList.add("bad luck brian");
		this.memesList.add("what if I told you...");
		this.memesList.add("unhelpful highschool teacher");
		this.memesList.add("ME GUSTA");
	}
	
	private void buildPoliticalTopicsList()
	{
		this.politicalTopicsList.add("Donald Trump");
		this.politicalTopicsList.add("Hillary Clinton");
		this.politicalTopicsList.add("Elections");
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if(currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
				
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean isPolitical = false;
		
			for(String currentPolitics: politicalTopicsList)
			{
				if(currentInput.toLowerCase().contains(currentPolitics.toLowerCase()))
				{
					isPolitical = true;
				}
			}	
		
		return isPolitical;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean isMeme = false;
		
		for(String currentMeme: memesList)
		{
			if(currentInput.toLowerCase().contains(currentMeme.toLowerCase()))
			{
				isMeme = true;
			}
		}	
		
		return isMeme;
	}
	
	public String processConversation(String currentInput)
	{
		String currentTopic = "Oh, what else do you want to talk about?";
		int randomTopic = (int) (Math.random() * 5); //Generates a random number between 0 and 4.
		
		switch(randomTopic)
		{
			case 0:
				if(memeChecker(currentInput))
				{
					currentTopic = "That is a very popular meme this year. What else are you wanting to talk about?";
				}
				break;
			case 1:
				if(politicalTopicChecker(currentInput))
				{
					currentTopic = "Elections are coming up. Who's your favorite canidate?";
				}
				break;
			case 2:
				if(contentChecker(currentInput))
				{
					currentTopic = "Huh. So you're into that?";
				}
				break;
			case 3:
				if(currentInput.length() > 20)
				{
					currentTopic = "Wow. You're really long winded, aren't you?";
				}
				break;
			case 4:
				currentTopic = "How about that weather?";
				break;
			default:
				currentTopic = "It seems the world has ended. Would like some popcorn to munch as you watch the universe die?";
				break;
		}
		
		
		return currentTopic;
	}
	
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return null;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return null;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		
	}
	
	public boolean quitChecker(String currentInput)
	{
		boolean hasQuit = false;
		
		if(currentInput.equals("quit"))
		{
			hasQuit = true;
		}
		
		return hasQuit;
	}
	
	public void buildNotKeyboardMash()
	{
		this.notKeyboardMash.add("S.D.F.");
		this.notKeyboardMash.add("derf");
	}
	
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean isKeyboardMash = false;
		
		if(currentInput.length() <= 3)
		{
			for(String currentMash : notKeyboardMash)
			{
				if(currentInput.toLowerCase().contains(currentMash.toLowerCase()))
				{
					isKeyboardMash = false;
				}
				else
				{
					isKeyboardMash = true;
				}
			}
			
		}
		
		return isKeyboardMash;
	}

}
