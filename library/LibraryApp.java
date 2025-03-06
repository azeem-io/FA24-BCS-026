public class LibraryApp{

    public static void main(String[] args) {
        Address address1 = new Address(123, 45, "New York");
        Address address2 = new Address(456, 78, "Boston");

        Person librarian = new Person("John Smith", address1, "Male");
        Person staffMember = new Person("Jane Doe", address2, "Female");

        Date publishDate = new Date(15, 5, 2020);
        Book book = new Book("Java Programming", "ISBN-123-456", publishDate, "James Gosling");

        Library library = new Library("Central Library", librarian, staffMember, book);

        System.out.println("Library Information:");
        System.out.println(library.getName());

        library.printDetails();

        Library libraryCopy = new Library(library);

        Date newDate = new Date(10, 2, 2022);
        Book newBook = new Book("Data Structures", "ISBN-789-012", newDate, "Robert Sedgewick");
        libraryCopy.setBook(newBook);

        Address address3 = new Address(789, 10, "Chicago");
        Person newStaff = new Person("Bob Johnson", address3, "Male");
        libraryCopy.setStaff(newStaff);

        System.out.println("\nAfter modifications:");
        System.out.println("Original library: ");
        library.printDetails();

        System.out.println("\nModified copy: ");
        libraryCopy.printDetails();

        System.out.println("\nEquals comparison:");
        System.out.println("Original equals copy? " + library.isEqual(libraryCopy));

        Library identicalLibrary = new Library("Central Library", librarian, staffMember, book);
        System.out.println("Original equals identical? " + library.isEqual(identicalLibrary));

        Address testAddress1 = new Address(123, 45, "New York");
        Address testAddress2 = new Address(123, 45, "New York");
        System.out.println("\nAddress equals test: " + address1.isEqual(testAddress1));

        Book book1 = new Book("Java Programming", "ISBN-123-456", publishDate, "James Gosling");
        System.out.println("Book equals test: " + book.isEqual(book1));

        Date date1 = new Date(15, 5, 2020);
        System.out.println("Date equals test: " + publishDate.isEqual(date1));
    }
}
