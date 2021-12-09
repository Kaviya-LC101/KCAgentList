package org.Housing.KCAgentList.controllers;

import org.Housing.KCAgentList.data.HouseListData;
import org.Housing.KCAgentList.models.HouseList;
import org.Housing.KCAgentList.models.StatusType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("house")
public class HouseListController {

    @GetMapping
    public String displayAllListings(Model model){
        model.addAttribute("title","All Listings");
        model.addAttribute("houseLists", HouseListData.getALL());
        return "view";
    }

    @GetMapping("add")
    public String renderAddListingsForm(Model model){
        model.addAttribute("title","Add House");
        model.addAttribute(new HouseList());
        model.addAttribute("types", StatusType.values());
        return "house/add";
    }

    @PostMapping("add")
    public String addListings(@ModelAttribute @Valid HouseList newHouseList, Errors errors,Model model){
        if(errors.hasErrors()){
            model.addAttribute("title","Add House");

            return("house/add");
        }
        HouseListData.add(newHouseList);
        return "redirect:";
    }
    @GetMapping("delete")
    public String displayDeleteHouseListForm(Model model){
        model.addAttribute("title","Delete Events");
        model.addAttribute("houseLists",HouseListData.getALL());
        return "house/delete";
    }
    @PostMapping("delete")
    public String deleteHouseListings(@RequestParam(required = false) int[] houseIds){
        if(houseIds!=null) {
            for (int id : houseIds) {
                HouseListData.remove(id);
            }
        }


        return "redirect:";
    }

    @GetMapping("update")
    public String displayUpdateForm(Model model){
        //HouseList housetoEdit=HouseListData.getById(houseId);
        model.addAttribute("title","Update House");
        model.addAttribute("houseLists",HouseListData.getALL());
        //String title="Update House"+housetoEdit.getHouseDescription()+"(id="+housetoEdit.getId()+")";
        //model.addAttribute("title",title);
        return "house/update";
    }

    @GetMapping("updateDetails")
    public String displayUpdateHouseDetailsForm(Model model,int houseId){
        model.addAttribute("title","Update House Details");
        HouseList houseToEdit=HouseListData.getById(houseId);
        model.addAttribute("houseList",houseToEdit);
        model.addAttribute("types", StatusType.values());
        return "house/updateDetails";
    }

    @PostMapping("updateDetails")
    public String processUpdateDetailsForm(int houseId,String houseDescription,String location,float price,StatusType status,String yearBuilt){
        HouseList houseListToEdit=HouseListData.getById(houseId);
        houseListToEdit.setLocation(location);
        houseListToEdit.setPrice(price);
        houseListToEdit.setStatus(status);
        houseListToEdit.setYearBuilt(yearBuilt);
        return "redirect:";
    }



}
