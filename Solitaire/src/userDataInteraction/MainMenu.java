package userDataInteraction;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * 
 * @author Derek Pendleton
 * @version 10-15-18
 *
 *	This class will run the main menu from which everything will be controlled.
 */

public class MainMenu 
{
	
	public static User currentUser;

	public static void main(String[] args) 
	{
		
		//Get screen dimensions as a Dimension object
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//pull screen height and width from screenSize
		//double screenHeight = screenSize.getHeight();
		//double screenWidth = screenSize.getWidth();
		
		MainWindow primaryWindow = new MainWindow();
		
		primaryWindow.buildWindow();
		
	}

}
