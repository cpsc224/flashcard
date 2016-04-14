import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuizPanel extends JPanel {
	private JTextField answerTextField;
	private JLabel answerLabel;
	private JButton submitButton, quitButton, checkAnswerButton, correctButton, incorrectButton;
	/**
	 * Create the panel.
	 */
	public QuizPanel() {
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
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		quitButton.setBounds(6, 262, 75, 29);
		add(quitButton);
		
		checkAnswerButton = new JButton("Check Answer");
		checkAnswerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		checkAnswerButton.setBounds(171, 230, 117, 29);
		add(checkAnswerButton);
		
		correctButton = new JButton("Correct");
		correctButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		correctButton.setBounds(114, 230, 117, 29);
		add(correctButton);
		
		incorrectButton = new JButton("Incorrect");
		incorrectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
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
