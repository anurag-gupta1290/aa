import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserProfile {
    private JFrame frame;
    private JLabel nameLabel, emailLabel, phoneLabel, addressLabel;
    private JLabel profilePic;
    private DefaultListModel<String> favoritesModel;
    private JList<String> favoritesList;

    public UserProfile() {
        frame = new JFrame("Foodie - User Profile");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // Background Image
        ImageIcon bgImage = new ImageIcon("images/splash.png"); // Add your background image
        JLabel bgLabel = new JLabel(bgImage);
        bgLabel.setBounds(0, 0, 600, 500);
        frame.add(bgLabel);

        // Profile Picture
        ImageIcon profileImage = new ImageIcon("images/user.png"); // Add user profile picture
        profilePic = new JLabel(profileImage);
        profilePic.setBounds(250, 20, 100, 100);
        bgLabel.add(profilePic);

        // User Details
        nameLabel = new JLabel("Name: Anurag Gupta");
        emailLabel = new JLabel("Email: anurag@example.com");
        phoneLabel = new JLabel("Phone: +91 9876543210");
        addressLabel = new JLabel("Address: Lucknow, India");

        nameLabel.setBounds(50, 140, 300, 25);
        emailLabel.setBounds(50, 170, 300, 25);
        phoneLabel.setBounds(50, 200, 300, 25);
        addressLabel.setBounds(50, 230, 300, 25);

        nameLabel.setForeground(Color.GREEN);
        emailLabel.setForeground(Color.GREEN);
        phoneLabel.setForeground(Color.GREEN);
        addressLabel.setForeground(Color.GREEN);

        bgLabel.add(nameLabel);
        bgLabel.add(emailLabel);
        bgLabel.add(phoneLabel);
        bgLabel.add(addressLabel);

        // Favorites List
        JLabel favTitle = new JLabel("Favorite Foods:");
        favTitle.setBounds(50, 270, 150, 25);
        favTitle.setForeground(Color.WHITE);
        bgLabel.add(favTitle);

        favoritesModel = new DefaultListModel<>();
        favoritesModel.addElement("Pizza");
        favoritesModel.addElement("Burger");
        favoritesModel.addElement("Pasta");

        favoritesList = new JList<>(favoritesModel);
        JScrollPane scrollPane = new JScrollPane(favoritesList);
        scrollPane.setBounds(50, 300, 200, 100);
        bgLabel.add(scrollPane);

        // Edit Profile Button
        JButton editButton = new JButton("Edit Profile");
        editButton.setBounds(400, 300, 150, 40);
        editButton.setBackground(new Color(255, 69, 0));
        editButton.setForeground(Color.WHITE);
        bgLabel.add(editButton);

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Edit Profile Feature Coming Soon!");
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new UserProfile();
    }
}
