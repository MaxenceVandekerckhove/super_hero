package com.myproject.superhero.controllers;

import com.myproject.superhero.models.Hero;
import com.myproject.superhero.models.Incidents;
import com.myproject.superhero.repository.HeroRepository;
import com.myproject.superhero.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MapController {

    @Autowired
    HeroRepository _heroRepository;
    @Autowired
    IncidentRepository _incidentRepository;

    @RequestMapping("/map")
    public String showMapPage(Model model) {
        List<Hero> heroes = (List<Hero>) _heroRepository.findAll();
        model.addAttribute("heroes",heroes);
        return "map.html";
    }

    @GetMapping("/create_map")
    public String formIncident(Model model) {
        Incidents incident = new Incidents();
        String incidentDesignation = incident.getDesignation();
        model.addAttribute("incident", incidentDesignation);

        // Display All Incidents
        List<Incidents> incidents = (List<Incidents>) _incidentRepository.findAll();
        model.addAttribute("incidents",incidents);
        return "create_map.html";
    }

    @PostMapping("/submitIncident")
    public String submitIncident(Model model, Integer chosenIncidentId, String incidentLatitude, String incidentLongitude) {

        // Check if we get the Lat/Long

        System.out.println(incidentLatitude + " " + incidentLongitude);
        model.addAttribute("incidentLatitude", incidentLatitude);
        model.addAttribute("incidentLongitude", incidentLongitude);

        // Getting the Incident chosen by ID of the checkbox.
        Incidents chosenIncident = _incidentRepository.getById(chosenIncidentId);
        System.out.println(chosenIncident);

        // Getting Heroes linked to Incident into a List
        List<Hero> heroesThatCanDoThisIncident = chosenIncident.getHeroes();
        System.out.println(heroesThatCanDoThisIncident.toString());

        // Sending Heroes in Map
        List<Hero> heroes = (List<Hero>) heroesThatCanDoThisIncident;
        System.out.println(heroes);
        model.addAttribute("heroes",heroesThatCanDoThisIncident);

        return ("/map");
    }
}
