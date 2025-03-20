public class Screen{
    private int screenNumber;
    private String movietitle;
    private Seat[][] seats;

    Screen(int sn, String mt, int rows, int cols){
        screenNumber = sn;
        movietitle = mt;
        this.seats = new Seat[rows][cols];
    }

    public boolean bookSeat(int row, int col, Customer customer){
        if(!seats[row][col].bookSeat()){
            return true;
        } else {
            System.out.println("Already booked");
            return false;
        }
    }

    public void displayScreen(){
        System.out.println("Screen Number: " + screenNumber);
        System.out.println("Movie Title: " + movietitle);
        System.out.println("Total Seats: " + (seats.length * seats[0].length));
    }

    public int getScreenNumber(){
        return screenNumber;
    }

    public String getMovietitle(){
        return movietitle;
    }

    public Seat getSeat(int row, int col){
        return seats[row][col];
    }

    public void initializeSeats(){
        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[i].length; j++){
                String type = (i < 3) ? "Premium" : "Regular";
                double price = (i < 3) ? 12.99 : 8.99;
                seats[i][j] = new Seat(j+1, i+1, type, price);
            }
        }
    }
}
