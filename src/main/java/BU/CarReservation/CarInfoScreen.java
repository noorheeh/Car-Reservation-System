package BU.CarReservation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarInfoScreen extends JFrame {

	public static JPanel contentPane;
	public static JTextField txtBrand;
	public static JTextField txtModel;
	public static JTextField txtEngine;
	public static JTextField txtSeating;
	public static JTextField txtYear;
	public static JTextField txtColor;
	public static JTextField txtPrice;
	public static JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarInfoScreen frame = new CarInfoScreen();
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
	public CarInfoScreen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Model:");
		label.setBounds(31, 74, 46, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Brand:");
		label_1.setBounds(31, 40, 46, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Color");
		label_2.setBounds(31, 218, 46, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Seating");
		label_3.setBounds(31, 153, 46, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Engine:");
		label_4.setBounds(31, 115, 46, 14);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("Year:");
		label_5.setBounds(31, 182, 46, 14);
		contentPane.add(label_5);

		button = new JButton("Back");
		button.setBounds(303, 209, 89, 23);
		contentPane.add(button);

		JLabel label_6 = new JLabel("Price:");
		label_6.setBounds(255, 131, 46, 14);
		contentPane.add(label_6);

		txtBrand = new JTextField();
		txtBrand.setBounds(107, 37, 86, 20);
		contentPane.add(txtBrand);
		txtBrand.setColumns(10);

		txtModel = new JTextField();
		txtModel.setBounds(107, 70, 89, 23);
		contentPane.add(txtModel);
		txtModel.setColumns(10);

		txtEngine = new JTextField();
		txtEngine.setBounds(107, 112, 89, 23);
		contentPane.add(txtEngine);
		txtEngine.setColumns(10);

		txtSeating = new JTextField();
		txtSeating.setBounds(107, 150, 89, 23);
		contentPane.add(txtSeating);
		txtSeating.setColumns(10);

		txtYear = new JTextField();
		txtYear.setBounds(107, 179, 86, 23);
		contentPane.add(txtYear);
		txtYear.setColumns(10);

		txtColor = new JTextField();
		txtColor.setBounds(107, 215, 86, 23);
		contentPane.add(txtColor);
		txtColor.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.setBounds(303, 128, 86, 23);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
	}
}
