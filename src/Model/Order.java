package Model;

import ADT.arrayList.ArrayListADT;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import Algorithms.BookSorter;


public class Order {
    private static int counter = 1;

    private final int orderId;
    private Customer customer;
    private ArrayListADT<OrderBook> books;
    private OrderStatus status;
    private final LocalDateTime orderTime;

    //Constructor
    public Order(Customer customer, ArrayListADT<OrderBook> books) {
        this.orderId = counter;
        setBooks(books);
        setCustomer(customer);
        this.status = OrderStatus.PENDING;
        this.orderTime = LocalDateTime.now();
        counter++;
    }

    //Setter
    public void setBooks(ArrayListADT<OrderBook> books) {
        this.books = books;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    //Getter
    public int getOrderId() {
        return this.orderId;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    public ArrayListADT<OrderBook> getBooks() {
        return this.books;
    }
    public OrderStatus getStatus() {
        return this.status;
    }
    public LocalDateTime getOrderTime() {
        return this.orderTime;
    }


    //Calculate total price
    public double getTotalPrice() {
        double total = 0;
        for (int i = 0; i < books.size(); i++) {
            OrderBook book = books.get(i);
            total += book.getTotalPrice();
        }
        total = Math.round(total * 1000)/1000.0;
        return total;
    }

    //Override the toString method
    @Override
    public String toString() {
        BookSorter.insertionSortByPrice(books);

        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: " + orderId + "\n");
        sb.append("Customer: " + customer + "\n");
        sb.append("Books:\n");

        for (int i = 0; i < books.size(); i++) {
            OrderBook book = books.get(i);
            sb.append("  - ").append(book).append("\n");
        }
        sb.append("Total price: $" + getTotalPrice() + "\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        sb.append("Order Time: ").append(orderTime.format(formatter)).append("\n");
        sb.append("Status: " + status + "\n");
        return sb.toString();
    }
}
