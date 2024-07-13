import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegistration extends JFrame implements ActionListener {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public UserRegistration() {
        setTitle("User Registration");
        setSize(300, 210);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 40, 80, 25);
        panel.add(emailLabel);

        emailField = new JTextField(20);
        emailField.setBounds(100, 40, 165, 25);
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 70, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 70, 165, 25);
        panel.add(passwordField);

        registerButton = new JButton("Register");
        registerButton.setBounds(100, 110, 100, 25);
        panel.add(registerButton);

        registerButton.addActionListener(this);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        MemberManagement memberManagement = new MemberManagement();
        memberManagement.addMember(email, password);

        JOptionPane.showMessageDialog(null, "Registration successful. You can now sign in.");
        dispose();
        SignIn signIn = new SignIn();
        signIn.setVisible(true);
    }

    public static void main(String[] args) {
        UserRegistration frame = new UserRegistration();
        frame.setVisible(true);
    }
}
