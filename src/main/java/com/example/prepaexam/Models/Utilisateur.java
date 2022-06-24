package com.example.prepaexam.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @ManyToMany(mappedBy = "utilisateurs")
    private List<Blog> blogs = new ArrayList<>();

    public Utilisateur() {
    }

    public Utilisateur(String email, String nom, String prenom, UserRole role) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }

    public boolean add(Blog blog) {
        blog.addUtilisateur(this);
        return blogs.add(blog);
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void commenter(Billet b, Commentaire c){
        b.addCommentaire(c);
    }

    public void redigerArticle(){

    }

    public void validerArticle(Billet b){
        b.setStatus(BilletStatus.VALIDEE);
    }

    public void supprimerCommentaire(){

    }

    public void publicArticle(Billet b){
        b.setStatus(BilletStatus.PUBLIEE);
    }
}
