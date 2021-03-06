package userDataInteraction;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import solitaire.Solitaire;

/**
 * @author Derek Pendleton
 * @version 10-15-18
 * 
 * 	This class is an implementation of the primary window for the main menu.
 * 	The plan is for this to be updated by a customization window.
 *
 */
public class MainWindow extends WindowTemplate 
{
	private boolean refreshWindow;
	

	public void buildWindow()
	{
			//set refresh bool to false to begin the loop.
			refreshWindow = false;
			//declare frame
			JFrame mainFrame = new JFrame("main menu");
			
			//ensure that the application will close if this frame is exited
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//declare title text
			JLabel title = new JLabel("Welcome to Solitaire! \n Please Choose an Option:", SwingConstants.CENTER);
			
			//define text size
			title.setPreferredSize(new Dimension(300, 100));
			
			//add title to frame
			mainFrame.getContentPane().add(title, BorderLayout.NORTH);
			
			//create the panel to hold all of our buttons
			JPanel buttons = new JPanel();
			
			//create the buttons
			JButton play = new JButton("Play");
			//play.setPreferredSize(new Dimension(300, 100));
			JButton selectProfile = new JButton("Select Profile");
			//selectProfile.setPreferredSize(new Dimension(300, 100));
			JButton createProfile = new JButton("Create Profile");
			//createProfile.setPreferredSize(new Dimension(300, 100));
			JButton viewStats = new JButton("View Statistics");
			//viewStats.setPreferredSize(new Dimension(300, 100));
			JButton customize = new JButton("Customize Menu");
			//credits.setPreferredSize(new Dimension(300, 100));
			
			//fetch window customization settings.
			FileSystemInteracter.getMenuSettings();
			
			//add buttons to content window
			buttons.add(play);
			if (MenuCustomizationSettings.selectProfile)
			{
				buttons.add(selectProfile);
			}
			if (MenuCustomizationSettings.createProfile)
			{
				buttons.add(createProfile);
			}
			if (MenuCustomizationSettings.stats)
			{
				buttons.add(viewStats);
			}
			buttons.add(customize);
			
			//define action listeners
			play.addActionListener(new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
					  mainFrame.dispose();
					  MainWindow.play();
				  } 
				} );
			
			createProfile.addActionListener(new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
					  //launch create profile window
					  CreateUserWindow createUserWindow = new CreateUserWindow();
					  createUserWindow.buildWindow();
					  
				  } 
				} );
			
			selectProfile.addActionListener(new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
					  //launch create profile window
					  SelectProfileWindow selectProfileWindow = new SelectProfileWindow();
					  selectProfileWindow.buildWindow();
					  
				  } 
				} );
			
			customize.addActionListener(new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
					  //launch create profile window
					  CustomizeWindow customizeWindow = new CustomizeWindow();
					  customizeWindow.buildWindow();
					  
				  } 
				} );
			
			viewStats.addActionListener(new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
					  //launch create profile window
					  StatisticsWindow statsWindow = new StatisticsWindow();
					  statsWindow.buildWindow();
					  
				  } 
				} );
			
			//tell JPanel that we want a grid layout
			buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
			
			//add button pane to the frame
			mainFrame.getContentPane().add(buttons);
			
			//tell JFrame to look at what is in the pane and set the window size
			mainFrame.pack();
			
			//set frame visibility to true
			mainFrame.setVisible(true);
			
	}
	
	public static void play()
	{
		
		newsolitaire.Solitaire.run();
	}
	
}
