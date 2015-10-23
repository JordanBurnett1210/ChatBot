package chat.controller;

/**
 * Starts the Chatbot program.
 * @author jbur0473
 * @version 1.0 10/21/15
 */

public class ChatbotRunner
{
	
	public static void main(String [] args)
	{
		ChatbotController botController = new ChatbotController();
		botController.start();
	}

}
