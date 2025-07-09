package Ds;

import Model.Order;


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

    //Override the toString method
    @Override
    public String toString() {
        return queue.toString();
    }

}
