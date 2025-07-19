package Model;


public class Book {
    private String title;
    private String author;
    private double price;
    private int quantity;
    private String category;

    //Constructor
    public Book(String title, String author, double price, int quantity, String category) {
        setTitle(title);
        setAuthor(author);
        setPrice(price);
        setQuantity(quantity);
        setCategory(category);
    }

    //Setter
    public void setPrice(double price ){
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Quantity cannot be less than zero");
        }
    }
    public void setCategory(String category) {
        this.category = category;
    }

    //Getter
    public int getQuantity() {
        return this.quantity;
    }
    public double getPrice() {
        return this.price;
    }
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getCategory() {
        return this.category;
    }

    //Override the toString method
    @Override
    public String toString() {
        return title + " by " + author + " - $" + price + " [Category: " + category + "]";
    }

//    public static void main(String[] args) {
//
//        // Test 1: Create book normally
//        System.out.println("=== Test 1: Create book ===");
//        Book book1 = new Book("Clean Code", "Robert C. Martin", 29.99, 3, "Programming");
//        System.out.println("Book 1: " + book1);  // will call toString()
//        System.out.println("Title: " + book1.getTitle());
//        System.out.println("Author: " + book1.getAuthor());
//        System.out.println("Price: $" + book1.getPrice());
//        System.out.println("Quantity: " + book1.getQuantity());
//        System.out.println("Category: " + book1.getCategory());
//
//        // Test 2: Set new values
//        System.out.println("\n=== Test 2: Update fields ===");
//        book1.setPrice(35.50);
//        book1.setQuantity(10);
//        book1.setCategory("Software Engineering");
//        System.out.println("Updated Book: " + book1);
//
//        // Test 3: Negative price
//        System.out.println("\n=== Test 3: Negative price (expect error) ===");
//        try {
//            Book book2 = new Book("Bad Book", "Unknown", -5.0, 1, "Mystery");
//        } catch (IllegalArgumentException e) {
//            System.out.println("Caught exception: " + e.getMessage());
//        }
//
//        // Test 4: Zero or negative quantity
//        System.out.println("\n=== Test 4: Invalid quantity (expect error) ===");
//        try {
//            Book book3 = new Book("Bad Quantity", "Some Author", 10.0, -3, "Fiction");
//        } catch (IllegalArgumentException e) {
//            System.out.println("Caught exception: " + e.getMessage());
//        }
//    }
}
