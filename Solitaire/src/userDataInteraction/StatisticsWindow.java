
package userDataInteraction;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

/**
 * @author Derek Pendleton
 * @version 11-05-18
 *
 */
public class StatisticsWindow extends WindowTemplate 
{
	
	JFrame frame;
	
	public void buildWindow()
	{
		//declare frame
				frame = new JFrame("Create User");
				
				//declare panel
				JPanel mainPanel = new JPanel();
						
				//ensure that the application will close if this frame is exited
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
				//declare title text
				JLabel title = new JLabel("Enter New Profile Information:", SwingConstants.CENTER);
				
				//add title to frame
				mainPanel.add(title, BorderLayout.NORTH);
				
				//establish a border for the panel
				mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
				
				//initialize field labels
				JLabel firstNameLabel = new JLabel("First Name: ");
				JLabel lastNameLabel = new JLabel("Last Name: ");
				JLabel ageLabel = new JLabel("Age: ");
				JLabel timePlayedLabel = new JLabel("Time Played: ");
				JLabel bestTimeLabel = new JLabel("Fastest Time: ");
				JLabel gamesPlayedLabel = new JLabel("Games Played: ");
				JLabel gamesWonLabel = new JLabel("Games Won: ");
				JLabel totalScoreLabel = new JLabel("Total Score: ");
				JLabel highestScoreLabel = new JLabel("Highest Score: ");
				JLabel firstName = new JLabel(MainMenu.currentUser.getFirstName());
				JLabel lastName = new JLabel(MainMenu.currentUser.getLastName());
				JLabel age = new JLabel(Integer.toString(MainMenu.currentUser.getAge()));
				JLabel timePlayed = new JLabel(Double.toString(MainMenu.currentUser.getTimePlayed()));
				JLabel bestTime = new JLabel(Double.toString(MainMenu.currentUser.getFastestGame()));
				JLabel gamesPlayed = new JLabel(Integer.toString(MainMenu.currentUser.getGamesPlayed()));
				JLabel gamesWon = new JLabel(Integer.toString(MainMenu.currentUser.getGamesWon()));
				JLabel totalScore = new JLabel(Integer.toString(MainMenu.currentUser.getGameScore()));
				JLabel highScore = new JLabel(Integer.toString(MainMenu.currentUser.getHighScore()));
				
				//create submit button
				JButton close = new JButton("Close");
				
				//create submit button listener
				close.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                frame.dispose();
		            }
		        });
				
				//create window layout
				//followed guide at: https://stackoverflow.com/questions/11927963/get-input-from-jframe.
				GroupLayout windowLayout = new GroupLayout(mainPanel);
				mainPanel.setLayout(windowLayout);
				windowLayout.setHorizontalGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(windowLayout.createSequentialGroup()
														  .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
																  	.addComponent(firstNameLabel)
																  	.addComponent(lastNameLabel)
																  	.addComponent(ageLabel)
																  	.addComponent(timePlayedLabel)
																  	.addComponent(bestTimeLabel)
																  	.addComponent(gamesPlayedLabel)
																  	.addComponent(gamesWonLabel)
																  	.addComponent(totalScoreLabel)
																  	.addComponent(highestScoreLabel))
														  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														  .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																  	.addComponent(firstName, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
																  	.addComponent(lastName, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
																  	.addComponent(age, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
																  	.addComponent(timePlayed, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
																  	.addComponent(bestTime, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
																  	.addComponent(gamesPlayed, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
																  	.addComponent(gamesWon, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
																  	.addComponent(totalScore, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
																  	.addComponent(highScore, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
														  .addGap(18,18,18)
														  .addComponent(close)
														  .addGap(0,65,Short.MAX_VALUE)));
				
				windowLayout.setVerticalGroup(
						windowLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			            .addGroup(windowLayout.createSequentialGroup()
			                .addContainerGap()
			                .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			                    .addComponent(firstNameLabel)
			                    .addComponent(firstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			                .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				                    .addComponent(lastNameLabel)
				                    .addComponent(lastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				            .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					                .addComponent(timePlayedLabel)
					                .addComponent(timePlayed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					        .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					                .addComponent(bestTimeLabel)
					                .addComponent(bestTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					        .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					                .addComponent(bestTimeLabel)
					                .addComponent(bestTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					        .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					                .addComponent(gamesPlayedLabel)
					                .addComponent(gamesPlayed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					        .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					                .addComponent(gamesWonLabel)
					                .addComponent(gamesWon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					        .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					                .addComponent(totalScoreLabel)
					                .addComponent(totalScore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					        .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					                .addComponent(highestScoreLabel)
					                .addComponent(highScore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			                .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			                    .addComponent(ageLabel)
			                    .addComponent(age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			                    .addComponent(close))
			                .addContainerGap(15, Short.MAX_VALUE)));
				
				//set layout
				GroupLayout layout = new GroupLayout(frame.getContentPane());
		        frame.getContentPane().setLayout(layout);
		        layout.setHorizontalGroup(
		            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		        );
		        layout.setVerticalGroup(
		            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		        );
		        

		        frame.pack();
		        
		        frame.setVisible(true);
	}
	
}
