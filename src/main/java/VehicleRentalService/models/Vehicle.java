package VehicleRentalService.models;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private String id;
    private VehicleType type;
    private Branch branch;
    private List<Slot> bookedSlots;

    public Vehicle(String id, VehicleType type, Branch branch) {
        this.id = id;
        this.type = type;
        this.branch = branch;
        this.bookedSlots = new ArrayList<>();
    }

    public VehicleType getType() {
        return type;
    }

    public Branch getBranch() {
        return branch;
    }

    public List<Slot> getBookedSlots() {
        return bookedSlots;
    }
}
