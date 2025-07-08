package Service;

import ADT.arrayList.ArrayListADT;
import Model.Book;
import Model.Order;

public class BookLibrary {
    private ArrayListADT<Book> books;

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

    public void printAllBooks() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i+1 + ". " + books.get(i));
        }
    }

    public int size() {
        return books.size();
    }

    public Book get(int i) {
        return books.get(i);
    }

}