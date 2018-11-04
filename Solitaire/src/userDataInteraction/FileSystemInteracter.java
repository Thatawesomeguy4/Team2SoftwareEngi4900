
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
	public static void serializeUser()
	{
		
	}
	
	//method to de-serialize a user
	public static void deserializeUser()
	{
		
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
             return;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
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
		    return null;
		}catch(ClassNotFoundException c){
		    System.out.println("Class not found");
		    c.printStackTrace();
		    return null;
		}
		
		return userList;
	}
	
}
