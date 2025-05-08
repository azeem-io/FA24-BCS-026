public abstract class Shape2D extends Shape {

    private boolean isFilled;

    public void setFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    public Shape2D(String n, boolean isFilled) {
        super(n);
        this.isFilled = isFilled;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
