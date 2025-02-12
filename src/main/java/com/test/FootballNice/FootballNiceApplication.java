package com.test.FootballNice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.test.FootballNice.repositories.EquipeRepository;
import com.test.FootballNice.repositories.JoueurRepository;
import com.test.FootballNice.entities.Joueur;
import com.test.FootballNice.entities.Equipe;

@SpringBootApplication
public class FootballNiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballNiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(EquipeRepository equipeRepository, JoueurRepository joueurRepository) {
        return (args) -> {
            // Creating and saving Equipe data
            Equipe nice = new Equipe();
            nice.setName("OGC Nice");
            nice.setAcronym("OGCN");
            nice.setBudget(100000000.0); // 100 million
            Equipe lyon = new Equipe();
            lyon.setName("Lyon");
            lyon.setAcronym("L");
            lyon.setBudget(200000000.0);
            // Saving Equipe (team)
            equipeRepository.save(nice);
            equipeRepository.save(lyon);

            // Creating and saving Joueurs (players) for the team
            Joueur joueur1 = new Joueur();
            joueur1.setName("Dante");
            joueur1.setPosition("Defender");

            Joueur joueur2 = new Joueur();
            joueur2.setName("Amine ");
            joueur2.setPosition("Forward");

            Joueur joueur3 = new Joueur();
            joueur3.setName("Kasper ");
            joueur3.setPosition("Goalkeeper");

            nice.getJoueurs().add(joueur1); // Assuming Equipe has a list of Joueurs
            nice.getJoueurs().add(joueur2);
            nice.getJoueurs().add(joueur3);
            joueur1.setEquipe(nice); // If bi-directional relationship

            // Saving Joueurs
            joueurRepository.save(joueur1);
            joueurRepository.save(joueur2);
            joueurRepository.save(joueur3);

        };
    }
}
