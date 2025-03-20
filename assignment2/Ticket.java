public class Ticket{
    private int ticketId;
    private Customer customer;
    private int screenNumber;
    private int seatNumber;
    private String movieTitle;
    private double price;


    Ticket(){
    }

    public Ticket(int ticketId, Customer customer, int screenNumber, int seatNumber, String movieTitle, double price) {
        this.ticketId = ticketId;
        this.customer = customer;
        this.screenNumber = screenNumber;
        this.seatNumber = seatNumber;
        this.movieTitle = movieTitle;
        this.price = price;
    }

    public void display() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Movie: " + movieTitle);
        System.out.println("Screen: " + screenNumber);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Price: $" + price);
        System.out.println("Customer Details:");
        customer.display();
    }
}
