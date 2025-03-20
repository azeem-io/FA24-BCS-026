public class Seat{
    private int seatNumber;
    private int rowNumber;
    private String type;
    private double price;
    private boolean isBooked;


    Seat(int sn, int rn, String t, double p){
        seatNumber = sn;
        rowNumber = rn;
        type = t;
        price = p;
        isBooked = false;
    }

    public boolean bookSeat(){
        return isBooked;
    }


    public void displaySeat(){

    }

    public int getSeatNumber(){
        return this.seatNumber;
    }

    public int getRowNumber(){
        return this.rowNumber;
    }

    public double getPrice(){
        return this.price;
    }

    public boolean getIsBooked(){
        return this.isBooked;
    }



}
