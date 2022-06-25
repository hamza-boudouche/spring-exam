package com.example.prepaexam.Controllers;

import com.example.prepaexam.Models.Utilisateur;
import com.example.prepaexam.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/utilisateurs")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public String getAll(Model model){
        List<Utilisateur> users = utilisateurService.getAll();
        users.stream().forEach(u -> System.out.println(u));
        model.addAttribute("utilisateurs", users);
        return "utilisateurs";
    }

    @GetMapping("/add")
    public String addUtilisateur(Model model){
        Utilisateur utilisateur = new Utilisateur();
        model.addAttribute("utilisateur", utilisateur);
        return "addUtilisateur";
    }

    @PostMapping("/add")
    public String addedUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur){
        System.out.println(utilisateur);
        utilisateurService.saveUtilisateur(utilisateur);
        return "redirect:/utilisateurs";
    }

    @GetMapping("/info/{id}")
    public String getUtilisateur(@PathVariable(name = "id") Long id, Model model){
        Utilisateur utilisateur = utilisateurService.getById(id);
        model.addAttribute("utilisateur", utilisateur);
        return "utilisateurInfo";
    }

    @PostMapping("/delete/{id}")
    public String deleteUtilisateur(@PathVariable(name = "id") Long id){
        utilisateurService.deleteUtilisateur(id);
        return "redirect:/utilisateurs";
    }
}
