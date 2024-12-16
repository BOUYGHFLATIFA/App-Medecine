package ma.projet.medecine.repositories;



import ma.projet.medecine.entities.Malade;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MaladeRepository extends JpaRepository<Malade, Long> {
    List<Malade> findByNomContaining(String nom);

	List<Malade> findByNomContainingIgnoreCase(String nom);
}
