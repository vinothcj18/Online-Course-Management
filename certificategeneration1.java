package Management;
import Management.Completed;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class generating extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[] a = new String[20];
	private ArrayList<String> ar = new ArrayList<String>();
	static JComboBox comboBox;
	static JTextField textField;
	public static String c_n;
	public static Object textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generating frame = new generating();
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
	public generating() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Name :");
		lblNewLabel.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblNewLabel.setBounds(46, 96, 86, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterCourseName = new JLabel("Enter Course Name :");
		lblEnterCourseName.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblEnterCourseName.setBounds(39, 151, 145, 27);
		contentPane.add(lblEnterCourseName);
		
		textField = new JTextField();
		textField.setBounds(185, 100, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fill Your Details For Generating Certificate");
		lblNewLabel_1.setFont(new Font("Footlight MT Light", Font.BOLD, 18));
		lblNewLabel_1.setBounds(39, 22, 362, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   String c_n=(String)comboBox.getSelectedItem();
			   System.out.println(c_n);
				
				try {
					cert newframe = new cert();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
					o.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(295, 214, 131, 22);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Completed newframe = new Completed();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1, this, "Error while establishing connection failed", 0);
					o.printStackTrace();
				}
			}
		});
		try {
			int i=0;
			System.out.print(LoginPage.username);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
			Statement st=con.createStatement();
			String sql="select Course_name from  completed where username='"+LoginPage.username+"'";
			
			PreparedStatement pts=con.prepareStatement(sql);
			ResultSet rs= pts.executeQuery();
			    
		
			while(rs.next()) {
				ar.add(rs.getString("Course_name"));
				a[i]=new String(rs.getString("Course_name"));
			//Object o[]= {rs.getString("Course_id"),rs.getString("Course_name"),rs.getString("Instructor_id"),rs.getString("Duration"),rs.getString("username")};
			
			++i;
			}
	}
		catch(Exception ec) {
			JOptionPane.showMessageDialog(null,"it has not been registered");
			ec.printStackTrace();
		}
		
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBounds(10, 215, 85, 21);
		contentPane.add(btnNewButton_1);
		
		comboBox = new JComboBox(a);
		comboBox.setBounds(194, 155, 117, 21);
		contentPane.add(comboBox);
	}
}
