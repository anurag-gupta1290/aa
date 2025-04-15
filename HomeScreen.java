import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeScreen {
    private String username;

    public HomeScreen(String username) {
        this.username = username;

        JFrame frame = new JFrame("Foodie - Home");
        frame.setSize(1800, 1200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // Background Image
        ImageIcon bgImage = new ImageIcon(getClass().getResource("/assets/images/mac.png"));
        JLabel bgLabel = new JLabel(bgImage);
        bgLabel.setBounds(0, 0, 900, 600);
        frame.add(bgLabel);

        // Navigation Bar
        JPanel navBar = new JPanel();
        navBar.setBounds(0, 0, 900, 50);
        navBar.setBackground(new Color(0, 0, 0, 180));
        navBar.setLayout(null);

        JButton homeBtn = new JButton("Home");
        homeBtn.setBounds(50, 10, 100, 30);
        homeBtn.setForeground(Color.WHITE);
        homeBtn.setBackground(Color.DARK_GRAY);
        navBar.add(homeBtn);

        JButton ordersBtn = new JButton("Orders");
        ordersBtn.setBounds(200, 10, 100, 30);
        ordersBtn.setForeground(Color.WHITE);
        ordersBtn.setBackground(Color.DARK_GRAY);
        navBar.add(ordersBtn);

        JButton profileBtn = new JButton("Profile");
        profileBtn.setBounds(350, 10, 100, 30);
        profileBtn.setForeground(Color.WHITE);
        profileBtn.setBackground(Color.DARK_GRAY);
        navBar.add(profileBtn);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(750, 10, 100, 30);
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setBackground(Color.RED);
        navBar.add(logoutBtn);

        bgLabel.add(navBar);

        // Restaurant Panel
        JPanel restaurantPanel = new JPanel();
        restaurantPanel.setLayout(new GridLayout(2, 2, 20, 20));
        restaurantPanel.setBounds(100, 100, 700, 400);
        restaurantPanel.setOpaque(false);

        // Add Restaurants
        addRestaurant(restaurantPanel, "McDonald's", "/assets/images/mac.png");
        addRestaurant(restaurantPanel, "Domino's Pizza", "/assets/images/dominos.png");
        addRestaurant(restaurantPanel, "Starbucks", "/assets/images/starbucks.png");
        addRestaurant(restaurantPanel, "Subway", "/assets/images/subway.png");

        bgLabel.add(restaurantPanel);

        frame.setVisible(true);

        // Navigation Button Actions
        homeBtn.addActionListener(e -> JOptionPane.showMessageDialog(frame, "You are already on Home."));
        ordersBtn.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Order section coming soon!"));
        profileBtn.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Logged in as: " + username));
        logoutBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Appliaction is Close...");
            Timer timer = new Timer(3000, evt -> System.exit(0));
            timer.setRepeats(false);
            timer.start();
        });
    }

    // Method to Add Restaurant Cards with Click Event
    private void addRestaurant(JPanel panel, String name, String imgPath) {
        JPanel restPanel = new JPanel();
        restPanel.setLayout(new BorderLayout());
        restPanel.setPreferredSize(new Dimension(150, 150));
        restPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ImageIcon icon = new ImageIcon(getClass().getResource(imgPath));
        Image img = icon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(img));
        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));

        restPanel.add(imgLabel, BorderLayout.CENTER);
        restPanel.add(nameLabel, BorderLayout.SOUTH);

        // Click listener to open FoodOrderingPage
        restPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new FoodOrderingPage();  // restaurant name pass kar sakte ho agar required ho
            }
        });

        panel.add(restPanel);
    }

    public static void main(String[] args) {
        new HomeScreen("Current user admin ");
    }
}