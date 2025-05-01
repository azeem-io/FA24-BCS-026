public class ParkingSystem {
    private String campusName;
    private Supervisor supervisor;
    private PermitHolder[] permitHolders;
    private ParkingZone[] zones;
    private int zoneCount = 0;
    private int holdersCount = 0;
    private static ParkingSystem instance = null;

    private ParkingSystem(String name, Supervisor s) {
        this.campusName = name;
        this.supervisor = s;
        this.zones = new ParkingZone[10];
        this.permitHolders = new PermitHolder[10];
    }

    public static ParkingSystem getInstance(String name, Supervisor s) {
        if (instance == null) {
            instance = new ParkingSystem(name, s);
            return instance;
        } else {
            System.out.println("Warning: ParkingSystem instance already exists. Returning existing instance.");
            return instance;
        }
    }

    public void addZone(ParkingZone z) {
        this.zones[zoneCount] = z;
        zoneCount++;
    }

    public void addPermitHolder(PermitHolder p) {
        this.permitHolders[holdersCount] = p;
        holdersCount++;
    }

    public void setName(String name) {
        this.campusName = name;
    }

    public void setSupervisor(Supervisor s) {
        this.supervisor = s;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Campus: ").append(this.campusName).append("\n");
        sb.append("Supervisor: ").append(this.supervisor.toString()).append("\n");

        sb.append("Zones: [");
        for (int i = 0; i < zoneCount; i++) {
            sb.append(zones[i].toString());
            if (i < zoneCount - 1) {
                sb.append(", \n       ");
            }
        }
        sb.append("]\n");

        sb.append("Permit Holders: [");
        for (int i = 0; i < holdersCount; i++) {
            sb.append(permitHolders[i].toString());
            if (i < holdersCount - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}