package com.myproject.superhero;


import com.myproject.superhero.models.Hero;
import com.myproject.superhero.models.Incidents;
import com.myproject.superhero.repository.HeroRepository;
import com.myproject.superhero.repository.IncidentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class DataRepositoryTest {
    @Autowired
    private HeroRepository heroRepository;
    @Autowired
    private IncidentRepository incidentRepository;

    @Test
    public void TestMethod() {

        // Creating Heroes

        Hero superman = new Hero();
        superman.setNickname("SuperMan");
        superman.setPhone_number("0601020304");
        superman.setAddress("405 Arthur Kill Rd");
        superman.setPostal_code("NY 10308");
        superman.setTown("Staten Island");
        superman.setCountry("United States");

        Hero spiderman = new Hero();
        spiderman.setNickname("SpiderMan");
        spiderman.setPhone_number("0602030405");
        spiderman.setAddress("71 Barlow Ave");
        spiderman.setPostal_code("NY 10308");
        spiderman.setTown("Staten Island");
        spiderman.setCountry("United States");

        Hero supermario = new Hero();
        supermario.setNickname("SuperMario");
        supermario.setPhone_number("0603040506");
        supermario.setAddress("2nd St");
        supermario.setPostal_code("NY 10308");
        supermario.setTown("Staten Island");
        supermario.setCountry("United States");

        // Creating Incidents

        Incidents incendie = new Incidents();
        incendie.setDesignation("Incendie");

        Incidents accidentRoutier = new Incidents();
        accidentRoutier.setDesignation("Accident Routier");

        Incidents accidentFluvial = new Incidents();
        accidentFluvial.setDesignation("Accident Fluvial");

        Incidents accidentAerien = new Incidents();
        accidentAerien.setDesignation("Accident Aerien");

        Incidents eboulement = new Incidents();
        eboulement.setDesignation("Eboulement");

        Incidents invasionDeSerpents = new Incidents();
        invasionDeSerpents.setDesignation("Invasion de Serpents");

        Incidents fuideDeGaz = new Incidents();
        fuideDeGaz.setDesignation("Fuite de Gaz");

        Incidents manifestation = new Incidents();
        manifestation.setDesignation("Manifestation");

        Incidents braquage = new Incidents();
        braquage.setDesignation("Braquage");

        Incidents evasiondUnPrisonier = new Incidents();
        evasiondUnPrisonier.setDesignation("Evasion d'Un Prisonier");

        // Putting Heroes & Incidents Together with a List for each Hero

        List<Incidents> incidentsListSpiderman = new ArrayList<>();
        incidentsListSpiderman.add(incendie);
        incidentsListSpiderman.add(accidentRoutier);
        incidentsListSpiderman.add(accidentFluvial);

        spiderman.setRealisableIncidents(incidentsListSpiderman);

        List<Incidents> incidentsListSuperMan = new ArrayList<>();
        incidentsListSuperMan.add(incendie);

        superman.setRealisableIncidents(incidentsListSuperMan);

        List<Incidents> incidentsListSuperMario = new ArrayList<>();
        incidentsListSuperMario.add(accidentFluvial);

        supermario.setRealisableIncidents(incidentsListSuperMario);

        // Saving Incidents

        List<Incidents> savedIncidents = new ArrayList<>();
        savedIncidents.add(incendie);
        savedIncidents.add(accidentRoutier);
        savedIncidents.add(accidentFluvial);
        savedIncidents.add(accidentAerien);
        savedIncidents.add(eboulement);
        savedIncidents.add(invasionDeSerpents);
        savedIncidents.add(fuideDeGaz);
        savedIncidents.add(manifestation);
        savedIncidents.add(braquage);
        savedIncidents.add(evasiondUnPrisonier);

        incidentRepository.saveAll(savedIncidents);

        // Saving Heroes

        List<Hero> savedHeroes = new ArrayList<>();
        savedHeroes.add(spiderman);
        savedHeroes.add(superman);
        savedHeroes.add(supermario);

        heroRepository.saveAll(savedHeroes);
    }
}
