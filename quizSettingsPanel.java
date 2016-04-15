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
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class quizSettingPanel extends JPanel{
	public quizSettingPanel(GUI frame){ 
	setLayout(null);
		
		JLabel quizSettingsButton = new JLabel("Quiz Settings");
		quizSettingsButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		quizSettingsButton.setBounds(139, 28, 179, 20);
		add(quizSettingsButton);

		JButton backButton = new JButton("Back");
		backButton.setBounds(12, 230, 112, 25);
		add(backButton);

		JButton saveButton = new JButton("Save");
		saveButton.setBounds(310, 230, 112, 25);
		add(saveButton);
		
		JRadioButton rdbtnTextField = new JRadioButton("Text Field");
		rdbtnTextField.setBounds(139, 78, 109, 23);
		add(rdbtnTextField);
		
		JRadioButton rdbtnManual = new JRadioButton("Manual");
		rdbtnManual.setBounds(139, 116, 109, 23);
		add(rdbtnManual);
		
		if(deck.getIsManual(true)){
			rdbtnManual.setSelected(true);
		}
		else
			rdbtnTextField.setSelected(true);

		rdbtnTextField.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
				deck.setManualOff();		
		}
		});
		
		rdbtnManual.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
				deck.setManualOn();
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