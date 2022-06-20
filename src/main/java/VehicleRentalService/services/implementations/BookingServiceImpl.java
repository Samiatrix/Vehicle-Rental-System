package VehicleRentalService.services.implementations;

import VehicleRentalService.Exceptions.NoVehicleAvailableForBookingException;
import VehicleRentalService.models.*;
import VehicleRentalService.services.BookingService;
import VehicleRentalService.services.BranchService;
import VehicleRentalService.services.VehicleService;

import java.util.HashMap;
import java.util.Map;

public class BookingServiceImpl implements BookingService {
    private Map<String, Booking> bookings;
    private VehicleService vehicleService;
    private BranchService branchService;

    public BookingServiceImpl(VehicleService vehicleService, BranchService branchService) {
        this.vehicleService = vehicleService;
        this.branchService = branchService;
        this.bookings = new HashMap<>();
    }

    @Override
    public String bookVehicle(String vehicleType, Slot slot) {
        Vehicle vehicle = vehicleService.getLowestPriceVehicle(vehicleType, slot);
        if(vehicle == null){
            throw new NoVehicleAvailableForBookingException();
        }
        vehicle.getBookedSlots().add(slot);
        Booking booking = new Booking(VehicleType.valueOf(vehicleType), vehicle, slot, vehicle.getBranch());
        bookings.put(booking.getId(), booking);
        return booking.getId();
    }
}
