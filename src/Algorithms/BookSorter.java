package Algorithms;

import ADT.arrayList.ArrayListADT;
import Model.OrderBook;

public class BookSorter {

    public static void insertionSortByTitle(ArrayListADT<OrderBook> orders) {
        for (int i = 1; i < orders.size(); i++) {

            OrderBook currentOrder = orders.get(i);
            int j = i -1;

            while (j >= 0 && orders.get(j).getTitle().compareToIgnoreCase(currentOrder.getTitle()) > 0) {
                orders.set(j+1, orders.get(j));
                j--;
            }
            orders.set(j + 1, currentOrder);
        }
    }

    public static void insertionSortByPrice(ArrayListADT<OrderBook> orders) {
        for (int i = 1; i < orders.size(); i++) {

            OrderBook currentOrder = orders.get(i);
            int j = i -1;

            while (j >= 0 && orders.get(j).getTotalPrice() < currentOrder.getTotalPrice()) {
                orders.set(j+1, orders.get(j));
                j--;
            }
            orders.set(j + 1, currentOrder);
        }
    }
}
