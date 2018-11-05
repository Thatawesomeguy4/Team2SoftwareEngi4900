
package userDataInteraction;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author Derek Pendleton
 * @version 11-4-18
 *
 */
public class FileSystemInteracter 
{
	
	//method to serialize a user
	public static void serializeUser(User user)
	{
		try{
            FileOutputStream fos= new FileOutputStream("C:\\Program Files\\LABELLELUCIEUSERLIST\\" + user.getFirstName() + user.getLastName());
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.close();
            fos.close();
          }catch(IOException ioe){
               ioe.printStackTrace();
           }
		FileSystemInteracter.addUserToList(user.getFirstName() + user.getLastName());
	}
	
	//method to de-serialize a user
	public static User deserializeUser(String user)
	{
		User userToReturn = null;
		try
        {
            FileInputStream fis = new FileInputStream("C:\\Program Files\\LABELLELUCIEUSERLIST\\USERLIST");
            ObjectInputStream ois = new ObjectInputStream(fis);
            userToReturn = (User) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
             return null;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return null;
          }
		return userToReturn;
	}
	
	//this method will add a new username to the user arraylist
	public static void addUserToList(String user)
	{
		//first read in the userList
		ArrayList<String> userList = new ArrayList<String>();
		try
        {
            FileInputStream fis = new FileInputStream("C:\\Program Files\\LABELLELUCIEUSERLIST\\USERLIST");
            ObjectInputStream ois = new ObjectInputStream(fis);
            userList = (ArrayList<String>) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
          }
		
        userList.add(user);
        
        //now serialize the arraylist
        try{
            FileOutputStream fos= new FileOutputStream("C:\\Program Files\\LABELLELUCIEUSERLIST\\USERLIST");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(userList);
            oos.close();
            fos.close();
          }catch(IOException ioe){
               ioe.printStackTrace();
           }
		
	}
	
	//this method will fetch the user from the txt list
	public static ArrayList<String> getUserList()
	{
		//read in the user list
		ArrayList<String> userList = new ArrayList<String>();
		try
		{
			FileInputStream fis = new FileInputStream("C:\\Program Files\\LABELLELUCIEUSERLIST\\USERLIST");
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    userList = (ArrayList<String>) ois.readObject();
		    ois.close();
		    fis.close();
		}catch(IOException ioe){
		    ioe.printStackTrace();
		    //return an empty list
		    return new ArrayList<String>();
		}catch(ClassNotFoundException c){
		    System.out.println("Class not found");
		    c.printStackTrace();
		    //return an empty list
		    return new ArrayList<String>();
		}
		
		return userList;
	}
	
}
