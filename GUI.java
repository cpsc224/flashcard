import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GUI extends JFrame {

	private static ProfileManager pm;
	private User user;
	private Deck deck;
	private Card card;
	private Deck originalDeck;
	
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
			
			if(pm.getNumberOfUsers() == 0) existUserButton.setEnabled(false);
			
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
			userLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			userLabel.setBounds(182, 28, 56, 29);
			add(userLabel);
			
			JButton backButton = new JButton("Back");
			backButton.setBounds(25, 242, 97, 25);
			add(backButton);
			
			JButton deleteButton = new JButton("Delete User");
			deleteButton.setBounds(165, 242, 105, 25);
			add(deleteButton);
			
			JButton selectButton = new JButton("Select");
			selectButton.setBounds(316, 242, 97, 25);
			add(selectButton);
			
			if(pm.getNumberOfUsers() == 0) {
				selectButton.setEnabled(false);
				deleteButton.setEnabled(false);
			}
			
			String [] data = new String[pm.getNumberOfUsers()];
			for(int i = 0; i < pm.getNumberOfUsers(); i++) {
				data[i] = (pm.getUser(i)).getUsername();
			}
			
			JList userList = new JList(data);
			userList.setFont(new Font("Tahoma", Font.PLAIN, 14));
			userList.setSelectedIndex(0);
			JScrollPane scrollPane = new JScrollPane(userList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setBounds(96, 55, 243, 154);
			add(scrollPane);
			
			backButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					frame.getContentPane().removeAll();
					frame.add(new openPanel(frame));
					frame.setVisible(true);
				}
			});
			
			selectButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					String selected = userList.getSelectedValue().toString();
					user = pm.getUser(selected);
					frame.getContentPane().removeAll();
					frame.add(new userMenuPanel(frame));
					frame.setVisible(true);
				}
			});

			
			deleteButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					String message = "Are you sure that you want to delete this user?";
				    String title = "Delete User";
				    int reply = JOptionPane.showConfirmDialog(frame, message, title, JOptionPane.YES_NO_OPTION);
				    if (reply == JOptionPane.YES_OPTION) {
				    	String selected = userList.getSelectedValue().toString();
						pm.removeUser(selected);
						frame.getContentPane().removeAll();
						frame.add(new userListPanel(frame));
						frame.setVisible(true);
				    }
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
						frame.add(new deckListPanel(frame));
						frame.setVisible(true);
					}
				}
			});//end create button action listener
			
			backButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					frame.getContentPane().removeAll();
					frame.add(new userMenuPanel(frame));
					frame.setVisible(true);
				}
			});
		}	
	}
	
	public class deckListPanel extends JPanel{
		public deckListPanel(GUI frame){
			setLayout(null);
			
			JLabel deckLabel = new JLabel("Decks");
			deckLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			deckLabel.setBounds(182, 28, 56, 29);
			add(deckLabel);
			
			JButton backButton = new JButton("Back");
			backButton.setBounds(25, 242, 97, 25);
			add(backButton);
			
			JButton deleteButton = new JButton("Delete Deck");
			deleteButton.setBounds(165, 242, 105, 25);
			add(deleteButton);
			
			JButton selectButton = new JButton("Select");
			selectButton.setBounds(316, 242, 97, 25);
			add(selectButton);
			
			if(user.getNumberOfDecks() == 0) {
				selectButton.setEnabled(false);
				deleteButton.setEnabled(false);
			}
			
			
			String [] data = new String[user.getNumberOfDecks()];
			for(int i = 0; i < user.getNumberOfDecks(); i++) {
				data[i] = (user.getDeck(i)).getName();
			}
			
			JList deckList = new JList(data);
			deckList.setSelectedIndex(0);
			JScrollPane scrollPane = new JScrollPane(deckList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			deckList.setFont(new Font("Tahoma", Font.PLAIN, 14));
			scrollPane.setBounds(96, 55, 243, 154);
			add(scrollPane);
			
			backButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					frame.getContentPane().removeAll();
					frame.add(new userMenuPanel(frame));
					frame.setVisible(true);
				}
			});
			
			deleteButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					String message = "Are you sure that you want to delete this deck?";
				    String title = "Delete Deck";
				    int reply = JOptionPane.showConfirmDialog(frame, message, title, JOptionPane.YES_NO_OPTION);
				    if (reply == JOptionPane.YES_OPTION) {
				    	String selected = deckList.getSelectedValue().toString();
				    	user.removeDeck(selected);
				    	frame.getContentPane().removeAll();
				    	frame.add(new deckListPanel(frame));
				    	frame.setVisible(true);
				    } 
				}
			});
			
			selectButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					String selected = deckList.getSelectedValue().toString();
					deck = user.getDeck(selected);
					frame.getContentPane().removeAll();
					frame.add(new deckMenuPanel(frame));
					frame.setVisible(true);
				}
			});
		}
	}
	
	public class categoryPanel extends JPanel{
		public categoryPanel(GUI frame){
			setLayout(null);
			
			JLabel catLabel = new JLabel("Categories");
			catLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			catLabel.setBounds(175, 28, 100, 29);
			add(catLabel);
			
			JButton backButton = new JButton("Back");
			backButton.setBounds(25, 242, 97, 25);
			add(backButton);
			
			
			JButton selectButton = new JButton("Select");
			selectButton.setBounds(316, 242, 97, 25);
			add(selectButton);
			
			String [] data = user.getCategories();
			
			JList catList = new JList(data);
			catList.setSelectedIndex(0);
			JScrollPane scrollPane = new JScrollPane(catList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			catList.setFont(new Font("Tahoma", Font.PLAIN, 14));
			scrollPane.setBounds(96, 55, 243, 154);
			add(scrollPane);
			
			backButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					frame.getContentPane().removeAll();
					frame.add(new userMenuPanel(frame));
					frame.setVisible(true);
				}
			});
			
			selectButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					String selected = catList.getSelectedValue().toString();
					deck = user.createCategoryDeck(selected);
					frame.getContentPane().removeAll();
					frame.add(new categoryMenuPanel(frame));
					frame.setVisible(true);
				}
			});
		}
	}
	
	public class editCardPanel extends JPanel{
		public editCardPanel(GUI frame){
			setLayout(null);
			
			JLabel cardLabel = new JLabel("Edit Cards");
			cardLabel.setHorizontalAlignment(SwingConstants.LEFT);
			cardLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			cardLabel.setBounds(175, 28, 95, 29);
			add(cardLabel);
			
			JButton backButton = new JButton("Back");
			backButton.setBounds(20, 242, 112, 25);
			add(backButton);
			
			JButton editButton = new JButton("Edit Selected");
			editButton.setBounds(301, 242, 112, 25);
			add(editButton);
			
			JButton addButton = new JButton("Add");
			addButton.setBounds(25, 13, 97, 25);
			add(addButton);
			
			JButton deleteButton = new JButton("Delete");
			deleteButton.setBounds(316, 13, 97, 25);
			add(deleteButton);
			
			if(deck.getSize() == 0) {
				editButton.setEnabled(false);
				deleteButton.setEnabled(false);
			}
			
			String [] data = new String [deck.getSize()];
			for(int i = 0; i < deck.getSize(); i++){
				data[i] = (deck.getCard(i)).getQuestion();
			}
			
			JList cardList = new JList(data);
			JScrollPane scrollPane = new JScrollPane(cardList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			cardList.setFont(new Font("Tahoma", Font.PLAIN, 14));
			scrollPane.setBounds(46, 55, 346, 154);
			add(scrollPane);
			cardList.setSelectedIndex(0);
			
			editButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int selected = cardList.getSelectedIndex();
					card = deck.getCard(selected);
					frame.getContentPane().removeAll();
					frame.add(new editOneCardPanel(frame));
					frame.setVisible(true);
				}
			});
			
			addButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					frame.getContentPane().removeAll();
					frame.add(new addCardPanel(frame));
					frame.setVisible(true);
				}
			});
			
			deleteButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					String message = "Are you sure that you want to delete this card?";
				    String title = "Delete Card";
				    int reply = JOptionPane.showConfirmDialog(frame, message, title, JOptionPane.YES_NO_OPTION);
				    if (reply == JOptionPane.YES_OPTION) {
				    	int selected = cardList.getSelectedIndex();
				    	deck.removeCard(selected);
				    	frame.getContentPane().removeAll();
				    	frame.add(new editCardPanel(frame));
				    	frame.setVisible(true);
				    } 
				}
			});
			
			backButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					frame.getContentPane().removeAll();
					frame.add(new editPanel(frame));
					frame.setVisible(true);
				}
			});
		}
	}
	
	
	public class QuizPanel extends JPanel {
		private JTextField answerTextField;
		private JLabel answerLabel;
		private JButton submitButton, quitButton, checkAnswerButton, correctButton, incorrectButton;

		public QuizPanel(GUI frame) {
			setLayout(null);
			
			JLabel quizModeLabel = new JLabel("Quiz Mode");
			quizModeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			quizModeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			quizModeLabel.setBounds(177, 28, 93, 16);
			add(quizModeLabel);
			
			JTextPane cardTextPanel = new JTextPane();
			cardTextPanel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			cardTextPanel.setEditable(false);
			cardTextPanel.setBounds(66, 56, 324, 166);
			add(cardTextPanel);
			
			answerLabel = new JLabel("Answer:");
			answerLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			answerLabel.setBounds(49, 234, 54, 16);
			add(answerLabel);
			
			answerTextField = new JTextField();
			answerTextField.setBounds(104, 230, 258, 26);
			add(answerTextField);
			answerTextField.setColumns(10);
			
			submitButton = new JButton("Submit");
			
			
			submitButton.addMouseListener(new MouseAdapter() {
				/**
				 * When the submit button is clicked, submits the answer and compares it to the card answer.
				 */
				public void mouseClicked(MouseEvent e) {
					String answer = answerTextField.getText();
					//if(answer.equals(anObject) )
				}
			});
			submitButton.setBounds(363, 230, 81, 29);
			add(submitButton);
			
			quitButton = new JButton("Quit");
			quitButton.setBounds(6, 262, 75, 29);
			add(quitButton);
			
			checkAnswerButton = new JButton("Check Answer");
			checkAnswerButton.setBounds(171, 230, 117, 29);
			add(checkAnswerButton);
			
			correctButton = new JButton("Correct");
			correctButton.setBounds(114, 230, 117, 29);
			add(correctButton);
			
			incorrectButton = new JButton("Incorrect");
			incorrectButton.setBounds(245, 230, 117, 29);
			add(incorrectButton);
			
		}
		
		/**
		 * Helper method to change the state of the Panel to manual mode
		 */
		public void displayManualMode(){
			answerLabel.setVisible(false);
			answerTextField.setVisible(false);
			submitButton.setVisible(false);
			correctButton.setVisible(false);
			incorrectButton.setVisible(false);
			
			checkAnswerButton.setVisible(true);
		}
		
		/**
		 * Helper method to change the state of the Panel to "check answer mode" mode
		 */
		public void displayCheckAnswerMode(){
			checkAnswerButton.setVisible(false);
			correctButton.setVisible(true);
			incorrectButton.setVisible(true);	
		}
		
		/**
		 * Helper method to change the state of the Panel to TextFieldMode mode
		 */
		public void displayTextFieldMode(){
			answerLabel.setVisible(true);
			answerTextField.setVisible(true);
			submitButton.setVisible(true);
			correctButton.setVisible(false);
			incorrectButton.setVisible(false);
			checkAnswerButton.setVisible(false);
		}
	}
	
	public class PracticePanel extends JPanel {
		public PracticePanel(GUI frame) {
			setLayout(null);
			
			JLabel practiceModeLabel = new JLabel("Practice Mode");
			practiceModeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			practiceModeLabel.setBounds(164, 28, 123, 16);
			add(practiceModeLabel);
			
			JTextPane textPane = new JTextPane();
			textPane.setBounds(66, 56, 324, 166);
			add(textPane);
			
			JButton quitButton = new JButton("Quit");
			quitButton.setBounds(6, 265, 117, 29);
			add(quitButton);
			
			JButton flipButton = new JButton("Flip");

			flipButton.setBounds(186, 221, 90, 29);
			add(flipButton);
			
			JButton previousButton = new JButton("Previous");
			previousButton.setBounds(84, 221, 90, 29);
			add(previousButton);
			
			JButton nextButton = new JButton("Next");
			nextButton.setBounds(288, 221, 90, 29);
			add(nextButton);

		}
	}
	
	
	public class editPanel extends JPanel{
		public editPanel(GUI frame){ 
				setLayout(null);
				JButton editCardButton = new JButton("Edit Cards");
				editCardButton.setBounds(138, 38, 147, 30);
				add(editCardButton);
				
				JButton renameDeckButton = new JButton("Rename Deck");
				renameDeckButton.setBounds(138, 78, 147, 30);
				add(renameDeckButton);
				
				JButton catButton = new JButton("Change Category");
				catButton.setBounds(138, 118, 147, 30);
				add(catButton);
				
				JButton quizSettingButton = new JButton("Quiz Settings");
				quizSettingButton.setBounds(138, 158, 147, 30);
				add(quizSettingButton);
				
				JButton backButton = new JButton("Back");
				backButton.setBounds(138, 198, 147, 30);
				add(backButton);

				JLabel userNameLabel = new JLabel("Edit");
				userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
				userNameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				userNameLabel.setBounds(93, 11, 237, 25);
				add(userNameLabel);
				
				editCardButton.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e){
						frame.getContentPane().removeAll();
						frame.add(new editCardPanel(frame));
						frame.setVisible(true);
					}
				});
				
				renameDeckButton.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e){
						frame.getContentPane().removeAll();
						frame.add(new renameDeckPanel(frame));
						frame.setVisible(true);
					}
				});
				
				catButton.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e){
						frame.getContentPane().removeAll();
						frame.add(new changeCategoryPanel(frame));
						frame.setVisible(true);
					}
				});
				
				quizSettingButton.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e){
						frame.getContentPane().removeAll();
						frame.add(new settingPanel(frame));
						frame.setVisible(true);
					}
				});

				backButton.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e){
						frame.getContentPane().removeAll();
						frame.add(new deckMenuPanel(frame));
						frame.setVisible(true);
					}
				});		
		}
	}
	public class deckMenuPanel extends JPanel{
		public deckMenuPanel(GUI frame){ 
		setLayout(null);
		JButton quizButton = new JButton("Quiz");
		quizButton.setBounds(138, 38, 147, 30);
		add(quizButton);
		
		JButton practiceButton = new JButton("Practice");
		practiceButton.setBounds(138, 78, 147, 30);
		add(practiceButton);
		
		JButton editButton = new JButton("Edit");
		editButton.setBounds(138, 118, 147, 30);
		add(editButton);
		
		JButton freqMissedButton = new JButton("Frequently Missed");
		freqMissedButton.setBounds(138, 158, 147, 30);
		add(freqMissedButton);
		
		JButton resultsButton = new JButton("Results");
		resultsButton.setBounds(138, 198, 147, 30);
		add(resultsButton);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(138, 238, 147, 30);
		add(backButton);
		
		JLabel userNameLabel = new JLabel(deck.getName());
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		userNameLabel.setBounds(93, 11, 237, 25);
		add(userNameLabel);
	
		quizButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.add(new QuizPanel(frame));
				frame.setVisible(true);
			}
		});
		
		practiceButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.add(new PracticePanel(frame));
				frame.setVisible(true);
			}
		});
		
		editButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.add(new editPanel(frame));
				frame.setVisible(true);
			}
		});
		
		freqMissedButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
				originalDeck = deck;
				deck = user.createFreqMissed(deck);
				frame.getContentPane().removeAll();
				frame.add(new frequentlyMissedPanel(frame));
				frame.setVisible(true);
			}
		});
		
		resultsButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.add(new resultsPanel(frame));
				frame.setVisible(true);
			}
		});

		backButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.add(new deckListPanel(frame));
				frame.setVisible(true);
			}
		});
		}
	}
		
 	public class userMenuPanel extends JPanel{
		public userMenuPanel(GUI frame){ 
		setLayout(null);
		
		JButton createNewDeckButton = new JButton("Create New Deck");
		createNewDeckButton.setBounds(138, 49, 147, 35);
		add(createNewDeckButton);
		
		JButton viewDeckButton = new JButton("View Decks");
		viewDeckButton.setBounds(138, 95, 147, 35);
		add(viewDeckButton);
		
		JButton resultsButton = new JButton("Results");
		resultsButton.setBounds(138, 141, 147, 35);
		add(resultsButton);
		
		JButton viewCategoriesButton = new JButton("View Categories");
		viewCategoriesButton.setBounds(138, 187, 147, 35);
		add(viewCategoriesButton);
		
		JButton signOutButton = new JButton("Sign Out");
		signOutButton.setBounds(138, 233, 147, 35);
		add(signOutButton);
		
		if(user.getNumberOfDecks() == 0){
			viewDeckButton.setEnabled(false);
			viewCategoriesButton.setEnabled(false);
		}
		
		JLabel userNameLabel = new JLabel(user.getUsername());
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		userNameLabel.setBounds(93, 22, 237, 25);
		add(userNameLabel);
		
		createNewDeckButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.add(new newDeckPanel(frame));
				frame.setVisible(true);
			}
		});
		
		viewDeckButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.add(new deckListPanel(frame));
				frame.setVisible(true);
			}
		});
		
		resultsButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.add(new resultPanel(frame));
				frame.setVisible(true);
			}
		});
		
		viewCategoriesButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.add(new categoryPanel(frame));
				frame.setVisible(true);
			}
		});
		
		signOutButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.add(new openPanel(frame));
				frame.setVisible(true);
			}
		});
		}
	}
 	
 	public class addCardPanel extends JPanel{
 		public addCardPanel(GUI frame){
 			setLayout(null);
 			
 			JLabel cardLabel = new JLabel("Add Card");
 			cardLabel.setHorizontalAlignment(SwingConstants.LEFT);
 			cardLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
 			cardLabel.setBounds(175, 28, 95, 29);
 			add(cardLabel);
 			
 			JButton backButton = new JButton("Back");
 			backButton.setBounds(25, 242, 107, 25);
 			add(backButton);
 			
 			JButton addButton = new JButton("Add Card");
 			addButton.setBounds(306, 242, 107, 25);
 			add(addButton);
 			
 			JLabel questionLabel = new JLabel("Question:");
 			questionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
 			questionLabel.setBounds(25, 63, 68, 17);
 			add(questionLabel);
 			
 			JTextArea questionTextArea = new JTextArea();
 			questionTextArea.setRows(2);
 			questionTextArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
 			questionTextArea.setBounds(25, 85, 388, 55);
 			questionTextArea.setLineWrap(true);
 			add(questionTextArea);
 			
 			JTextArea answerTextArea = new JTextArea();
 			answerTextArea.setRows(2);
 			answerTextArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
 			answerTextArea.setBounds(25, 174, 388, 55);
 			answerTextArea.setLineWrap(true);
 			add(answerTextArea);
 			
 			JLabel answerLabel = new JLabel("Answer:");
 			answerLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
 			answerLabel.setBounds(25, 153, 68, 17);
 			add(answerLabel);
 			
 			addButton.addActionListener( new ActionListener() {
 				public void actionPerformed(ActionEvent e){
 					String q = questionTextArea.getText();
 					String a = answerTextArea.getText();
 					if(q.equals("")) {
						Object[] options = {"OK"};
					    int n = JOptionPane.showOptionDialog(frame,
					                   "Please enter a question.","Error",
					                   JOptionPane.PLAIN_MESSAGE,
					                   JOptionPane.QUESTION_MESSAGE,
					                   null,
					                   options,
					                   options[0]);
					}
 					else if(a.equals("")){
 						Object[] options = {"OK"};
					    int n = JOptionPane.showOptionDialog(frame,
					                   "Please enter an answer.","Error",
					                   JOptionPane.PLAIN_MESSAGE,
					                   JOptionPane.QUESTION_MESSAGE,
					                   null,
					                   options,
					                   options[0]);
 					}
					else {
						deck.addCard(q, a);
	 					frame.getContentPane().removeAll();
	 					frame.add(new editCardPanel(frame));
	 					frame.setVisible(true);
					}
 				}
 			});
 			
 			backButton.addActionListener( new ActionListener() {
 				public void actionPerformed(ActionEvent e){
 					frame.getContentPane().removeAll();
 					frame.add(new editCardPanel(frame));
 					frame.setVisible(true);
 				}
 			});
 		}
 	}
 	
 	public class editOneCardPanel extends JPanel{
 		public editOneCardPanel(GUI frame){
 			setLayout(null);
 			
 			JLabel cardLabel = new JLabel("Edit Card");
 			cardLabel.setHorizontalAlignment(SwingConstants.LEFT);
 			cardLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
 			cardLabel.setBounds(175, 28, 95, 29);
 			add(cardLabel);
 			
 			JButton backButton = new JButton("Back");
 			backButton.setBounds(25, 242, 107, 25);
 			add(backButton);
 			
 			JButton saveButton = new JButton("Save");
 			saveButton.setBounds(306, 242, 107, 25);
 			add(saveButton);
 			
 			JLabel questionLabel = new JLabel("Question:");
 			questionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
 			questionLabel.setBounds(25, 63, 68, 17);
 			add(questionLabel);
 			
 			JTextArea questionTextArea = new JTextArea();
 			questionTextArea.setRows(2);
 			questionTextArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
 			questionTextArea.setBounds(25, 85, 388, 55);
 			questionTextArea.setLineWrap(true);
 			questionTextArea.setText(card.getQuestion());
 			add(questionTextArea);
 			
 			JTextArea answerTextArea = new JTextArea();
 			answerTextArea.setRows(2);
 			answerTextArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
 			answerTextArea.setBounds(25, 174, 388, 55);
 			answerTextArea.setLineWrap(true);
 			answerTextArea.setText(card.getAnswer());
 			add(answerTextArea);
 			
 			JLabel answerLabel = new JLabel("Answer:");
 			answerLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
 			answerLabel.setBounds(25, 153, 68, 17);
 			add(answerLabel);
 			
 			saveButton.addActionListener( new ActionListener() {
 				public void actionPerformed(ActionEvent e){
 					String q = questionTextArea.getText();
 					String a = answerTextArea.getText();
 					if(q.equals("")) {
						Object[] options = {"OK"};
					    int n = JOptionPane.showOptionDialog(frame,
					                   "Please enter a question.","Error",
					                   JOptionPane.PLAIN_MESSAGE,
					                   JOptionPane.QUESTION_MESSAGE,
					                   null,
					                   options,
					                   options[0]);
					}
 					else if(a.equals("")){
 						Object[] options = {"OK"};
					    int n = JOptionPane.showOptionDialog(frame,
					                   "Please enter an answer.","Error",
					                   JOptionPane.PLAIN_MESSAGE,
					                   JOptionPane.QUESTION_MESSAGE,
					                   null,
					                   options,
					                   options[0]);
 					}
					else {
						card.setQuestion(q);
						card.setAnswer(a);
	 					frame.getContentPane().removeAll();
	 					frame.add(new editCardPanel(frame));
	 					frame.setVisible(true);
					}
 				}
 			});
 			
 			backButton.addActionListener( new ActionListener() {
 				public void actionPerformed(ActionEvent e){
 					frame.getContentPane().removeAll();
 					frame.add(new editCardPanel(frame));
 					frame.setVisible(true);
 				}
 			});
 		}
 	}
 	
 	public class frequentlyMissedPanel extends JPanel{
 		public frequentlyMissedPanel(GUI frame){
 			setLayout(null);
 			
 			JLabel cardLabel = new JLabel("Frequenty Missed");
 			cardLabel.setHorizontalAlignment(SwingConstants.LEFT);
 			cardLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
 			cardLabel.setBounds(137, 11, 158, 29);
 			add(cardLabel);
 			
 			JButton quizButton = new JButton("Quiz");
 			quizButton.setBounds(138, 38, 147, 30);
 			add(quizButton);
 			
 			JButton practiceButton = new JButton("Practice");
 			practiceButton.setBounds(138, 78, 147, 30);
 			add(practiceButton);
 			
 			JButton backButton = new JButton("Back");
 			backButton.setBounds(138, 118, 147, 30);
 			add(backButton);
 			
 			quizButton.addActionListener( new ActionListener() {
 				public void actionPerformed(ActionEvent e){
 					frame.getContentPane().removeAll();
 					frame.add(new QuizPanel(frame));
 					frame.setVisible(true);
 				}
 			});
 			
 			practiceButton.addActionListener( new ActionListener() {
 				public void actionPerformed(ActionEvent e){
 					frame.getContentPane().removeAll();
 					frame.add(new PracticePanel(frame));
 					frame.setVisible(true);
 				}
 			});
 			
 			backButton.addActionListener( new ActionListener() {
 				public void actionPerformed(ActionEvent e){
 					deck = originalDeck;
 					frame.getContentPane().removeAll();
 					frame.add(new deckMenuPanel(frame));
 					frame.setVisible(true);
 				}
 			});
 		}
 	}
 	
 	public class categoryMenuPanel extends JPanel{
		public categoryMenuPanel(GUI frame){ 
			setLayout(null);
			JButton quizButton = new JButton("Quiz");
			quizButton.setBounds(138, 38, 147, 30);
			add(quizButton);
			
			JButton practiceButton = new JButton("Practice");
			practiceButton.setBounds(138, 78, 147, 30);
			add(practiceButton);
			
			JButton freqMissedButton = new JButton("Frequently Missed");
			freqMissedButton.setBounds(138, 118, 147, 30);
			add(freqMissedButton);
			
			JButton settingButton = new JButton("Quiz Settings");
			settingButton.setBounds(138, 158, 147, 30);
			add(settingButton);
			
			JButton backButton = new JButton("Back");
			backButton.setBounds(138, 198, 147, 30);
			add(backButton);
			
			
			JLabel catLabel = new JLabel(deck.getName());
			catLabel.setHorizontalAlignment(SwingConstants.CENTER);
			catLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			catLabel.setBounds(93, 11, 237, 25);
			add(catLabel);
			
			quizButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					frame.getContentPane().removeAll();
					frame.add(new QuizPanel(frame));
					frame.setVisible(true);
				}
			});
			
			practiceButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					frame.getContentPane().removeAll();
					frame.add(new PracticePanel(frame));
					frame.setVisible(true);
				}
			});
			
			freqMissedButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					originalDeck = deck;
					deck = user.createFreqMissed(deck);
					frame.getContentPane().removeAll();
					frame.add(new frequentlyMissedPanel(frame));
					frame.setVisible(true);
				}
			});
			
			settingButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					frame.getContentPane().removeAll();
					frame.add(new settingPanel(frame));
					frame.setVisible(true);
				}
			});
			
			backButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e){
					frame.getContentPane().removeAll();
					frame.add(new categoryPanel(frame));
					frame.setVisible(true);
				}
			});
		}
 	}

}
