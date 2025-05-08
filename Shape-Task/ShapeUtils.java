public class ShapeUtils {

  public static void DisplayShapes(Shape[] shapes) {
    for (Shape shape : shapes) {
      System.out.println("==================");
      System.out.println("Name: " + shape.getName());
      if (shape instanceof Circle) {
        Circle circle = (Circle) shape;
        System.out.println("Circle Radius: " + circle.getRadius());
        System.out.println("Circle Area: " + circle.area());
      } else if (shape instanceof Sphere) {
        Sphere sphere = (Sphere) shape;
        System.out.println("Sphere Radius: " + sphere.getRadius());
        System.out.println("Sphere Volume: " + sphere.volume());
      } else if (shape instanceof Rectangle) {
        Rectangle rectangle = (Rectangle) shape;
        System.out.println("Rectangle Width: " + rectangle.getWidth());
        System.out.println("Rectangle Length: " + rectangle.getLength());
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Rectangle Perimeter: " + rectangle.perimeter());
      } else if (shape instanceof Cube) {
        Cube cube = (Cube) shape;
        System.out.println("Cube Side Length: " + cube.getSide());
        System.out.println("Cube Volume: " + cube.volume());
      }
      System.out.println("==================");

    }
  }

  public static void increaseRectLength(Shape[] shapes, double length) {
    for (Shape shape : shapes) {
      if (shape instanceof Rectangle) {
        Rectangle rectangle = (Rectangle) shape;
        double newLength = rectangle.getLength() + length;
        rectangle.setLength(newLength);
      }
    }
  }

  public static void drawDrawables(Drawable[] drawables) {
    for (Drawable drawable : drawables) {
      drawable.draw();
    }
  }

  public static boolean isIntersecting(Shape shape1, Shape shape2) {
    if (shape1 instanceof Rectangle && shape2 instanceof Rectangle) {
      Rectangle rec1 = (Rectangle) shape1;
      Rectangle rec2 = (Rectangle) shape2;
      return rec1.getTopLeftCorner().getX() < rec2.getTopLeftCorner().getX() + rec2.getWidth() &&
          rec1.getTopLeftCorner().getX() + rec1.getWidth() > rec2.getTopLeftCorner().getX() &&
          rec1.getTopLeftCorner().getY() < rec2.getTopLeftCorner().getY() + rec2.getLength() &&
          rec1.getTopLeftCorner().getY() + rec1.getLength() > rec2.getTopLeftCorner().getY();
    } else {
      System.out.println("Not rectangle");
      return false;
    }
  }
}