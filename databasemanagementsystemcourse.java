package Management;
import Management.LoginPage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.AbstractListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

public class dbms extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPane_1;
	private int progressBar;
	static JProgressBar r;
	private JMenuBar menuBar;
	static JLabel lblNewLabel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dbms frame = new dbms();
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
	public dbms() {
		Color ProgressDefault;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 608);
		
		 menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Week 1");
		mntmNewMenuItem.setForeground(Color.WHITE);
		mntmNewMenuItem.setFont(new Font("Footlight MT Light", Font.BOLD | Font.ITALIC, 18));
		mntmNewMenuItem.setBackground(Color.BLACK);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Chapter 1");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println((new File("C:\\Users\\vinot\\Downloads\\Silberschatz_A_databases_6th_edition_ebookpdf (1).pdf")).exists()); 
					Process p =Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler  \"C:\\Users\\vinot\\Downloads\\Silberschatz_A_databases_6th_edition_ebookpdf (1).pdf");
					File pdfFile = new File("C:\\Users\\vinot\\Downloads\\Silberschatz_A_databases_6th_edition_ebookpdf (1).pdf");
					Desktop.getDesktop().open(pdfFile);
					 p.waitFor();
					}
					catch(Exception o) {
						JOptionPane.showMessageDialog(mntmNewMenuItem_1 , this, "Error while establishing connection failed", 0);
					}
			}
		});
		mntmNewMenuItem_1.setForeground(Color.WHITE);
		mntmNewMenuItem_1.setFont(new Font("Perpetua", Font.ITALIC, 16));
		mntmNewMenuItem_1.setBackground(new Color(64, 128, 128));
		mnNewMenu.add(mntmNewMenuItem_1);
		r = new JProgressBar();
		menuBar.add(r);
		r.setValue(0);
		r.setBackground(Color.white);
		r.setForeground(Color.green);
		ProgressDefault = r.getForeground();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				
				private String username;

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int x = r.getValue();
					int y=x+10;
					r.setValue(x + 10);	
	;;				lblNewLabel.setText(""+y+"%");
					
					}
			});
		
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Chapter 2");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File pdfFile = new File("C:\\Users\\vinot\\Pictures\\Saved Pictures\\24042020_Transaction Management in DBMS.pdf");
				try {
					Desktop.getDesktop().open(pdfFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_1_1.setForeground(Color.WHITE);
		mntmNewMenuItem_1_1.setFont(new Font("Perpetua", Font.ITALIC, 16));
		mntmNewMenuItem_1_1.setBackground(new Color(64, 128, 128));
		mnNewMenu.add(mntmNewMenuItem_1_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int x = r.getValue();
					int y=x+10;
					r.setValue(x + 10);	
	;;				lblNewLabel.setText(""+y+"%");
				}
			});
		
		JMenuItem mntmNewMenuItem_1_1_2_1 = new JMenuItem("Assignment 1");
		mntmNewMenuItem_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DbmsAssignment2 newframe = new DbmsAssignment2 ();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(mntmNewMenuItem_1_1_2_1).dispose();
				}
				catch(Exception o) {
					
					
				}
			}
		});
		mntmNewMenuItem_1_1_2_1.setForeground(Color.WHITE);
		mntmNewMenuItem_1_1_2_1.setFont(new Font("Perpetua", Font.ITALIC, 16));
		mntmNewMenuItem_1_1_2_1.setBackground(new Color(64, 128, 128));
		mnNewMenu.add(mntmNewMenuItem_1_1_2_1);
mntmNewMenuItem_1_1_2_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int x = r.getValue();
				int y=x+20;
				r.setValue(x + 20);	
				lblNewLabel.setText(""+y+"%");	
			}
		});
		
		JMenuItem mntmWeek = new JMenuItem("Week 2");
		mntmWeek.setForeground(Color.WHITE);
		mntmWeek.setFont(new Font("Footlight MT Light", Font.BOLD | Font.ITALIC, 18));
		mntmWeek.setBackground(Color.BLACK);
		mnNewMenu.add(mntmWeek);
		
		JMenuItem mntmNewMenuItem_1_1_1 = new JMenuItem("Chapter 3");
		mntmNewMenuItem_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File pdfFile = new File("C:\\Users\\vinot\\Pictures\\Saved Pictures\\ch7.pdf");
				try {
					Desktop.getDesktop().open(pdfFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_1_1_1.setForeground(Color.WHITE);
		mntmNewMenuItem_1_1_1.setFont(new Font("Perpetua", Font.ITALIC, 16));
		mntmNewMenuItem_1_1_1.setBackground(new Color(64, 128, 128));
		mnNewMenu.add(mntmNewMenuItem_1_1_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			mntmNewMenuItem_1_1_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int x = r.getValue();
					int y=x+10;
					r.setValue(x + 10);	
					lblNewLabel.setText(""+y+"%");	
				}
			});
		
		JMenuItem mntmNewMenuItem_1_1_2 = new JMenuItem("Assignment 2");
		mntmNewMenuItem_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DbmsAssignment newframe = new DbmsAssignment ();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(mntmNewMenuItem_1_1_2).dispose();
				}
				catch(Exception o) {
					
					
				}
			}
		});
		mntmNewMenuItem_1_1_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int x = r.getValue();
				int y=x+20;
				r.setValue(x + 20);	
				lblNewLabel.setText(""+y+"%");	
			}
		});
		
		JMenuItem mntmNewMenuItem_1_1_1_1 = new JMenuItem("Chapter 4");
		mntmNewMenuItem_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File pdfFile = new File("C:\\Users\\vinot\\Downloads\\ch15.pdf");
				try {
					Desktop.getDesktop().open(pdfFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_1_1_1_1.setForeground(Color.WHITE);
		mntmNewMenuItem_1_1_1_1.setFont(new Font("Perpetua", Font.ITALIC, 16));
		mntmNewMenuItem_1_1_1_1.setBackground(new Color(64, 128, 128));
		mnNewMenu.add(mntmNewMenuItem_1_1_1_1);
		mntmNewMenuItem_1_1_1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int x = r.getValue();
				int y=x+10;
				r.setValue(x + 10);	
				lblNewLabel.setText(""+y+"%");	
			}
		});
		
		mntmNewMenuItem_1_1_2.setForeground(Color.WHITE);
		mntmNewMenuItem_1_1_2.setFont(new Font("Perpetua", Font.ITALIC, 16));
		mntmNewMenuItem_1_1_2.setBackground(new Color(64, 128, 128));
		mnNewMenu.add(mntmNewMenuItem_1_1_2);
		
		JMenuItem mntmNewMenuItem_1_1_2_2 = new JMenuItem("Final Assignment");
		mntmNewMenuItem_1_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DbmsAssignment3 newframe = new DbmsAssignment3 ();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(mntmNewMenuItem_1_1_2_2).dispose();
				}
				catch(Exception o) {
					
					
				}
			}
		});
		mntmNewMenuItem_1_1_2_2.setForeground(Color.WHITE);
		mntmNewMenuItem_1_1_2_2.setFont(new Font("Perpetua", Font.ITALIC, 16));
		mntmNewMenuItem_1_1_2_2.setBackground(new Color(64, 128, 128));
		mnNewMenu.add(mntmNewMenuItem_1_1_2_2);
		
		contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		mntmNewMenuItem_1_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String username=LoginPage.username;
					int x = r.getValue();
					r.setValue(x + 20);
					//File pdfFile = new File("C:\\Users\\vinot\\Downloads\\Silberschatz_A_databases_6th_edition_ebookpdf (1).pdf");
					//try {
						//Desktop.getDesktop().open(pdfFile);
					//} catch (IOException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					//}	
				
					int x1 = r.getValue();
					int y=x+20;
					r.setValue(x + 20);	
					lblNewLabel.setText(""+y+"%");
					if(x1==100) {
						System.out.print("hello:)");
						try {
						    String s="Database Management";
						    String c="DB-007";
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
							String sql="insert into completed values(?,?,?,?,?,?,?)";
							PreparedStatement pts=con.prepareStatement(sql);
							
							pts.setString(2,c);
							pts.setString(3, s);
							pts.setString(1, username);
							
							pts.setInt(4,0);
							pts.setInt(5,0);
							pts.setInt(6,0);
							pts.setInt(7,0);
							
							

							
							pts.executeUpdate();
						
							 
							
						
						}
							catch(Exception ex) {
								ex.printStackTrace();}
						
						}
					
					}
		});
		

		setContentPane(contentPane_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(10, 476, 85, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ongoing newframe = new Ongoing();
				newframe.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton).dispose();
			}
		});
		contentPane_1.setLayout(null);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 707, 505);
		contentPane_1.add(scrollPane);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		list.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 20));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"\t\tA Database Management System (DBMS) is a software suite designed ", "\t\tto efficiently store, manage, and retrieve data. It serves as an intermediary ", "\t\tbetween users and databases, offering an organized and secure way to interact", "\t\twith data. Think of it as a digital librarian, overseeing the storage and organization", "\t\tof information within a computer system.", "", "", "", "", "\t\tDBMS allows users to create, update, delete, and manipulate data while ensuring", "\t\tdata integrity, security, and concurrency control. It provides a structured framework", "\t\tfor storing data in various formats, such as tables, documents, or graphs, and offers", "\t\tmechanisms for querying and analyzing this data.", "", "", "", "", "\t\tOne of the primary advantages of using a DBMS is its ability to handle large volumes ", "\t\tof data and support multiple users accessing the data simultaneously. It also provides", "\t\tmechanisms for data backup, recovery, and data modeling, enabling users to design ", "\t\tefficient database schemas that suit their specific requirements.", "", "", "", "", "\t\tOverall, DBMS plays a crucial role in modern information systems, powering applications ", "\t\tranging from simple personal databases to large-scale enterprise systems. Its importance ", "\t\tlies in its ability to efficiently manage data, ensuring its accessibility, security, and reliability ", "\t\tfor various users and applications."};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		 lblNewLabel = new JLabel("");
		 lblNewLabel.setText(""+r.getString());
		lblNewLabel.setBounds(641, 10, 66, 19);
		contentPane_1.add(lblNewLabel);
	}

}
