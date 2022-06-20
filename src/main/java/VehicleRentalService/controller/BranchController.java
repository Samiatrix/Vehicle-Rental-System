package VehicleRentalService.controller;

import VehicleRentalService.services.BranchService;

public class BranchController {
    private BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    public void addBranch(String branchName){
        branchService.addBranch(branchName);
    }

    public void allocatePrice(String branchName, String vehicleType, Double price){
        branchService.allocatePrice(branchName, vehicleType, price);
    }
}
