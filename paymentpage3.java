package Management;
import Management.LoginPage;
import Management.Paymentpage;
import Management.billCourses;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class finalpayment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	JTextField textField_1;
    static JTextField textField_2;
	static JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finalpayment frame = new finalpayment();
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
	public finalpayment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Card Number :");
		lblNewLabel.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblNewLabel.setBounds(43, 43, 121, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblExpirationDate = new JLabel("Expiration Date :");
		lblExpirationDate.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblExpirationDate.setBounds(43, 109, 121, 34);
		contentPane.add(lblExpirationDate);
		
		JLabel lblCardHolderName = new JLabel("Card Holder Name :");
		lblCardHolderName.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblCardHolderName.setBounds(43, 180, 121, 34);
		contentPane.add(lblCardHolderName);
		
		final JButton btnNewButton = new JButton("Proceed to Pay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String username=LoginPage.username;
			  //try {
					System.out.println(textField.getText().equals(""));
					System.out.println(textField_1.getText().equals(""));
					System.out.println(textField_2.getText().equals(""));
					
					if( textField.getText().equals("") && textField_1.getText().equals("") && textField_2.getText().equals("") ) {
					JOptionPane.showMessageDialog(btnNewButton,"Payment not Successfull", "Payment result" , -1);
	
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
						String sql="insert into finalpayment values(?,?,?,?,?,?)";
						PreparedStatement pts=con.prepareStatement(sql);
						pts.setString(1,textField.getText() );
						pts.setString(2,textField_1.getText());
						pts.setString(3, textField_2.getText());
						pts.setString(4, username);
						pts.setString(5, textField_3.getText());
						pts.setString(6, "Failed");
						
						
						

						
						pts.executeUpdate();
						
						 
					     }
						catch(Exception ex) {
							JOptionPane.showMessageDialog(null,"it has been not registered");
							}
					}
					else {
						SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
						Calendar cp= Calendar.getInstance();
						String output=sdf.format(cp.getTime());
						
						String date2=textField_1.getText();
						try {
							Date d1=sdf.parse(output);
							Date d2=sdf.parse(date2);
							if(d2.after(d1)) {
								System.out.println("true");
							
						
						try {
							System.out.print("aaa");
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
							String sql="insert into finalpayment values(?,?,?,?,?,?)";
							PreparedStatement pts=con.prepareStatement(sql);
							pts.setString(1,textField.getText() );
							pts.setString(2,textField_1.getText());
							pts.setString(3, textField_2.getText());
							pts.setString(4, username);
							pts.setString(5, textField_3.getText());
							pts.setString(6, "Successfull");
							
							
							

							
							pts.executeUpdate();
							JOptionPane.showMessageDialog(btnNewButton, "Payment Successfull", "Payment result", -1);
							 JOptionPane.showMessageDialog(null,"it has been registered");
							 try {
									report newframe = new report();
									newframe.setVisible(true);
									SwingUtilities.windowForComponent(btnNewButton).dispose();
								}
								catch(Exception o) {
									JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
								}
							 
						}
							catch(Exception ex) {
								JOptionPane.showMessageDialog(null,"it has been not registered");}
						}
						else {
							System.out.println("false");
							JOptionPane.showMessageDialog(null,"card expired");
						}
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"enter valid card expiration date");
					}
						
					//}
				
				//catch(Exception o) {
					//JOptionPane.showMessageDialog(btnNewButton, this, "payment Failed", 0);
				//}
				 
				
			}}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(78, 317, 200, 34);
		contentPane.add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					billCourses newframe = new billCourses ();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1, this, "Error while establishing connection failed", 0);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBounds(43, 533, 85, 34);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Perpetua", Font.ITALIC, 18));
		textField.setBounds(183, 43, 221, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Perpetua", Font.ITALIC, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(183, 109, 221, 33);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Perpetua", Font.ITALIC, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(183, 180, 221, 33);
		contentPane.add(textField_2);
		
		final JButton btnNewButton_2 = new JButton("Done");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					viewpasttransaction newframe = new viewpasttransaction();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_2).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_2, this, "Error while establishing connection failed", 0);
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_2.setBounds(490, 533, 95, 30);
		contentPane.add(btnNewButton_2);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblAmount.setBounds(43, 245, 121, 34);
		contentPane.add(lblAmount);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Perpetua", Font.ITALIC, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(183, 245, 221, 33);
		contentPane.add(textField_3);
		textField_3.setText(""+billCourses.amount);
		
		
	}
}
