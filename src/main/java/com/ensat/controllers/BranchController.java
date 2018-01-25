package com.ensat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensat.entities.Branch;
import com.ensat.services.BranchService;

/**
 * Product controller.
 */
@Controller
public class BranchController {

    private BranchService branchService;

    @Autowired
    public void setProductService(BranchService branchService) {
        this.branchService = branchService;
    }

    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/branchs", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("branchs", branchService.listAllBranchs());
        System.out.println("Returning branchs:");
        return "branchs";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("branch/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("branch", branchService.getBranchById(id));
        return "branchshow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("branch/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("branch", branchService.getBranchById(id));
        return "branchform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("branch/new")
    public String newProduct(Model model) {
        model.addAttribute("branch", new Branch());
        return "branchform";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "branch", method = RequestMethod.POST)
    public String saveBranch(Branch branch) {
    	branchService.saveBranch(branch);
        return "redirect:/branch/" + branch.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("branch/delete/{id}")
    public String delete(@PathVariable Integer id) {
    	branchService.deleteBranch(id);
        return "redirect:/products";
    }

}
