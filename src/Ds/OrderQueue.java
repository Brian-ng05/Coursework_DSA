package Ds;

import Model.Order;


public class OrderQueue {
    private ADT.linkedQueue.linkedQueueADT<Order> queue = new ADT.linkedQueue.linkedQueueADT<>();

    public void offer(Order order) {
        queue.offer(order);
    }

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

    public void printAllOrders() {
        System.out.println("===== Current Orders =====");
        System.out.println(queue);
        System.out.println("==========================");
    }

    @Override
    public String toString() {
        return queue.toString();
    }

//    public static void main(String[] args) {
//        OrderQueue queue = new OrderQueue();
//        Customer customer1 = new Customer("Brian", "Da Nang", "0369235524");
//        OrderBook book1 = new OrderBook("Haha", "Brian", 1.23, 2);
//        OrderBook book2 = new OrderBook("Hihi", "Brian", 1.39, 7);
//        ArrayListADT<OrderBook> books = new ArrayListADT<>();
//        books.add(book1);
//        books.add(book2);
//
//        Order order = new Order(customer1, books);
//
//
//        Customer customer2 = new Customer("Brian", "Da Nang", "0369235524");
//        ArrayListADT<OrderBook> books1 = new ArrayListADT<>();
//        books1.add(book1);
//        books1.add(book2);
//        Order order1 = new Order(customer2, books1);
//        order1.setStatus(OrderStatus.PROCESSING);
//
//        queue.offer(order);
//        queue.offer(order1);
//        System.out.println(queue);
//        System.out.println(queue.peek());
//        queue.poll();
//        System.out.println(queue);
//        queue.offer(order);
//        queue.offer(order);
//        queue.printAllOrders();
//    }

}
