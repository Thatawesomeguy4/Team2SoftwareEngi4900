
package userDataInteraction;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

/**
 * @author Derek Pendleton
 * @version 11/03/18
 *
 */
public class CreateUserWindow extends WindowTemplate 
{
	
	private JFrame frame;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField age;
	private ArrayList<String> userList;
	
	public int buildWindow()
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
		firstName = new JTextField();
		lastName = new JTextField();
		age = new JTextField();
		
		//initialize field labels
		JLabel firstNameLabel = new JLabel("First Name: ");
		JLabel lastNameLabel = new JLabel("Last Name: ");
		JLabel ageLabel = new JLabel("Age: ");
		
		//create submit button
		JButton submit = new JButton("Submit");
		
		//create submit button listener
		submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitUser(e);
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
														  	.addComponent(ageLabel))
												  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												  .addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
														  	.addComponent(firstName, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
														  	.addComponent(lastName, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
														  	.addComponent(age, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
												  .addGap(18,18,18)
												  .addComponent(submit)
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
	                    .addComponent(ageLabel)
	                    .addComponent(age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
		
		return 0;
	}
	
	//this method is responsible for creating and serializing the user
	private void submitUser(ActionEvent e)
	{
		//get user input from text fields
		String firstNameInput = firstName.getText();
        String lastNameInput = lastName.getText();
        String ageInput = age.getText();
        
        //create user name for usage
        String userName = firstNameInput + lastNameInput;
        
        //fetch the user list
        this.getUserList();

        //check for no input
        if ("".equals(firstNameInput) || "".equals(lastNameInput) || "".equals(ageInput))
        {
            JOptionPane.showMessageDialog(frame, "Name or password is empty!", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
        }
        //check for age not being a number
        else if (!(ageInput.matches("^[0-9]*$")))
        {
        	JOptionPane.showMessageDialog(frame, "Age input was not valid!", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
        }
        //check to see if user with first name + last name combo already exists
        else if (userList.contains(userName))
        {
        	JOptionPane.showMessageDialog(frame, "A user with this first and last name already exist!", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
        }
        //user input valid, create user
        else
        {
            JOptionPane.showMessageDialog(frame, "Your input was valid", "Creating User", JOptionPane.PLAIN_MESSAGE);
        }
	}
	
	//this method fetches the txt user list
	private void getUserList()
	{
		//call the system I/O class (yet to be built) to read in the user txt list
	}
	
}
