package com.roderick.playground;

import com.roderick.playground.model.Champion;
import com.roderick.playground.repo.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@SpringBootApplication
public class PlaygroundApplication implements CommandLineRunner {
    @Autowired
    ChampionRepository repo; //could also use @EnableMongoRepository

    public static void main(String[] args) {
        SpringApplication.run(PlaygroundApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        long t = System.currentTimeMillis();
        long end = t + 15000;

        repo.deleteAll();
//String champName, String role, String type, String phrase, List<String> counterTo, List<String> counteredBy
		//"Cho'Gath", "Shen", "Yorick"
        repo.save(new Champion("Senna", "Support", "Marksman", "No one dies alone in the mist",
                new ArrayList<String>(Arrays.asList("Braum", "Rakan")), new ArrayList<String>(Arrays.asList("Lulu", "Thresh", "Yuumi"))));
        repo.save(new Champion("Lucian", "AD Carry", "Marksman", "Everybody dies. Some jsut need a little help",
                new ArrayList<String>(Arrays.asList("Tristana", "Vayne", "Caitlyn")), new ArrayList<String>(Arrays.asList("Jhin", "Kog'Maw", "Ashe"))));
        repo.save(new Champion("Malphite", "Top", "Tank", "Rock Solid",
                new ArrayList<String>(Arrays.asList("Gnar", "Jax", "Fiora")), new ArrayList<String>(Arrays.asList("Cho'Gath", "Shen", "Yorick"))));
        repo.save(new Champion("Hecarim", "=Jungle", "Fighter", "No one dies alone in the mist",
                new ArrayList<String>(Arrays.asList("Lee Sin", "Graves", "Ekko")), new ArrayList<String>(Arrays.asList("Trundle", "Shyvana", "Volibear"))));
        repo.save(new Champion("Veigar", "Mid", "Mage", "But if the tables were turned, I would show you NO MERCY",
                new ArrayList<String>(Arrays.asList("Yasuo", "Fizz")), new ArrayList<String>(Arrays.asList("Ryze", "Anivia"))));

        //this is some slick trick I just learned. the "::" indicates that I'll be invoking the method after with an argument of the type returned by the findAll() method
        repo.findAll().forEach(System.out::println);
        System.out.println("=================================================================");
        System.out.println("Finding the phrase for Malphite using get phrase query method\n"+repo.getPhrase("Malphite")); // this still prints id, even though I just want phrase
        System.out.println("\nFinding the phrase for Malphite using getPhrase: \n"+repo.findByChampName("Malphite").getPhrase()); // this still prints id, even though I just want phrase
		System.out.println("=================================================================\nfinding by type \"Marksman\"");
		repo.findByType("Marksman").forEach(System.out::println);
    }

}
