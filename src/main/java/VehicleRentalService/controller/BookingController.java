package VehicleRentalService.controller;

import VehicleRentalService.models.Slot;
import VehicleRentalService.services.BookingService;
import VehicleRentalService.services.BranchService;
import VehicleRentalService.services.VehicleService;

public class BookingController {
    private VehicleService vehicleService;
    private BranchService branchService;
    private BookingService bookingService;

    public BookingController(VehicleService vehicleService, BranchService branchService, BookingService bookingService) {
        this.vehicleService = vehicleService;
        this.branchService = branchService;
        this.bookingService = bookingService;
    }

    public String bookVehicle(String vehicleType, int startTime, int endTime){
        String bookingId = bookingService.bookVehicle(vehicleType, new Slot(startTime, endTime));
        return bookingId;
    }
}
