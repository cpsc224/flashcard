
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.List;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;

public class GroupUI extends JFrame {

	private JPanel contentPane;
	private JButton button;
	private JButton button_1;
	private JPanel panel;
	private JPanel newUserPanel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JPanel cards;
	private JPanel existingUserP;
	private JLabel lblNewLabel_2;
	private JButton btnBack_1;
	private JButton btnNewButton_1;
	private JPanel createNewDeck;
	private JLabel lblCreateNewDeck;
	private JLabel lblPleaseEnterDeck;
	private JTextField textField_1;
	private JPanel userMenu;
	private JLabel lblNewLabel_3;
	private JButton btnCreateNewDeck;
	private JButton btnViewDecks;
	private JButton btnCancel;
	private JButton btnCreate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupUI frame = new GroupUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GroupUI() {
		
		setTitle("Study Tool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		cards = new JPanel();
		contentPane.add(cards);
		cards.setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		cards.add(panel, "panel");
		
		JLabel lblWelcomeToThe = DefaultComponentFactory.getInstance().createLabel("Welcome to the Study Tool");
		
		
		button = new JButton("New User");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			CardLayout cl2 = (CardLayout)(cards.getLayout());
			cl2.show(cards, "newUserPanel");
			}
		});
		
		
		button_1 = new JButton("Existing User");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Allows user to delete an entry
			 */
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "existingUserP");
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
			
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(157)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(button, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(139)
							.addComponent(lblWelcomeToThe)))
					.addContainerGap(156, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(40)
					.addComponent(lblWelcomeToThe)
					.addGap(18)
					.addComponent(button)
					.addGap(18)
					.addComponent(button_1)
					.addContainerGap(115, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		newUserPanel = new JPanel();
		cards.add(newUserPanel, "newUserPanel");
		
		JLabel lblNewLabel = new JLabel("Create New User");
		lblNewLabel.setBounds(151, 35, 144, 14);
		newUserPanel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Please Enter Name:");
		lblNewLabel_1.setBounds(43, 83, 130, 14);
		newUserPanel.add(lblNewLabel_1);
		newUserPanel.add(lblNewLabel);
		
		btnBack_1 = new JButton("Cancel");
		btnBack_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl4 = (CardLayout)(cards.getLayout());
				cl4.show(cards, "panel");
			}
		});
		
		textField = new JTextField();
		String userName = textField.getText();
		textField.setBounds(171, 80, 230, 20);
		textField.setColumns(10);
		newUserPanel.add(textField);
		btnBack_1.setBounds(43, 190, 89, 23);
		newUserPanel.add(btnBack_1);
		
		btnNewButton_1 = new JButton("Create");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl4 = (CardLayout)(cards.getLayout());
				cl4.show(cards, "createNewDeck");
			}
		});
		btnNewButton_1.setBounds(312, 190, 89, 23);
		newUserPanel.add(btnNewButton_1);
		
		existingUserP = new JPanel();
		cards.add(existingUserP, "existingUserP");
		
		lblNewLabel_2 = new JLabel("Users");
		lblNewLabel_2.setBounds(198, 5, 100, 14);
		
		JList list = new JList();
		list.setBounds(136, 30, 178, 132);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CardLayout cl3 = (CardLayout)(cards.getLayout());
				cl3.show(cards, "panel");
			}
		});
		btnBack.setBounds(136, 173, 82, 23);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.setBounds(236, 173, 78, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		existingUserP.setLayout(null);
		existingUserP.add(lblNewLabel_2);
		existingUserP.add(list);
		existingUserP.add(btnBack);
		existingUserP.add(btnNewButton);
		
		createNewDeck = new JPanel();
		cards.add(createNewDeck, "createNewDeck");
		createNewDeck.setLayout(null);
		
		lblCreateNewDeck = new JLabel("Create New Deck");
		lblCreateNewDeck.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCreateNewDeck.setBounds(144, 11, 157, 14);
		createNewDeck.add(lblCreateNewDeck);
		
		lblPleaseEnterDeck = new JLabel("Please Enter Deck Name:");
		lblPleaseEnterDeck.setBounds(20, 108, 175, 14);
		createNewDeck.add(lblPleaseEnterDeck);
		
		textField_1 = new JTextField();
		textField_1.setBounds(20, 133, 367, 20);
		createNewDeck.add(textField_1);
		textField_1.setColumns(10);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl5 = (CardLayout)(cards.getLayout());
				cl5.show(cards, "userMenu");
			}
		});
		btnCancel.setBounds(20, 201, 89, 23);
		createNewDeck.add(btnCancel);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(298, 201, 89, 23);
		createNewDeck.add(btnCreate);
		
		userMenu = new JPanel();
		cards.add(userMenu, "userMenu");
		userMenu.setLayout(null);
		
		lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setText(userName);
		lblNewLabel_3.setBounds(120, 11, 183, 16);
		userMenu.add(lblNewLabel_3);
		
		btnCreateNewDeck = new JButton("Create New Deck");
		btnCreateNewDeck.setBounds(141, 36, 137, 23);
		userMenu.add(btnCreateNewDeck);
		
		btnViewDecks = new JButton("View Decks");
		btnViewDecks.setBounds(141, 70, 137, 23);
		userMenu.add(btnViewDecks);
	
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
