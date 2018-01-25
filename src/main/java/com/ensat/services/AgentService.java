package com.ensat.services;

import java.util.List;

import com.ensat.dto.AgentBranch;
import com.ensat.entities.Agent;

public interface AgentService {

	 List<AgentBranch> listAllAgentsBrach();

	 AgentBranch getAgentBrachById(Integer id);

    Agent saveAgent(Agent product);

    void deleteAgent(Integer id);

}
