import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GUI extends JFrame {

	private static ProfileManager pm;
	private User user;
	private Deck deck;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				pm = new ProfileManager();
				
				GUI frame = new GUI(pm);
				frame.setVisible(true);
			}
		});
	}

	public GUI(ProfileManager pm) {
		setTitle("Study Tool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);

		add(new openPanel(this));
		setVisible(true);
	}
	
	public class openPanel extends JPanel{
		public openPanel(GUI frame){
			setLayout(null);
			
			JButton existUserButton = new JButton("Existing User");
			existUserButton.setBounds(138, 166, 147, 35);
			add(existUserButton);
			
			JButton newUserButton = new JButton("Create New User");
			newUserButton.setBounds(138, 102, 147, 35);
			add(newUserButton);
			
			JLabel welcomeLabel = new JLabel("Welcome to the Study Tool!");
			welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			welcomeLabel.setBounds(87, 23, 292, 25);
			add(welcomeLabel);
			
			newUserButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					frame.getContentPane().removeAll();
					frame.add(new userPanel(frame));
					frame.setVisible(true);
				}
			});
			
			existUserButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					frame.getContentPane().removeAll();
					frame.add(new userListPanel(frame));
					frame.setVisible(true);
				}
			});
		}
	}
	
	public class userPanel extends JPanel{
		public userPanel(GUI frame){
			setLayout(null);
			
			JLabel createLabel = new JLabel("Create New User");
			createLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			createLabel.setBounds(139, 28, 179, 20);
			add(createLabel);
			
			JLabel enterLabel = new JLabel("Please Enter a Username:");
			enterLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			enterLabel.setBounds(12, 91, 163, 27);
			add(enterLabel);
			
			JTextField textField = new JTextField();
			textField.setBounds(12, 126, 267, 27);
			textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			add(textField);
			textField.setColumns(10);
			
			JButton backButton = new JButton("Back");
			backButton.setBounds(12, 230, 112, 25);
			add(backButton);
			
			JButton createButton = new JButton("Create");
			createButton.setBounds(310, 230, 112, 25);
			add(createButton);
			
			backButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					frame.getContentPane().removeAll();
					frame.add(new openPanel(frame));
					frame.setVisible(true);
				}
			});
			
			createButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					String username = textField.getText();
					if(pm.isUsernameTaken(username)) {
						 Object[] options = {"OK"};
						    int n = JOptionPane.showOptionDialog(frame,
						                   "Username already taken. Please enter a different username.","Username Taken",
						                   JOptionPane.PLAIN_MESSAGE,
						                   JOptionPane.QUESTION_MESSAGE,
						                   null,
						                   options,
						                   options[0]);
					}
					else if(username.equals("")) {
						Object[] options = {"OK"};
					    int n = JOptionPane.showOptionDialog(frame,
					                   "Please enter a username.","Error",
					                   JOptionPane.PLAIN_MESSAGE,
					                   JOptionPane.QUESTION_MESSAGE,
					                   null,
					                   options,
					                   options[0]);
					}
					else {
						user = new User(username);
						pm.addUser(user);
						frame.getContentPane().removeAll();
						frame.add(new newDeckPanel(frame));
						frame.setVisible(true);
					}
				}
			});
		}
	}
	
	public class userListPanel extends JPanel{
		public userListPanel(GUI frame){
			setLayout(null);
			
			JLabel userLabel = new JLabel("Users");
			userLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			userLabel.setBounds(182, 13, 56, 29);
			add(userLabel);
			
			JButton backButton = new JButton("Back");
			backButton.setBounds(41, 242, 97, 25);
			add(backButton);
			
			JButton selectButton = new JButton("Select");
			selectButton.setBounds(316, 242, 97, 25);
			add(selectButton);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(96, 55, 243, 154);
			add(scrollPane);
			
			JList userList = new JList();
			scrollPane.setViewportView(userList);
			
			backButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					frame.getContentPane().removeAll();
					frame.add(new openPanel(frame));
					frame.setVisible(true);
				}
			});
		}
	}
	
	public class newDeckPanel extends JPanel{
		public newDeckPanel(GUI frame){
			setLayout(null);
			
			JLabel createLabel = new JLabel("Create New Deck");
			createLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			createLabel.setBounds(139, 28, 179, 20);
			add(createLabel);
			
			JLabel deckLabel = new JLabel("Please Enter Deck Name:");
			deckLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			deckLabel.setBounds(12, 72, 163, 27);
			add(deckLabel);
			
			JTextField nameTextField = new JTextField();
			nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			nameTextField.setBounds(12, 102, 267, 27);
			add(nameTextField);
			nameTextField.setColumns(10);
			
			JButton backButton = new JButton("Back");
			backButton.setBounds(12, 230, 112, 25);
			add(backButton);
			
			JButton createButton = new JButton("Create");
			createButton.setBounds(310, 230, 112, 25);
			add(createButton);
			
			JLabel catLabel = new JLabel("Please Enter Deck Category:");
			catLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			catLabel.setBounds(12, 142, 193, 27);
			add(catLabel);
			
			JTextField catTextField = new JTextField();
			catTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			catTextField.setColumns(10);
			catTextField.setBounds(12, 172, 267, 27);
			add(catTextField);
			
			createButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					String name = nameTextField.getText();
					String cat = catTextField.getText();
					
					if(user.isDeckNameTaken(name)) {
						 Object[] options = {"OK"};
						    int n = JOptionPane.showOptionDialog(frame,
						                   "Deck name already taken. Please enter a different name.","Deck Name Taken",
						                   JOptionPane.PLAIN_MESSAGE,
						                   JOptionPane.QUESTION_MESSAGE,
						                   null,
						                   options,
						                   options[0]);
					}
					else if(name.equals("")) {
						Object[] options = {"OK"};
					    int n = JOptionPane.showOptionDialog(frame,
					                   "Please enter a name for your deck.","Error",
					                   JOptionPane.PLAIN_MESSAGE,
					                   JOptionPane.QUESTION_MESSAGE,
					                   null,
					                   options,
					                   options[0]);
					}
					else if(cat.equals("")) {
						Object[] options = {"OK"};
					    int n = JOptionPane.showOptionDialog(frame,
					                   "Please enter a category for your deck.","Error",
					                   JOptionPane.PLAIN_MESSAGE,
					                   JOptionPane.QUESTION_MESSAGE,
					                   null,
					                   options,
					                   options[0]);
					}
					else {
						deck = new Deck(name, cat);
						user.addDeck(deck);
						frame.getContentPane().removeAll();
						frame.add(new newDeckPanel(frame));
						frame.setVisible(true);
					}
				}
			});//end create button action listener
		}
	}
	
	
}