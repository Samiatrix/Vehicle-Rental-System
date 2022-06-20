package VehicleRentalService.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Branch {
    String name;
    List<Vehicle> vehicles;
    Map<VehicleType, Double> prices;

    public Branch(String name) {
        this.name = name;
        this.vehicles = new ArrayList<>();
        this.prices = new HashMap<>();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Map<VehicleType, Double> getPrices() {
        return prices;
    }
}
