package Management;
import Management.LoginPage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class scrollall extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					scrollall frame = new scrollall();
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
	public scrollall() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 775);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 682, 688);
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(100,100));
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setPreferredSize(new Dimension(200, 200));
		panel_4.setBackground(Color.WHITE);
		panel.add(panel_4);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(427, 0, 50, 200);
		panel_4.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Course Id : BC-004");
		lblNewLabel_2.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(468, 51, 210, 33);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Duration : 12 weeks");
		lblNewLabel_2_1.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1.setBounds(468, 112, 210, 33);
		panel_4.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\vinot\\Pictures\\Screenshots\\Screenshot 2024-06-05 143954.png"));
		lblNewLabel_3.setBounds(-83, 0, 511, 200);
		panel_4.add(lblNewLabel_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setPreferredSize(new Dimension(200, 200));
		panel_3.setBackground(Color.WHITE);
		panel.add(panel_3);
		
		JSeparator separator_1111111 = new JSeparator();
		separator_1111111.setOrientation(SwingConstants.VERTICAL);
		separator_1111111.setBounds(427, 0, 50, 200);
		panel_3.add(separator_1111111);
		
		JLabel lblNewLabel_2_1_1_1_11111111 = new JLabel("Course Id : PJ-013");
		lblNewLabel_2_1_1_1_11111111.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1_1_1_11111111.setBounds(466, 37, 210, 33);
		panel_3.add(lblNewLabel_2_1_1_1_11111111);
		
		JLabel lblNewLabel_2_1_1_1_111111111 = new JLabel("Duration : 12 weeks");
		lblNewLabel_2_1_1_1_111111111.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1_1_1_111111111.setBounds(466, 110, 210, 33);
		panel_3.add(lblNewLabel_2_1_1_1_111111111);
		
		JLabel lblNewLabel_5_6 = new JLabel("");
		lblNewLabel_5_6.setIcon(new ImageIcon("C:\\Users\\vinot\\Pictures\\Screenshots\\Screenshot 2024-06-05 151129.png"));
		lblNewLabel_5_6.setBounds(-120, 0, 544, 325);
		panel_3.add(lblNewLabel_5_6);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setPreferredSize(new Dimension(200, 200));
		panel_11.setBackground(Color.WHITE);
		panel.add(panel_11);
		
		JSeparator separator_111111 = new JSeparator();
		separator_111111.setOrientation(SwingConstants.VERTICAL);
		separator_111111.setBounds(427, 0, 50, 200);
		panel_11.add(separator_111111);
		
		JLabel lblNewLabel_2_1_1_1_111111 = new JLabel("Course Id : FS-006");
		lblNewLabel_2_1_1_1_111111.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1_1_1_111111.setBounds(466, 37, 210, 33);
		panel_11.add(lblNewLabel_2_1_1_1_111111);
		
		JLabel lblNewLabel_2_1_1_1_1111111 = new JLabel("Duration : 18 weeks");
		lblNewLabel_2_1_1_1_1111111.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1_1_1_1111111.setBounds(466, 110, 210, 33);
		panel_11.add(lblNewLabel_2_1_1_1_1111111);
		
		JLabel lblNewLabel_5_5 = new JLabel("");
		lblNewLabel_5_5.setIcon(new ImageIcon("C:\\Users\\vinot\\Pictures\\Screenshots\\Screenshot 2024-06-05 150649.png"));
		lblNewLabel_5_5.setBounds(-124, -23, 551, 223);
		panel_11.add(lblNewLabel_5_5);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setPreferredSize(new Dimension(200, 200));
		panel_10.setBackground(Color.WHITE);
		panel.add(panel_10);
		
		JSeparator separator_11111 = new JSeparator();
		separator_11111.setOrientation(SwingConstants.VERTICAL);
		separator_11111.setBounds(427, 0, 50, 200);
		panel_10.add(separator_11111);
		
		JLabel lblNewLabel_2_1_1_1_1111 = new JLabel("Course Id : EM-015");
		lblNewLabel_2_1_1_1_1111.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1_1_1_1111.setBounds(466, 37, 210, 33);
		panel_10.add(lblNewLabel_2_1_1_1_1111);
		
		JLabel lblNewLabel_2_1_1_1_11111 = new JLabel("Duration : 8 weeks");
		lblNewLabel_2_1_1_1_11111.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1_1_1_11111.setBounds(466, 110, 210, 33);
		panel_10.add(lblNewLabel_2_1_1_1_11111);
		
		JLabel lblNewLabel_5_4 = new JLabel("");
		lblNewLabel_5_4.setIcon(new ImageIcon("C:\\Users\\vinot\\Pictures\\Screenshots\\Screenshot 2024-06-05 150451.png"));
		lblNewLabel_5_4.setBounds(-130, 0, 559, 200);
		panel_10.add(lblNewLabel_5_4);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setPreferredSize(new Dimension(200, 200));
		panel_9.setBackground(Color.WHITE);
		panel.add(panel_9);
		
		JSeparator separator_1111 = new JSeparator();
		separator_1111.setOrientation(SwingConstants.VERTICAL);
		separator_1111.setBounds(427, 0, 50, 200);
		panel_9.add(separator_1111);
		
		JLabel lblNewLabel_2_2_1_111 = new JLabel("Course Id : DS-008");
		lblNewLabel_2_2_1_111.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_2_1_111.setBounds(466, 37, 210, 33);
		panel_9.add(lblNewLabel_2_2_1_111);
		
		JLabel lblNewLabel_2_1_1_1_111 = new JLabel("Duration : 12 weeks");
		lblNewLabel_2_1_1_1_111.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1_1_1_111.setBounds(466, 110, 210, 33);
		panel_9.add(lblNewLabel_2_1_1_1_111);
		
		JLabel lblNewLabel_5_3 = new JLabel("");
		lblNewLabel_5_3.setIcon(new ImageIcon("C:\\Users\\vinot\\Pictures\\Screenshots\\Screenshot 2024-06-05 150232.png"));
		lblNewLabel_5_3.setBounds(-133, 0, 561, 200);
		panel_9.add(lblNewLabel_5_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setPreferredSize(new Dimension(200, 200));
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		
		JSeparator separator_11111111 = new JSeparator();
		separator_11111111.setOrientation(SwingConstants.VERTICAL);
		separator_11111111.setBounds(427, 0, 50, 200);
		panel_2.add(separator_11111111);
		
		JLabel lblNewLabel_2_1_1_1_1111111111 = new JLabel("Course Id : Py-001");
		lblNewLabel_2_1_1_1_1111111111.setIcon(new ImageIcon("C:\\Users\\vinot\\Pictures\\Screenshots\\Screenshot 2024-06-05 193717.png"));
		lblNewLabel_2_1_1_1_1111111111.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1_1_1_1111111111.setBounds(466, 37, 210, 33);
		panel_2.add(lblNewLabel_2_1_1_1_1111111111);
		
		JLabel lblNewLabel_2_1_1_1_11111111111 = new JLabel("Duration : 3 weeks");
		lblNewLabel_2_1_1_1_11111111111.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1_1_1_11111111111.setBounds(466, 110, 210, 33);
		panel_2.add(lblNewLabel_2_1_1_1_11111111111);
		
		JLabel lblNewLabel_5_7 = new JLabel("");
		lblNewLabel_5_7.setBounds(0, 0, 429, 200);
		panel_2.add(lblNewLabel_5_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setPreferredSize(new Dimension(200, 200));
		panel_8.setBackground(Color.WHITE);
		panel.add(panel_8);
		
		JSeparator separator_111 = new JSeparator();
		separator_111.setOrientation(SwingConstants.VERTICAL);
		separator_111.setBounds(427, 0, 50, 200);
		panel_8.add(separator_111);
		
		JLabel lblNewLabel_2_2_1_11 = new JLabel("Course Id : DB-007");
		lblNewLabel_2_2_1_11.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_2_1_11.setBounds(466, 37, 210, 33);
		panel_8.add(lblNewLabel_2_2_1_11);
		
		JLabel lblNewLabel_2_1_1_1_11 = new JLabel("Duration : 12 weeks");
		lblNewLabel_2_1_1_1_11.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1_1_1_11.setBounds(466, 110, 210, 33);
		panel_8.add(lblNewLabel_2_1_1_1_11);
		
		JLabel lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.setIcon(new ImageIcon("C:\\Users\\vinot\\Pictures\\Screenshots\\Screenshot 2024-06-05 145738.png"));
		lblNewLabel_5_2.setBounds(-174, 0, 603, 200);
		panel_8.add(lblNewLabel_5_2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setPreferredSize(new Dimension(200, 200));
		panel_7.setBackground(Color.WHITE);
		panel.add(panel_7);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setOrientation(SwingConstants.VERTICAL);
		separator_11.setBounds(427, 0, 50, 200);
		panel_7.add(separator_11);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Course Id : CS-010");
		lblNewLabel_2_2_1_1.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_2_1_1.setBounds(466, 37, 210, 33);
		panel_7.add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Duration : 8 weeks");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1_1_1_1.setBounds(466, 110, 210, 33);
		panel_7.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon("C:\\Users\\vinot\\Pictures\\Screenshots\\Screenshot 2024-06-05 145603.png"));
		lblNewLabel_5_1.setBounds(-55, 0, 485, 200);
		panel_7.add(lblNewLabel_5_1);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.white);
		panel_5.setPreferredSize(new Dimension(200,200));
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(427, 0, 50, 200);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		panel_5.add(separator_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Course Id : C-003");
		lblNewLabel_2_2.setBounds(468, 36, 210, 33);
		lblNewLabel_2_2.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		panel_5.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Duration : 6 weeks");
		lblNewLabel_2_1_1.setBounds(468, 103, 210, 33);
		lblNewLabel_2_1_1.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		panel_5.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(-53, 0, 483, 200);
		panel_5.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\vinot\\Pictures\\Screenshots\\Screenshot 2024-06-05 144222.png"));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.white);
		panel_6.setPreferredSize(new Dimension(200,200));
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBounds(427, 0, 50, 200);
		panel_6.add(separator_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Course Id : CP-005");
		lblNewLabel_2_2_1.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_2_1.setBounds(466, 37, 210, 33);
		panel_6.add(lblNewLabel_2_2_1);
		
		
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Duration : 12 weeks");
		lblNewLabel_2_1_1_1.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1_1_1.setBounds(466, 110, 210, 33);
		panel_6.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(-190, 0, 619, 200);
		panel_6.add(lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\vinot\\Pictures\\Screenshots\\Screenshot 2024-06-05 144639.png"));
		
		JLabel lblNewLabel = new JLabel("List of Coures we are offering !");
		lblNewLabel.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(10, 10, 246, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Course_id");
		lblNewLabel_1.setFont(new Font("Perpetua", Font.ITALIC, 22));
		lblNewLabel_1.setBounds(746, 185, 107, 34);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(845, 185, 101, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_18 = new JButton("Add");
		btnNewButton_18.addActionListener(new ActionListener()
				{
			    private Connection con;
		        private ResultSet rs;
		        private String p2;
		        private String p3;
		        private String p4;
		        private String p5;
			public void actionPerformed(ActionEvent e) {
				String username=LoginPage.username;
				String Course_id= textField.getText();
				System.out.println(username+Course_id);
				
			try {   
				    
				    con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
				    Statement st=con.createStatement();
				    String q1="select Course_id,Course_name,Instructor_id,Duration from allcourses where Course_id = ? ";
				    PreparedStatement p1= con.prepareStatement(q1);
				    p1.setString(1,Course_id);
				  //p1.setString(2, user_id);
				     rs= p1.executeQuery();
				     while(rs.next()) {
				    	 p2 = rs.getString("Course_id");
					     p3= rs.getString("Course_name");
					     p4 = rs.getString("Instructor_id");
					     p5 = rs.getString("Duration"); 
				     }
				     
				     System.out.print(p2);
				     System.out.print(p3);
				     System.out.print(p4);
				     System.out.print(p5);
				     
				    
			}
			catch (SQLException e2) {
				    e2.printStackTrace();
				    // Handle any SQL errors
				}
				
				try {
				    
				    
				    String query = "INSERT INTO ongoing VALUES (?, ?, ?, ?, ?)";
				    PreparedStatement pst = con.prepareStatement(query);				    
				    pst.setString(1, p2);
				    pst.setString(2, p3);
				    pst.setString(3, p4);
				    pst.setString(4, p5);
				    pst.setString(5,LoginPage.username);
				   
				    
				    
				    int rowsAffected = pst.executeUpdate();
				    if (rowsAffected > 0) {
				        JOptionPane.showMessageDialog(null, "Successfully Inserted");
				        setVisible(false);
				        new Ongoing().setVisible(true);
				    } else {
				        JOptionPane.showMessageDialog(null, "Failed to Insert");
				    }
				    pst.close();
				    con.close();
				    
				} catch (SQLException e1) {
				    e1.printStackTrace();
				    // Handle any SQL errors
				}
			}
		});
		btnNewButton_18.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_18.setBounds(845, 242, 74, 34);
		getContentPane().add(btnNewButton_18);
		
		JButton btnNewButton_19 = new JButton("Back");
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menupage newframe = new menupage();
				newframe.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_19).dispose();
			}
		});
		btnNewButton_19.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_19.setBounds(861, 674, 85, 34);
		getContentPane().add(btnNewButton_19);
	}
}
