package VehicleRentalService.services;

import VehicleRentalService.models.Slot;

public interface BookingService {
    String bookVehicle(String vehicleType, Slot slot);
}
