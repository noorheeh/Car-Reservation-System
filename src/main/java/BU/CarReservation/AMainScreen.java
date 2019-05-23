package BU.CarReservation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AMainScreen {

	private JFrame frmMainScreen;
	private JTable table;
	static ObjectMapper om = new ObjectMapper();
	static File reservationFile = new File("reservation.txt");
	static ArrayList<Reserve> reserveList = new ArrayList<Reserve>();
	static Reserve reserve = null;


	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AMainScreen window = new AMainScreen();
					window.frmMainScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		om.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		if (reservationFile.exists()) {
			reserveList = om.readValue(reservationFile, new TypeReference<ArrayList<Reserve>>() {
			});
		}
	}

	/**
	 * Create the application.
	 */
	public AMainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainScreen = new JFrame();
		frmMainScreen.setTitle("Main Screen");
		frmMainScreen.setBounds(100, 100, 725, 468);
		frmMainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainScreen.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 56, 584, 181);
		frmMainScreen.getContentPane().add(scrollPane);
		DefaultTableModel model =new DefaultTableModel();
		table = new JTable(model);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Customer Name", "Car Brand", "Car Model", "From", "To" }));
		scrollPane.setViewportView(table);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numCols=table.getModel().getColumnCount();
				if (reservationFile.exists()) {			
					for (int i = 0; i < reserveList.size(); i++) {
						Object[] o=new Object[numCols];
						o[0]=reserveList.get(i).getCustomer().getName();
						o[1]=reserveList.get(i).getCar().getBrand();
						o[2]=reserveList.get(i).getCar().getModel();
						o[3]=reserveList.get(i).getStartDate();
						o[4]=reserveList.get(i).getEndDate();
						((DefaultTableModel) table.getModel()).addRow(o);
					}
				}else {
					Object[] o=new Object[numCols];
					o[0]="ok";
					o[1]="ok";
					o[2]="ok";
					o[3]="ok";
					o[4]="ok";
					((DefaultTableModel) table.getModel()).addRow(o);
				}
			}
		});
		btnShow.setBounds(545, 270, 89, 23);
		frmMainScreen.getContentPane().add(btnShow);

	}
}
