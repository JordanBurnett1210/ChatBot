package chat.model;

import twitter4j.*;
import java.util.ArrayList;

/**
 * @version 0.2
 * @author jbur0473
 * Class for all twitter related aspects of chatbot.
 */

public class CTECTwitter
{
	//declaration
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	
	public CTECTwitter()
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
	}
}
