package Ds;

import ADT.arrayList.ArrayListADT;
import Model.Customer;
import Model.Order;
import Model.OrderBook;

public class OrderHistoryStack {
    public ADT.linkedStack.linkedStackADT<Order> stack = new ADT.linkedStack.linkedStackADT<>();

    //Setter
    public void push(Order order) {
        stack.push(order);
    }

    //Getters
    public Order pop() {
        return stack.pop();
    }

    public Order peek() {
        return stack.peek();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    //Method to print all orders
    public void printAllOrders() {
        System.out.println("======== Orders History ========");
        System.out.println(stack);
        System.out.println("================================");
    }


//        public static void main(String[] args) {
//        OrderHistoryStack history = new OrderHistoryStack();
//
//        // Create customer and books
//        Customer customer = new Customer("Brian", "Da Nang", "0369235524");
//
//        OrderBook book1 = new OrderBook("Clean Code", "Robert C. Martin", 2.49, 2);
//        OrderBook book2 = new OrderBook("Effective Java", "Joshua Bloch", 3.99, 1);
//
//        // Create order 1
//        ArrayListADT<OrderBook> books1 = new ArrayListADT<>();
//        books1.add(book1);
//        books1.add(book2);
//        Order order1 = new Order(customer, books1);
//        history.push(order1);
//
//        // Create order 2
//        OrderBook book3 = new OrderBook("Refactoring", "Martin Fowler", 4.59, 3);
//        ArrayListADT<OrderBook> books2 = new ArrayListADT<>();
//        books2.add(book3);
//        Order order2 = new Order(customer, books2);
//        history.push(order2);
//
//        // Print all order history
//        System.out.println("\nOrder History:");
//        history.printAllOrders();
//
//        // View the most recent order (peek)
//        System.out.println("\nMost Recent Order (peek):");
//        System.out.println(history.peek());
//
//        // Cancel the most recent order (pop)
//        System.out.println("\nCanceling the Most Recent Order:");
//        Order removed = history.pop();
//        System.out.println("Cancelled:\n" + removed);
//
//        // Print order history after cancellation
//        System.out.println("\nOrder History After Cancellation:");
//        history.printAllOrders();
//
//        // Check the current size of the stack
//        System.out.println("\nTotal Orders in Stack: " + history.size());
//    }


}

