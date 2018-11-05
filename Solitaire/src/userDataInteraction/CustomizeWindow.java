package userDataInteraction;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

/**
 * @author Derek Pendleton
 * @version 11-05-18
 *
 */
public class CustomizeWindow extends WindowTemplate 
{
	JFrame frame;
	JCheckBox selectProfile;
	JCheckBox createProfile;
	JCheckBox stats;
	
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
			
			//initialize all user input fields
			selectProfile = new JCheckBox("Display Profile Selection Button");
			createProfile = new JCheckBox("Display Profile Creation Button");
			stats = new JCheckBox("Display Statistics Button");
			
			//set all of the boxes to their current state in the system.
			selectProfile.setSelected(MenuCustomizationSettings.selectProfile);
			createProfile.setSelected(MenuCustomizationSettings.createProfile);
			stats.setSelected(MenuCustomizationSettings.stats);
			
			//create submit button
			JButton submit = new JButton("submit");
			
			//create submit button listener
			submit.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                customize();
	                frame.dispose();
	            }
	        });
			
			//create window layout
			//followed guide at: https://stackoverflow.com/questions/11927963/get-input-from-jframe.
			GroupLayout windowLayout = new GroupLayout(mainPanel);
			mainPanel.setLayout(windowLayout);
			windowLayout.setHorizontalGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
											.addGroup(windowLayout.createSequentialGroup()
													  .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
															  	.addComponent(selectProfile, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
															  	.addComponent(createProfile, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
															  	.addComponent(stats, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
													  .addGap(18,18,18)
													  .addComponent(submit)
													  .addGap(0,65,Short.MAX_VALUE)));
			
			windowLayout.setVerticalGroup(
					windowLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addGroup(windowLayout.createSequentialGroup()
		                .addContainerGap()
		                .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                    .addComponent(selectProfile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			                    .addComponent(createProfile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                    .addComponent(stats, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                    .addComponent(submit))
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
	
	private void customize()
	{
		ArrayList<Boolean> settings = new ArrayList<Boolean>();
		settings.add(selectProfile.isSelected());
		settings.add(createProfile.isSelected());
		settings.add(stats.isSelected());
		FileSystemInteracter.serializeMenuSettings(settings);
		JOptionPane.showMessageDialog(frame, "Settings Saved! Restart to apply", "Settings", JOptionPane.PLAIN_MESSAGE);
	}
	
}
