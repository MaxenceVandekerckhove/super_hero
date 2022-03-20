package com.myproject.superhero.controllers;

import com.myproject.superhero.models.Hero;
import com.myproject.superhero.models.Incidents;
import com.myproject.superhero.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IncidentController {

    @Autowired
    IncidentRepository _incidentRepository;
}
