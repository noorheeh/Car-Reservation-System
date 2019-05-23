package BU.CarReservation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.core.JsonGenerationException;
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
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ReseveScreen {

	static JFrame frmReservation;
	static Reserve reserve = CMainScreen.reserve;
	static ArrayList<Reserve> reserveList = new ArrayList<Reserve>();
	static File reservationFile = new File("reservation.txt");
	static ObjectMapper om = new ObjectMapper();

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
					ReseveScreen window = new ReseveScreen();
					window.frmReservation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		if (reservationFile.exists())
			om.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
			reserveList = om.readValue(reservationFile, new TypeReference<ArrayList<Reserve>>() {
			});
	}

	/**
	 * Create the application.
	 */
	public ReseveScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReservation = new JFrame();
		frmReservation.setTitle("Reservation");
		frmReservation.setBounds(100, 100, 450, 300);
		frmReservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReservation.getContentPane().setLayout(null);

		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(52, 66, 46, 14);
		frmReservation.getContentPane().add(lblFrom);

		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(52, 112, 46, 14);
		frmReservation.getContentPane().add(lblTo);

		final JDateChooser dateChooserFrom = new JDateChooser();
		dateChooserFrom.setBounds(108, 66, 91, 20);
		frmReservation.getContentPane().add(dateChooserFrom);

		final JDateChooser dateChooserTo = new JDateChooser();
		dateChooserTo.setBounds(108, 112, 91, 20);
		frmReservation.getContentPane().add(dateChooserTo);

		final JButton btnTotalPrice = new JButton("Total Price");
		btnTotalPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				reserve.setStartDate(dateFormat.format(dateChooserFrom.getDate()));
				reserve.setEndDate(dateFormat.format(dateChooserTo.getDate()));
				int totalDays = 0;
				try {
					java.util.Date startDate = dateFormat.parse(reserve.getStartDate());
					java.util.Date endDate = dateFormat.parse(reserve.getEndDate());
					totalDays = (int) (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Integer totalPrice = totalDays * reserve.getCar().getPrice();
				btnTotalPrice.setText(totalPrice.toString()+" $");

			}
		});
		btnTotalPrice.setBounds(83, 180, 116, 23);
		frmReservation.getContentPane().add(btnTotalPrice);

		JLabel lblPayBy = new JLabel("Pay by:");
		lblPayBy.setBounds(304, 66, 46, 14);
		frmReservation.getContentPane().add(lblPayBy);

		JButton btnPaypal = new JButton("PayPal");
		btnPaypal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reserveList.add(reserve);
				om.enable(SerializationFeature.INDENT_OUTPUT);
				try {
					om.writeValue(new File("reservation.txt"), reserveList);
				} catch (JsonGenerationException e1) {
					e1.printStackTrace();
				} catch (JsonMappingException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JFrame PayPalframe=new JFrame();
				PayPalframe.setVisible(true);
				JPanel PayPal;
				 JTextField txtEmail;
				 JPasswordField passwordField;
				 PayPalframe.setTitle("PayPal");
				 PayPalframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				 PayPalframe.setBounds(100, 100, 402, 258);
				 PayPalframe.getContentPane().setLayout(null);
				PayPal = new JPanel();
				PayPal.setBorder(new EmptyBorder(5, 5, 5, 5));
				PayPalframe.setContentPane(PayPal);
				PayPal.setLayout(null);

				JLabel lblEmail = new JLabel("Email");
				lblEmail.setBounds(43, 74, 46, 14);
				PayPal.add(lblEmail);

				JLabel lblPass = new JLabel("Pass");
				lblPass.setBounds(43, 124, 46, 14);
				PayPal.add(lblPass);

				txtEmail = new JTextField();
				txtEmail.setBounds(111, 71, 150, 20);
				PayPal.add(txtEmail);
				txtEmail.setColumns(10);

				passwordField = new JPasswordField();
				passwordField.setBounds(111, 122, 150, 20);
				PayPal.add(passwordField);
				JButton btnReserve = new JButton("Reserve");
				btnReserve.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JOptionPane.showMessageDialog(null, "Reservation done");

					}
				});

				btnReserve.setBounds(287, 185, 89, 23);
				PayPal.add(btnReserve);
			}
		});
		btnPaypal.setBounds(304, 92, 105, 23);
		frmReservation.getContentPane().add(btnPaypal);
	}
}
