package Management;
import Management.LoginPage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Container;

import javax.swing.UIManager;

public class Paymentpage extends JFrame {
private JDateChooser dateChooser;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField textField;
	static JTextField textField_1;
	private JTextField textField_4;
		private JLabel lbltitle,lblEnterYourDob;
		private JDateChooser dateChooser_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paymentpage frame = new Paymentpage();
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
	public Paymentpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter your First Name :");
		lblNewLabel.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblNewLabel.setBounds(120, 123, 146, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterYourLast = new JLabel("Enter your Last Name :");
		lblEnterYourLast.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblEnterYourLast.setBounds(120, 175, 146, 29);
		contentPane.add(lblEnterYourLast);
		
		 lblEnterYourDob = new JLabel("Enter your DOB :");
		lblEnterYourDob.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblEnterYourDob.setBounds(120, 229, 146, 29);
		contentPane.add(lblEnterYourDob);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(290, 229, 211, 29);
		contentPane.add(dateChooser_1);
		
	   //add.(textField_2);
		
		JLabel lblEnterContactNo = new JLabel("Enter Contact No :");
		lblEnterContactNo.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblEnterContactNo.setBounds(120, 284, 146, 29);
		contentPane.add(lblEnterContactNo);
		
		JLabel lblEnterAddress = new JLabel("Enter Address :");
		lblEnterAddress.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblEnterAddress.setBounds(120, 388, 146, 29);
		contentPane.add(lblEnterAddress);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(290, 391, 468, 29);
		contentPane.add(textArea);
		
		JLabel lblEnterEmail = new JLabel("Enter E-mail :");
		lblEnterEmail.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblEnterEmail.setBounds(120, 453, 146, 29);
		contentPane.add(lblEnterEmail);
		
		JTextArea txtrPleaseFillYour = new JTextArea();
		txtrPleaseFillYour.setFont(new Font("Monospaced", Font.ITALIC, 18));
		txtrPleaseFillYour.setText("Please Fill your Personal Details !");
		txtrPleaseFillYour.setBounds(57, 26, 651, 29);
		contentPane.add(txtrPleaseFillYour);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBounds(290, 284, 214, 29);
		contentPane.add(textArea_1_1);
		
		JTextArea textArea_1_5 = new JTextArea();
		textArea_1_5.setBounds(290, 332, 214, 29);
		contentPane.add(textArea_1_5);
		
		final JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Ongoing newframe = new Ongoing();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(57, 648, 85, 29);
		contentPane.add(btnNewButton);
		
		final JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			

			

			private DateFormat dateFormat;

			public void actionPerformed(ActionEvent e) {
				
				String username=LoginPage.username;
				String f1=textField.getText();
				String l1=textField_1.getText();
				Date d1=dateChooser_1.getDate();
				System.out.print(d1);
				String date = dateFormat.getDateInstance().format(dateChooser_1.getDate());
				String d2=textField_4.getText();
				String d3=textArea_1_1.getText();
				String d4=textArea_1_5.getText();
				int no=d3.length();
				int no1=d4.length();
				try {
					if( d2.contains("@") )
					{
						
						}
					else {
						JOptionPane.showMessageDialog(btnNext,"Enter valid mail", "Alert" , -1);
					}
					
					if(no==10) {
						
					}
					else {
						JOptionPane.showMessageDialog(btnNext,"Enter valid phone number1", "Alert" , -1);
					}
                  if(no1==10) {
						
					}
					else {
						JOptionPane.showMessageDialog(btnNext,"Enter valid phone number2", "Alert" , -1);
					}
					if( textField.getText().equals("") && textField_1.getText().equals("") && date.equals("") ) {
						JOptionPane.showMessageDialog(btnNext,"Enter details", "Alert" , -1);
					}
					else {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
					
					String sql="insert into paymentdetails values(?,?,?,?)";
					PreparedStatement pts=con.prepareStatement(sql);
					pts.setString(1,f1 );
					pts.setString(2,l1);
					pts.setString(3, date);
					pts.setString(4, LoginPage.username);
		

					
					
					
					

					
					pts.executeUpdate();
					 JOptionPane.showMessageDialog(null,"it has been registered");
					 billCourses newframe = new billCourses();
						
						newframe.setVisible(true);
						SwingUtilities.windowForComponent(btnNext).dispose();
					 
				}}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"it has not been registered");
                         ex.printStackTrace();
					}
				
		
			}
		});
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNext.setBounds(673, 648, 85, 29);
		contentPane.add(btnNext);
		
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblCountry.setBounds(120, 519, 146, 29);
		contentPane.add(lblCountry);
		
		JLabel lblState = new JLabel("State :");
		lblState.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblState.setBounds(120, 576, 146, 29);
		contentPane.add(lblState);
		
		JTextArea textArea_1_6 = new JTextArea();
		textArea_1_6.setBounds(290, 522, 214, 29);
		contentPane.add(textArea_1_6);
		
		JTextArea textArea_1_7 = new JTextArea();
		textArea_1_7.setBounds(290, 579, 214, 29);
		contentPane.add(textArea_1_7);
		
		textField = new JTextField();
		textField.setBounds(293, 111, 211, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(293, 175, 211, 37);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(516, 111, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("*");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_2_1.setBounds(514, 175, 45, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("*");
		lblNewLabel_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_2_2.setBounds(516, 238, 45, 13);
		contentPane.add(lblNewLabel_2_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(290, 459, 211, 37);
		contentPane.add(textField_4);
	}
}
