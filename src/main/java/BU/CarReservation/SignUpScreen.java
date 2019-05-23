package BU.CarReservation;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SignUpScreen {

	private JFrame frmSignUp;
	private JTextField txtName;
	private JTextField txtUsername;
	private JTextField txtPhonenum;
	private JPasswordField pwdPass;
	private JTextField txtAddress;
	private JTextField txtIdnum;
	static ObjectMapper om = new ObjectMapper();
	static File customerFile = new File("Customers.txt");
	static ArrayList<Customer> customers = new ArrayList<Customer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpScreen window = new SignUpScreen();
					window.frmSignUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public SignUpScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignUp = new JFrame();
		frmSignUp.getContentPane().setBackground(new Color(230, 230, 250));
		frmSignUp.setTitle("Sign Up");
		frmSignUp.setBounds(100, 100, 482, 349);
		frmSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignUp.getContentPane().setLayout(null);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(39, 34, 46, 14);
		frmSignUp.getContentPane().add(lblName);

		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(347, 34, 74, 14);
		frmSignUp.getContentPane().add(lblUserName);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(347, 91, 74, 14);
		frmSignUp.getContentPane().add(lblPassword);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(39, 63, 74, 14);
		frmSignUp.getContentPane().add(lblGender);

		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setBounds(39, 135, 74, 14);
		frmSignUp.getContentPane().add(lblBirthday);

		JLabel lblPhonNumber = new JLabel("Phone Number");
		lblPhonNumber.setBounds(39, 181, 103, 14);
		frmSignUp.getContentPane().add(lblPhonNumber);

		JLabel lblIdNumber = new JLabel("ID Number");
		lblIdNumber.setBounds(39, 250, 74, 14);
		frmSignUp.getContentPane().add(lblIdNumber);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(39, 216, 74, 14);
		frmSignUp.getContentPane().add(lblAddress);

		txtName = new JTextField();
		txtName.setBounds(152, 31, 123, 20);
		frmSignUp.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtUsername = new JTextField();
		txtUsername.setBounds(313, 60, 123, 20);
		frmSignUp.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		txtPhonenum = new JTextField();
		txtPhonenum.setBounds(152, 178, 123, 20);
		frmSignUp.getContentPane().add(txtPhonenum);
		txtPhonenum.setColumns(10);

		pwdPass = new JPasswordField();
		pwdPass.setBounds(313, 116, 123, 20);
		frmSignUp.getContentPane().add(pwdPass);

		txtAddress = new JTextField();
		txtAddress.setBounds(152, 213, 123, 20);
		frmSignUp.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);

		txtIdnum = new JTextField();
		txtIdnum.setBounds(152, 247, 123, 20);
		frmSignUp.getContentPane().add(txtIdnum);
		txtIdnum.setColumns(10);

		final JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(230, 230, 250));
		rdbtnMale.setBounds(152, 63, 57, 23);
		frmSignUp.getContentPane().add(rdbtnMale);

		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(230, 230, 250));
		rdbtnFemale.setBounds(152, 87, 86, 23);
		frmSignUp.getContentPane().add(rdbtnFemale);

		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(152, 135, 123, 20);
		frmSignUp.getContentPane().add(dateChooser);

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtAddress.getText() == null || txtIdnum.getText() == null || txtName.getText() == null
						|| txtPhonenum.getText() == null || txtUsername.getText() == null || pwdPass.getText() == null
						|| dateChooser.getDate() == null)
					JOptionPane.showMessageDialog(null, "Please, Enter all info");
				else {
				Customer c = new Customer();
				c.setName(txtName.getText());
				c.setUserName(txtUsername.getText());
				c.setPass(pwdPass.getText());
				c.setAddress(txtAddress.getText());
				c.setPhoneNum(txtPhonenum.getText());
				c.setIDNum(txtIdnum.getText());
				if (rdbtnMale.isSelected())
					c.setGender("Male");
				else
					c.setGender("Female");

				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				c.setBirthday(dateFormat.format(dateChooser.getDate()));
				int i = 0;
				boolean accessAdd = true;
				om.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
				try {
					if (customerFile.exists()) {
						customers = om.readValue(customerFile, new TypeReference<ArrayList<Customer>>() {
						});
						while (i < customers.size()) {
							if (customers.get(i).getName().equals(c.getName())) {
								JOptionPane.showMessageDialog(null, "This name already exists");
								accessAdd = false;
							}
							if (customers.get(i).getUserName().equals(txtUsername.getText())) {
								JOptionPane.showMessageDialog(null, "This User Name is taken");
								accessAdd = false;
							}
							i++;
						}
						
						if (accessAdd) {
							customers.add(c);
							om.enable(SerializationFeature.INDENT_OUTPUT);
							om.writeValue(new File("Customers.txt"), customers);
							JOptionPane.showMessageDialog(null, "Sign up Saccess");
						}
					} else {
						om.enable(SerializationFeature.INDENT_OUTPUT);
						om.writeValue(customerFile, c);
						JOptionPane.showMessageDialog(null, "Sign up Saccess");
					}

				} catch (JsonParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JsonMappingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}	
		});
		btnSignUp.setBounds(332, 161, 89, 23);
		frmSignUp.getContentPane().add(btnSignUp);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frmSignUp.dispose();
				try {
					LoginScreen.main(null);
				} catch (JsonParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JsonMappingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBack.setBounds(367, 276, 89, 23);
		frmSignUp.getContentPane().add(btnBack);
	}
}
