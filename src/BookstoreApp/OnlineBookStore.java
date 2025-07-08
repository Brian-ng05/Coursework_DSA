package BookstoreApp;

import ADT.arrayList.ArrayListADT;
import Model.Book;
import Model.Customer;
import Model.Order;
import Model.OrderBook;
import Service.BookLibrary;
import Service.OrderManager;

import java.util.Scanner;


public class OnlineBookStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        OrderManager manager = new OrderManager();
        BookLibrary books = new BookLibrary();



        boolean running = true;
        do {
            String[] menu = {
                    "======== Online Bookstore ========",
                    "1. Create new order",
                    "2. View all orders",
                    "3. Process next order",
                    "4. View order in queue",
                    "5. View order history",
                    "6. Cancel last processed order",
                    "7. View cancelled orders",
                    "8. Search order (by ID or Name/Phone)",
                    "9. Exit"
            };
            for (String i : menu) {
                System.out.println(i);
            }

            String userChoice = sc.nextLine();
            switch (userChoice) {
                case "1":

                    String fullname, address, phoneNumber;
                    while (true) {
                        System.out.print("Enter your full name, please!: ");
                        fullname = sc.nextLine().trim();
                        System.out.println();

                        if (fullname.isEmpty()) {
                            System.out.println("Your name cannot be empty.\n");
                        } else {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("Enter your address, please!: ");
                        address = sc.nextLine().trim();
                        System.out.println();

                        if (address.isEmpty()) {
                            System.out.println("Your address cannot be empty.\n");
                        } else {
                            break;
                        }

                    }

                    while (true) {
                        System.out.print("Enter your phone number, please!: ");
                        phoneNumber = sc.nextLine().trim();
                        System.out.println();

                        if (phoneNumber.isEmpty()) {
                            System.out.println("Your phone number cannot be empty.\n");
                        } else if (!phoneNumber.matches("\\+?\\d{9,15}")) {
                            System.out.println("Invalid phone number. It must be 9–15 digits.\n");
                        } else {
                            break;
                        }
                    }
                    Customer customer = new Customer(fullname, address, phoneNumber);


                    ArrayListADT<OrderBook> selectedBooks = new ArrayListADT<>();

                    while (true) {
                        books.printAllBooks();

                        System.out.println("Select book number (1-" + books.size() + ") (or 0 to finish): ");

                        String input = sc.nextLine().trim();
                        int choice;

                        try {
                            choice = Integer.parseInt(input);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.\n");
                            continue;
                        }

                        if (choice == 0) {
                            break;
                        }

                        if (choice < 1 || choice > books.size()) {
                            System.out.println("Invalid book number.\n");
                            continue;
                        }

                        Book selectedBook = books.get(choice - 1);
                        System.out.print("Enter quantity for \"" + selectedBook.getTitle() + "\": ");

                        String quan = sc.nextLine().trim();
                        int quantity;

                        try {
                            quantity = Integer.parseInt(quan);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.\n");
                            continue;
                        }


                        if (quantity <= 0 || quantity > selectedBook.getQuantity()) {
                            System.out.println("Invalid quantity. Available: " + selectedBook.getQuantity() + "\n");
                            continue;
                        }

                        selectedBooks.add(new OrderBook(selectedBook.getTitle(), selectedBook.getAuthor(), selectedBook.getPrice(), quantity));

                        selectedBook.setQuantity(selectedBook.getQuantity() - quantity);
                        System.out.println("Added: " + selectedBook.getTitle() + " x" + quantity + "\n");
                        }

                        if (!selectedBooks.isEmpty()) {
                            manager.createOrder(customer, selectedBooks);
                            System.out.println("Order created successfully!\n");
                            System.out.println();
                        } else {
                            System.out.println("Please select a book first.");
                            System.out.println();
                        }
                    break;


                case "2":
                    if (!manager.isAllOrdersEmpty()) {
                        manager.printAllOrder();
                    } else {
                        System.out.println("No orders have been placed yet.");
                        System.out.println();
                    }
                    break;


                case "3":
                    if (!manager.isAllOrdersEmpty()) {
                        manager.processNextOrder();
                    } else {
                        System.out.println("No orders have been placed yet.");
                        System.out.println();
                    }
                    break;


                case "4":
                    if (!manager.isOrderQueueEmpty()) {
                        manager.printOrderQueue();
                    }else {
                        System.out.println("No order in queue yet.");
                        System.out.println();
                    }
                    break;


                case "5":
                    if (!manager.isOrderHistoryEmpty()) {
                        manager.printOrderHistory();
                    }else {
                        System.out.println("No order history yet.");
                        System.out.println();
                    }
                    break;


                case "6":
                    if (!manager.isOrderHistoryEmpty()) {
                        manager.cancelLastOrder();
                    }else {
                        System.out.println("No orders have been processed yet.");
                        System.out.println();
                    }
                    break;


                case "7":
                    if (!manager.isCancelledOrderEmpty()) {
                        manager.printCancelledOrders();
                    }else {
                        System.out.println("No cancelled order history yet.");
                        System.out.println();
                    }
                     break;


                case "8":
                    System.out.println("Search by: \n 1. Order ID \n 2. Name or Phone");

                    String opt = sc.nextLine().trim();
                    int option;

                    try {
                        option = Integer.parseInt(opt);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.\n");
                        continue;
                    }

                    if (option == 1) {
                        System.out.print("Enter Order ID: ");

                        String id = sc.nextLine().trim();
                        int orderId;

                        try {
                            orderId = Integer.parseInt(id);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.\n");
                            continue;
                        }

                        Order order = manager.searchByOrderId(orderId);
                            if (order != null) {
                                System.out.println(order);
                            } else {
                                System.out.println("Order not found.");
                        }
                    } else {
                        System.out.print("Enter name or phone: ");
                        String input = sc.nextLine();

                        ArrayListADT<Order> orders = manager.searchByNameOrPhone(input);

                        if (orders == null || orders.isEmpty()) {
                            System.out.println("Order not found.");
                        } else {
                            for (int i = 0; i < orders.size(); i++) {
                                System.out.println(orders.get(i));
                            }
                        }
                    }
                    break;


                case "9":
                    System.out.println("Exiting... Thank you!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option (1-9).");
                    break;
            }
        } while (running);
    }
}

