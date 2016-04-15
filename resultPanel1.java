import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

import GUI.openPanel;

import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class resultPanel1 extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public resultPanel1() {
		setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		/*		frame.getContentPane().removeAll();
				frame.add(new openPanel(frame));
				frame.setVisible(true);*/
			}
		});
		btnBack.setBounds(168, 241, 117, 29);
		add(btnBack);
		
		JButton button = new JButton("<-");
		button.setBounds(39, 241, 117, 29);
		add(button);
		
		JButton button_1 = new JButton("->");
		button_1.setBounds(297, 241, 117, 29);
		add(button_1);
		
		JLabel resultsLabel = new JLabel("RESULTS:");
		resultsLabel.setBounds(190, 19, 61, 16);
		add(resultsLabel);
		
		
	
		
		String[] columnNames = {"Attempt", "Score"};
		int attempt = 1;
		
	/*	ArrayList scoring = deck.getResults();
		Object[][] data; // = new Object[][]();
		for (int i = 0; i < scoring.size(); i++)
		{
			 data[i][i] = {
			{scoring.get(i), attempt}
			
				};	
			attempt++;
		}
		*/
		
		Object[] [] data = {
				{"Beyonce", "Grown Woman", "4"},
				{"Nicki Minaj", "Anaconda", "Pinkprint"},
				{"Drake", "One Dance", "View of the 6"}
		};
	
		 table = new JTable(data, columnNames);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(88, 70, 244, 100);
		add(scrollPane);
	}
}
