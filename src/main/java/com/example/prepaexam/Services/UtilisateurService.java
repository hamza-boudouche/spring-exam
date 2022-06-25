package com.example.prepaexam.Services;

import com.example.prepaexam.Models.Utilisateur;
import com.example.prepaexam.Repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAll() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getById(Long id) {
        return utilisateurRepository.findById(id).get();
    }

    public Utilisateur saveUtilisateur(Utilisateur u) {
        return utilisateurRepository.save(u);
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
