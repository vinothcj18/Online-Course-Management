package Management;
import  Management.billCourses;
import  Management.finalpayment;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;

public class report extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextComponent textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					report frame = new report();
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
	public report() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 681, 531);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.append("\n\n\n"+
				"\tPhone NO:9345732050\t\t\t    www.onlineeducation\n"+
				"\tPhone NO:9500417970\t\t\t    email:elearning@gmail.com\n\n\n"+
				"\t\t     ONLINE EDUCATION  \n\n"+
				"\t\t        FEE REPORT\n\n"+
				
				"\tCourse Name:\t\t\t\t"+billCourses.textField.getText()+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				"\tCourse_id:\t\t\t\t"+billCourses.textField_1.getText()+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				"\tAmount:\t\t\t\t"+finalpayment.textField_3.getText()+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				"\tPayee Name:\t\t\t\t"+finalpayment.textField_2.getText()+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				"\t\t\"CASH RECEIVED BY ONLINE EDUCATION \n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				"==========================================================================\n\n\n\n\n"+
				"\t\t*NO REFUND IS AVAILABLE FOR WRONG PAYMENT!\n"+
				"\t \n"
				);
	

JButton btnNewButton = new JButton("Print");
btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
btnNewButton.setBounds(161, 571, 122, 40);
contentPane.add(btnNewButton);
JButton btnNewButton_1 = new JButton("Back");
btnNewButton_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {
			viewpasttransaction newframe = new viewpasttransaction();
			newframe.setVisible(true);
			SwingUtilities.windowForComponent(btnNewButton_1).dispose();
		}
		catch(Exception o) {
			JOptionPane.showMessageDialog(btnNewButton_1, this, "Error while establishing connection failed", 0);
			o.printStackTrace();
		}
	}
});
btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
btnNewButton_1.setBounds(410, 571, 97, 40);
contentPane.add(btnNewButton_1);
btnNewButton.addActionListener(new ActionListener() {
	

	public void actionPerformed(ActionEvent e) {
		try {
			textArea.print();
		} catch (PrinterException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
});}}
