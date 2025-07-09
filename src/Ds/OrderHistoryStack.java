package Ds;

import Model.Order;

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
        System.out.println("======== Cancelled Orders ========");
        System.out.println(stack);
        System.out.println("==================================");
    }

    @Override
    public String toString() {
        return stack.toString();
    }


}

