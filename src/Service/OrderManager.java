package Service;

import ADT.arrayList.ArrayListADT;
import static Algorithms.BookSearcher.searchByOrderId;
import static Algorithms.BookSearcher.searchByNameOrPhone;
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

    //Method to create a new order
    public void createOrder (Customer customer, ArrayListADT<OrderBook> books) {
        Order order = new Order(customer, books);   //Create an order
        allOrders.add(order);                       //Add the order in allOrders arraylist
        orderQueue.offer(order);                    //Offer the order in orderQueue
        System.out.println("Order created: " + order.getOrderId());
    }

    //Method to print all orders
    public void printAllOrder() {
        System.out.println("======== All Orders ========");
        for (int i = 0; i < allOrders.size(); i++) {        //Loop through all allOrders arraylist
            System.out.println(allOrders.get(i));           //Get the order
        }
        System.out.println("============================");
        System.out.println();
    }


    //Method to search order by id
    public Order searchById(int orderId) {
        return searchByOrderId(allOrders, orderId);
    }
    //Method to search order by name or phone number
    public ArrayListADT<Order> searchByNOrP(String input) {
        return searchByNameOrPhone(allOrders, input);
    }


    //Method to update the status of order in queue
    public void processNextOrder() {
        Order nextOrder = orderQueue.poll();    //Delete and get the top order in stack
        if (nextOrder != null) {                //Check if the nextOrder is null
            nextOrder.setStatus(OrderStatus.PROCESSING);        //Update the status
            orderHistory.push(nextOrder);                       //Add the nextOrder to orderHistory list
            System.out.println("Processing: \n" + nextOrder);
        }
    }

    // Cancels the most recently processed order and adds it to the list of cancelled orders
    public void cancelLastOrder() {
        Order lastOrder = orderHistory.pop();   // Pop the last order from the order history stack
        if (lastOrder != null) {                //Check if there is an order to cancel
            lastOrder.setStatus(OrderStatus.CANCELLED);     //Set the order's status to CANCELLED
            cancelledOrders.add(lastOrder);                 //Add the cancelled order to the cancelledOrders list
            System.out.println("Canceling: \n " + lastOrder);
        }
    }

    //Print all order history
    public void printOrderHistory() {
        orderHistory.printAllOrders();
    }

    //Print all cancelled order
    public void printCancelledOrders() {
        System.out.println("======== Cancelled Orders ========");
        for (int i = 0; i < cancelledOrders.size(); i++) {
            System.out.println(cancelledOrders.get(i));
        }
        System.out.println("==================================");
    }

    //Print all processing order in queue
    public void printOrderQueue() {
        orderQueue.printAllOrders();
    }

    //Getter
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
