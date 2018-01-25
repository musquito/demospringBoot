package com.ensat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ensat.entities.Agent;

public interface AgentRepository extends CrudRepository<Agent, Integer> {

}
