public abstract class Shape implements Drawable {
    private String name;

    public Shape(String n) {
        this.name = n;
    }

    abstract double area();

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
