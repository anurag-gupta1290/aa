import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPage {
    private JFrame frame;
    private JRadioButton codOption, onlineOption;
    private JButton payButton;

    public PaymentPage() {
        frame = new JFrame("Foodie - Payment");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Panel with background color
        JPanel bgPanel = new JPanel();
        bgPanel.setBackground(new Color(100, 149, 237)); // Cornflower Blue
        bgPanel.setLayout(null);
        frame.setContentPane(bgPanel);

        JLabel titleLabel = new JLabel("Choose Payment Method", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(150, 50, 300, 30);
        titleLabel.setForeground(Color.WHITE);
        bgPanel.add(titleLabel);

        codOption = new JRadioButton("Cash on Delivery");
        codOption.setBounds(200, 120, 200, 30);
        codOption.setOpaque(false);
        codOption.setForeground(Color.WHITE);

        onlineOption = new JRadioButton("Online Payment");
        onlineOption.setBounds(200, 160, 200, 30);
        onlineOption.setOpaque(false);
        onlineOption.setForeground(Color.WHITE);

        ButtonGroup group = new ButtonGroup();
        group.add(codOption);
        group.add(onlineOption);

        bgPanel.add(codOption);
        bgPanel.add(onlineOption);

        payButton = new JButton("Proceed to Pay");
        payButton.setBounds(200, 220, 200, 40);
        payButton.setBackground(new Color(50, 205, 50));
        payButton.setForeground(Color.WHITE);
        bgPanel.add(payButton);

        payButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (codOption.isSelected() || onlineOption.isSelected()) {
                    frame.dispose();
                    new OrderTracking();

                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a payment method.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PaymentPage();
    }
}
