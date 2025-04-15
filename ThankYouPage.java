import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThankYouPage {
    private JFrame frame;

    public ThankYouPage() {
        frame = new JFrame("Foodie - Thank You!");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(135, 206, 250);
                Color color2 = new Color(255, 105, 180);
                GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        gradientPanel.setLayout(null);
        frame.setContentPane(gradientPanel);

        JLabel thankYouLabel = new JLabel("Thank You for Ordering!", SwingConstants.CENTER);
        thankYouLabel.setFont(new Font("Arial", Font.BOLD, 24));
        thankYouLabel.setBounds(100, 80, 400, 30);
        thankYouLabel.setForeground(Color.WHITE);
        gradientPanel.add(thankYouLabel);

        JLabel subText = new JLabel("Your delicious food is on the way!", SwingConstants.CENTER);
        subText.setFont(new Font("Arial", Font.PLAIN, 16));
        subText.setBounds(100, 120, 400, 25);
        subText.setForeground(Color.WHITE);
        gradientPanel.add(subText);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(150, 250, 130, 40);
        exitButton.setBackground(new Color(255, 69, 0));
        exitButton.setForeground(Color.WHITE);
        gradientPanel.add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Thank you! Visit Again.");
                System.exit(0);
            }
        });

        JButton homeButton = new JButton("Back to Home");
        homeButton.setBounds(320, 250, 150, 40);
        homeButton.setBackground(new Color(50, 205, 50));
        homeButton.setForeground(Color.WHITE);
        gradientPanel.add(homeButton);

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new FoodOrderingPage(); // Back to menu
            }
        });

        frame.setVisible(true);
    }
}
