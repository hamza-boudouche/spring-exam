package com.example.prepaexam.Models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commentaire extends Contenu{
    @ManyToOne
    @JoinColumn(
            name = "billet_id"
    )
    private Billet billet;

    public Commentaire() {
    }

    public Commentaire(String titre, String contenu, Utilisateur utilisateur, Billet billet) {
        super(titre, contenu, utilisateur);
        this.billet = billet;
    }
}
