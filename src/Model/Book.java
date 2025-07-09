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
}
