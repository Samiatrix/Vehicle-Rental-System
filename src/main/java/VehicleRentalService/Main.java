package VehicleRentalService;

import VehicleRentalService.controller.BookingController;
import VehicleRentalService.controller.BranchController;
import VehicleRentalService.controller.VehicleController;
import VehicleRentalService.services.BookingService;
import VehicleRentalService.services.BranchService;
import VehicleRentalService.services.VehicleService;
import VehicleRentalService.services.implementations.BookingServiceImpl;
import VehicleRentalService.services.implementations.BranchServiceImpl;
import VehicleRentalService.services.implementations.VehicleServiceImpl;
import VehicleRentalService.strategy.LowestRentalPriceStrategy;
import VehicleRentalService.strategy.implementations.LowestRentalPriceStrategyImpl;

import java.nio.file.ClosedWatchServiceException;

public class Main {
    public static void main(String[] args) {
        LowestRentalPriceStrategy lowestRentalPriceStrategy = new LowestRentalPriceStrategyImpl();
        BranchService branchService = new BranchServiceImpl();
        VehicleService vehicleService = new VehicleServiceImpl(lowestRentalPriceStrategy);
        BookingService bookingService = new BookingServiceImpl(vehicleService);
        BranchController branchController = new BranchController(branchService);
        VehicleController vehicleController = new VehicleController(vehicleService, branchService);
        BookingController bookingController = new BookingController(vehicleService, branchService, bookingService);

        branchController.addBranch("Vasant Vihar");
        branchController.addBranch("Connaught Place");
        branchController.addBranch("Kashmere Gate");

        branchController.allocatePrice("Vasant Vihar", "Sedan", 100.0);
        branchController.allocatePrice("Vasant Vihar", "Hatchback", 80.0);
        branchController.allocatePrice("Vasant Vihar", "SUV", 120.0);

        branchController.allocatePrice("Connaught Place", "Sedan", 120.0);
        branchController.allocatePrice("Connaught Place", "Hatchback", 100.0);
        branchController.allocatePrice("Connaught Place", "SUV", 150.0);

        branchController.allocatePrice("Kashmere Gate", "Sedan", 150.0);
        branchController.allocatePrice("Kashmere Gate", "Hatchback", 120.0);
        branchController.allocatePrice("Kashmere Gate", "SUV", 200.0);

        vehicleController.addVehicle("vehicle1", "SUV", "Vasant Vihar");
        vehicleController.addVehicle("vehicle2", "Sedan", "Vasant Vihar");
        vehicleController.addVehicle("vehicle3", "Hatchback", "Vasant Vihar");
        vehicleController.addVehicle("vehicle4", "SUV", "Connaught Place");
        vehicleController.addVehicle("vehicle5", "Sedan", "Connaught Place");
        vehicleController.addVehicle("vehicle6", "Hatchback", "Connaught Place");
        vehicleController.addVehicle("vehicle7", "SUV", "Kashmere Gate");
        vehicleController.addVehicle("vehicle8", "Sedan", "Kashmere Gate");
        vehicleController.addVehicle("vehicle9", "Hatchback", "Kashmere Gate");

        String bookingId1 = bookingController.bookVehicle("Sedan", 1, 2);
        String bookingId2 = bookingController.bookVehicle("Sedan", 1, 2);
        String bookingId3 = bookingController.bookVehicle("Sedan", 1, 2);
        String bookingId4 = bookingController.bookVehicle("Sedan", 1, 2);


    }
}
