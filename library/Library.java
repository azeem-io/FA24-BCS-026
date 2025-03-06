public class Library {
    private String name;
    private Person inCharge;
    private Person staff;
    private Book book;

    public Library(String name, Person inCharge, Person staff, Book book) {
        this.name = name;
        this.inCharge = new Person(inCharge);
        this.staff = new Person(staff);
        this.book = book != null ? new Book(book) : null;
    }

    public Library(Library library) {
        this.name = library.name;
        this.inCharge = new Person(library.inCharge);
        this.staff = new Person(library.staff);
        this.book = library.book != null ? new Book(library.book) : null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getInCharge() {
        return new Person(inCharge);
    }

    public void setInCharge(Person inCharge) {
        this.inCharge = new Person(inCharge);
    }

    public Person getStaff() {
        return new Person(staff);
    }

    public void setStaff(Person staff) {
        this.staff = new Person(staff);
    }

    public Book getBook() {
        return book != null ? new Book(book) : null;
    }

    public void setBook(Book book) {
        this.book = book != null ? new Book(book) : null;
    }

    public boolean isEqual(Library other) {
        if (other == null) {
            return false;
        }

        boolean nameEqual = this.name.equals(other.name);
        boolean inChargeEqual = this.inCharge.isEqual(other.inCharge);
        boolean staffEqual = this.staff.isEqual(other.staff);

        if (this.book == null && other.book == null) {
            return nameEqual && inChargeEqual && staffEqual;
        } else if (this.book == null || other.book == null) {
            return false;
        } else {
            return nameEqual && inChargeEqual && staffEqual && this.book.isEqual(other.book);
        }
    }

    public void printDetails() {
        System.out.println("Library Name: " + name);

        System.out.println("Person In Charge:");
        inCharge.printDetails();

        System.out.println("Staff Member:");
        staff.printDetails();

        if (book != null) {
            System.out.println("Book:");
            book.printDetails();
        } else {
            System.out.println("No book available");
        }
    }
}
