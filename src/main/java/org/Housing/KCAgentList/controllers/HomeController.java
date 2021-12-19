package org.Housing.KCAgentList.controllers;

import org.Housing.KCAgentList.data.HouseListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired
    private HouseListRepository houseListRepository;

    @GetMapping("/view")
    public String displayAllListings(Model model){
        model.addAttribute("title","All Listings");
        model.addAttribute("houseLists", houseListRepository.findAll());
        return "view";
    }

    @GetMapping()
    public String index(){
        return "index";
    }




}
