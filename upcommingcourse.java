package Management;

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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Upcoming extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField txtOurFutureCourses;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Upcoming frame = new Upcoming();
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
	public Upcoming() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 976, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		final JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(56, 651, 109, 40);
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
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Footlight MT Light", Font.ITALIC, 18));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
					String query="select * from allcourses where Start_date=? ";
					PreparedStatement pts=con.prepareStatement(query);
					pts.setString(1,textField.getText());
					ResultSet rs=pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("Course_id"),rs.getString("Course_name"),rs.getString("Instructor_id"),rs.getString("Duration"),rs.getString("Start_date")};
					dt.addRow(o);
					}
			}
					
				catch(Exception ex) {
					ex.printStackTrace();}
			}
		});
		
		txtOurFutureCourses = new JTextField();
		txtOurFutureCourses.setBackground(new Color(0, 255, 128));
		txtOurFutureCourses.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 30));
		txtOurFutureCourses.setText("Our Future Courses !");
		txtOurFutureCourses.setBounds(323, 38, 328, 64);
		contentPane.add(txtOurFutureCourses);
		txtOurFutureCourses.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Enter Date");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(210, 139, 120, 34);
		contentPane.add(lblNewLabel_1);
		textField.setBounds(303, 141, 134, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 205, 673, 238);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel
				(
				
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			
			new String[] {
				"Course_id", "Course_name", "Instructor_id", "Duration", "Start_date"
			}
			
		));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 10, 962, 721);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vinot\\Downloads\\WhatsApp Image 2024-04-14 at 22.06.26.jpeg"));
		contentPane.add(lblNewLabel);
		table.getColumnModel().getColumn(1).setPreferredWidth(160);
	}
}
