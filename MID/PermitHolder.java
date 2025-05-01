public class PermitHolder extends Person {
    private int permitId;
    private static int count = 999;

    PermitHolder(String name) {
        super(name);
        this.permitId = count + 1;
        count++;
    }

    public int getPermitId() {
        return permitId;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Permit ID: " + permitId;
    }
}