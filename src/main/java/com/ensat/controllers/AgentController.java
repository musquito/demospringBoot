package com.ensat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensat.entities.Agent;
import com.ensat.services.AgentService;
import com.ensat.services.BranchService;

/**
 * Product controller.
 */
@Controller
public class AgentController {

    private AgentService agentService;

    @Autowired
    public void setAgentService(AgentService agentService) {
        this.agentService = agentService;
    }
    private BranchService branchService;

    @Autowired
    public void setBranchService(BranchService branchService) {
        this.branchService = branchService;
    }


    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/agents", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("agents", agentService.listAllAgentsBrach());
        System.out.println("Returning agents:");
        return "agents";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("agent/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("agent", agentService.getAgentBrachById(id));
        return "agentsshow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("agent/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        model.addAttribute("agent", agentService.getAgentBrachById(id).getAgent());
        model.addAttribute("branchs", branchService.listAllBranchs());
        return "agentform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("agent/new")
    public String newProduct(Model model) {
        model.addAttribute("agent", new Agent());
        model.addAttribute("branchs", branchService.listAllBranchs());
        return "agentform";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "agent", method = RequestMethod.POST)
    public String saveProduct(Agent agent) {
    	agentService.saveAgent(agent);
        return "redirect:/agent/" + agent.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("agent/delete/{id}")
    public String delete(@PathVariable Integer id) {
    	agentService.deleteAgent(id);
        return "redirect:/agents";
    }

}
