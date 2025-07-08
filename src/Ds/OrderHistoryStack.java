package Ds;

import ADT.arrayList.ArrayListADT;
import Model.Customer;
import Model.Order;
import Model.OrderBook;

public class OrderHistoryStack {
    public ADT.linkedStack.linkedStackADT<Order> stack = new ADT.linkedStack.linkedStackADT<>();

    public void push(Order order) {
        stack.push(order);
    }

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

