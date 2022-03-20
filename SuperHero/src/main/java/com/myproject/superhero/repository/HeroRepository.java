package com.myproject.superhero.repository;

import com.myproject.superhero.models.Hero;
import com.myproject.superhero.models.Incidents;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeroRepository extends CrudRepository<Hero, Integer> {
    List<Hero> findByNickname(String nickname);
}
