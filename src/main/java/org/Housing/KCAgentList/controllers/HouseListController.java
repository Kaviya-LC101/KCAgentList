package org.Housing.KCAgentList.controllers;

import org.Housing.KCAgentList.data.HouseListRepository;
import org.Housing.KCAgentList.data.StatusCategoriesRepository;
import org.Housing.KCAgentList.models.HouseList;
import org.Housing.KCAgentList.models.StatusCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("house")
public class HouseListController {

   @Autowired
   private HouseListRepository houseListRepository;

   @Autowired
   private StatusCategoriesRepository statusCategoriesRepository;

    @GetMapping("add")
    public String renderAddListingsForm(Model model){
        model.addAttribute("title","Add House");
        model.addAttribute(new HouseList());
        model.addAttribute("types", statusCategoriesRepository.findAll());
        return "house/add";
    }

    @PostMapping("add")
    public String addListings(@ModelAttribute @Valid HouseList newHouseList, Errors errors,Model model){
        if(errors.hasErrors()){
            model.addAttribute("title","Add House");
            model.addAttribute("types", statusCategoriesRepository.findAll());
            return("house/add");
        }

       houseListRepository.save(newHouseList);
        return "redirect:/view";
    }
    @GetMapping("delete")
    public String displayDeleteHouseListForm(Model model){
        model.addAttribute("title","Delete Events");
        model.addAttribute("houseLists",houseListRepository.findAll());
        return "house/delete";
    }
    @PostMapping("delete")
    public String deleteHouseListings(@RequestParam(required = false) int[] houseIds){
        if(houseIds!=null) {
            for (int id : houseIds) {
                houseListRepository.deleteById(id);
            }
        }


        return "redirect:/view";
    }

    @GetMapping("update")
    public String displayUpdateForm(Model model){
        model.addAttribute("title","Update House");
        model.addAttribute("houseLists",houseListRepository.findAll());

        return "house/update";
    }

    @GetMapping("updateDetails")
    public String displayUpdateHouseDetailsForm(Model model,int houseId){
        model.addAttribute("title","Update House Details");
        Optional<HouseList> oppHouseEdit=houseListRepository.findById(houseId);
        HouseList houseToEdit=(HouseList) oppHouseEdit.get();
        model.addAttribute("houseList",houseToEdit);
        model.addAttribute("types",statusCategoriesRepository.findAll());
        return "house/updateDetails";
    }

    @PostMapping("updateDetails")
    public String processUpdateDetailsForm(int houseId, String houseDescription, String location, float price, Integer status, String yearBuilt) {
            Optional<HouseList> opphouseEdit = houseListRepository.findById(houseId);
            HouseList houseListToEdit = (HouseList) opphouseEdit.get();
            houseListToEdit.setHouseDescription(houseDescription);
            houseListToEdit.setLocation(location);
            houseListToEdit.setPrice(price);
            houseListToEdit.setYearBuilt(yearBuilt);
            Optional<StatusCategories> oppStatus = statusCategoriesRepository.findById(status);
            StatusCategories newstatus = (StatusCategories) oppStatus.get();
            houseListToEdit.setStatus(newstatus);
            houseListRepository.save(houseListToEdit);
            return "redirect:/view";

    }

}
