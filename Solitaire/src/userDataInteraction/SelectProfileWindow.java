package userDataInteraction;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

/**
 * @author Derek Pendleton
 * @version 11-5-18
 *
 */
public class SelectProfileWindow extends WindowTemplate 
{
	JFrame frame;
	JComboBox dropDown;
	
	public void buildWindow()
	{
		//declare frame
				frame = new JFrame("Select User");
				
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
				
				//fetch User list
				ArrayList<String> userList = FileSystemInteracter.getUserList();
				
				//initialize dropdown
				dropDown = new JComboBox<String>();
				
				//fill dropdown
				for (String user : userList) 
				{
					dropDown.addItem(user);
				}
				
				//initialize field labels
				JLabel chooseLabel = new JLabel("Choose A User: ");
				
				
				//create submit button
				JButton submit = new JButton("Submit");
				
				//create submit button listener
				submit.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                setUser();
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
																  	.addComponent(chooseLabel))
														  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														  .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																  	.addComponent(dropDown, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
														  .addGap(18,18,18)
														  .addComponent(submit)
														  .addGap(0,65,Short.MAX_VALUE)));
				
				windowLayout.setVerticalGroup(
						windowLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			            .addGroup(windowLayout.createSequentialGroup()
			                .addContainerGap()
			                .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			                    .addComponent(chooseLabel)
			                    .addComponent(dropDown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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

	//this method is responsible for setting the user's chosen profile
	public void setUser()
	{
		MainMenu.currentUser = FileSystemInteracter.deserializeUser((String) this.dropDown.getSelectedItem());
	}
}
