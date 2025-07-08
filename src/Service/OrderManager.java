package Service;

import ADT.arrayList.ArrayListADT;
import Algorithms.BookSearcher;
import static Algorithms.BookSorter.insertionSortByTitle;
import static Algorithms.BookSorter.insertionSortByPrice;
import Ds.OrderHistoryStack;
import Ds.OrderQueue;
import Model.Customer;
import Model.Order;
import Model.OrderBook;
import Model.OrderStatus;

public class OrderManager {
    private ArrayListADT<Order> allOrders;
    private ArrayListADT<Order> cancelledOrders;
    private OrderQueue orderQueue;
    private OrderHistoryStack orderHistory;

    //Constructor
    public OrderManager() {
        this.allOrders = new ArrayListADT<>();
        this.cancelledOrders = new ArrayListADT<>();
        this.orderQueue = new OrderQueue();
        this.orderHistory = new OrderHistoryStack();
    }

    public void createOrder (Customer customer, ArrayListADT<OrderBook> books) {
        Order order = new Order(customer, books);
        allOrders.add(order);
        orderQueue.offer(order);
        System.out.println("Order created: " + order.getOrderId());
    }

    public void printAllOrder() {
        System.out.println("======== All Orders ========");
        System.out.println(allOrders);
        System.out.println("============================");
        System.out.println();
    }

    public void sortByTitle(Order order) {
        ArrayListADT<OrderBook> books = order.getBooks();
        insertionSortByTitle(books);
    }
    public void sortByPrice(Order order) {
        ArrayListADT<OrderBook> books = order.getBooks();
        insertionSortByPrice(books);
    }


    public Order searchByOrderId(int orderId) {
        return new BookSearcher().searchByOrderId(allOrders, orderId);
    }
    public ArrayListADT<Order> searchByNameOrPhone(String input) {
        return new BookSearcher().searchByNameOrPhone(allOrders, input);
    }



    public void updateStatus(int orderId, OrderStatus status) {
        Order order = searchByOrderId(orderId);
        if (order != null) {
            order.setStatus(status);
        }
    }

    public void processNextOrder() {
        Order nextOrder = orderQueue.poll();
        if (nextOrder != null) {
            nextOrder.setStatus(OrderStatus.PROCESSING);
            orderHistory.push(nextOrder);
            System.out.println("Processing: \n" + nextOrder);
        }
    }

    public void cancelLastOrder() {
        Order lastOrder = orderHistory.pop();
        if (lastOrder != null) {
            lastOrder.setStatus(OrderStatus.CANCELLED);
            cancelledOrders.add(lastOrder);
            System.out.println("Canceling: \n " + lastOrder);
        }
    }

    public void printOrderHistory() {
        orderHistory.printAllOrders();
    }

    public void printCancelledOrders() {
        System.out.println("======== Cancelled Orders ========");
        System.out.println(cancelledOrders);
        System.out.println("==================================");
    }

    public void printOrderQueue() {
        orderQueue.printAllOrders();
    }

    public void printOrderDetail(Order order) {
        if (order != null) {
            System.out.println("======== Order Detail ========");
            System.out.println(order);
            System.out.println("==============================");
        } else {
            System.out.println("Order not found.");
        }
    }


    public boolean isOrderQueueEmpty() {
        return orderQueue.isEmpty();
    }

    public boolean isAllOrdersEmpty() {
        return allOrders.isEmpty();
    }

    public boolean isOrderHistoryEmpty() {
        return orderHistory.isEmpty();
    }

    public boolean isCancelledOrderEmpty() {
        return cancelledOrders.isEmpty();
    }


}
