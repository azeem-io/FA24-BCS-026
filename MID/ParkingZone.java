public class ParkingZone {
   private String zoneId;
   private Vehicle[] vehicles;
   private int vehicleCount = 0;
   private static int zoneCounter = 1;

   ParkingZone() {
      this.zoneId = "Z" + zoneCounter++;
      this.vehicles = new Vehicle[5];
   }

   public String getZoneId() {
      return zoneId;
   }

   public void addVehicle(Vehicle v) {
      if (v != null && v.getLicensePlate() != null) {
         if (vehicleCount < 5) {
            this.vehicles[vehicleCount] = v;
            vehicleCount++;
         }
      }
   }

   public Vehicle[] getVehicles() {
      return vehicles;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("Zone ID: ").append(zoneId).append(", Vehicles: [");

      for (int i = 0; i < vehicles.length; i++) {
         if (vehicles[i] != null) {
            sb.append(vehicles[i].toString());
         } else {
            sb.append("null");
         }

         if (i < vehicles.length - 1) {
            sb.append(", ");
         }
      }

      sb.append("]");
      return sb.toString();
   }
}