public class Sphere extends Shape3D {
    private double radius;

    public Sphere(String n, double radius) {
        super(n);
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
        return 0;
    }

    @Override
    double volume() {
        return (4 / 3) * 3.142 * radius * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("This is draw function of sphere");
    }

}
