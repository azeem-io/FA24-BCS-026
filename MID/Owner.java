public class Owner extends Person {
    private String ownerId;
    private static int count = 1;

    Owner(String name) {
        super(name);
        this.ownerId = String.format("%04d", count);
        count++;
    }

    public String getOwnerId() {
        return ownerId;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Owner ID: " + ownerId;
    }
}