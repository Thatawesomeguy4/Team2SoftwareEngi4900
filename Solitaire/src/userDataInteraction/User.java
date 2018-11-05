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
	private int gamesWon; // number of games won
	private int gameScore; // users game score
	private int highScore; // records application highest score
	
	//default constructor
	public User(String fName, String lName, int age)
	{
		this.firstName = fName;
		this.lastName = lName;
		this.age = age;
		this.timePlayed = 0;
		this.fastestGame = 0;
		this.gamesPlayed = 0;
		this.gamesWon = 0;
		this.gameScore = 0;
		this.highScore = 0;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public double getTimePlayed()
	{
		return this.timePlayed;
	}
	
	public double getFastestGame()
	{
		return this.fastestGame;
	}
	
	public int getGamesPlayed()
	{
		return this.gamesPlayed;
	}
	
	public int getGamesWon()
	{
		return this.gamesWon;
	}
	
	public int getGameScore()
	{
		return this.gameScore;
	}
	
	public int getHighScore()
	{
		return this.highScore;
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
	
	public void incrementGamesWon()
	{
		this.gamesWon++;
	}
	
	public void increaseScore(int score) {
		this.gameScore += score;
	}
	
	public void setHighScore(int score) {
		highScore = score;
	}
}
