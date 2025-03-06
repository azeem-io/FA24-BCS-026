public class Person{
    private String name;
    private Address address;
    private String gender;

    public Person(String name, Address address, String gender) {
        this.name = name;
        this.address = new Address(address);
        this.gender = gender;
    }

    public Person(Person person) {
        this.name = person.name;
        this.address = new Address(person.address);
        this.gender = person.gender;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return new Address(address);
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = new Address(address);
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isEqual(Person other) {
        if (other == null) {
            return false;
        }
        return this.name.equals(other.name) &&
               this.address.isEqual(other.address) &&
               this.gender.equals(other.gender);
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.print("Address: ");
        address.printDetails();
    }
}
