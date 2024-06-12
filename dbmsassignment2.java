package Management;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import Management.LoginPage;
import Management.Ongoing;

public class DbmsAssignment extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
	private static GraphicsConfiguration s;
    private JPanel contentPane;
	private JButton btnNext;
	private int count;
	private int current;
	private JButton btnResult;
	private JRadioButton[] radioButton=new JRadioButton[5];
	private JLabel label;
	private Connection con;
	private JButton btnResult1;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DbmsAssignment frame = new DbmsAssignment();
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
    public DbmsAssignment() {
        super(s);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setBounds(100, 100, 1000, 761);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setPreferredSize(new Dimension(500,500));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        label = new JLabel();
        contentPane.add(label);
        ButtonGroup bg = new ButtonGroup();

       // JRadioButton radioButton[] = new JRadioButton[5];
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            getContentPane().add(radioButton[i]);
            bg.add(radioButton[i]);
        }

         btnNext = new JButton("Next");
         btnResult = new JButton("Result");
        btnResult.setVisible(false);
        btnResult1 = new JButton("view answer");
        btnResult1.setVisible(false);
        

        btnNext.addActionListener(this);
        btnResult.addActionListener(this);
        btnResult1.addActionListener(this);
        getContentPane().add(btnNext);
        getContentPane().add(btnResult);
       // getContentPane().add(btnResult1);

        int count = 0, current = 0, x = 1, y = 1, now = 0;
        int m[] = new int[10];

        set();

        label.setBounds(30, 40, 450, 20);
        radioButton[0].setBounds(50, 80, 350, 20);
        radioButton[1].setBounds(50, 110, 350, 20);
        radioButton[2].setBounds(50, 140, 350, 20);
        radioButton[3].setBounds(50, 170, 350, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnResult.setBounds(270, 240, 100, 30);
        btnResult1.setBounds(410, 240, 100, 30);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocation(250, 100);
        setSize(600, 350);
    }

    public DbmsAssignment(String string) {
		// TODO Auto-generated constructor stub
	}

	// handle all actions based on event
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            if (check())
                count++;
            current++;
            
            set();
            if (current == 9) {
            	//getContentPane().removeAll();
            	//getContentPane().revalidate();
            	//getContentPane().add(btnResult1);
            	 //btnResult1.setBounds(270, 240, 100, 30);
                btnNext.setEnabled(false);
                btnResult.setVisible(true);
                btnResult.setText("Result");
                
                                
                
            }
            
        }
        if (e.getActionCommand().equals("view answer")) {
        	try {
				a1 newframe = new a1();
				newframe.setVisible(true);
				SwingUtilities.windowForComponent(btnResult1).dispose();
				
			}
			catch(Exception o) {
				
			}

        }
        if (e.getActionCommand().equals("Result")) {
            if (check())
                count++;
            current++;
            
            JOptionPane.showMessageDialog(this, "Total Mark: " + count);
            btnResult1.setVisible(true);
            btnResult1.setText("view answer");
            dbms.r.setValue(80);

            getContentPane().add(btnResult1);
            
			    // Handle any SQL errors
            try {   
 			   
            	Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
				
				String sql="update completed set Assignment_2='"+count+"'  where username='"+LoginPage.username+"' and Course_id = '"+Ongoing.comboBox.getSelectedItem()+"'";
				PreparedStatement pts=con.prepareStatement(sql);
				
				
				pts.executeUpdate();
				 JOptionPane.showMessageDialog(null,"it has been registered");
				 
	                    
	                			     
			    
            }
            catch(Exception E) {
            	JOptionPane.showMessageDialog(null,"it has been not registered");
            	E.printStackTrace();
            }
            btnNext.setEnabled(false);
            
            
           
				
			
		}
    }

    // SET Questions with options
    void set() {
        radioButton[4].setSelected(true);
        if (current == 0) {
            label.setText("Que1: What does a foreign key do in a relational database?");
            radioButton[0].setText(" It ensures that each record in a table is unique.");
            radioButton[1].setText(" It establishes a link between two tables.");
            radioButton[2].setText(" It defines the primary key of a table.");
            radioButton[3].setText(" It enforces data integrity rules.");
            radioButton[0].setSelected(false); // Set default as false
        }
        if (current == 1) {
			label.setText("Que2: What does ACID stand for in the context of database transactions?");
			radioButton[0].setText(" All Committed Is Durable");
			radioButton[1].setText(" Atomicity, Consistency, Isolation, Durability");
			radioButton[2].setText(" Atomic Commit Is Distributed");
			radioButton[3].setText(" All Changes In Database");
		}
		if (current == 2) {
			label.setText("Que3:What does DBMS stand for?");
			radioButton[0].setText(" Database Manipulation System");
			radioButton[1].setText(" Data-Based Management System");
			radioButton[2].setText(" Database Management System");
			radioButton[3].setText(" Data Manipulation System");
		}
		if (current == 3) {
			label.setText("Que4: What is a primary key in a relational database?");
			radioButton[0].setText(" A key used for encryption");
			radioButton[1].setText(" A unique identifier for each record in a table");
			radioButton[2].setText(" A key used for foreign key constraints");
			radioButton[3].setText(" A key used for indexing purposes");
		}
		if (current == 4) {
			label.setText("Que5: Which normalization form ensures that all non-key attributes are fully functionalally dependent on the primary key?");
			radioButton[0].setText("  First Normal Form (1NF)");
			radioButton[1].setText(" Second Normal Form (2NF)");
			radioButton[2].setText(" Third Normal Form (3NF)");
			radioButton[3].setText(" Fourth Normal Form (4NF)");
		}
		if (current == 5) {
			label.setText("Que6: Which of the following is not a data manipulation operation in SQL?");
			radioButton[0].setText(" INSERT");
			radioButton[1].setText(" DELETE");
			radioButton[2].setText(" MODIFY");
			radioButton[3].setText(" UPDATE");
		}
		if (current == 6) {
			label.setText("Que7: Which of the following is not a type of database backup?");
			radioButton[0].setText(" Incremental backup");
			radioButton[1].setText(" Differential backup");
			radioButton[2].setText(" Parallel backup");
			radioButton[3].setText(" Full backup");
		}
		if (current == 7) {
			label.setText("Que8: Which of the following is not a type of database model? ");
			radioButton[0].setText(" Relational model");
			radioButton[1].setText(" Hierarchical model");
			radioButton[2].setText(" Object-oriented model");
			radioButton[3].setText(" Structured model");
		}
		if (current == 8) {
			label.setText("Que9: Which of the following is not a type of SQL constraint?");
			radioButton[0].setText(" PRIMARY KEY");
			radioButton[1].setText(" UNIQUE");
			radioButton[2].setText(" FOREIGN KEY");
			radioButton[3].setText(" ORDER BY");
		}
		if (current == 9) {
			label.setText("Que10: Which of the following is not a type of SQL join?");
			radioButton[0].setText(" Inner join");
			radioButton[1].setText(" Outer join");
			radioButton[2].setText(" Cross join");
			radioButton[3].setText(" Parallel join");
		}
		
//... Rest of the questions
    }

    // declare right answers.
    boolean check() {
    	if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[2].isSelected());
		if (current == 3)
			return (radioButton[1].isSelected());
		if (current == 4)
			return (radioButton[1].isSelected());
		if (current == 5)
			return (radioButton[2].isSelected());
		if (current == 6)
			return (radioButton[2].isSelected());
		if (current == 7)
			return (radioButton[3].isSelected());
		if (current == 8)
			return (radioButton[3].isSelected());
		if (current == 9)
			return (radioButton[3].isSelected());
		return false;
    

//... Rest of the checks
   
    }
}