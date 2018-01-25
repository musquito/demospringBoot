package com.ensat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.entities.Branch;
import com.ensat.repositories.BranchRepository;

/**
 * Product service implement.
 */
@Service
public class BranchServiceImpl implements BranchService {

    private BranchRepository branchRepository;

    @Autowired
    public void setBranchRepository(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public Iterable<Branch> listAllBranchs() {
        return branchRepository.findAll();
    }

    @Override
    public Branch getBranchById(Integer id) {
        return branchRepository.findOne(id);
    }

    @Override
    public Branch saveBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public void deleteBranch(Integer id) {
    	branchRepository.delete(id);
    }

}
