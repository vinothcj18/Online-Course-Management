package Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class hi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hi frame = new hi();
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
	public hi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 738);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 911, 649);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"   Que1: What does a foreign key do in a relational database?", "        ", "        Answer: B) It establishes a link between two tables.", "", "   Que2: What does ACID stand for in the context of database transactions?", "", "        Answer: B) Atomicity, Consistency, Isolation, Durability", "", "   Que3: What does DBMS stand for?", "        ", "        Answer: C) Database Management System", "", "  Que4:  What is a primary key in a relational database?", "", "        Answer: B) A unique identifier for each record in a table", "", "   Que5: Which normalization form ensures that all non-key attributes are fully functionalally dependent on the primary key?", "", "        Answer: B) Second Normal Form (2NF)", "", "   Que6: Which of the following is not a data manipulation operation in SQL?", "", "        Answer: C) MODIFY", "", "   Que7: Which of the following is not a type of database backup?", "", "        Answer: C) Parallel backup", "", "   Que8: Which of the following is not a type of database model?", "", "        Answer: D) Structured model", "", "   Que9 :Which of the following is not a type of SQL constraint?", " ", "        Answer: D) ORDER BY", "", "   Que10: Which of the following is not a type of SQL join?", "", "        Answer: D) Parallel join"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new dbms().setVisible(true);
				dbms.r.setValue(40);
				dbms.lblNewLabel.setText(""+40+"%");
				dispose();
			}
		});
		btnNewButton.setBounds(659, 669, 144, 32);
		contentPane.add(btnNewButton);
		
	}
}
