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
public class PlaygroundApplication  implements CommandLineRunner {
	@Autowired ChampionRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(PlaygroundApplication.class, args);
	}
	@Override
	public void run (String...args) throws Exception{
		long t =  System.currentTimeMillis();
		long end = t+15000;

			repo.deleteAll();

			repo.save(new Champion("Senna", "Support", new ArrayList<String>(Arrays.asList("marksman")), "No one dies alone in the mist",
					new ArrayList<String>(Arrays.asList("Braum", "Rakan")), new ArrayList<String>(Arrays.asList("Lulu", "Thresh", "Yuumi"))));
			System.out.println(repo.findByChampName("Senna"));

		System.out.println("\nyay it works! Now time to close");
		System.exit(0);
	}

}
