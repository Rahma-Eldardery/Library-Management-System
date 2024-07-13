import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn extends JFrame implements ActionListener {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton signInButton, createButton;

    public SignIn() {
        setTitle("SignIn");
        setSize(300, 210);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 40, 80, 25);
        panel1.add(emailLabel);

        emailField = new JTextField(20);
        emailField.setBounds(100, 40, 165, 25);
        panel1.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 70, 80, 25);
        panel1.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 70, 165, 25);
        panel1.add(passwordField);

        signInButton = new JButton("SignIn");
        signInButton.setBounds(30, 110, 100, 25);
        panel1.add(signInButton);

        signInButton.addActionListener(this);

        createButton = new JButton("New");
        createButton.setBounds(160, 110, 100, 25);
        panel1.add(createButton);

        createButton.addActionListener(this);

        add(panel1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();

        if (source == signInButton) {
            if (findAccount(email, password)) {
                //JOptionPane.showMessageDialog(null, "Hello");
                dispose();
                UserServices userServices = new UserServices();
                userServices.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "WRONG EMAIL OR PASSWORD.\n Press New if you don't have an account.");
            }
        } else if (source == createButton) {
            dispose();
            UserRegistration registration = new UserRegistration();
            registration.setVisible(true);
        }
    }

    private boolean findAccount(String email, String password) {
        for (Member member : Member.membersList) {
            if (member.getContactInfo().equals(email) && member.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SignIn frame2 = new SignIn();
        frame2.setVisible(true);
    }
}
