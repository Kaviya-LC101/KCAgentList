package org.Housing.KCAgentList.controllers;

import org.Housing.KCAgentList.data.HouseListData;
import org.Housing.KCAgentList.models.HouseList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "house/add";
    }

    @PostMapping("add")
    public String addListings(@ModelAttribute HouseList newHouseList){
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

}
