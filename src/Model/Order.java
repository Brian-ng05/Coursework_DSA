package Model;

import ADT.arrayList.ArrayListADT;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import Algorithms.BookSorter;


import static Algorithms.BookSorter.insertionSortByPrice;
import static Algorithms.BookSorter.insertionSortByTitle;

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
        this.customer = customer;
        this.books = books;
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

    @Override
    public String toString() {
        BookSorter.insertionSortByPrice(books);

        StringBuilder sb = new StringBuilder();
//        sb.append("[");
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
//        sb.append("]");
        return sb.toString();
    }

//    public static void main(String[] args) {
//        Customer customer1 = new Customer("Brian", "Da Nang", "0369235524");
//        OrderBook book1 = new OrderBook("Haha", "Brian", 1.23, 2);
//        OrderBook book2 = new OrderBook("aihi", "Brian", 1.39, 7);
//        OrderBook book3 = new OrderBook("Bray", "Brian", 1.22, 3);
//        ArrayListADT<OrderBook> books = new ArrayListADT<>();
//        books.add(book1);
//        books.add(book2);
//        insertionSortByPrice(books);
//
//
//        Order order = new Order(customer1, books);
//        System.out.println(order);
//
//        Customer customer2 = new Customer("Brian", "Da Nang", "0369235524");
//        ArrayListADT<OrderBook> books1 = new ArrayListADT<>();
//        books1.add(book1);
//        books1.add(book2);
//        books1.add(book3);
//        Order order1 = new Order(customer2, books1);
//        order1.setStatus(OrderStatus.PROCESSING);
//        insertionSortByTitle(books1);
//        System.out.println(order1);
//    }
}
