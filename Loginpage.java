package Management;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	private JLabel error;
	public static String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setTitle("E-Learning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		error = new JLabel("");
		error.setForeground(new Color(255, 0, 0));
		error.setBackground(new Color(0, 255, 255));
		error.setFont(new Font("Times New Roman", Font.BOLD, 30));
		error.setBounds(31, 447, 846, 85);
		contentPane.add(error);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setBounds(166, 282, 151, 36);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBounds(166, 391, 163, 36);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		user = new JTextField();
		user.setFont(new Font("Footlight MT Light", Font.ITALIC, 18));
		user.setBounds(374, 287, 260, 27);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Footlight MT Light", Font.ITALIC, 18));
		pass.setBounds(376, 391, 258, 27);
		contentPane.add(pass);
		
		final JButton btnNewButton = new JButton("Forgot password?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ForgotPassword().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
				}
				
			}
		});
		btnNewButton.setBounds(49, 563, 219, 36);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				try {
					int er=0;
					String us = user.getText();
					String ps = pass.getText();
					System.out.println(us);
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println(ps);
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
					System.out.println("1");
					Statement st = con.createStatement();
					System.out.println("1");
					String sql = "Select * from access";
					System.out.println("1");
					ResultSet rs = st.executeQuery(sql);
					System.out.println("1");
					while(rs.next()){
					
					username = rs.getString("username");
					System.out.println("1-");
					String password = rs.getString("password");
					System.out.println("1-");
					
					
					if(us.equals(username) && ps.equals(password)){
					username=rs.getString("username");
					new menupage().setVisible(true);
					System.out.println("true");
					SwingUtilities.windowForComponent(btnNewButton).dispose();
					er = 0;
					break;
					}
					
					else{
					user.setText("");
					pass.setText("");
					System.out.println("false");
					er=1;
					}
				}
					if(er ==1) {
						error.setVisible(true);
						error.setText("Incorrect password or Username");
						}
					}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
				}
			}
		});
		btnNewButton_1.setBounds(396, 563, 151, 36);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btnNewButton_1);
		
		final JButton btnNewButton_2 = new JButton("Create new account");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new crepage().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_2).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_2, this, "Error while establishing connection failed", 0);
				}	
			}
		});
		btnNewButton_2.setBounds(675, 563, 219, 36);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(284, 55, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(199, 99, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, 10, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Show password");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					pass.setEchoChar((char)0);
				}
				else {
					pass.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnNewRadioButton.setBounds(662, 399, 137, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\vinot\\Downloads\\WhatsApp Image 2024-03-03 at 20.41.32.jpeg"));
		lblNewLabel_5.setBounds(0, 0, 1000, 725);
		contentPane.add(lblNewLabel_5);
	}
}
