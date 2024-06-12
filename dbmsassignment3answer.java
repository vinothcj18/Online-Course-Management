package Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class a3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					a3 frame = new a3();
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
	public a3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 761);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 894, 667);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"   Que1: What is query processing in a database management system (DBMS)?", "", "        Answer: b) The process of interpreting and executing queries", "", "   Que2: Which of the following steps is NOT involved in query processing?", "", "        Answer: c) Compiling SQL queries into machine code", "", "   Que3: What is query optimization in DBMS?", "", "        Answer: b) The process of selecting the most efficient query execution plan", "", "   Que4: Which of the following is NOT a common query optimization technique?", "", "        Answer: c) Loop optimization", "", "   Que5: What is a query execution plan?", "", "        Answer: b) A plan for executing a query, including the sequence of operations", "", "   Que6: Which component of DBMS is responsible for parsing and translating SQL queries?", "", "        Answer: c) Query Parser", "", "   Que7: What is join elimination in query optimization?", "", "        Answer: a) The process of removing unnecessary joins from the query plan", "", "   Que8: What is predicate pushdown?", "", "        Answer: b) The process of pushing down filters or conditions to the data source", "", "   Que9: Which of the following is NOT a type of join operation in SQL?", "", "        Answer: d) MERGE JOIN", "", "  Que10: What is query caching in DBMS?", "        ", "        Answer: a) The process of storing frequently executed queries in memory for faster retrieval"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Completed newframe = new Completed();
				newframe.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton).dispose(); 
			}
		});
		btnNewButton.setBounds(751, 693, 103, 31);
		contentPane.add(btnNewButton);
	}

}
