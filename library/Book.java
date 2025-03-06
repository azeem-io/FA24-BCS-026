public class Book{
    private String title;
    private String issn;
    private Date dop;
    private String author;

    Book(String title, String issn, Date dop, String author){
        this.title = title;
        this.issn = issn;
        this.dop = new Date(dop);
        this.author = author;
    }

    public Book(Book book) {
        this.title = book.title;
        this.issn = book.issn;
        this.dop = new Date(book.dop);
        this.author = book.author;
    }

    public String getTitle() {
        return title;
    }

    public String getIssn() {
        return issn;
    }

    public Date getDop() {
        return new Date(dop);
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public void setDop(Date dop) {
        this.dop = new Date(dop);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isEqual(Book other) {
        if (other == null) {
            return false;
        }
        return this.title.equals(other.title) &&
               this.issn.equals(other.issn) &&
               this.dop.isEqual(other.dop) &&
               this.author.equals(other.author);
    }

    public void printDetails() {
        System.out.println("Title: " + title);
        System.out.println("ISSN: " + issn);
        System.out.print("Date of Publication: ");
        dop.printDetails();
        System.out.println("Author: " + author);
    }
}
