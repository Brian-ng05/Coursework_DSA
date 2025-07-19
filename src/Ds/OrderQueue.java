package Ds;

import ADT.arrayList.ArrayListADT;
import Model.Customer;
import Model.Order;
import Model.OrderBook;
import Model.OrderStatus;


public class OrderQueue {
    private ADT.linkedQueue.linkedQueueADT<Order> queue = new ADT.linkedQueue.linkedQueueADT<>();

    //Setter
    public void offer(Order order) {
        queue.offer(order);
    }

    //Getters
    public Order poll() {
        return queue.poll();
    }

    public Order peek() {
        return queue.peek();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    //Method to print all orders in queue
    public void printAllOrders() {
        System.out.println("===== Current Orders =====");
        System.out.println(queue);
        System.out.println("==========================");
    }


//    public static void main(String[] args) {
//        OrderQueue queue = new OrderQueue();
//
//        // Create first customer and books
//        Customer customer1 = new Customer("Brian", "Da Nang", "0369235524");
//        OrderBook book1 = new OrderBook("Haha", "Brian", 1.23, 2);
//        OrderBook book2 = new OrderBook("Hihi", "Brian", 1.39, 7);
//        ArrayListADT<OrderBook> books = new ArrayListADT<>();
//        books.add(book1);
//        books.add(book2);
//
//        // Create first order
//        Order order = new Order(customer1, books);

//        // Create second customer and order
//        Customer customer2 = new Customer("David", "Ha Noi", "0123456789");
//        ArrayListADT<OrderBook> books1 = new ArrayListADT<>();
//        books1.add(book1);
//        books1.add(book2);
//        Order order1 = new Order(customer2, books1);
//        order1.setStatus(OrderStatus.PROCESSING); // Set order status to PROCESSING
//
//        // Add orders to the queue
//        queue.offer(order);
//        queue.offer(order1);
//
//        // Print all orders in the queue
//        System.out.println("All Orders in Queue:");
//        queue.printAllOrders();
//
//        // Peek at the first order without removing it
//        System.out.println("\nPeek First Order:");
//        System.out.println(queue.peek());
//
//        // Remove the first order (poll)
//        System.out.println("\nRemoving First Order (poll):");
//        queue.poll();
//
//        // Print remaining orders
//        System.out.println("\nOrders After Polling:");
//        queue.printAllOrders();
//
//        // Add more orders (same order reused for testing)
//        queue.offer(order);
//        queue.offer(order);
//
//        // Final state of the queue
//        System.out.println("\nFinal Orders in Queue:");
//        queue.printAllOrders();
//    }

}
