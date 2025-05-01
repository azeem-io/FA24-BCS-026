public class Vehicle {
    private String licensePlate;
    private String type;
    private Owner owner;
    private static String[] existingLicensePlates = new String[100];
    private static int licensePlateCount = 0;

    Vehicle(String lp, String type, Owner owner) {
        for (int i = 0; i < licensePlateCount; i++) {
            if (existingLicensePlates[i] != null && existingLicensePlates[i].equals(lp)) {
                System.out.println("Error: Duplicate license plate '" + lp + "' is not allowed.");
                return;
            }
        }

        this.licensePlate = lp;
        this.type = type;
        this.owner = owner;
        existingLicensePlates[licensePlateCount++] = lp;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getType() {
        return type;
    }

    public Owner getOwner() {
        return owner;
    }

    public Vehicle shallowCopy() {
        Vehicle copy = new Vehicle(this.licensePlate + "-copy", this.type, this.owner);
        return copy;
    }

    public Vehicle deepCopy() {
        Owner newOwner = new Owner(this.owner.getName());
        Vehicle copy = new Vehicle(this.licensePlate + "-copy", this.type, newOwner);
        return copy;
    }

    @Override
    public String toString() {
        if (licensePlate == null) {
            return "License Plate: null, Type: null, Owner: [null]";
        }
        return "License Plate: " + this.licensePlate + ", Type: " + this.type + ", Owner: [" + owner.toString() + "]";
    }
}