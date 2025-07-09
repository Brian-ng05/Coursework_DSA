package Algorithms;

import ADT.arrayList.ArrayListADT;
import Model.Order;

public class BookSearcher {

    //Searches for an order with the given orderId
    public static Order searchByOrderId(ArrayListADT<Order> orders, int orderId) {
        int low = 0, high = orders.size() - 1;

        //Binary search loop
        while (low <= high) {
            int mid = (low + high) / 2;
            int midId = orders.get(mid).getOrderId();

            //If match is found, return the order
            if (midId == orderId) {
                return orders.get(mid);

                //If the target ID is greater, ignore the left half
            } else if (midId < orderId) {
                low = mid + 1;

                // If the target ID is smaller, ignore the right half
            } else {
                high = mid - 1;
            }
        }

        //If no match is found, return null
        return null;
    }



    //Searches for orders where the customer's name contains the input string
    public static ArrayListADT<Order> searchByNameOrPhone(ArrayListADT<Order> orders, String input) {
        ArrayListADT<Order> matchedOrders = new ArrayListADT<>();   //List to store matching results

        //Normalize the input (remove spaces and convert to lowercase)
        String nameOrPhone = input.toLowerCase().replaceAll("\\s+", "");

        for (int i = 0; i < orders.size(); i++) {
            //Get customer's name and phone number and normalize them
            String name = orders.get(i).getCustomer().getName().toLowerCase().replaceAll("\\s+", "");
            String phone = orders.get(i).getCustomer().getPhoneNumber().replaceAll("\\s+", "");

            //If name contains the input, or phone number matches exactly, it's a match
            if (name.contains(nameOrPhone) || phone.equals(nameOrPhone)) {
                matchedOrders.add(orders.get(i));
            }
        }
        return matchedOrders;       //Return the list of matching orders
    }
}
