package org.Housing.KCAgentList.controllers;

import org.Housing.KCAgentList.data.StatusCategoriesRepository;
import org.Housing.KCAgentList.models.StatusCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("status")
public class StatusCategoryController {

    @Autowired
    private StatusCategoriesRepository statusCategoriesRepository;

    @GetMapping()
    public String displayAllStatus(Model model){
        model.addAttribute("title","Status");
        model.addAttribute("statusLists",statusCategoriesRepository.findAll());
        return "status/view";
    }

    @GetMapping("create")
    public String displayCreateStatusForm(Model model){
        model.addAttribute("title","Create Status");
        model.addAttribute(new StatusCategories());
        return "status/create";
    }

    @PostMapping("create")
    public String processCreateStatusForm(@ModelAttribute @Valid StatusCategories newStatusCategory, Errors errors,Model model){
        if (errors.hasErrors()){
          model.addAttribute("title","Create Status") ;
          return "status/create";
        }
        statusCategoriesRepository.save(newStatusCategory);
        return "redirect:";
    }

}
