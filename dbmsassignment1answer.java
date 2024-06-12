package Management;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class a1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					a1 frame = new a1();
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
	public a1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 934, 608);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"  Que1: In a database transaction, what is a savepoint?", "", "             Answer: B) A point in the transaction where a partial rollback can be performed.", "", "  Que2: What does ACID stand for in the context of database transactions?", "", "             Answer: D) Atomicity, Consistency, Isolation, Durability", " ", "  Que3: What does the durability property of a transaction ensure?", "", "             Answer: B) That once a transaction is committed, its effects are permanent", "", "   Que4: What is a distributed transaction?", "", "             Answer: B) A transaction that involves multiple databases on different servers", "", "   Que5: What is a transaction in a database context?", "", "             Answer: B) An isolated unit of work that accesses and possibly modifies various data items", "", "   Que6: What is a transaction rollback?", "", "             Answer: B) A mechanism to undo changes made by a transaction if it is aborted", "", "   Que7: What is the purpose of the isolation property in database transactions?", "", "            Answer: D) To ensure that the intermediate states of transactions are not visible to other transactions", "", "   Que8: Which of the following is not a common technique for ensuring transaction durability?", "", "            Answer: D) Load balancing", "", "  Que9:  Which of the following is not a component of a transaction processing system (TPS)?", "", "           Answer: D) Query optimizer", "", "   Que10: Which of the following is not a correct statement regarding the atomicity property of transactions?", "", "           Answer: D) It ensures that each transaction is isolated from other transactions."};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new dbms().setVisible(true);
				dbms.r.setValue(80);
				dbms.lblNewLabel.setText(""+80+"%");
				dispose();
				//SwingUtilities.windowForComponent(btnNewButton).dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(739, 637, 85, 21);
		contentPane.add(btnNewButton);
		
	}
}
