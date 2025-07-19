package Model;

public class OrderBook  {
    private String title;
    private String author;
    private double price;
    private int quantity;

    //Constructor
    public OrderBook(String title, String author, double price, int quantity) {
        setTitle(title);
        setAuthor(author);
        setPrice(price);
        setQuantity(quantity);
    }

    //Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Getters
    public double getTotalPrice() {
        return this.price * this.quantity;
    }

    //Override the toString method
    @Override
    public String toString() {
        return (title + " by " + author + " x" + quantity);
    }


//    public static void main(String[] args) {
//        System.out.println("=== Test 1: Create valid OrderBook ===");
//        OrderBook ob1 = new OrderBook("Clean Code", "Robert C. Martin", 45.0, 2);
//        System.out.println("OrderBook: " + ob1);
//        System.out.println("Total Price: $" + ob1.getTotalPrice());
//
//        System.out.println("\n=== Test 2: Update OrderBook fields ===");
//        ob1.setTitle("Clean Architecture");
//        ob1.setAuthor("Uncle Bob");
//        ob1.setPrice(50.0);
//        ob1.setQuantity(3);
//        System.out.println("Updated OrderBook: " + ob1);
//        System.out.println("New Total Price: $" + ob1.getTotalPrice());
//
//        System.out.println("\n=== Test 3: Edge case - quantity 0 ===");
//        OrderBook ob2 = new OrderBook("Refactoring", "Martin Fowler", 60.0, 0);
//        System.out.println("OrderBook: " + ob2);
//        System.out.println("Total Price: $" + ob2.getTotalPrice());
//    }
}
