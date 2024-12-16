package ma.projet.medecine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.medecine.entities.Medecin;

public interface MedicinRepository extends JpaRepository<Medecin, Long> {
}
