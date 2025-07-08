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

    @Override
    public String toString() {
        return name + " - " + address + " - " + phoneNumber;
    }

//    public static void main(String[] args) {
//        Customer customer1 = new Customer("Brian", "Son Tra, Da Nang", "0369235524");
//        System.out.println(customer1);
//    }
}
