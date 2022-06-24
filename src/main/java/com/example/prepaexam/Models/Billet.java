package com.example.prepaexam.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Billet extends Contenu{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long num;
    @Enumerated(EnumType.STRING)
    private BilletStatus status;
    public LocalDate date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billet")
    private List<Commentaire> commentaires = new ArrayList<>();
    @ManyToOne
    @JoinColumn(
            name = "blog_id"
    )
    private Blog blog;

    public Billet() {
    }

    public Billet(String titre, String contenu, Utilisateur utilisateur, Long num, BilletStatus status, LocalDate date, Blog blog) {
        super(titre, contenu, utilisateur);
        this.num = num;
        this.status = status;
        this.date = date;
        this.blog = blog;
        blog.addBillet(this);
    }

    public boolean addCommentaire(Commentaire c) {
        return commentaires.add(c);
    }

    public void setStatus(BilletStatus status) {
        this.status = status;
    }
}
