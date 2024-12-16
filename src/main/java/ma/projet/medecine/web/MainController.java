package ma.projet.medecine.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.projet.medecine.entities.Malade;
import ma.projet.medecine.entities.Medecin;

@Controller
public class MainController {

    @Autowired
    private MaladeRestService maladeService;

    @Autowired
    private MdecinRestService medecinService;

    @GetMapping("/accueil")
    public String accueil(Model model) {
        model.addAttribute("patients", maladeService.getAllMalades());
        return "Accueil";
    }


    @GetMapping("/ajouter-patient")
    public String afficherFormulaireAjoutMalade(Model model) {
        model.addAttribute("medecins", medecinService.getAllMedecins()); 
        return "AjouterMalade"; 
    }


    @PostMapping("/ajouter-patient")
    public String ajouterMalade(@ModelAttribute Malade malade) {
        maladeService.addMalade(malade); 
        return "redirect:/accueil"; 
    }

    @GetMapping("/ajouter-medecin")
    public String ajouterMedecinForm() {
        return "AjouterMedecin"; 
    }

    @PostMapping("/ajouter-medecin")
    public String ajouterMedecin(@ModelAttribute Medecin medecin) {
        medecinService.addMedecin(medecin);
        return "redirect:/accueil";
    }

    @GetMapping("/chercher-malade")
    public String chercherMalade(@RequestParam(name = "nom", required = false) String nom, Model model) {
        if (nom != null && !nom.isEmpty()) {
            model.addAttribute("malades", maladeService.searchMaladeByName(nom));
        } else {
            model.addAttribute("malades", List.of()); 
        }
        return "ChercherPatient";
    }


    @GetMapping("/logout-success")
    public String logout() {
        return "redirect:/login"; 
    }
}
