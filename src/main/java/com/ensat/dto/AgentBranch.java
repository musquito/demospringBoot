package com.ensat.dto;

import com.ensat.entities.Agent;
import com.ensat.entities.Branch;

public class AgentBranch {
	private Agent agent;
	private Branch branch;

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

}
