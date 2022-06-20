package VehicleRentalService.controller;

import VehicleRentalService.models.Branch;
import VehicleRentalService.models.VehicleType;
import VehicleRentalService.services.BranchService;
import VehicleRentalService.services.VehicleService;

public class VehicleController {
    private VehicleService vehicleService;
    private BranchService branchService;

    public VehicleController(VehicleService vehicleService, BranchService branchService) {
        this.vehicleService = vehicleService;
        this.branchService = branchService;
    }

    public void addVehicle(String vehicleId, String vehicleType, String branchName){
        Branch branch = branchService.getBranchByBranchName(branchName);
        vehicleService.addVehicle(vehicleId, VehicleType.valueOf(vehicleType), branch);
    }


}
