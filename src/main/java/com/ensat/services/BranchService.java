package com.ensat.services;

import com.ensat.entities.Branch;

public interface BranchService {

    Iterable<Branch> listAllBranchs();

    Branch getBranchById(Integer id);

    Branch saveBranch(Branch product);

    void deleteBranch(Integer id);

}
