import java.io.Serializable;

/**
 * @author Derek Pendleton
 * @version 10-3-2018
 * 
 * 	This class describes the users of the solitaire system. This will house everything
 * 	From user information to their game statistics.
 *
 */
public class User implements Serializable
{
	String firstName; //user first name
	String lastName; //user last name
	int age; //user age
	double timePlayed; //total time the user has spent playing the game
	double fastestGame; //the least amount of time it took the user to win a game
	
}
