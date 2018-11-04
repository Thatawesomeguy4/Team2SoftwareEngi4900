package userDataInteraction;
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
	private String firstName; //user first name
	private String lastName; //user last name
	private int age; //user age
	private double timePlayed; //total time the user has spent playing the game
	private double fastestGame; //the least amount of time it took the user to win a game
	private int gamesPlayed; //number of new games started
	
	//default constructor
	public User(String fName, String lName, int age)
	{
		this.firstName = fName;
		this.lastName = lName;
		this.age = age;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	//method to increment the number of games played
	public void incrementGamesPlayed()
	{
		this.gamesPlayed ++;
	}
	
	public void setFastestGame(double time)
	{
		this.fastestGame = time;
	}
	
	public void updateTimePlayed(double time)
	{
		this.timePlayed += time;
	}
}
