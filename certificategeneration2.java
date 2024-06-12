package Management;
import Management.generating;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;

public class cert extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cert frame = new cert();
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
	public cert() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Completed newframe = new Completed();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1, this, "Error while establishing connection failed", 0);
					o.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(416, 607, 91, 29);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 758, 579);
		contentPane.add(scrollPane);
		
		 textPane = new JTextPane();
		 //textPane.setText("Vinoth");
		 textPane.insertIcon(new ImageIcon("C:\\Users\\vinot\\Downloads\\of COMPLETION.png"));
		scrollPane.setViewportView(textPane);
		JLabel r = new JLabel("login.username");
		r.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		r.setPreferredSize(new Dimension(300,300));
		r.setBounds(300,180,200,50);
		
		String gh=generating.textField.getText();
		r.setText("");
		 
		//JTextArea t = new JTextArea();
		//t.setPreferredSize(new Dimension(300,300));
		////t.append(gh);
		//t.setBounds(300,180,200,50);
		//textPane.insertComponent(t);
		//textPane.add(t);
		textPane.add(r);
		
		JLabel r1 = new JLabel("DATABASE MANAGEMENT SYSTEM");
		r1.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		r1.setPreferredSize(new Dimension(300,300));
		r1.setBounds(350,230,350,50);
		String gh1=generating.textField.getText();
		r1.setText((String) generating.comboBox.getSelectedItem());
		
		//textPane.insertIcon(new ImageIcon("C:\\Users\\vinot\\Downloads\\of COMPLETION.png"));
		textPane.add(r1);
		JButton btnNewButton = new JButton("Download");
		btnNewButton.addActionListener(new ActionListener() {
			//private JTextComponent textPane;

			public void actionPerformed(ActionEvent e) {
				try {
					
					textPane.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
		});
		btnNewButton.setBounds(107, 606, 154, 31);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnNewButton);
		}
}
