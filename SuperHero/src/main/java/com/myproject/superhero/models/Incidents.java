package com.myproject.superhero.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "incidents")
public class Incidents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String designation;

    @ManyToMany( mappedBy = "realisableIncidents")
    private List<Hero> heroes;

    public Incidents() {

    }

    //Methods for Id, designation...

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    // Method for ToString

    @Override
    public String toString() {
        return this.designation;
    }
}
