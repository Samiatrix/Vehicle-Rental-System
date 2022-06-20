package VehicleRentalService.services.implementations;

import VehicleRentalService.models.Branch;
import VehicleRentalService.models.Slot;
import VehicleRentalService.models.Vehicle;
import VehicleRentalService.models.VehicleType;
import VehicleRentalService.services.VehicleService;
import VehicleRentalService.strategy.LowestRentalPriceStrategy;

import java.util.*;

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
        List<Vehicle> availableVehicles = removeUnavailableVehicles(vehicleCandidates, slot);
        if(availableVehicles.isEmpty()){
            return null;
        }
        return lowestRentalPriceStrategy.getLowestRentalVehicle(availableVehicles, VehicleType.valueOf(vehicleType));
    }

    private List<Vehicle> removeUnavailableVehicles(List<Vehicle> vehicleCandidates, Slot slot) {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for(Vehicle vehicle : vehicleCandidates){
            Optional<Slot> optionalBookedSlot = vehicle.getBookedSlots().stream().filter(bslot -> bslot.getStartTime() == slot.getStartTime() && bslot.getEndTime() == slot.getEndTime()).findAny();
            if(optionalBookedSlot.isEmpty()){
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    private void addVehicleByType(VehicleType type, Vehicle vehicle) {
        vehicles.computeIfAbsent(type, k -> new ArrayList<>());
        vehicles.get(type).add(vehicle);
    }
}
