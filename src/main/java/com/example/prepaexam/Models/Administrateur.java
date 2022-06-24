package com.example.prepaexam.Models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Administrateur extends Utilisateur{
    @ManyToOne
    @JoinColumn(
            name = "blog_id"
    )
    private Blog blog;

    public Administrateur() {
        super();
    }

    public Administrateur(String email, String nom, String prenom, UserRole role, Blog b) {
        super(email, nom, prenom, role);
        this.blog = b;
    }

    public void attribuerRole(UserRole r, Utilisateur u){
        u.setRole(r);
    }
}
