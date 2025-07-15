package Algorithms;

import ADT.arrayList.ArrayListADT;
import Model.Book;
import Model.OrderBook;

public class BookSorter {

    //Sorts the given list of OrderBook objects in ascending order by title
    public static void insertionSortByTitle(ArrayListADT<Book> orders) {

        //Start from the second element (i = 1), assuming the first one is already sorted
        for (int i = 1; i < orders.size(); i++) {

            //Store the current element to be positioned
            Book currentOrder = orders.get(i);
            int j = i -1;

            //Move elements that are greater than currentOrder (based on title) one position ahead
            while (j >= 0 && orders.get(j).getTitle().compareToIgnoreCase(currentOrder.getTitle()) > 0) {
                orders.set(j+1, orders.get(j));     //Shift the element rightward
                j--;
            }
            orders.set(j + 1, currentOrder);    //Insert the currentOrder at the correct position
        }
    }


    //Sorts the given list of OrderBook objects in descending order by total price
    public static void insertionSortByPrice(ArrayListADT<OrderBook> orders) {
        for (int i = 1; i < orders.size(); i++) {

            OrderBook currentOrder = orders.get(i);
            int j = i -1;

            //Move elements that are less than currentOrder (based on price) one position ahead
            while (j >= 0 && orders.get(j).getTotalPrice() < currentOrder.getTotalPrice()) {
                orders.set(j+1, orders.get(j));
                j--;
            }
            orders.set(j + 1, currentOrder);
        }
    }
}
