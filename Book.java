public class Book {
    private String id;
    private String title;
    private boolean isBorrowed;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
        this.isBorrowed = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        return " id= " + id + "\t" +
                " title= " + title + "\t" +
                " isBorrowed= " + isBorrowed +
                "\n";
    }
}
