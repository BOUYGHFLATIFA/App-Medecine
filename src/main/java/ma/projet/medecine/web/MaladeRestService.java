package ma.projet.medecine.web;


import ma.projet.medecine.entities.Malade;
import ma.projet.medecine.repositories.MaladeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaladeRestService {

    @Autowired
    private MaladeRepository maladeRepository;

    public List<Malade> getAllMalades() {
        return maladeRepository.findAll();
    }

    public Malade addMalade(Malade malade) {
        return maladeRepository.save(malade);
    }

    public List<Malade> searchMaladeByName(String nom) {
        return maladeRepository.findByNomContainingIgnoreCase(nom);
    }
}
