public class Circle extends Shape2D {
    private double radius;
    private Point center;

    public Circle(String n, double radius, boolean isFilled) {
        super(n, isFilled);
        this.radius = radius;
    }

    public void setRadius(double r) {
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    double area() {
        double area = this.radius * 3.142;
        return area;
    }

    @Override
    public void draw() {
        System.out.println("This is draw function of circle");
    }

}
