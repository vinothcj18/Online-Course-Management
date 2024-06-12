package Management;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class ForgotPassword extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextField textField;
    private JLabel captchaLabel;
    private JTextField captchaField;
    private String captcha;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ForgotPassword frame = new ForgotPassword();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static String generateCaptcha() {
        Random rand = new Random();
        int length = 7 + (Math.abs(rand.nextInt()) % 3);
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int base = Math.abs(rand.nextInt()) % 62;
            char charN;
            if (base < 26) {
                charN = (char) (65 + base);
            } else if (base < 52) {
                charN = (char) (97 + (base - 26));
            } else {
                charN = (char) (48 + (base - 52));
            }
            captcha.append(charN);
        }
        return captcha.toString();
    }

    public ForgotPassword() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1023, 765);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        captcha = generateCaptcha();

        JLabel lblNewLabel = new JLabel("Enter Captcha");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel.setBounds(94, 289, 155, 25);
        contentPane.add(lblNewLabel);

        captchaLabel = new JLabel(captcha);
        captchaLabel.setFont(new Font("Arial", Font.BOLD, 20));
        captchaLabel.setBounds(505, 289, 200, 30);
        contentPane.add(captchaLabel);

        captchaField = new JTextField();
        captchaField.setBounds(350, 289, 130, 30);
        contentPane.add(captchaField);
        captchaField.setColumns(10);

        JButton refreshButton = new JButton("Refresh Captcha");
        refreshButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                captcha = generateCaptcha();
                captchaLabel.setText(captcha);
            }
        });
        refreshButton.setBounds(695, 289, 150, 30);
        contentPane.add(refreshButton);

        final JRadioButton showPasswordRadioButton = new JRadioButton("Show Password");
        showPasswordRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPasswordRadioButton.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                    confirmPasswordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                    confirmPasswordField.setEchoChar('*');
                }
            }
        });
        showPasswordRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        showPasswordRadioButton.setBounds(701, 212, 131, 24);
        contentPane.add(showPasswordRadioButton);

        textField = new JTextField();
        textField.setFont(new Font("Footlight MT Light", Font.ITALIC, 18));
        textField.setBounds(352, 52, 298, 34);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel newPasswordLabel = new JLabel("Enter new password:");
        newPasswordLabel.setBounds(94, 137, 219, 31);
        newPasswordLabel.setFont(new Font("Bell MT", Font.BOLD, 20));
        contentPane.add(newPasswordLabel);

        JLabel confirmPasswordLabel = new JLabel("Confirm password:");
        confirmPasswordLabel.setBounds(94, 205, 200, 37);
        confirmPasswordLabel.setFont(new Font("Bell MT", Font.BOLD, 20));
        contentPane.add(confirmPasswordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Footlight MT Light", Font.ITALIC, 18));
        passwordField.setBounds(352, 138, 302, 31);
        contentPane.add(passwordField);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(new Font("Footlight MT Light", Font.ITALIC, 18));
        confirmPasswordField.setBounds(348, 209, 302, 31);
        contentPane.add(confirmPasswordField);

        final JButton backButton = new JButton("Back");
        backButton.setBounds(82, 631, 113, 31);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    LoginPage newFrame = new LoginPage();
                    newFrame.setVisible(true);
                    SwingUtilities.windowForComponent(backButton).dispose();
                } catch (Exception o) {
                    JOptionPane.showMessageDialog(backButton, "Error while establishing connection failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        contentPane.add(backButton);

        final JButton doneButton = new JButton("Done");
        doneButton.setBounds(784, 631, 100, 31);
        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String enteredCaptcha = captchaField.getText();
                if (!enteredCaptcha.equals(captcha)) {
                    JOptionPane.showMessageDialog(doneButton, "Incorrect Captcha!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String username = textField.getText();
                String newPassword = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (!newPassword.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(doneButton, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check password strength (at least 1 uppercase, 1 lowercase, 1 digit)
                int upperCount = 0;
                int lowerCount = 0;
                int digitCount = 0;
                for (char ch : newPassword.toCharArray()) {
                    if (Character.isUpperCase(ch))
                        upperCount++;
                    else if (Character.isLowerCase(ch))
                        lowerCount++;
                    else if (Character.isDigit(ch))
                        digitCount++;
                }

                if (upperCount < 1 || lowerCount < 1 || digitCount < 1) {
                    JOptionPane.showMessageDialog(doneButton, "Password should contain at least 1 uppercase, 1 lowercase, and 1 digit.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Update password in database
                Connection con = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "Kingmakercj18");
                    String sql = "UPDATE access SET password = ? WHERE username = ?";
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setString(1, newPassword);
                    stmt.setString(2, username);
                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(doneButton, "Password updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        LoginPage newFrame = new LoginPage();
                        newFrame.setVisible(true);
                        SwingUtilities.windowForComponent(doneButton).dispose();
                    } else {
                        JOptionPane.showMessageDialog(doneButton, "Failed to update password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(doneButton, "Error while establishing connection: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        if (con != null) {
                            con.close();
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(doneButton, "Error while closing connection: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        doneButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        contentPane.add(doneButton);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Bell MT", Font.BOLD, 20));
        usernameLabel.setBounds(99, 52, 188, 31);
        contentPane.add(usernameLabel);

        JLabel backgroundLabel = new JLabel("");
        backgroundLabel.setBounds(0, 0, 999, 728);
        backgroundLabel.setIcon(new ImageIcon("C:\\Users\\vinot\\Downloads\\WhatsApp Image 2024-03-03 at 20.41.03.jpeg"));
        contentPane.add(backgroundLabel);
    }
}
