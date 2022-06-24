package com.example.prepaexam.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blog")
    private List<Billet> billets = new ArrayList<>();
    @ManyToMany
    @JoinTable(
        name = "blog_utilisateur",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Utilisateur> utilisateurs = new ArrayList<>();

    public Blog() {
    }

    public boolean addUtilisateur(Utilisateur utilisateur) {
        return utilisateurs.add(utilisateur);
    }

    public boolean addBillet(Billet billet) {
        return billets.add(billet);
    }

    public Blog(String nom) {
        this.nom = nom;
    }
}
