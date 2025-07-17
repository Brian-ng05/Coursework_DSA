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
}
