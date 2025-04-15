import javax.swing.*;
import java.awt.*;

public class SplashScreen {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Foodie App");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        frame.setSize(1000, 700);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        ImageIcon iconSplash = new ImageIcon(SplashScreen.class.getResource("/assets/images/splash.png"));

        // High quality scaling
        Image img = iconSplash.getImage().getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);

        JLabel label = new JLabel(scaledIcon);
        label.setLayout(new BorderLayout());  // To allow adding heading on image

        // Stylish Heading
        JLabel heading = new JLabel("WelCome ! My Food Delivery Application - Foodies", JLabel.CENTER);
        heading.setFont(new Font("Serif", Font.BOLD, 36));
        heading.setForeground(new Color(45, 106, 9));  // Dark navy shade
        heading.setOpaque(false);
        heading.setBorder(BorderFactory.createEmptyBorder(40, 10, 10, 10));

        // Add heading on top of the image
        label.add(heading, BorderLayout.NORTH);

        panel.add(label, BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);

        try {
            Thread.sleep(10000);  // Show splash screen for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        frame.dispose();  // Close splash screen
        new LoginScreen();  // Move to Login Page
    }
}
