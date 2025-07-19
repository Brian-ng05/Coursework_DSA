package Model;

import ADT.arrayList.ArrayListADT;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Algorithms.BookSearcher;
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


//    public static void main(String[] args) {
//
//        // === Create Customers ===
//        Customer customer1 = new Customer("Brian Tran", "Da Nang", "0369235524");
//        Customer customer2 = new Customer("David Le", "Ha Noi", "0123456789");
//        Customer customer3 = new Customer("Trung", "Hue", "0911222333");
//
//        // === Create Books ===
//        OrderBook book1 = new OrderBook("Clean Code", "Robert C. Martin", 3.99, 1);  // total 3.99
//        OrderBook book2 = new OrderBook("Effective Java", "Joshua Bloch", 4.99, 2);  // total 9.98
//        OrderBook book3 = new OrderBook("Refactoring", "Martin Fowler", 2.49, 3);    // total 7.47
//
//        // === Create Orders ===
//        ArrayListADT<Order> orderList = new ArrayListADT<>();
//
//        ArrayListADT<OrderBook> booksA = new ArrayListADT<>();
//        booksA.add(book1);
//        booksA.add(book3);
//        Order orderA = new Order(customer1, booksA);  // id = 1
//        orderList.add(orderA);
//
//        ArrayListADT<OrderBook> booksB = new ArrayListADT<>();
//        booksB.add(book2);
//        Order orderB = new Order(customer2, booksB);  // id = 2
//        orderList.add(orderB);
//
//        ArrayListADT<OrderBook> booksC = new ArrayListADT<>();
//        booksC.add(book1);
//        booksC.add(book2);
//        Order orderC = new Order(customer3, booksC);  // id = 3
//        orderList.add(orderC);
//
//        // === Print All Orders ===
//        System.out.println("All Orders:");
//        for (int i = 0; i < orderList.size(); i++) {
//            System.out.println(orderList.get(i));
//        }
//
//        // === Search by Order ID ===
//        System.out.println("Searching for Order ID 2...");
//        Order found = BookSearcher.searchByOrderId(orderList, 2);
//        if (found != null) {
//            System.out.println("Found:\n" + found);
//        } else {
//            System.out.println("Not Found.");
//        }
//
//        // === Search by Name or Phone ===
//        System.out.println("Search by name 'brian':");
//        ArrayListADT<Order> result1 = BookSearcher.searchByNameOrPhone(orderList, "brian");
//        for (int i = 0; i < result1.size(); i++) {
//            System.out.println(result1.get(i));
//        }
//
//        System.out.println("Search by phone '0911222333':");
//        ArrayListADT<Order> result2 = BookSearcher.searchByNameOrPhone(orderList, "0911222333");
//        for (int i = 0; i < result2.size(); i++) {
//            System.out.println(result2.get(i));
//        }
//
//        System.out.println("Search by name 'le':");
//        ArrayListADT<Order> result3 = BookSearcher.searchByNameOrPhone(orderList, "le");
//        for (int i = 0; i < result3.size(); i++) {
//            System.out.println(result3.get(i));
//        }
//    }
}
