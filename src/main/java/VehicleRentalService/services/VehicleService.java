package VehicleRentalService.services;

import VehicleRentalService.models.Branch;
import VehicleRentalService.models.Slot;
import VehicleRentalService.models.Vehicle;
import VehicleRentalService.models.VehicleType;

public interface VehicleService {
    void addVehicle(String id, VehicleType type, Branch branch);

    Vehicle getLowestPriceVehicle(String vehicleType, Slot slot);
}
