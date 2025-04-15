import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OrderTracking {
    private JFrame frame;
    private JProgressBar progressBar;
    private JLabel statusLabel;
    private Timer timer;
    private int progress = 0;
    private String[] statuses = {"Order Placed", "Being Prepared", "Out for Delivery", "Delivered"};
    private int statusIndex = 0;

    public OrderTracking() {
        frame = new JFrame("Foodie - Order Tracking");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // Background Image    "/assets/images/splash.png"
        ImageIcon bgImage = new ImageIcon("/assets/images/tracking_bg.png"); // Add your background image
        JLabel bgLabel = new JLabel(bgImage);
        bgLabel.setBounds(0, 0, 600, 400);
        frame.add(bgLabel);

        // Status Label
        statusLabel = new JLabel("Order Status: " + statuses[statusIndex], SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 18));
        statusLabel.setBounds(150, 100, 300, 30);
        statusLabel.setForeground(Color.BLACK);
        bgLabel.add(statusLabel);

        // Progress Bar
        progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(100, 150, 400, 30);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        bgLabel.add(progressBar);

        // Start Tracking Button
        JButton trackButton = new JButton("Start Tracking");
        trackButton.setBounds(200, 220, 200, 40);
        trackButton.setBackground(new Color(200, 26, 111));
        trackButton.setForeground(Color.WHITE);
        bgLabel.add(trackButton);

        frame.setVisible(true);

        // Button Click Event
        trackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startTracking();
            }
        });
    }

    private void startTracking() {
        timer = new Timer(3000, new ActionListener() { // Updates every 3 seconds
            public void actionPerformed(ActionEvent e) {
                progress += 25;
                progressBar.setValue(progress);
                statusIndex++;

                if (statusIndex < statuses.length) {
                    statusLabel.setText("Order Status: " + statuses[statusIndex]);
                    new ThankYouPage();
                } else {
                    timer.stop();
                    JOptionPane.showMessageDialog(frame, "Your Order has been Delivered!");
                }
            }
        });

        timer.start();
    }

    public static void main(String[] args) {
        new OrderTracking();
    }
}