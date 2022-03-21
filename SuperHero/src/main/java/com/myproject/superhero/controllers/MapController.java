package com.myproject.superhero.controllers;

import com.myproject.superhero.models.Hero;
import com.myproject.superhero.models.Incidents;
import com.myproject.superhero.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MapController {

    @Autowired
    HeroRepository _heroRepository;

    @RequestMapping("/map")
    public String showMapPage(Model model) {
        List<Hero> heroes = (List<Hero>) _heroRepository.findAll();
        model.addAttribute("heroes",heroes);
        return "map.html";
    }
}
