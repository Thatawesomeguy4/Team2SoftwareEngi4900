package userDataInteraction;

import java.io.Serializable;

/**
 * @author Derek Pendleton
 * @version 11-05-18
 * 
 * This is a class to hold the settings for the main menu
 *
 */
public class MenuCustomizationSettings implements Serializable
{
	public static boolean selectProfile; //bool to decide to/not to display select profile button.
	public static boolean createProfile; //bool to decide to/not to display create profile button.
	public static boolean stats; //bool to decide to/not to display stats button.
}
