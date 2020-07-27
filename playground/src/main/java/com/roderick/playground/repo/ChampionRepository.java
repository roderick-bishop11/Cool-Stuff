package com.roderick.playground.repo;

import com.roderick.playground.model.Champion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ChampionRepository extends MongoRepository<Champion, String> {
    public Champion findByChampName(String champName);
    public List<Champion> findByRole(String role);
   @Query(value="{ 'champName' : ?0 }",fields="{ 'phrase' : 1, 'id' : 0}") //this runs a query that uses value to look up and will return only the fields set to 1
    public String getPhrase(String champName); // a method like this that would return the phrase would be in the controller/consumer
    public List<Champion> findByType(String type);
  //  public List<String> findCounterTo(String name);
 //   public List<String> findCounteredBy(String name);



}
