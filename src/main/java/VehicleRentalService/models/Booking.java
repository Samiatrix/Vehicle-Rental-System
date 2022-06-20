package VehicleRentalService.models;

import java.util.UUID;

public class Booking {
    private String id;
    private VehicleType vehicleType;
    private Vehicle vehicle;
    private Slot slot;
    private Branch branch;

    public Booking(VehicleType vehicleType, Vehicle vehicle, Slot slot, Branch branch) {
        this.id = UUID.randomUUID().toString();
        this.vehicleType = vehicleType;
        this.vehicle = vehicle;
        this.slot = slot;
        this.branch = branch;
    }

    public String getId() {
        return id;
    }
}
