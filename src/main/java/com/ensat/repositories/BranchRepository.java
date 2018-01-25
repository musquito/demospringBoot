package com.ensat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ensat.entities.Branch;

public interface BranchRepository extends CrudRepository<Branch, Integer> {

}
