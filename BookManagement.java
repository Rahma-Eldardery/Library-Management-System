import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BookManagement {
    private List<Book> books = new ArrayList<>();

    public BookManagement() {
        books.add(new Book("1", "Book1"));
        books.add(new Book("2", "Book2"));
        books.add(new Book("3", "Book3"));
    }

    public List<Book> viewBooks() {
        return books;
    }

    public void issueBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId) && !book.isBorrowed()) {
                book.setBorrowed(true);
                JOptionPane.showMessageDialog(null,"Book borrowed: " + book.getTitle());
                return;
            }
        }
        JOptionPane.showMessageDialog(null,"Book not available.");
    }

    public void returnBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId) && book.isBorrowed()) {
                book.setBorrowed(false);
                JOptionPane.showMessageDialog(null,"Book returned: " + book.getTitle());
                return;
            }
        }
        JOptionPane.showMessageDialog(null,"Book not available.");
    }

    public void addBook(String bookName){
        books.add(new Book(Integer.toString(books.size()+1),bookName));
    }
}
