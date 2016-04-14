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
import javax.swing.SwingConstants;



public class editPanel extends JPanel{
		public editPanel(GUI frame){ 
				setLayout(null);
				JButton addCardButton = new JButton("Add Card");
				addCardButton.setBounds(138, 38, 147, 35);
				add(addCardButton);
				
				JButton removeCardButton = new JButton("Remove Cards");
				removeCardButton.setBounds(138, 79, 147, 35);
				add(removeCardButton);
				
				JButton editCardButton = new JButton("Edit Cards");
				editCardButton.setBounds(138, 121, 147, 35);
				add(editCardButton);
				
				JButton renameDeckButton = new JButton("Rename Deck");
				renameDeckButton.setBounds(138, 164, 147, 35);
				add(renameDeckButton);
				
				JButton quizSettingButton = new JButton("Quiz Settings");
				quizSettingButton.setBounds(138, 208, 147, 35);
				add(quizSettingButton);
				
				JButton backButton = new JButton("Back");
				backButton.setBounds(138, 252, 147, 35);
				add(backButton);
				
				JLabel userNameLabel = new JLabel("Edit");
				userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
				userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
				userNameLabel.setBounds(93, 11, 237, 25);
				add(userNameLabel);
			
				addCardButton.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e){
						frame.getContentPane().removeAll();
						frame.add(new quizPanel(frame));
						frame.setVisible(true);
					}
				});
				
				removeCardButton.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e){
						frame.getContentPane().removeAll();
						frame.add(new practicePanel(frame));
						frame.setVisible(true);
					}
				});
				
				editCardButton.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e){
						frame.getContentPane().removeAll();
						frame.add(new editPanel(frame));
						frame.setVisible(true);
					}
				});
				
				renameDeckButton.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e){
						frame.getContentPane().removeAll();
						frame.add(new frequentlyMissedPanel(frame));
						frame.setVisible(true);
					}
				});
				
				quizSettingButton.addActionListener( new ActionListener() {
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
public class deckMenuPanel extends JPanel{
	public deckMenuPanel(GUI frame){ 
		setLayout(null);
		JButton quizButton = new JButton("Quiz");
		quizButton.setBounds(138, 38, 147, 35);
		add(quizButton);
		
		JButton practiceButton = new JButton("Practice");
		practiceButton.setBounds(138, 79, 147, 35);
		add(practiceButton);
		
		JButton editButton = new JButton("Edit");
		editButton.setBounds(138, 121, 147, 35);
		add(editButton);
		
		JButton viewCategoriesButton = new JButton("Frequently Missed");
		viewCategoriesButton.setBounds(138, 164, 147, 35);
		add(viewCategoriesButton);
		
		JButton resultsButton = new JButton("Results");
		resultsButton.setBounds(138, 208, 147, 35);
		add(resultsButton);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(138, 252, 147, 35);
		add(backButton);
		
		JLabel userNameLabel = new JLabel(deck.getName()));
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userNameLabel.setBounds(93, 11, 237, 25);
		add(userNameLabel);
	
		quizButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.add(new quizPanel(frame));
				frame.setVisible(true);
			}
		});
		
		practiceButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.add(new practicePanel(frame));
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
		
		viewCategoriesButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
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
		createNewDeckButton.setBounds(138, 59, 147, 35);
		add(createNewDeckButton);
		
		JButton viewDeckButton = new JButton("View Decks");
		viewDeckButton.setBounds(138, 105, 147, 35);
		add(viewDeckButton);
		
		JButton resultsButton = new JButton("Results");
		resultsButton.setBounds(138, 151, 147, 35);
		add(resultsButton);
		
		JButton viewCategoriesButton = new JButton("View Categories");
		viewCategoriesButton.setBounds(138, 197, 147, 35);
		add(viewCategoriesButton);
		
		JButton signOutButton = new JButton("Sign Out");
		signOutButton.setBounds(138, 243, 147, 35);
		add(signOutButton);
		
		JLabel userNameLabel = new JLabel("Andrea");//user.getUserName()));
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
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