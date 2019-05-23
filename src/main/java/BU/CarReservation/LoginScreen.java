package BU.CarReservation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.SwingConstants;

public class LoginScreen {

	private JFrame frmLogIn;
	private JTextField txtUserName;
	static ObjectMapper om = new ObjectMapper();
	static File customerFile = new File("Customers.txt");
	static ArrayList<Customer> customers = new ArrayList<Customer>();
	static Customer customer = null;
	private JPasswordField pwdPass;

	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.frmLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		om.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		if (customerFile.exists())
			customers = om.readValue(customerFile, new TypeReference<ArrayList<Customer>>() {
			});
	}

	/**
	 * Create the application.
	 */
	public LoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogIn = new JFrame();
		frmLogIn.setTitle("Log In");
		frmLogIn.setBounds(100, 100, 450, 300);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(61, 56, 74, 14);
		frmLogIn.getContentPane().add(lblUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(61, 112, 74, 14);
		frmLogIn.getContentPane().add(lblPassword);

		txtUserName = new JTextField();
		txtUserName.setBounds(145, 53, 86, 20);
		frmLogIn.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);

		JButton btnLogin = new JButton("Log In");
		btnLogin.setForeground(Color.BLUE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				if(customerFile.exists()) {
				while (i < customers.size()) {
					if (customers.get(i).getUserName().equals(txtUserName.getText())
							&& customers.get(i).getPass().equals(pwdPass.getText())) {
						customer = customers.get(i);
					}
					i++;
				}
				}
				if (txtUserName.getText().equals("admin") && pwdPass.getText().equals("admin")) {
					frmLogIn.dispose();
					try {
						AMainScreen.main(null);
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
				} else if (customer!=null) {
					frmLogIn.dispose();
					CMainScreen.main(null);
				}else
					JOptionPane.showMessageDialog(null, "Invaild user name or password");

			}
		});
		btnLogin.setBounds(281, 175, 89, 23);
		frmLogIn.getContentPane().add(btnLogin);

		JButton btnLogup = new JButton("Sign Up");
		btnLogup.setForeground(Color.RED);
		btnLogup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLogIn.dispose();
				SignUpScreen.main(null);

			}
		});
		btnLogup.setBounds(281, 214, 89, 23);
		frmLogIn.getContentPane().add(btnLogup);

		pwdPass = new JPasswordField();
		pwdPass.setBounds(145, 108, 84, 23);
		frmLogIn.getContentPane().add(pwdPass);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\noorheeh\\Desktop\\Server socket\\CarReservation\\LogSPhoto.jpg"));
		label.setLabelFor(frmLogIn.getContentPane());
		label.setBounds(0, 0, 434, 261);
		frmLogIn.getContentPane().add(label);
	}
}
