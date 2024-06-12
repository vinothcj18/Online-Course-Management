package Management;
import Management.LoginPage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class crepage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crepage frame = new crepage();
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
	public crepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 715);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel error = new JLabel("");
		error.setForeground(new Color(255, 0, 0));
		error.setFont(new Font("Bodoni MT Condensed", Font.BOLD | Font.ITALIC, 40));
		error.setBounds(30, 490, 759, 99);
		contentPane.add(error);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblNewLabel.setBounds(51, 135, 169, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblPassword.setBounds(51, 216, 169, 48);
		contentPane.add(lblPassword);
		
		user = new JTextField();
		user.setFont(new Font("Footlight MT Light", Font.ITALIC, 18));
		user.setBounds(269, 146, 320, 33);
		contentPane.add(user);
		user.setColumns(10);
		
		final JButton btnNewButton = new JButton("Signin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int ed = 0;
				String us = user.getText();
				String np = passwordField.getText();
				String cp = passwordField_1.getText();
				if(np.equals(cp)) {
				
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
				System.out.println("1");
				Statement st = con.createStatement();
				String sql2 = "select count(*) as COUNT from access";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ResultSet res2 = ps2.executeQuery();
				String sql = "SELECT * FROM access";
				ResultSet res1 = st.executeQuery(sql);
				String input = np;
				int inputLen = input.length();
				int uppercount=0;
				int lowercount=0;
	        	int digitcount=0;
				for(int j =0; j < inputLen ; j++)
				{
					char ch = input.charAt(j);
					if (Character.isUpperCase(ch))
						uppercount++;
					else if (Character.isLowerCase(ch))
						lowercount++;
					else if (Character.isDigit(ch))
						digitcount++;
				}
				System.out.print(uppercount);
				System.out.print(lowercount);
				System.out.print(digitcount);
				int c = 0;
				while(res2.next()) {
					c = res2.getInt(1);
					
				}
				c=c+2;
				while(res1.next()) {
					String use1 = res1.getString("username");
					if(us!=use1 && uppercount >= 1 && lowercount >= 3 && digitcount >=1) {
						ed =1 ;
						String sql3 = "insert into access values('"+c+"','"+us+"','"+np+"')";
						PreparedStatement pts = con.prepareStatement(sql3);
						pts.executeUpdate(sql3);
						
						try {
							new LoginPage().setVisible(true);
							SwingUtilities.windowForComponent(btnNewButton).dispose();
							JOptionPane.showMessageDialog(btnNewButton, " account successfully created ");
						}
						catch(Exception o) {
							JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
						}
						break;
					}
				
					else {
						user.setText("");
						passwordField.setText("");
						//passwordField_1.setText();
						//JOptionPane.showMessageDialog(null, "password not matched");
					}
				}}
				else {
					JOptionPane.showMessageDialog(null, "password not match");
									
								}
				if(ed==0) {
					error.setText("Invalid Password,Please enter the Strong Password !");
				}

				}
				
				catch(Exception r) {
					JOptionPane.showMessageDialog(null,"username already exists");
						r.printStackTrace();				}
			}
					
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(662, 580, 127, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("confirm password");
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblNewLabel_1.setBounds(51, 312, 248, 33);
		contentPane.add(lblNewLabel_1);
		
		final JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage newframe = new LoginPage();
				newframe.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_1).dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBounds(51, 578, 85, 41);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Account Settings");
		lblNewLabel_2.setFont(new Font("Castellar", Font.BOLD, 30));
		lblNewLabel_2.setBounds(269, 33, 364, 67);
		contentPane.add(lblNewLabel_2);
		
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Show Password");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(634, 233, 140, 26);
		contentPane.add(rdbtnNewRadioButton);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Footlight MT Light", Font.ITALIC, 18));
		passwordField.setBounds(269, 234, 328, 33);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Footlight MT Light", Font.ITALIC, 18));
		passwordField_1.setBounds(269, 315, 328, 34);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_4 = new JLabel("NOTE : PLEASE USE ATLEAST 1 UPPERCASE AND 1 DIGIT !");
		lblNewLabel_4.setFont(new Font("Yu Gothic Medium", Font.ITALIC, 18));
		lblNewLabel_4.setBounds(274, 374, 536, 48);
		contentPane.add(lblNewLabel_4);
		
		
		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Show Password");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					passwordField_1.setEchoChar((char)0);
				}
				else {
					passwordField_1.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnNewRadioButton_1.setBounds(633, 321, 141, 24);
		contentPane.add(rdbtnNewRadioButton_1);
	}
}
