package Model;

public class Customer {
    private String name;
    private String address;
    private String phoneNumber;

    //Constructor
    public Customer(String name, String address, String phoneNumber) {
        setName(name);
        setAddress(address);
        setPhoneNumber(phoneNumber);
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("\\+?\\d{9,15}")) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Invalid phone number format");
        }
    }

    //Getter
    public String getAddress() {
        return this.address;
    }
    public String getName() {
        return this.name;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    //Override the toString method
    @Override
    public String toString() {
        return name + " - " + address + " - " + phoneNumber;
    }


//        public static void main(String[] args) {
//
//            // Test 1: Create customer with valid phone number
//            System.out.println("=== Test 1: Valid customer ===");
//            Customer c1 = new Customer("Alice", "123 Main St", "+84987654321");
//            System.out.println("Customer: " + c1);
//            System.out.println("Name: " + c1.getName());
//            System.out.println("Address: " + c1.getAddress());
//            System.out.println("Phone: " + c1.getPhoneNumber());
//
//            // Test 2: Update name, address, phone
//            System.out.println("\n=== Test 2: Update fields ===");
//            c1.setName("Alice Nguyen");
//            c1.setAddress("456 New Road");
//            c1.setPhoneNumber("0987654321");
//            System.out.println("Updated Customer: " + c1);
//
//            // Test 3: Invalid phone number (too short)
//            System.out.println("\n=== Test 3: Invalid phone (short) ===");
//            try {
//                Customer c2 = new Customer("Bob", "789 Street", "123");
//            } catch (IllegalArgumentException e) {
//                System.out.println("Caught exception: " + e.getMessage());
//            }
//
//            // Test 4: Invalid phone number (letters inside)
//            System.out.println("\n=== Test 4: Invalid phone (letters) ===");
//            try {
//                Customer c3 = new Customer("Charlie", "101 Lane", "09abc12345");
//            } catch (IllegalArgumentException e) {
//                System.out.println("Caught exception: " + e.getMessage());
//            }
//
//            // Test 5: Phone number with country code
//            System.out.println("\n=== Test 5: Valid with +84 code ===");
//            Customer c4 = new Customer("David", "321 City", "+84123456789");
//            System.out.println("Customer: " + c4);
//        }

}
