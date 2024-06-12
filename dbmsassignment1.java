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

public class DbmsAssignment2 extends JFrame implements ActionListener {

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
                    DbmsAssignment2 frame = new DbmsAssignment2();
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
    public DbmsAssignment2() {
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
       

        int count = 0, current = 0, x = 1, y = 1, now = 0;
        int m[] = new int[11];

        set();

        label.setBounds(30, 40, 550, 20);
        radioButton[0].setBounds(50, 80, 550, 20);
        radioButton[1].setBounds(50, 110, 550, 20);
        radioButton[2].setBounds(50, 140, 550, 20);
        radioButton[3].setBounds(50, 170, 550, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnResult.setBounds(270, 240, 100, 30);
        btnResult1.setBounds(410, 240, 100, 30);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocation(250, 100);
        setSize(600, 350);
    }

    public DbmsAssignment2(String string) {
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
                btnResult1.setVisible(true);
                btnResult1.setText("view answer");
                
                
            }
            
        }
        if (e.getActionCommand().equals("view answer")) {
        	hi newframe = new hi();
			newframe.setVisible(true);
			SwingUtilities.windowForComponent(btnResult1).dispose();
        }
        if (e.getActionCommand().equals("Result")) {
            if (check())
                count++;
            current++;
            
            JOptionPane.showMessageDialog(this, "Total Mark: " + count);
            getContentPane().add(btnResult1);
            
			    // Handle any SQL errors
            try {   
 			   
            	Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
				
				String sql="update completed set Assignment='"+count+"'  where username='"+LoginPage.username+"' and Course_id = '"+Ongoing.comboBox.getSelectedItem()+"'";
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
            label.setText("Que1: In a database transaction, what is a savepoint?");
            radioButton[0].setText(" A point in the transaction where the changes are saved to disk");
            radioButton[1].setText(" A point in the transaction where a partial rollback can be performed.");
            radioButton[2].setText(" A point in the transaction where the transaction is committed.");
            radioButton[3].setText(" A point in the transaction where the transaction is aborted.");
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
			label.setText("Que3:What does the durability property of a transaction ensure?");
			radioButton[0].setText(" That transactions are executed in a durable manner");
			radioButton[1].setText(" That once a transaction is committed, its effects are permanent");
			radioButton[2].setText(" That transactions are executed in a consistent manner");
			radioButton[3].setText(" That transactions are isolated from each other");
		}
		if (current == 3) {
			label.setText("Que4: What is a distributed transaction?");
			radioButton[0].setText(" A transaction that involves multiple databases on the same server");
			radioButton[1].setText(" A transaction that involves multiple databases on different servers");
			radioButton[2].setText(" A transaction that involves multiple tables within the same database");
			radioButton[3].setText(" A transaction that is executed over a network connection");
		}
		if (current == 4) {
			label.setText("Que5: What is a transaction in a database context?");
			radioButton[0].setText(" A series of operations performed on a single table");
			radioButton[1].setText(" Second Normal Form (2NF)");
			radioButton[2].setText(" Third Normal Form (3NF)");
			radioButton[3].setText(" Fourth Normal Form (4NF)");
		}
		if (current == 5) {
			label.setText("Que6: Which of the following is not a data manipulation operation in SQL?");
			radioButton[0].setText(" A series of operations performed on a single table");
			radioButton[1].setText(" An isolated unit of work that accesses and possibly modifies various data items");
			radioButton[2].setText(" A query executed by a user");
			radioButton[3].setText(" A database backup operation");
		}
		if (current == 6) {
			label.setText("Que7: What is a transaction rollback?	");
			radioButton[0].setText(" A database operation that reads data but does not modify it");
			radioButton[1].setText(" A mechanism to undo changes made by a transaction if it is aborted");
			radioButton[2].setText(" A mechanism to permanently delete data from the database");
			radioButton[3].setText(" A database operation that modifies data");
		}
		if (current == 7) {
			label.setText("Que8: What is the purpose of the isolation property in database transactions? ");
			radioButton[0].setText(" To ensure that transactions are executed concurrently");
			radioButton[1].setText(" To ensure that transactions are executed serially");
			radioButton[2].setText(" To prevent unauthorized access to the database");
			radioButton[3].setText(" To ensure that the intermediate states of transactions are not visible to other transactions");
		}
		if (current == 8) {
			label.setText("Que9: Which of the following is not a common technique for ensuring transaction durability?");
			radioButton[0].setText(" Write-ahead logging");
			radioButton[1].setText(" Shadow paging");
			radioButton[2].setText(" Checkpointing");
			radioButton[3].setText(" Load balancing");
		}
		if (current == 9) {
			label.setText("Que10:Which of the following is not a component of a transaction processing system (TPS)?");
			radioButton[0].setText(" Transaction manager");
			radioButton[1].setText(" Recovery manager	");
			radioButton[2].setText(" User interface");
			radioButton[3].setText(" Query optimizer");
		}
		
//... Rest of the questions
    }

    // declare right answers.
    boolean check() {
    	if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[3].isSelected());
		if (current == 2)
			return (radioButton[1].isSelected());
		if (current == 3)
			return (radioButton[1].isSelected());
		if (current == 4)
			return (radioButton[1].isSelected());
		if (current == 5)
			return (radioButton[1].isSelected());
		if (current == 6)
			return (radioButton[3].isSelected());
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