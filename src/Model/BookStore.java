package Model;
import ADT.arrayList.ArrayListADT;


public class BookStore {
    private ArrayListADT<Book> books = new ArrayListADT<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayAllBooks() {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println(book.getTitle() + " - " + book.getAuthor() + " - $" + book.getPrice() + " - " + book.getQuantity() + " copies" + " - Category: " + book.getCategory());
        }
    }
//    public static void main(String[] args) {
//        BookStore store = new BookStore();
//        Book book1 = new Book("Java Programming", "James Gosling", 29.99, 10, "Drama");
//        Book book2 = new Book("Effective Java", "Joshua Bloch", 39.99, 5, "Drama");
//        Book book3 = new Book("Clean Code", "Robert C. Martin", 35.50, 8, "Drama");
//
//        store.addBook(book1);
//        store.addBook(book2);
//        store.addBook(book3);
//
//        store.displayAllBooks();
//    }
}