package com.ensat.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.dto.AgentBranch;
import com.ensat.entities.Agent;
import com.ensat.entities.Branch;
import com.ensat.repositories.AgentRepository;
import com.ensat.repositories.BranchRepository;

/**
 * Product service implement.
 */
@Service
public class AgentServiceImpl implements AgentService {

	private AgentRepository agentRepository;

	private BranchRepository branchRepository;

	@Autowired
	public void setAgentRepository(AgentRepository agentRepository) {
		this.agentRepository = agentRepository;
	}

	@Autowired
	public void setProductRepository(BranchRepository branchRepository) {
		this.branchRepository = branchRepository;
	}

	@Override
	public List<AgentBranch> listAllAgentsBrach() {
		Iterable<Agent> as = agentRepository.findAll();
		List<AgentBranch> abList = new ArrayList<AgentBranch>();
		for (Agent agent : as) {
			AgentBranch ab = new AgentBranch();
			Branch b = branchRepository.findOne(agent.getBranchId());
			ab.setAgent(agent);
			ab.setBranch(b);
			abList.add(ab);
		}

		return abList;
	}

	@Override
	public AgentBranch getAgentBrachById(Integer id) {
		AgentBranch ab = new AgentBranch();
		Agent a = agentRepository.findOne(id);
		Branch b = branchRepository.findOne(a.getBranchId());
		ab.setAgent(a);
		ab.setBranch(b);
		return ab;
	}

	@Override
	public Agent saveAgent(Agent agent) {
		return agentRepository.save(agent);
	}

	@Override
	public void deleteAgent(Integer id) {
		agentRepository.delete(id);
	}

}
