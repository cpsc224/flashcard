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
public class changeCategoryPanel extends JPanel{
	public changeCategoryPanel(GUI frame){ 
setLayout(null);

JLabel changeCatButton = new JLabel("Change Category");
changeCatButton.setFont(new Font("Tahoma", Font.BOLD, 16));
changeCatButton.setBounds(139, 28, 179, 20);
add(changeCatButton);

JLabel deckLabel = new JLabel("Please Enter New Category Name:");
deckLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
deckLabel.setBounds(12, 72, 232, 27);
add(deckLabel);

JTextField catTextField = new JTextField();
catTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
catTextField.setColumns(10);
catTextField.setBounds(12, 110, 267, 27);
add(catTextField);

JButton backButton = new JButton("Back");
backButton.setBounds(12, 230, 112, 25);
add(backButton);

JButton createButton = new JButton("Update");
createButton.setBounds(310, 230, 112, 25);
add(createButton);

createButton.addActionListener( new ActionListener() {
	public void actionPerformed(ActionEvent e){
		String cat = catTextField.getText();
		if(cat.equals("")) {
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
			String name = deck.getName();
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
		frame.add(new editPanel(frame));
		frame.setVisible(true);
	}
});
	}	
}
