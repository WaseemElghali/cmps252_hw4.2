// IAN: 40
package cmps252.HW4_2;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Comparators.AddressComparator;
import Comparators.CityComparator;
import Comparators.CompanyComparator;
import Comparators.CountyComparator;
import Comparators.EmailComparator;
import Comparators.FaxComparator;
import Comparators.FirstNameComparator;
import Comparators.LastNameComparator;
import Comparators.PhoneComparator;
import Comparators.StateComparator;
import Comparators.WebComparator;
import Comparators.ZIPComparator;
import cmps252.HW4_2.UnitTesting.Configuration;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;

public class RecordBrowser {

	JFrame frame;
	private JTextField SearchBar;
	private JTextField FirstNameField;
	private JTextField LastNameField;
	private JTextField CompanyField;
	private JTextField CityField;
	private JTextField AddressField;
	private JTextField PhoneField;
	private JTextField StateField;
	private JTextField ZIPField;
	private JTextField CountyField;
	private JTextField WebField;
	private JTextField FaxField;
	private JTextField EmailField;
	private JTextField RecordNumber;
	private ArrayList<Customer> Records;
	JLabel lblNewLabel;
	int position = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecordBrowser window = new RecordBrowser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RecordBrowser() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize() throws FileNotFoundException {
		frame = new JFrame();
		Records = FileParser.getCustomers(Configuration.CSV_File);
		frame.getContentPane().addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				int notches = arg0.getWheelRotation();
			       if (notches < 0) { // checks if the wheel moved forward
			    	   if(position == 4999) {
							position = 0;
						} else {
							position++;
						}
						displayCustomer(position);
						lblNewLabel.setText("Record "+(position+1)+" of 5000");
			       } else { // if it moves backwards
			    	   if(position == 0) { // an if statement to prevent index out of bounds error and maintain continuity
							position = 4999;
						} else {
							position--; // decreases the position by 1
						}
			    	   displayCustomer(position);
			    	   lblNewLabel.setText("Record "+(position+1)+" of 5000");
			       }
			}
		});
		frame.setBounds(100, 100, 503, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(20, 317, 173, 21);
		frame.getContentPane().add(panel);

		lblNewLabel = new JLabel("Record 0 of 0");
		panel.add(lblNewLabel);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		frame.getContentPane().setLayout(null);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 487, 25);
		frame.getContentPane().add(toolBar);

		JButton button = new JButton("<<");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				position = 0; // sets the position to 0
				displayCustomer(position);
				lblNewLabel.setText("Record "+(position+1)+" of 5000");
			}
		});
		button.setBackground(SystemColor.controlHighlight);
		toolBar.add(button);

		JSeparator separator = new JSeparator();
		toolBar.add(separator);

		JButton button_1 = new JButton("<");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(position == 0) { // an if statement to prevent index out of bounds error and maintain continuity
					position = 4999;
				} else {
					position--; // decreases the position by 1
				}
				displayCustomer(position);
				lblNewLabel.setText("Record "+(position+1)+" of 5000");
			}
		});
		button_1.setBackground(SystemColor.controlHighlight);
		toolBar.add(button_1);

		JSeparator separator_1 = new JSeparator();
		toolBar.add(separator_1);

		JButton button_2 = new JButton(">");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(position == 4999) {
					position = 0;
				} else {
					position++;
				}
				displayCustomer(position);
				lblNewLabel.setText("Record "+(position+1)+" of 5000");
			}
		});
		button_2.setBackground(SystemColor.controlHighlight);
		toolBar.add(button_2);

		JSeparator separator_2 = new JSeparator();
		toolBar.add(separator_2);

		JButton button_3 = new JButton(">>");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { // same as the "<" button but for moving forward
				position = 4999;
				displayCustomer(position);
				lblNewLabel.setText("Record "+(position+1)+" of 5000");
			}
		});
		button_3.setBackground(SystemColor.controlHighlight);
		toolBar.add(button_3);

		JSeparator separator_3 = new JSeparator();
		toolBar.add(separator_3);

		SearchBar = new JTextField();
		toolBar.add(SearchBar);
		SearchBar.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				for(int index = 0;index < 5000; index++) { // for loop to check for the phone number in the array
					if (Records.get(index).getPhone().equals(SearchBar.getText())){
						displayCustomer(index);
						lblNewLabel.setText("Record "+(index+1)+" of 5000");
						break;
					} else if (!Records.get(index).getPhone().equals(SearchBar.getText()) && index == 4999){
						JOptionPane.showMessageDialog(null, "Number not found.");
					}
				}
			}
		});
		btnSearch.setBackground(UIManager.getColor("Button.light"));
		toolBar.add(btnSearch);

		JSeparator separator_4 = new JSeparator();
		toolBar.add(separator_4);

		JLabel lblSort = new JLabel("Sort");
		toolBar.add(lblSort);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "FirstName", "LastName", "Company", "Address",
				"City", "County", "State", "ZIP", "Phone", "Fax", "Email", "Web" }));
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // sorts the customers array according to what the user selects from the JComboBox
				if (comboBox.getSelectedItem().equals("First Name")) { // an if/else if block that sorts the Customers array according to what the user chooses from the combo box
					Collections.sort(Records, new FirstNameComparator());
				} else if (comboBox.getSelectedItem().equals("Last Name")) {
					Collections.sort(Records, new LastNameComparator());
				} else if (comboBox.getSelectedItem().equals("Company")) {
					Collections.sort(Records, new CompanyComparator());
				} else if (comboBox.getSelectedItem().equals("Address")) {
					Collections.sort(Records, new AddressComparator());
				} else if (comboBox.getSelectedItem().equals("City")) {
					Collections.sort(Records, new CityComparator());
				} else if (comboBox.getSelectedItem().equals("County")) {
					Collections.sort(Records, new CountyComparator());
				} else if (comboBox.getSelectedItem().equals("State")) {
					Collections.sort(Records, new StateComparator());
				} else if (comboBox.getSelectedItem().equals("Phone")) {
					Collections.sort(Records, new PhoneComparator());
				} else if (comboBox.getSelectedItem().equals("ZIP")) {
					Collections.sort(Records, new ZIPComparator());
				} else if (comboBox.getSelectedItem().equals("Web")) {
					Collections.sort(Records, new WebComparator());
				} else if (comboBox.getSelectedItem().equals("Fax")) {
					Collections.sort(Records, new FaxComparator());
				} else if (comboBox.getSelectedItem().equals("Email")) {
					Collections.sort(Records, new EmailComparator());
				}
			}
		});
		toolBar.add(comboBox);
		JCheckBox chckbxDescending = new JCheckBox("Descending");
		chckbxDescending.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				 Collections.reverse(Records); // reverses the list
			}
		});
		toolBar.add(chckbxDescending);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(20, 36, 77, 14);
		frame.getContentPane().add(lblFirstName);

		FirstNameField = new JTextField();
		FirstNameField.setBackground(Color.WHITE);
		FirstNameField.setBounds(20, 50, 173, 20);
		frame.getContentPane().add(FirstNameField);
		FirstNameField.setColumns(10);

		LastNameField = new JTextField();
		LastNameField.setBackground(Color.WHITE);
		LastNameField.setColumns(10);
		LastNameField.setBounds(236, 50, 173, 20);
		frame.getContentPane().add(LastNameField);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(237, 36, 75, 14);
		frame.getContentPane().add(lblLastName);

		CompanyField = new JTextField();
		CompanyField.setBackground(Color.WHITE);
		CompanyField.setColumns(10);
		CompanyField.setBounds(20, 88, 173, 20);
		frame.getContentPane().add(CompanyField);

		JLabel lblCompany = new JLabel("Company");
		lblCompany.setBounds(20, 73, 60, 14);
		frame.getContentPane().add(lblCompany);

		CityField = new JTextField();
		CityField.setBackground(Color.WHITE);
		CityField.setColumns(10);
		CityField.setBounds(20, 162, 173, 20);
		frame.getContentPane().add(CityField);

		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(20, 148, 60, 14);
		frame.getContentPane().add(lblCity);

		AddressField = new JTextField();
		AddressField.setBackground(Color.WHITE);
		AddressField.setColumns(10);
		AddressField.setBounds(20, 124, 173, 20);
		frame.getContentPane().add(AddressField);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(20, 109, 60, 14);
		frame.getContentPane().add(lblAddress);

		PhoneField = new JTextField();
		PhoneField.setBackground(Color.WHITE);
		PhoneField.setColumns(10);
		PhoneField.setBounds(20, 245, 173, 20);
		frame.getContentPane().add(PhoneField);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(20, 231, 60, 14);
		frame.getContentPane().add(lblPhone);

		StateField = new JTextField();
		StateField.setBackground(Color.WHITE);
		StateField.setColumns(10);
		StateField.setBounds(20, 207, 173, 20);
		frame.getContentPane().add(StateField);

		JLabel lblState = new JLabel("State");
		lblState.setBounds(20, 193, 60, 14);
		frame.getContentPane().add(lblState);

		ZIPField = new JTextField();
		ZIPField.setBackground(Color.WHITE);
		ZIPField.setColumns(10);
		ZIPField.setBounds(236, 207, 173, 20);
		frame.getContentPane().add(ZIPField);

		JLabel lblZIP = new JLabel("ZIP");
		lblZIP.setBounds(237, 193, 60, 14);
		frame.getContentPane().add(lblZIP);

		CountyField = new JTextField();
		CountyField.setBackground(Color.WHITE);
		CountyField.setColumns(10);
		CountyField.setBounds(236, 162, 173, 20);
		frame.getContentPane().add(CountyField);

		JLabel lblCounty = new JLabel("County");
		lblCounty.setBounds(237, 148, 60, 14);
		frame.getContentPane().add(lblCounty);

		WebField = new JTextField();
		WebField.setBackground(Color.WHITE);
		WebField.setColumns(10);
		WebField.setBounds(236, 286, 173, 20);
		frame.getContentPane().add(WebField);

		JLabel lblWeb = new JLabel("Web");
		lblWeb.setBounds(237, 272, 60, 14);
		frame.getContentPane().add(lblWeb);

		FaxField = new JTextField();
		FaxField.setBackground(Color.WHITE);
		FaxField.setColumns(10);
		FaxField.setBounds(236, 245, 173, 20);
		frame.getContentPane().add(FaxField);

		JLabel lblFax = new JLabel("Fax");
		lblFax.setBounds(237, 231, 60, 14);
		frame.getContentPane().add(lblFax);

		EmailField = new JTextField();
		EmailField.setBackground(Color.WHITE);
		EmailField.setColumns(10);
		EmailField.setBounds(20, 286, 173, 20);
		frame.getContentPane().add(EmailField);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 272, 60, 14);
		frame.getContentPane().add(lblEmail);

		RecordNumber = new JTextField();
		RecordNumber.setBounds(203, 317, 125, 21);
		frame.getContentPane().add(RecordNumber);
		RecordNumber.setColumns(10);

		JButton btnGo = new JButton("Go To");
		btnGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				position = Integer.parseInt(RecordNumber.getText()); // sets the position to the desired number on the
																		// field provided
				displayCustomer(position - 1);
				lblNewLabel.setText("Record " + (position) + " of 5000");
				RecordNumber.setText("");
			}
		});
		btnGo.setBounds(338, 317, 89, 23);
		frame.getContentPane().add(btnGo);
	}
	
	public void displayCustomer(int position) { // method sets the fields to their appropriate values according to the current position
		FirstNameField.setText(Records.get(position).getFirstName());
		LastNameField.setText(Records.get(position).getLastName());
		CompanyField.setText(Records.get(position).getCompany());
		AddressField.setText(Records.get(position).getAddress());
		CityField.setText(Records.get(position).getCity());
		StateField.setText(Records.get(position).getState());
		PhoneField.setText(Records.get(position).getPhone());
		EmailField.setText(Records.get(position).getEmail());
		ZIPField.setText(Records.get(position).getZIP());
		CountyField.setText(Records.get(position).getCounty());
		FaxField.setText(Records.get(position).getFax());
		WebField.setText(Records.get(position).getWeb());
	}
}
