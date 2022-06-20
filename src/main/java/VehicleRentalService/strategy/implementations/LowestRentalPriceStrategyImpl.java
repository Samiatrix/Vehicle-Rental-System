package VehicleRentalService.strategy.implementations;

import VehicleRentalService.models.Vehicle;
import VehicleRentalService.models.VehicleType;
import VehicleRentalService.strategy.LowestRentalPriceStrategy;

import java.util.List;

public class LowestRentalPriceStrategyImpl implements LowestRentalPriceStrategy {

    @Override
    public Vehicle getLowestRentalVehicle(List<Vehicle> vehicleList, VehicleType vehicleType) {
        double lowestRent = Double.MAX_VALUE;
        Vehicle lowestRentalVehicle = null;
        for(Vehicle vehicle : vehicleList){
            double vehiclePrice = vehicle.getBranch().getPrices().get(vehicleType);
            if(vehiclePrice < lowestRent){
                lowestRentalVehicle = vehicle;
                lowestRent = vehiclePrice;
            }
        }
        return lowestRentalVehicle;
    }
}
