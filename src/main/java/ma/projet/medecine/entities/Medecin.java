package ma.projet.medecine.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String specialite;
    private String telephone;
    
    @OneToMany(mappedBy = "medecinTraitant", cascade = CascadeType.ALL)
    private List<Malade> malades;
}