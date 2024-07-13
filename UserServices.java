import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserServices extends JFrame implements ActionListener {
    private JButton viewBooksButton, borrowBookButton, returnBookButton,addBookButton;
    private BookManagement bookManagement;

    public UserServices() {
        setTitle("User Services");
        setSize(300, 210);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        bookManagement = new BookManagement();

        JPanel panel = new JPanel();
        panel.setLayout(null);

        viewBooksButton = new JButton("View Books");
        viewBooksButton.setBounds(50, 15, 200, 25);
        panel.add(viewBooksButton);

        borrowBookButton = new JButton("Borrow Book");
        borrowBookButton.setBounds(50, 55, 200, 25);
        panel.add(borrowBookButton);

        returnBookButton = new JButton("Return Book");
        returnBookButton.setBounds(50, 95, 200, 25);
        panel.add(returnBookButton);

        addBookButton = new JButton("Add Book");
        addBookButton.setBounds(50, 135, 200, 25);
        panel.add(addBookButton);

        viewBooksButton.addActionListener(this);
        borrowBookButton.addActionListener(this);
        returnBookButton.addActionListener(this);
        addBookButton.addActionListener(this);
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        if (source == viewBooksButton) {
            JOptionPane.showMessageDialog(this,   bookManagement.viewBooks());
        } else if (source == borrowBookButton) {
            String bookId = JOptionPane.showInputDialog("Enter Book ID to Borrow:");
            if (bookId != null && !bookId.isEmpty()) {
                bookManagement.issueBook(bookId);
            }
        } else if (source == returnBookButton) {
            String bookId = JOptionPane.showInputDialog("Enter Book ID to Return:");
            if (bookId != null && !bookId.isEmpty()) {
                bookManagement.returnBook(bookId);
            }
        }else if (source == addBookButton) {
            String bookName = JOptionPane.showInputDialog("Enter Book Name to Add:");
            if (bookName != null && !bookName.isEmpty()) {
                bookManagement.addBook(bookName);
            }
        }
    }

    public static void main(String[] args) {
        UserServices frame = new UserServices();
        frame.setVisible(true);
    }
}
