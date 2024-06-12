package Management;
import Management.LoginPage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Completed extends JFrame {

	private static final long serialVersionUID = 1L;
	public static String course_id;
	public static String course_name;
	private JPanel contentPane;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Completed frame = new Completed();
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
	public Completed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 976, 765);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JButton btnNewButton = new JButton("Back");
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
		
		JButton btnNewButton_1 = new JButton("Certificate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					generating newframe = new generating();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1, this, "Error while establishing connection failed", 0);
					o.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_2 = new JButton("Payment");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_2.setBounds(69, 38, 129, 33);
		contentPane.add(btnNewButton_2);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1.setBounds(746, 492, 113, 40);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 158, 728, 264);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(40);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Course_name", "Course_id", "Assignment", "Assignment_2", "Final_Assignment", "Average"
			}
		));
		
		try {
			int i=0;
			System.out.print(LoginPage.username);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
			Statement st=con.createStatement();
			String sql="select Course_name,Course_id,Assignment,Assignment_2,Final_Assignment,Average from  completed where username='"+LoginPage.username+"'";
			
			PreparedStatement pts=con.prepareStatement(sql);
			ResultSet rs= pts.executeQuery();
			    DefaultTableModel dt=(DefaultTableModel)table.getModel();
			dt.setRowCount(0);
			while(rs.next()) {
				course_id=rs.getString("Course_id");
				 course_name=rs.getString("Course_name");
				 int marks1=rs.getInt("Assignment");
				 int marks2=rs.getInt("Assignment_2");
				 int marks3=rs.getInt("Final_Assignment");
				 float Avg=rs.getInt("Average");
				float Avg1=marks1+marks2+marks3;
				Avg=Avg1/3;
			Object o[]= {course_id,course_name,marks1,marks2,marks3,Avg};
			dt.addRow(o);
			++i;
			}}
		catch(Exception es) {
			es.printStackTrace();
		}
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(54, 636, 113, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vinot\\Downloads\\WhatsApp Image 2024-04-14 at 22.07.34 (1).jpeg"));
		lblNewLabel.setBounds(0, 10, 962, 718);
		contentPane.add(lblNewLabel);
	}
}
