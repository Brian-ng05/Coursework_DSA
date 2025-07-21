package BookstoreApp;

import ADT.arrayList.ArrayListADT;
import Model.*;
import Service.BookLibrary;
import Service.OrderManager;
import java.util.Scanner;


public class OnlineBookStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        //Create a Scanner object to read user input

        OrderManager orderManager = new OrderManager();  //Initialize order manager to handle order
        BookLibrary books = new BookLibrary();      //Initialize book library (contains available books)



        boolean running = true;     //Flag to control the main loop
        //Main program loop
        do {
            String[] menu = {       //Menu options to display to the user
                    "======== Online Bookstore ========",
                    "1. Create new order",
                    "2. View all orders",
                    "3. Process next order",
                    "4. View order in queue",
                    "5. View order history",
                    "6. Cancel last processed order",
                    "7. View cancelled orders",
                    "8. Search order (by ID or Name/Phone)",
                    "9. Exit",
                    "Select option by enter a number from 1 to 9."
            };
            for (String i : menu) {     //Print each line of the menu
                System.out.println(i);
            }

            String userChoice = sc.nextLine();       //Read the user's choice
            //Perform an action based on user's input
            switch (userChoice) {
                case "1":       //Create a new order

                    String fullname, address, phoneNumber;
                    //Get customer name
                    while (true) {
                        System.out.print("Enter your full name, please!: ");
                        fullname = sc.nextLine().trim();
                        System.out.println();

                        //Validate name
                        if (fullname.isEmpty()) {
                            System.out.println("Your name cannot be empty.\n");
                        } else {
                            break;
                        }
                    }

                    //Get customer address
                    while (true) {
                        System.out.print("Enter your address, please!: ");
                        address = sc.nextLine().trim();
                        System.out.println();

                        //Validate address
                        if (address.isEmpty()) {
                            System.out.println("Your address cannot be empty.\n");
                        } else {
                            break;
                        }

                    }

                    //Get customer phone number
                    while (true) {
                        System.out.print("Enter your phone number, please!: ");
                        phoneNumber = sc.nextLine().trim();
                        System.out.println();

                        //Validate phone number (must be digits only, 9–15 characters)
                        if (phoneNumber.isEmpty()) {
                            System.out.println("Your phone number cannot be empty.\n");
                        } else if (!phoneNumber.matches("\\+?\\d{9,15}")) {
                            System.out.println("Invalid phone number. It must be 9–15 digits.\n");
                        } else {
                            break;
                        }
                    }
                    //Create Customer object from input
                    Customer customer = new Customer(fullname, address, phoneNumber);

                    //List to store selected books in the order
                    ArrayListADT<OrderBook> selectedBooks = new ArrayListADT<>();

                    //Book selection loop
                    while (true) {
                        books.printAllBooks();      //Show all available books

                        //Ask user to select a book
                        System.out.print("Select book number (1-" + books.size() + ") (or 0 to finish): ");

                        String input = sc.nextLine().trim();
                        int choice;

                        //Validate book selection input
                        try {
                            choice = Integer.parseInt(input);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.\n");
                            continue;
                        }

                        //Break loop if user finishes selection
                        if (choice == 0) {
                            break;
                        }

                        if (choice < 1 || choice > books.size()) {      //Check if selected book number is valid
                            System.out.println("Invalid book number.\n");
                            continue;
                        }

                        Book selectedBook = books.get(choice - 1);      //Get selected book
                        System.out.print("Enter quantity for \"" + selectedBook.getTitle() + "\": ");   //Ask user for quantity

                        String quan = sc.nextLine().trim();
                        int quantity;

                        try {       //Validate quantity input
                            quantity = Integer.parseInt(quan);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.\n");
                            continue;
                        }

                        //Check if quantity is within available range
                        if (quantity <= 0 || quantity > selectedBook.getQuantity()) {
                            System.out.println("Invalid quantity. Available: " + selectedBook.getQuantity() + "\n");
                            continue;
                        }

                        //Add the selected book to order list
                        selectedBooks.add(new OrderBook(selectedBook.getTitle(), selectedBook.getAuthor(), selectedBook.getPrice(), quantity));

                        //Reduce the quantity of the book in the library
                        selectedBook.setQuantity(selectedBook.getQuantity() - quantity);
                        System.out.println("Added: " + selectedBook.getTitle() + " x" + quantity + "\n");   //Confirm added book
                        }


                        //If any books were selected, create the order
                        if (!selectedBooks.isEmpty()) {
                            orderManager.createOrder(customer, selectedBooks);
                            System.out.println("Order created successfully!\n");
                            System.out.println();
                        } else {    //No books selected
                            System.out.println("Please select a book first.");
                            System.out.println();
                        }
                    break;


                case "2":       //View all orders
                    if (!orderManager.isAllOrdersEmpty()) {
                        orderManager.printAllOrder();
                    } else {
                        System.out.println("No orders have been placed yet.");
                        System.out.println();
                    }
                    break;


                case "3":       //Process the next order in queue
                    if (!orderManager.isAllOrdersEmpty()) {
                        orderManager.processNextOrder();
                    } else {
                        System.out.println("No orders have been placed yet.");
                        System.out.println();
                    }
                    break;


                case "4":       //View all orders in the queue
                    if (!orderManager.isOrderQueueEmpty()) {
                        orderManager.printOrderQueue();
                    }else {
                        System.out.println("No order in queue yet.");
                        System.out.println();
                    }
                    break;


                case "5":        //View the order history (processed orders)
                    if (!orderManager.isOrderHistoryEmpty()) {
                        orderManager.printOrderHistory();
                    }else {
                        System.out.println("No order history yet.");
                        System.out.println();
                    }
                    break;


                case "6":       //Cancel the most recent processed order
                    if (!orderManager.isOrderHistoryEmpty()) {
                        orderManager.cancelLastOrder();
                    }else {
                        System.out.println("No orders have been processed yet.");
                        System.out.println();
                    }
                    break;


                case "7":        //View cancelled orders
                    if (!orderManager.isCancelledOrderEmpty()) {
                        orderManager.printCancelledOrders();
                    }else {
                        System.out.println("No cancelled order history yet.");
                        System.out.println();
                    }
                     break;


                case "8":       //Search for an order by ID or Name/Phone
                    System.out.println("Search by: \n 1. Order ID \n 2. Name or Phone");

                    String opt = sc.nextLine().trim();
                    int option;

                    //Validate search option input
                    try {
                        option = Integer.parseInt(opt);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.\n");
                        continue;
                    }

                    if (option == 1) {       //Search by Order ID
                        System.out.print("Enter Order ID: ");

                        String id = sc.nextLine().trim();
                        int orderId;

                        try {
                            orderId = Integer.parseInt(id);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.\n");
                            continue;
                        }

                        Order order = orderManager.searchById(orderId);      //Search order and display result
                            if (order != null) {
                                System.out.println(order);
                            } else {
                                System.out.println("Order not found.");
                        }
                    } else {        //Search by Name or Phone
                        System.out.print("Enter name or phone: ");
                        String input = sc.nextLine();

                        ArrayListADT<Order> orders = orderManager.searchByNOrP(input);

                        if (orders == null || orders.isEmpty()) {
                            System.out.println("Order not found.");
                        } else {
                            for (int i = 0; i < orders.size(); i++) {       //Print all matched orders
                                System.out.println(orders.get(i));
                            }
                        }
                    }
                    break;


                case "9":       //Exit the application
                    System.out.println("Exiting... Thank you!");
                    running = false;
                    break;
                default:        //Invalid menu choice
                    System.out.println("Invalid option. Please select a valid option (1-9).");
                    break;
            }
        } while (running);      //Repeat until user chooses to exit
    }
}

