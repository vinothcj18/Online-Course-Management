package Management;
import Management.LoginPage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class billCourses extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField textField;
	static JTextField textField_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	public static int amount;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					billCourses frame = new billCourses();
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
	public billCourses() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Fill Course Details !");
		lblNewLabel.setFont(new Font("Monospaced", Font.ITALIC, 18));
		lblNewLabel.setBounds(52, 37, 391, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Course Name :");
		lblNewLabel_1.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(111, 130, 127, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Course ID :");
		lblNewLabel_1_1.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblNewLabel_1_1.setBounds(111, 185, 127, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter Exam City :");
		lblNewLabel_1_2.setFont(new Font("Perpetua", Font.ITALIC, 18));
		lblNewLabel_1_2.setBounds(111, 244, 127, 26);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("1)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(263, 242, 24, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("2)");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(263, 295, 24, 26);
		contentPane.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Perpetua", Font.ITALIC, 18));
		textField.setBounds(229, 132, 304, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Perpetua", Font.ITALIC, 18));
		textField_1.setBounds(229, 185, 143, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		final JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Paymentpage newframe = new Paymentpage();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(42, 423, 85, 32);
		contentPane.add(btnNewButton);
		
		final JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			

       public void actionPerformed(ActionEvent e) {
    	   
				int er=0;
				int r=0;
				String course = textField_1.getText();
				String username=LoginPage.username;
				try {
					System.out.println("aa");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
					String sql = "Select * from v2";
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
	              while(rs.next()){
						
					String	ci = rs.getString("course_id");
						String us=rs.getString("username");
						String pay=rs.getString("Payment");
						
						
						
					
                    if(course.equals(ci) && username.equals(us) && pay.equals("Successfull") ){
                    	r=1;
                    	System.out.println(ci);
                    	System.out.println(us);
                    	System.out.println(pay);
							JOptionPane.showMessageDialog(null,"you already payed");
							break;
						}
                   
                    
						}
	              
				}
				catch(Exception ex) {
					System.out.println("aaa");
					JOptionPane.showMessageDialog(null,0);
					
					}

				
				
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
				String sql = "Select * from Ongoing";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
              while(rs.next()){
					
				String	ci = rs.getString("Course_id");
					String us=rs.getString("username");
					
					
					
					
					if(course.equals(ci) && username.equals(us)){
						 er=1;
						System.out.println(ci);
						System.out.println(us);
						try {
							
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
							
							String sql2="insert into billcourse values(?,?,?,?,?)";
							PreparedStatement pts=con1.prepareStatement(sql2);
							pts.setString(1,textField_1.getText() );
							pts.setString(2,textField.getText());
							pts.setString(3,(String)comboBox.getSelectedItem());
							pts.setString(4,(String)comboBox_1.getSelectedItem());
							pts.setString(5, username);

							
							
							
							

							
					pts.executeUpdate();
							String b="select Amount from allcourses where Course_id='"+textField_1.getText()+"'";
							PreparedStatement p23=con.prepareStatement(b);
							ResultSet ty=p23.executeQuery();
							while(ty.next()) {
								amount=Integer.parseInt(ty.getString(1));
							}
							System.out.println(amount);
							 JOptionPane.showMessageDialog(null,"it has been registered");
						}
							catch(Exception ex) {
								JOptionPane.showMessageDialog(null,"it has been not registered");}
						
						try {
							finalpayment newframe = new finalpayment();
							newframe.setVisible(true);
							SwingUtilities.windowForComponent(btnNext).dispose();
						}
						catch(Exception o) {
							JOptionPane.showMessageDialog(btnNext, this, "Error while establishing connection failed", 0);
						}
						
						
					}
					
					
						
					
				
			
              }
              if(er==0) {
					
					JOptionPane.showMessageDialog( btnNext,"Enter valid Course ID", "ERROR", -1);
				
				
				
			}
				
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNext, this, "Error while establishing connection failed", 0);
				}
				}});
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNext.setBounds(541, 431, 85, 32);
		contentPane.add(btnNext);
		
		 comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Ariyalur", "Chengalpattu", "Chennai", "Coimbatore", "Cuddalore", "Dharmapuri", "Dindigul", "Erode", "Kallakurichi", "Kancheepuram", "Karur", "Krishnagiri", "Madurai", "Mayiladuthurai", "Nagapattinam", "Kanniyakumari", "Nagercoil", "Namakkal", "Perambalur", "Pudukottai", "Ramanathapuram", "Ranipet", "Salem", "Sivagangai", "Tenkasi", "Thanjavur", "Theni", "Thiruvallur", "Thiruvarur", "Thoothukudi", "Trichirappalli", "Thirunelveli", "Tirupathur", "Tiruppur", "Tiruvannamalai", "The Nilgiris", "Vellore", "Viluppuram", "Virudhunagar"}));
		comboBox.setFont(new Font("Perpetua", Font.ITALIC, 18));
		comboBox.setBounds(297, 244, 187, 26);
		contentPane.add(comboBox);
		
    comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Ariyalur", "Chengalpattu", "Chennai", "Coimbatore", "Cuddalore", "Dharmapuri", "Dindigul", "Erode", "Kallakurichi", "Kancheepuram", "Karur", "Krishnagiri", "Madurai", "Mayiladuthurai", "Nagapattinam", "Kanniyakumari", "Nagercoil", "Namakkal", "Perambalur", "Pudukottai", "Ramanathapuram", "Ranipet", "Salem", "Sivagangai", "Tenkasi", "Thanjavur", "Theni", "Thiruvallur", "Thiruvarur", "Thoothukudi", "Trichirappalli", "Thirunelveli", "Tirupathur", "Tiruppur", "Tiruvannamalai", "The Nilgiris", "Vellore", "Viluppuram", "Virudhunagar"}));
		comboBox_1.setFont(new Font("Perpetua", Font.ITALIC, 18));
		comboBox_1.setBounds(297, 295, 187, 27);
		contentPane.add(comboBox_1);
	}
}
