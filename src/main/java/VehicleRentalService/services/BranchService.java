package VehicleRentalService.services;

import VehicleRentalService.models.Branch;

public interface BranchService {
    void addBranch(String branchName);

    void allocatePrice(String branchName, String vehicleType, Double price);

    Branch getBranchByBranchName(String branchName);
}
