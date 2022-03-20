package com.myproject.superhero.repository;

import com.myproject.superhero.models.Incidents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incidents, Integer> {
}
