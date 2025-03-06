public class Address{
    private int house;
    private int street;
    private String city;

    Address(int house, int street, String city) {
        this.house = house;
        this.street = street;
        this.city = city;
    }

    Address(Address address) {
        this.house = address.house;
        this.street = address.street;
        this.city = address.city;
    }

    public int getHouse() {
        return house;
    }

    public int getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public boolean isEqual(Address other) {
        if (other == null) {
            return false;
        }
        return this.house == other.house &&
               this.street == other.street &&
               this.city.equals(other.city);
    }

    public void printDetails() {
        System.out.println("House: " + house + ", Street: " + street + ", City: " + city);
    }
}
