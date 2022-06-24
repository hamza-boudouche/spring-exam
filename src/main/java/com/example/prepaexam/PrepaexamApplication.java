package com.example.prepaexam;

import com.example.prepaexam.Models.*;
import com.example.prepaexam.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class PrepaexamApplication {

    @Autowired
    private AdministrateurRepository administrateurRepository;
    @Autowired
    private BilletRepository billetRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private CommentaireRepository commentaireRepository;
    @Autowired
    private ContenuRepository contenuRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public static void main(String[] args) {
        SpringApplication.run(PrepaexamApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("hello world");
            // testing the models and repositories
            Blog b = new Blog("blog 1");
            blogRepository.save(b);
            Utilisateur u = new Utilisateur("email", "nom", "prenom", UserRole.UTILISATEUR);
            u.add(b);
            utilisateurRepository.save(u);
            blogRepository.save(b);
            Administrateur a = new Administrateur("email", "nom", "prenom", UserRole.MANAGER, b);
            administrateurRepository.save(a);
            Billet billet = new Billet("titre", "contenu", u, 1L, BilletStatus.CREE, LocalDate.now(), b);
            billetRepository.save(billet);
            Commentaire c = new Commentaire("titre", "contenu", u, billet);
            commentaireRepository.save(c);
        };
    }
}
