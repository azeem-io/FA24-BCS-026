public class Cube extends Shape3D {
    private double side;

    public Cube(String n, double side) {
        super(n);
        this.side = side;
    }

    public void setSide(double s) {
        this.side = s;
    }

    public double getSide() {
        return side;
    }

    @Override
    double area() {
        return 0;
    }

    @Override
    double volume() {
        return side * side * side;
    }

    @Override
    public void draw() {
        System.out.println("This is draw function of cube");

    }

}
