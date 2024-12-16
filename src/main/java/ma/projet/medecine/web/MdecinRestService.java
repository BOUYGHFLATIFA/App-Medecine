package ma.projet.medecine.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.medecine.entities.Medecin;
import ma.projet.medecine.repositories.MedicinRepository;

import java.util.List;

@Service
public class MdecinRestService {

    @Autowired
    private MedicinRepository medecinRepository;

    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }

    public Medecin addMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }
    
}
