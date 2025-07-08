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
        System.out.println("======== History Orders ========");
        System.out.println(stack);
        System.out.println("================================");
    }

    @Override
    public String toString() {
        return stack.toString();
    }


//    public static void main(String[] args) {
//        OrderHistoryStack history = new OrderHistoryStack();
//
//        // Tạo khách hàng và sách
//        Customer customer = new Customer("Brian", "Da Nang", "0369235524");
//        OrderBook book1 = new OrderBook("Clean Code", "Robert C. Martin", 2.49, 2);
//        OrderBook book2 = new OrderBook("Effective Java", "Joshua Bloch", 3.99, 1);
//
//        // Tạo đơn hàng 1
//        ArrayListADT<OrderBook> books1 = new ArrayListADT<>();
//        books1.add(book1);
//        books1.add(book2);
//        Order order1 = new Order(customer, books1);
//        history.push(order1);
//
//        // Tạo đơn hàng 2
//        OrderBook book3 = new OrderBook("Refactoring", "Martin Fowler", 4.59, 3);
//        ArrayListADT<OrderBook> books2 = new ArrayListADT<>();
//        books2.add(book3);
//        Order order2 = new Order(customer, books2);
//        history.push(order2);
//
//        // In toàn bộ lịch sử
//        System.out.println("\n📜 Lịch sử đơn hàng:");
//        history.printAllOrders();
//
//        // Xem đơn mới nhất (peek)
//        System.out.println("\n🔍 Đơn hàng mới nhất (peek):");
//        System.out.println(history.peek());
//
//        // Hủy đơn hàng mới nhất (pop)
//        System.out.println("\n⛔ Hủy đơn hàng mới nhất:");
//        Order removed = history.pop();
//        System.out.println("Đã hủy:\n" + removed);
//
//        // In lại lịch sử sau khi hủy
//        System.out.println("\n📜 Lịch sử sau khi hủy:");
//        history.printAllOrders();
//
//        // Kiểm tra size
//        System.out.println("\n📦 Tổng số đơn trong stack: " + history.size());
//    }
}

