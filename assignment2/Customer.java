public class Customer{
    private int customerId;
    private String name;
    private String phoneNumber;
    private String email;

    Customer(int customerId, String name, String phoneNumber, String email){
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void display(){
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
    }

    public int getCustomerId(){
        return customerId;
    }

    public String getName(){
        return name;
    }
}
