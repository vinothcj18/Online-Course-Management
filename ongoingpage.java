package Management;
import Management.LoginPage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Ongoing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	protected AbstractButton search;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton_1;
	private JTextField textField_2;
	private String[] a = new String[20];
	private ArrayList<String> ar = new ArrayList<String>();
	static JComboBox comboBox;
	private JButton btnNewButton_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Ongoing frame = new Ongoing();
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
	public Ongoing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 770);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		final JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(810, 600, 106, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					menupage newframe = new menupage();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
				}
			}
		});
		
		textField = new JTextField();
		textField.setBounds(148, 46, 166, 37);
		textField.setFont(new Font("Sitka Text", Font.ITALIC, 18));
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				try {
					int i=0;
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
					String query="select * from ongoing where username='"+LoginPage.username+"' and Course_id=?";
					PreparedStatement pts=con.prepareStatement(query);
					pts.setString(1,textField.getText());
					ResultSet rs=pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("Course_id"),rs.getString("Course_name"),rs.getString("Instructor_id"),rs.getString("Duration"),rs.getString("username")};
					dt.addRow(o);
					++i;
					}
			}
					
				catch(Exception ex) {
					ex.printStackTrace();}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(textField);
		textField.setColumns(10);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("search");
		lblNewLabel.setBounds(32, 47, 138, 36);
		lblNewLabel.setFont(new Font("Sitka Text", Font.ITALIC, 18));
		contentPane.add(lblNewLabel);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(97, 138, 670, 266);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		table.setRowHeight(40);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Course_id", "Course_name", "Instructor_id", "Duration", "username"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(225);
		try {
			int i=0;
			System.out.print(LoginPage.username);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
			Statement st=con.createStatement();
			String sql="select * from ongoing where username='"+LoginPage.username+"'";
			
			PreparedStatement pts=con.prepareStatement(sql);
			ResultSet rs= pts.executeQuery();
			    DefaultTableModel dt=(DefaultTableModel)table.getModel();
			dt.setRowCount(0);
			while(rs.next()) {
				ar.add(rs.getString("Course_id"));
				a[i]=new String(rs.getString("Course_id"));
			Object o[]= {rs.getString("Course_id"),rs.getString("Course_name"),rs.getString("Instructor_id"),rs.getString("Duration"),rs.getString("username")};
			dt.addRow(o);
			++i;
			}
	}
		catch(Exception ec) {
			JOptionPane.showMessageDialog(null,"it has not been registered");
			ec.printStackTrace();
		}
		table.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setBounds(403, 585, 106, 36);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String user_id =textField_1.getText();
				String Course_id =textField_2.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");	
					String sql = "delete  from ongoing where username ='"+LoginPage.username+"' and Course_id = '"+Course_id+"'";
					PreparedStatement pts=con.prepareStatement(sql);
					pts.executeUpdate(sql);
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1, this, "Error while establishing connection failed", 0);
					o.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Course_id");
		lblNewLabel_2.setBounds(47, 584, 123, 43);
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(201, 585, 173, 37);
		textField_2.setFont(new Font("Footlight MT Light", Font.ITALIC, 18));
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		final JButton btnNewButton_3 = new JButton("Next");
		btnNewButton_3.setBounds(377, 512, 85, 29);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				try {
					if(comboBox.getSelectedItem().equals("C-003")) {
						cprogram newframe = new cprogram();
						newframe.setVisible(true);
						SwingUtilities.windowForComponent(btnNewButton_3).dispose();
					//allpdfs window = new allpdfs();
					//window.frame.setVisible(true);
					//SwingUtilities.windowForComponent(btnNewButton_3).dispose();
						}
					if(comboBox.getSelectedItem().equals("DB-007")) {
						dbms newframe = new dbms();
						newframe.setVisible(true);
						SwingUtilities.windowForComponent(btnNewButton_3).dispose();
						
					}
					
					if(comboBox.getSelectedItem().equals("PJ-013")) {
						python newframe = new python();
						newframe.setVisible(true);
						SwingUtilities.windowForComponent(btnNewButton_3).dispose();
						

					}
					if(comboBox.getSelectedItem().equals("Py-001")) {
						python newframe = new python();
						newframe.setVisible(true);
						SwingUtilities.windowForComponent(btnNewButton_3).dispose();
					
					}
					if(comboBox.getSelectedItem().equals("BC-004")) {
						Blockchain newframe = new Blockchain();
						newframe.setVisible(true);
						SwingUtilities.windowForComponent(btnNewButton_3).dispose();
					
					}
					if(comboBox.getSelectedItem().equals("CP-005")) {
						cplus newframe = new cplus();
						newframe.setVisible(true);
						SwingUtilities.windowForComponent(btnNewButton_3).dispose();
					
					}
					
					if(comboBox.getSelectedItem().equals("DS-008")) {
						ds newframe = new ds();
						newframe.setVisible(true);
						SwingUtilities.windowForComponent(btnNewButton_3).dispose();
					
					}
					
					
					if(comboBox.getSelectedItem().equals("EM-015")) {
						enggmaths newframe = new enggmaths();
						newframe.setVisible(true);
						SwingUtilities.windowForComponent(btnNewButton_3).dispose();
					
					}
					if(comboBox.getSelectedItem().equals("FS-006")) {
						Fullstack newframe = new Fullstack();
						newframe.setVisible(true);
						SwingUtilities.windowForComponent(btnNewButton_3).dispose();
					
					}
					
					
					
					
					
					if(comboBox.getSelectedItem().equals("CS-010")) {
						commsys newframe = new commsys();
						newframe.setVisible(true);
						SwingUtilities.windowForComponent(btnNewButton_3).dispose();
					
					}
				
					
					
					
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_3, this, "Error while establishing connection failed", 0);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Course_id");
		lblNewLabel_1.setBounds(47, 500, 134, 43);
		lblNewLabel_1.setFont(new Font("Footlight MT Light", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblNewLabel_1);
		
		 comboBox = new JComboBox(a);
		comboBox.setBounds(201, 504, 138, 37);
		contentPane.add(comboBox);
		
		btnNewButton_2 = new JButton("Payment");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Paymentpage newframe = new Paymentpage();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_2).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_2, this, "Error while establishing connection failed", 0);
				}

			}
		});
		btnNewButton_2.setFont(new Font("Bell MT", Font.BOLD, 18));
		btnNewButton_2.setBounds(719, 62, 106, 37);
		contentPane.add(btnNewButton_2);
	}
}
