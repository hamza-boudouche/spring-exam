package com.example.prepaexam.Models;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Contenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String contenu;
    @ManyToOne
    @JoinColumn(
            name = "utilisateur_id"
    )
    private Utilisateur utilisateur;

    public Contenu() {
    }

    public Contenu(String titre, String contenu, Utilisateur utilisateur) {
        this.titre = titre;
        this.contenu = contenu;
        this.utilisateur = utilisateur;
    }
}
