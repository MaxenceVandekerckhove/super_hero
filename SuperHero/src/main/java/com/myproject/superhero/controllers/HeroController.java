package com.myproject.superhero.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.myproject.superhero.models.Hero;
import com.myproject.superhero.models.Incidents;
import com.myproject.superhero.repository.HeroRepository;
import com.myproject.superhero.repository.IncidentRepository;
import net.minidev.json.JSONObject;
import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import javax.swing.text.html.parser.Entity;
import java.util.Arrays;
import java.util.List;

@Controller
public class HeroController {

    @Autowired
    HeroRepository _heroRepository;
    @Autowired
    IncidentRepository _incidentRepository;

    @RequestMapping("/heroes")
    public String getHeroes(Model model) {
        List<Hero> heroes = (List<Hero>) _heroRepository.findAll();
        model.addAttribute("heroes",heroes);
        return ("heroes");
    }

    @GetMapping("/create_hero")
    public String formHero(Model model) {
        Hero hero = new Hero();
        model.addAttribute("hero", hero);
        List<Incidents> incidents = (List<Incidents>) _incidentRepository.findAll();
        model.addAttribute("incidents",incidents);
        return "create_hero";
    }

    @PostMapping("/submit")
    public RedirectView submitHero(@ModelAttribute Hero hero, Model model) {
        _heroRepository.save(hero);
        return new RedirectView("heroes");
    }
}