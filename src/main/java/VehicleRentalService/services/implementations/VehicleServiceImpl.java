package VehicleRentalService.services.implementations;

import VehicleRentalService.models.Branch;
import VehicleRentalService.models.Slot;
import VehicleRentalService.models.Vehicle;
import VehicleRentalService.models.VehicleType;
import VehicleRentalService.services.VehicleService;
import VehicleRentalService.strategy.LowestRentalPriceStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleServiceImpl implements VehicleService {
    private Map<VehicleType, List<Vehicle>> vehicles;
    private LowestRentalPriceStrategy lowestRentalPriceStrategy;

    public VehicleServiceImpl(LowestRentalPriceStrategy lowestRentalPriceStrategy) {
        this.vehicles = new HashMap<>();
        this.lowestRentalPriceStrategy = lowestRentalPriceStrategy;
    }

    @Override
    public void addVehicle(String id, VehicleType type, Branch branch) {
        Vehicle vehicle = new Vehicle(id, type, branch);
        branch.getVehicles().add(vehicle);
        addVehicleByType(type, vehicle);
    }

    @Override
    public Vehicle getLowestPriceVehicle(String vehicleType, Slot slot) {
        List<Vehicle> vehicleCandidates = vehicles.get(VehicleType.valueOf(vehicleType));
        removeUnavailableVehicles(vehicleCandidates, slot);
        if(vehicleCandidates.isEmpty()){
            return null;
        }
        return lowestRentalPriceStrategy.getLowestRentalVehicle(vehicleCandidates, VehicleType.valueOf(vehicleType));
    }

    private void removeUnavailableVehicles(List<Vehicle> vehicleCandidates, Slot slot) {
        vehicleCandidates.removeIf(vehicle -> vehicle.getBookedSlots().contains(slot));
    }

    private void addVehicleByType(VehicleType type, Vehicle vehicle) {
        vehicles.computeIfAbsent(type, k -> new ArrayList<>());
        vehicles.get(type).add(vehicle);
    }
}
