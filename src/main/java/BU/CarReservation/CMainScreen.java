package BU.CarReservation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.naming.ldap.Rdn;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CMainScreen {

	private JFrame frame;
	static ArrayList<Car> cars = new ArrayList<Car>();
	static Car selectCar = new Car();
	static Reserve reserve = new Reserve();
	static JRadioButton rdbtnMercedes;
	static JRadioButton rdbtnBmw;
	static JRadioButton rdbtnVolkswagen;
	static JRadioButton rdbtnDodge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CMainScreen window = new CMainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		cars.add(new Car("BMW", "M6", "4.4LV-8", "Silver", "2017", 5, 150));
		cars.add(new Car("Mercedes", "C 63", "4.0LV-8", "Black", "2019", 5, 110));
		cars.add(new Car("Volkswagen", "Golf GTI", "2.0LV-8", "Night Blue", "2018", 5, 90));
		cars.add(new Car("Dodge", "Challenger", "5.7LV-8", "White", "2019", 5, 130));
	}

	/**
	 * Create the application.
	 */
	public CMainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 730, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblSelectACar = new JLabel("Select a car:");
		lblSelectACar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectACar.setBounds(48, 25, 562, 31);
		frame.getContentPane().add(lblSelectACar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\noorheeh\\Desktop\\Server socket\\CarReservation\\BMW.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(28, 100, 200, 120);
		frame.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\noorheeh\\Desktop\\Server socket\\CarReservation\\Mercedes.jpg"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(321, 100, 200, 120);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon("C:\\Users\\noorheeh\\Desktop\\Server socket\\CarReservation\\volkswagen.jpg"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(48, 265, 200, 120);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("New label");
		label_2.setIcon(new ImageIcon("C:\\Users\\noorheeh\\Desktop\\Server socket\\CarReservation\\dodge.jpg"));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(321, 265, 200, 120);
		frame.getContentPane().add(label_2);

		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectCar(cars);
				reserve.setCustomer(LoginScreen.customer);
				reserve.setCar(selectCar);
				try {
					ReseveScreen.main(null);
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
		btnSelect.setBounds(570, 309, 89, 23);
		frame.getContentPane().add(btnSelect);

		rdbtnMercedes = new JRadioButton("Mercedes");
		rdbtnMercedes.setBackground(Color.WHITE);
		rdbtnMercedes.setBounds(356, 235, 109, 23);
		frame.getContentPane().add(rdbtnMercedes);

		rdbtnBmw = new JRadioButton("BMW");
		rdbtnBmw.setBackground(Color.WHITE);
		rdbtnBmw.setBounds(79, 235, 109, 23);
		frame.getContentPane().add(rdbtnBmw);

		rdbtnVolkswagen = new JRadioButton("Volkswagen");
		rdbtnVolkswagen.setBackground(Color.WHITE);
		rdbtnVolkswagen.setBounds(79, 392, 109, 23);
		frame.getContentPane().add(rdbtnVolkswagen);

		rdbtnDodge = new JRadioButton("Dodge");
		rdbtnDodge.setBackground(Color.WHITE);
		rdbtnDodge.setBounds(356, 392, 109, 23);
		frame.getContentPane().add(rdbtnDodge);

		JButton btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SelectCar(cars);
				final CarInfoScreen tes = new CarInfoScreen();
				tes.setVisible(true);
				CarInfoScreen.txtBrand.setText(selectCar.getBrand());
				CarInfoScreen.txtModel.setText(selectCar.getModel());
				CarInfoScreen.txtEngine.setText(selectCar.getEngin());
				CarInfoScreen.txtColor.setText(selectCar.getColor());
				CarInfoScreen.txtSeating.setText(Integer.toString(selectCar.getSeating()));
				CarInfoScreen.txtYear.setText(selectCar.getYear());
				CarInfoScreen.txtPrice.setText(Integer.toString(selectCar.getPrice()));

				tes.button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						tes.dispose();
					}
				});

			}
		});

		btnInfo.setBounds(570, 359, 89, 23);
		frame.getContentPane().add(btnInfo);

	}

	public static Car SelectCar(ArrayList<Car> cars) {
		String selectedCar = null;
		if (rdbtnBmw.isSelected())
			selectedCar = rdbtnBmw.getText();
		else if (rdbtnDodge.isSelected())
			selectedCar = rdbtnDodge.getText();
		else if (rdbtnMercedes.isSelected())
			selectedCar = rdbtnMercedes.getText();
		else if (rdbtnVolkswagen.isSelected())
			selectedCar = rdbtnVolkswagen.getText();
		else
			JOptionPane.showMessageDialog(null, "Please, Select a car");

		if (selectedCar != null) {
			for (int i = 0; i < cars.size(); i++) {
				if (cars.get(i).getBrand().equals(selectedCar))
					selectCar = cars.get(i);
			}
		}
		return selectCar;
	}
}
