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

    // Getters
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public double getPrice() {
        return this.price;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public double getTotalPrice() {
        return this.price * this.quantity;
    }

    @Override
    public String toString() {
        return (title + " by " + author + " x" + quantity);
    }
}
