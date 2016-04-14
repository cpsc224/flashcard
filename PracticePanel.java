import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PracticePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public PracticePanel() {
		setLayout(null);
		
		JLabel practiceModeLabel = new JLabel("Practice Mode");
		practiceModeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		practiceModeLabel.setBounds(164, 28, 123, 16);
		add(practiceModeLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(66, 56, 324, 166);
		add(textPane);
		
		JButton quitButton = new JButton("Quit");
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		quitButton.setBounds(6, 265, 117, 29);
		add(quitButton);
		
		JButton flipButton = new JButton("Flip");
		flipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		flipButton.setBounds(186, 221, 90, 29);
		add(flipButton);
		
		JButton previousButton = new JButton("Previous");
		previousButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		previousButton.setBounds(84, 221, 90, 29);
		add(previousButton);
		
		JButton nextButton = new JButton("Next");
		nextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		nextButton.setBounds(288, 221, 90, 29);
		add(nextButton);

	}
}
