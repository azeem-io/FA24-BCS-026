public class Rectangle extends Shape2D {
    private double length;
    private double width;
    private Point topLeftCorner;

    public Rectangle(String n, boolean isFilled, double length, double width, int x, int y) {
        super(n, isFilled);
        this.length = length;
        this.width = width;
        this.topLeftCorner = new Point(x, y);
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public Point getTopLeftCorner() {
        return this.topLeftCorner;
    }

    @Override
    double area() {
        return length * width;
    }

    public double perimeter() {
        return (length * 2) + (width * 2);
    }

    @Override
    public void draw() {
        System.out.println("This is draw function of rectangle");
    }

}
