package ma.projet.medecine.entities;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Malade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String dateNaissance;
    private String etat;
    private int score;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecinTraitant;
}
