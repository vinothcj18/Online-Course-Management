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

public class DbmsAssignment3 extends JFrame implements ActionListener {

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
                    DbmsAssignment3 frame = new DbmsAssignment3();
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
    public DbmsAssignment3() {
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
        //getContentPane().add(btnResult1);

        int count = 0, current = 0, x = 1, y = 1, now = 0;
        int m[] = new int[10];

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

    public DbmsAssignment3(String string) {
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
        	a3 newframe = new a3();
			newframe.setVisible(true);
			SwingUtilities.windowForComponent(btnResult1).dispose();
        }
        if (e.getActionCommand().equals("Result")) {
            if (check())
                count++;
            current++;
            
            JOptionPane.showMessageDialog(this, "Total Mark : " + count);
            getContentPane().add(btnResult1);
			    // Handle any SQL errors
            try {   
 			   
            	Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Kingmakercj18");
				
				String sql="update completed set Final_Assignment='"+count+"'  where username='"+LoginPage.username+"' and Course_id = '"+Ongoing.comboBox.getSelectedItem()+"'";
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
            label.setText("Que1: What is query processing in a database management system (DBMS)?");
            radioButton[0].setText(" The process of querying data from the database");
            radioButton[1].setText(" The process of interpreting and executing queries.");
            radioButton[2].setText(" The process of storing queries for future use.");
            radioButton[3].setText(" The process of designing databases.");
            radioButton[0].setSelected(false); // Set default as false
        }
        if (current == 1) {
			label.setText("Que2: Which of the following steps is NOT involved in query processing?");
			radioButton[0].setText(" Parsing and translating queries");
			radioButton[1].setText(" Optimizing query execution");
			radioButton[2].setText(" Compiling SQL queries into machine code");
			radioButton[3].setText(" Executing the query plan");
		}
		if (current == 2) {
			label.setText("Que3:What is query optimization in DBMS?");
			radioButton[0].setText(" The process of translating SQL queries into low-level machine instructions");
			radioButton[1].setText(" The process of selecting the most efficient query execution plan");
			radioButton[2].setText(" The process of indexing tables for faster query retrieval");
			radioButton[3].setText(" The process of validating SQL syntax");
		}
		if (current == 3) {
			label.setText("Que4: Which of the following is NOT a common query optimization technique?");
			radioButton[0].setText(" Indexing");
			radioButton[1].setText(" Join elimination");
			radioButton[2].setText(" Loop optimization");
			radioButton[3].setText(" Predicate pushdown");
		}
		if (current == 4) {
			label.setText("Que5: What is a query execution plan?");
			radioButton[0].setText(" A plan for designing a database schema");
			radioButton[1].setText(" A plan for designing a database schema");
			radioButton[2].setText(" A plan for executing a query, including the sequence of operations");
			radioButton[3].setText(" A plan for backing up database data");
		}
		if (current == 5) {
			label.setText("Que6: What is predicate pushdown?");
			radioButton[0].setText(" The process of pushing down aggregate functions in a query");
			radioButton[1].setText(" The process of pushing down filters or conditions to the data source");
			radioButton[2].setText(" The process of pushing down sorting operations in a query");
			radioButton[3].setText(" The process of pushing down subqueries to improve performance");
		}
		if (current == 6) {
			label.setText("Que7: Which component of DBMS is responsible for parsing and translating SQL queries?	");
			radioButton[0].setText(" Query Optimizer");
			radioButton[1].setText(" Query Executor");
			radioButton[2].setText(" Query Parser");
			radioButton[3].setText(" Query Compiler");
		}
		if (current == 7) {
			label.setText("Que8: What is join elimination in query optimization? ");
			radioButton[0].setText(" The process of removing unnecessary joins from the query plan");
			radioButton[1].setText(" The process of joining multiple tables to retrieve data");
			radioButton[2].setText(" The process of indexing join columns for faster performance");
			radioButton[3].setText(" The process of executing join queries in parallel");
		}
		if (current == 8) {
			label.setText("Que9: Which of the following is NOT a type of join operation in SQL?");
			radioButton[0].setText(" INNER JOIN");
			radioButton[1].setText(" OUTER JOIN");
			radioButton[2].setText(" CROSS JOIN");
			radioButton[3].setText(" MERGE JOIN");
		}
		if (current == 9) {
			label.setText("Que10:What is query caching in DBMS?");
			radioButton[0].setText(" The process of storing frequently executed queries in memory for faster retrieval");
			radioButton[1].setText(" The process of encrypting SQL queries for security purposes");
			radioButton[2].setText(" The process of compressing query results to save storage space");
			radioButton[3].setText(" The process of parallelizing query execution for improved performance");
		}
		
//... Rest of the questions
    }

    // declare right answers.
    boolean check() {
    	if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[2].isSelected());
		if (current == 2)
			return (radioButton[1].isSelected());
		if (current == 3)
			return (radioButton[2].isSelected());
		if (current == 4)
			return (radioButton[1].isSelected());
		if (current == 5)
			return (radioButton[2].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[3].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
    

//... Rest of the checks
   
    }
}