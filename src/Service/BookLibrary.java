package Service;

import ADT.arrayList.ArrayListADT;
import Algorithms.BookSorter;
import Model.Book;

public class BookLibrary {
    private ArrayListADT<Book> books;

    //Constructor
    public BookLibrary() {
        books = new ArrayListADT<>();
        loadBooks();
    }

    private void loadBooks() {
        this.books.add(new Book("Clean Code", "Robert C. Martin", 35.99, 20, "Software Engineering"));
        this.books.add(new Book("The Pragmatic Programmer", "Andrew Hunt", 42.50, 20, "Software Engineering"));
        this.books.add(new Book("Effective Java", "Joshua Bloch", 47.25, 20, "Java"));
        this.books.add(new Book("Design Patterns", "Erich Gamma", 55.00, 20, "Architecture"));
        this.books.add(new Book("Refactoring", "Martin Fowler", 49.95, 20, "Software Engineering"));
        this.books.add(new Book("Java Concurrency in Practice", "Brian Goetz", 45.00, 20, "Java"));
        this.books.add(new Book("Introduction to Algorithms", "Thomas H. Cormen", 75.00, 20, "Algorithms"));
        this.books.add(new Book("Head First Design Patterns", "Eric Freeman", 39.90, 20, "Architecture"));
        this.books.add(new Book("Code Complete", "Steve McConnell", 52.00, 20, "Software Engineering"));
        this.books.add(new Book("Algorithms", "Robert Sedgewick", 60.00, 20, "Algorithms"));
        this.books.add(new Book("Structure and Interpretation of Computer Programs", "Harold Abelson", 64.95, 20, "Computer Science"));
        this.books.add(new Book("Domain-Driven Design", "Eric Evans", 58.99, 20, "Architecture"));
        this.books.add(new Book("Cracking the Coding Interview", "Gayle Laakmann McDowell", 34.99, 20, "Interview"));
        this.books.add(new Book("Working Effectively with Legacy Code", "Michael Feathers", 43.20, 20, "Software Engineering"));
        this.books.add(new Book("The Art of Computer Programming", "Donald E. Knuth", 120.00, 20, "Algorithms"));
        this.books.add(new Book("Soft Skills", "John Sonmez", 33.33, 20, "Career"));
        this.books.add(new Book("You Don't Know JS", "Kyle Simpson", 27.75, 20, "JavaScript"));
        this.books.add(new Book("Python Crash Course", "Eric Matthes", 38.50, 20, "Python"));
        this.books.add(new Book("Computer Networking: A Top-Down Approach", "James F. Kurose", 70.00, 20, "Networking"));
        this.books.add(new Book("Deep Learning", "Ian Goodfellow", 89.90, 20, "AI"));

    }

    //Print all books in arraylist
    public void printAllBooks() {
        BookSorter.insertionSortByTitle(books);
        for (int i = 0; i < books.size(); i++) {                //Loop through all books in "books" to get book detail
            System.out.println(i+1 + ". " + books.get(i));
        }
    }

    //Getters
    public int size() {
        return books.size();
    }

    public Book get(int i) {
        return books.get(i);
    }


//    public static void main(String[] args) {
//        System.out.println("=== Test 1: Load and display all books ===");
//        BookLibrary library = new BookLibrary();
//        library.printAllBooks(); // Should print all 20 books sorted by title
//
//        System.out.println("\n=== Test 2: Get a book by index ===");
//        Book b = library.get(0);
//        System.out.println("First book in list (after sorting): " + b);
//
//        System.out.println("\n=== Test 3: Check total number of books ===");
//        System.out.println("Total books loaded: " + library.size());
//    }
}