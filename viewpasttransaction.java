package Management;
import Management.LoginPage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class viewpasttransaction extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewpasttransaction frame = new viewpasttransaction();
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
	public viewpasttransaction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1342, 767);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 75, 1162, 419);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(30);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"username", "firstname", "lastname", "dateofbirth", "course_name", "course_id", "Exam_city1", "Exam_city2", "cardnumber", "expirydate", "cardholdername", "Amount", "Payment"
			}
		));
		JButton btnNewButton = new JButton("show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
					Statement st=con.createStatement();
					String sql="select * from billcourse b inner join paymentdetails p on b.username=p.username inner join finalpayment f on p.username=f.username where b.username='"+LoginPage.username+"'";
					//String sql="SELECT * FROM login.paymentdetails natural join login.billcourse natural join login.finalpayment where username='"+LoginPage.username+"'";
					//String sql="select * from paymentdetails natural join (select * from billcourse inner join finalpayment where billcourse.username=finalpayment.username and billcourse.username="+LoginPage.username+" and finalpayment.username="+LoginPage.username+")";
					PreparedStatement pts=con.prepareStatement(sql);
					ResultSet rs= pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("username"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("dateofbirth"),rs.getString("course_name"),rs.getString("course_id"),rs.getString("Exam_city1"),rs.getString("Exam_city2"),rs.getString("cardnumber"),rs.getString("expirydate"),rs.getString("cardholdername"),rs.getString("Amount"),rs.getString("Payment")};
					dt.addRow(o);
					}
				
			}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(27, 24, 129, 35);
		contentPane.add(btnNewButton);
		scrollPane.setViewportView(table);
		
		final JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					finalpayment newframe = new finalpayment();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1, this, "Error while establishing connection failed", 0);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBounds(37, 585, 107, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("next");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Ongoing newframe = new Ongoing();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_2).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_2, this, "Error while establishing connection failed", 0);
				}

			}
		});
		btnNewButton_2.setBounds(478, 571, 116, 35);
		contentPane.add(btnNewButton_2);
	}
}
