
public class App {
    public static void main(String[] args) {

        Shape shape;
        Shape2D shape2d;
        Shape3D shape3d;

        Circle circle = new Circle("Circle 1", 4.0, false);
        Rectangle rectangle = new Rectangle("Rect 1", false, 10.0, 5.0, 0, 0);
        Rectangle rectangle2 = new Rectangle("Rect 1", false, 10.0, 4.0, 0, 2);
        Rectangle rectangle3 = new Rectangle("Rect 1", false, 10.0, 5.0, 12, 6);

        double cArea = circle.area();
        double rArea = rectangle.area();
        double rParameter = rectangle.perimeter();

        Sphere sphere = new Sphere("Sphere 1", 4.0);
        Cube cube = new Cube("Cube 1", 4.0);

        double sVolume = sphere.volume();
        double cVolume = cube.volume();

        System.out.println("Circle Area: " + cArea);
        System.out.println("Rectangle Area: " + rArea);
        System.out.println("Rectangle Perimeter: " + rParameter);

        System.out.println("Sphere Volume: " + sVolume);
        System.out.println("Cube Volume: " + cVolume);

        Shape[] shapes = new Shape[20];

        for (int i = 0; i < 19; i++) {
            shapes[i] = new Circle("Circle " + i, 4.0, false);
            i++;
            shapes[i] = new Rectangle("Rect " + i, false, 10.0, 5.0, i + 2, i + 3);
            i++;
            shapes[i] = new Sphere("Sphere " + i, 4.0);
            i++;
            shapes[i] = new Cube("Cube " + i, 4.0);
        }

        ShapeUtils.DisplayShapes(shapes);
        ShapeUtils.increaseRectLength(shapes, 10);
        System.out.println(" ");
        System.out.println(" ");
        ShapeUtils.DisplayShapes(shapes);

        ShapeUtils.drawDrawables(shapes);

        System.out.println("================");
        System.out.println(ShapeUtils.isIntersecting(rectangle, rectangle2)); // Should be true
        System.out.println(ShapeUtils.isIntersecting(rectangle, rectangle3)); // Should be false

    }
}
