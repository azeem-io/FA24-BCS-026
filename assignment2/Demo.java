public class Demo{
    public static void main(String args[]){
        Cinema cin = new Cinema("Cinema A", "Lahore", 1);

        Screen screen1 = new Screen(1, "Avengers", 8, 10);

        screen1.initializeSeats();

        cin.addScreen(0, screen1);

        Customer customer1 = new Customer(101, "Azeem sarwar", "1234", "azeem@gmail.com");

        boolean bookingStatus = screen1.bookSeat(2, 5, customer1);

        if(bookingStatus){
            Ticket ticket1 = new Ticket(1001, customer1, screen1.getScreenNumber(),
                                     screen1.getSeat(2, 5).getSeatNumber(),
                                     screen1.getMovietitle(),
                                     screen1.getSeat(2, 5).getPrice());

            System.out.println("=== Booking Confirmed ===");
            ticket1.display();
        }

        System.out.println("=== Cinema Information ===");
        cin.displayCinema();
    }
}
