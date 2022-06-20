package VehicleRentalService.strategy;

import VehicleRentalService.models.Vehicle;
import VehicleRentalService.models.VehicleType;

import java.util.List;

public interface LowestRentalPriceStrategy {
    Vehicle getLowestRentalVehicle(List<Vehicle> vehicleList, VehicleType vehicleType);
}
