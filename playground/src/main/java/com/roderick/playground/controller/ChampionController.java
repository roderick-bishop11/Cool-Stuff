package com.roderick.playground.controller;

import com.roderick.playground.model.Champion;
import com.roderick.playground.repo.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ChampionController {
    @Autowired
    ChampionRepository repo;

    @GetMapping("/getall")
    public List<Champion> getAll(){
        return repo.findAll();
    }

}
