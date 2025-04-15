import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen {
    public LoginScreen() {
        JFrame frame = new JFrame("Foodie - Login");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // Background Image
        ImageIcon bgImage = new ImageIcon(""); // Add your own background image path
        JLabel bgLabel = new JLabel(bgImage);
        bgLabel.setBounds(0, 0, 800, 500);
        frame.add(bgLabel);

        // Transparent Panel for Login Form
        JPanel panel = new JPanel();
        panel.setBounds(450, 100, 300, 300);
        panel.setBackground(new Color(0, 0, 0, 120));
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(120, 10, 100, 30);
        panel.add(titleLabel);

        JLabel userLabel = new JLabel(" Enter Username:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setBounds(20, 60, 100, 30);
        panel.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(120, 60, 150, 30);
        panel.add(userField);

        JLabel passLabel = new JLabel(" Enter Password:");
        passLabel.setForeground(Color.WHITE);
        passLabel.setBounds(20, 110, 100, 30);
        panel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(120, 110, 150, 30);
        panel.add(passField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(90, 180, 120, 30);
        loginButton.setBackground(new Color(255, 69, 0));
        loginButton.setForeground(Color.WHITE);
        panel.add(loginButton);

        JButton signupButton = new JButton("Signup");
        signupButton.setBounds(90, 220, 120, 30);
        signupButton.setBackground(Color.WHITE);
        panel.add(signupButton);

        bgLabel.add(panel);
        frame.setVisible(true);

        // Action Listeners
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                JOptionPane.showMessageDialog(frame, "Login Successful for: " + username);
                frame.dispose();
                new HomeScreen(username);
            }
        });

        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Redirecting to Signup Page...");
            }
        });
    }

    public static void main(String[] args) {
        new LoginScreen();
    }
}
