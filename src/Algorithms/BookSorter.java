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
            int j = i - 1;

            //Move elements that are greater than currentOrder (based on title) one position ahead
            while (j >= 0 && orders.get(j).getTitle().compareToIgnoreCase(currentOrder.getTitle()) > 0) {
                orders.set(j + 1, orders.get(j));     //Shift the element rightward
                j--;
            }
            orders.set(j + 1, currentOrder);    //Insert the currentOrder at the correct position
        }
    }


    //Sorts the given list of OrderBook objects in descending order by total price
    public static void insertionSortByPrice(ArrayListADT<OrderBook> orders) {
        for (int i = 1; i < orders.size(); i++) {

            OrderBook currentOrder = orders.get(i);
            int j = i - 1;

            //Move elements that are less than currentOrder (based on price) one position ahead
            while (j >= 0 && orders.get(j).getTotalPrice() < currentOrder.getTotalPrice()) {
                orders.set(j + 1, orders.get(j));
                j--;
            }
            orders.set(j + 1, currentOrder);
        }
    }


//        public static void main(String[] args) {
//
//            // === Test insertionSortByTitle (ascending by title) ===
//            ArrayListADT<Book> booksByTitle = new ArrayListADT<>();
//            booksByTitle.add(new Book("Zebra Book", "Author A", 5.99, 1, ""));
//            booksByTitle.add(new Book("Alpha Book", "Author B", 3.99, 2, ""));
//            booksByTitle.add(new Book("Mango Book", "Author C", 4.49, 3, ""));
//
//            System.out.println("Before sorting by title:");
//            printBookList(booksByTitle);
//
//            BookSorter.insertionSortByTitle(booksByTitle);
//
//            System.out.println("\nAfter sorting by title (ascending):");
//            printBookList(booksByTitle);
//
//
//            // === Test insertionSortByPrice (descending by total price) ===
//            ArrayListADT<OrderBook> booksByPrice = new ArrayListADT<>();
//            booksByPrice.add(new OrderBook("Book A", "Author A", 2.00, 2)); // total = 4.00
//            booksByPrice.add(new OrderBook("Book B", "Author B", 1.50, 5)); // total = 7.50
//            booksByPrice.add(new OrderBook("Book C", "Author C", 3.00, 1)); // total = 3.00
//
//            System.out.println("\nBefore sorting by total price:");
//            printOrderBookList(booksByPrice);
//
//            BookSorter.insertionSortByPrice(booksByPrice);
//
//            System.out.println("\nAfter sorting by total price (descending):");
//            printOrderBookList(booksByPrice);
//        }
//
//        // Helper method to print a list of Book (or OrderBook)
//        private static void printBookList(ArrayListADT<Book> books) {
//            for (int i = 0; i < books.size(); i++) {
//                System.out.println(books.get(i));
//            }
//        }
//
//        private static void printOrderBookList(ArrayListADT<OrderBook> books) {
//            for (int i = 0; i < books.size(); i++) {
//                System.out.println(books.get(i) + " - Total Price: " + books.get(i).getTotalPrice());
//            }
//        }

}
