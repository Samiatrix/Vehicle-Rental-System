package VehicleRentalService.services.implementations;

import VehicleRentalService.Exceptions.BranchAlreadyExistsException;
import VehicleRentalService.Exceptions.BranchNotFoundException;
import VehicleRentalService.models.Branch;
import VehicleRentalService.models.VehicleType;
import VehicleRentalService.services.BranchService;

import java.util.HashMap;
import java.util.Map;

public class BranchServiceImpl implements BranchService {
    private final Map<String, Branch> branches;

    public BranchServiceImpl() {
        this.branches = new HashMap<>();
    }

    @Override
    public void addBranch(String branchName) {
        if(branches.containsKey(branchName)){
            throw new BranchAlreadyExistsException();
        }
        Branch branch = new Branch(branchName);
        branches.put(branchName, branch);
    }

    @Override
    public void allocatePrice(String branchName, String vehicleType, Double price) {
        Branch branch = getBranchByBranchName(branchName);
        if(branch == null){
            throw new BranchNotFoundException();
        }
        VehicleType type = VehicleType.valueOf(vehicleType);
        branch.getPrices().put(type, price);
    }

    @Override
    public Branch getBranchByBranchName(String branchName) {
        return branches.get(branchName);
    }

}
