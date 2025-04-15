import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FoodOrderingPage {
    private JFrame frame;
    private JPanel cartPanel;
    private JLabel totalLabel;
    private int totalPrice = 0;
    private ArrayList<String> cartItems = new ArrayList<>();

    public FoodOrderingPage() {
        frame = new JFrame("Foodie - Order Your Food");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        ImageIcon bgImage = new ImageIcon("images/order_bg.png");
        JLabel bgLabel = new JLabel(bgImage);
        bgLabel.setBounds(0, 0, 900, 600);
        frame.add(bgLabel);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(2, 2, 20, 20));
        menuPanel.setBounds(50, 50, 500, 400);
        menuPanel.setOpaque(false);

        addMenuItem(menuPanel, "Burger", "assets/images/burger.jpg", 120);
        addMenuItem(menuPanel, "Pizza", "assets/images/pizza.jpg", 250);
        addMenuItem(menuPanel, "Pasta", "assets/images/pasta.jpg", 180);
        addMenuItem(menuPanel, "Fries", "assets/images/fries.png", 100);

        bgLabel.add(menuPanel);

        cartPanel = new JPanel();
        cartPanel.setBounds(600, 50, 250, 400);
        cartPanel.setBackground(new Color(255, 255, 255, 180));
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));

        JLabel cartTitle = new JLabel("Your Cart");
        cartTitle.setFont(new Font("Arial", Font.BOLD, 16));
        cartTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        cartPanel.add(cartTitle);

        totalLabel = new JLabel("Total: ₹0");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cartPanel.add(totalLabel);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setBackground(new Color(255, 69, 0));
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cartItems.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Cart is empty!");
                } else {
                    frame.dispose(); // Close current page
                    new PaymentPage(); // Open payment page
                }
            }
        });
        cartPanel.add(checkoutButton);

        bgLabel.add(cartPanel);

        frame.setVisible(true);
    }

    private void addMenuItem(JPanel panel, String name, String imgPath, int price) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BorderLayout());
        itemPanel.setPreferredSize(new Dimension(150, 150));

        ImageIcon icon = new ImageIcon(imgPath);
        JLabel imgLabel = new JLabel(icon);
        JLabel nameLabel = new JLabel(name + " - ₹" + price, SwingConstants.CENTER);

        JButton addButton = new JButton("Add to Cart");
        addButton.setBackground(new Color(50, 205, 50));
        addButton.setForeground(Color.WHITE);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cartItems.add(name);
                totalPrice += price;
                totalLabel.setText("Total: ₹" + totalPrice);
                JLabel cartItemLabel = new JLabel(name);
                cartPanel.add(cartItemLabel);
                cartPanel.revalidate();
                cartPanel.repaint();
            }
        });

        itemPanel.add(imgLabel, BorderLayout.CENTER);
        itemPanel.add(nameLabel, BorderLayout.SOUTH);
        itemPanel.add(addButton, BorderLayout.NORTH);
        panel.add(itemPanel);
    }

    public static void main(String[] args) {
        new FoodOrderingPage();
    }
}
