package Algorithms;

import ADT.arrayList.ArrayListADT;
import Model.Order;

public class BookSearcher {

    public Order searchByOrderId(ArrayListADT<Order> orders, int orderId) {
        int low = 0, high = orders.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midId = orders.get(mid).getOrderId();

            if (midId == orderId) {
                return orders.get(mid);
            } else if (midId < orderId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }



    public ArrayListADT<Order> searchByNameOrPhone(ArrayListADT<Order> orders, String input) {
        ArrayListADT<Order> matchedOrders = new ArrayListADT<>();

        for (int i = 0; i < orders.size(); i++) {

            String nameOrPhone = input.toLowerCase().replaceAll("\\s+", "");
            String name = orders.get(i).getCustomer().getName().toLowerCase().replaceAll("\\s+", "");
            String phone = orders.get(i).getCustomer().getPhoneNumber().replaceAll("\\s+", "");

                if (name.contains(nameOrPhone) || phone.equals(nameOrPhone)) {
                    matchedOrders.add(orders.get(i));
                }
            }
            return matchedOrders;
    }
}
