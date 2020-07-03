package com.roderick.playground.repo;

import com.roderick.playground.model.Champion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ChampionRepository extends MongoRepository<Champion, String> {
    public Champion findByChampName(String champName);
    public List<Champion> findByRole(String role);
  //  public String findPhrase(String champName); // does this work?
   // public List<String> listCounterTo(String name);
   // public List<String> listCounteredBy(String name);


}
