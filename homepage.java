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
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import java.awt.Color;

public class menupage extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menupage frame = new menupage();
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
	public menupage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 521);
		getContentPane().setLayout(null);
		
		final JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage newframe = new LoginPage();
				newframe.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton).dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(20, 431, 85, 32);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 937, 430);
		getContentPane().add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("Perpetua", Font.PLAIN, 15));
		list.setBackground(new Color(0, 255, 255));
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"About Us :", "", "", "    Online Education, is a joint venture of the IITs and IISc,", "    funded by the Ministry of Education (MoE) Government of India, and was launched in 2003. ", "    Initially started as a project to take quality education to all corners of the country, ", "    now offers close to 600+ courses for certification every semester in about 22 disciplines.", "", "", "", "Some highlights :", "", "\t1) Largest online repository in the world of courses in engineering, basic sciences and selected", "          humanities and management subjects", "\t2) YouTube channel for Online Education – most subscribed educational channel, 1.3 billion views", "          and 40+ lakhs subscribers", "\t3) More than 56000 hours of video content, transcribed and subtitled", "\t4) Most accessed library of peer-reviewed educational content in the world", "\t5) Translation of more than 12000 hrs of English transcripts in regional Indian languages.", "", "", " Online Certification:", "", "", "", "\t* The objective of enabling students obtain certificates for courses is to make students employable ", "        in the industry or pursue a suitable higher education programme. ", "\t* Through an online portal, 4, 8, or 12-week online courses, typically on topics relevant to students in", "        all years of higher education along with basic core courses in sciences and ", "\t  humanities with exposure to relevant tools and technologies, are being offered. Enrolment to and learning from these courses is free.", "\t* Following these online courses, an in-person, proctored certification exam is conducted and a certificate is provided through", "        the participating institutions and industry, as applicable.", "", "  Some statistics regarding the open online courses since March 2014 till Dec 2021:", "", "  \tCompleted courses: 3496;", "\t Enrollments across courses: 1.58 CRORE +", " \tNumber of exam registrations: 15.1 LAKH +", "", " Certification process:", "", "\t1) Subject Matter Experts (SME - faculty from IITs or partner institutes with input from industry)", "          create recorded video content for courses.", "\t2) The course is uploaded on the portal and opened for enrollments, which is free.", "\t3) Every week, about 3 hrs of video content is released along with an assignment , which is evaluated and", "          provides the student with a score.", "\t4) Teaching Assistants (TAs) and the faculty members support the discussion forum – answering questions and clearing doubts.", "\t5) If someone wants to get a certificate from the IITs/IISc after doing the course, he/she should register for the in-person proctored certification exam", "\t    that is conducted in 170+ cities across India and in select cities outside India too in collaboration with an exam partner.", "          For learners in many other countries looking to get certified,", "          online remote proctored exams are also administered. The certification exam is not free but has a nominal fee of Rs 1000.", "\t6) A learner will pass and be certified only if Average assignment score (out of 100) >= 40 AND Final exam score ( out of 100) >= 40. ", "\t    E-verifiable certificates are made available inside the candidate login. Only e-certificates will be published.", "          Hard copies of certificates will NOT be printed.", "          The pass criteria depends on the courses. The above mentioned is applicable for most of the courses but for those courses ", "          which have non proctored programming exams and for courses in other disciplines, the pass criteria may be different.", "\t7) These certificates are envisioned for use in credit transfer to universities or for making the student more employable or for ", "           enhancing their growth in their current place of work."};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblNewLabel = new JLabel("About us :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblNewLabel.setBounds(38, 32, 97, 38);
		getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		final JMenuItem mntmNewMenuItem = new JMenuItem("All Courses");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollall o=new scrollall();
				o.main(null);
			}
		});
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mnNewMenu.add(mntmNewMenuItem);
		
		final JMenuItem mntmNewMenuItem_1 = new JMenuItem("Ongoing");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ongoing s=new Ongoing();
				s.main(null);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		final JMenuItem mntmNewMenuItem_2 = new JMenuItem("Upcoming");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Upcoming a=new Upcoming();
				a.main(null);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		final JMenuItem mntmNewMenuItem_3 = new JMenuItem("Completed");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Completed f=new Completed();
				f.main(null);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Close");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menupage v =new menupage();
				v.main(null);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mnNewMenu.add(mntmNewMenuItem_4);
	}
}
