package tn.esprit.twin3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.twin3.entity.Etudiant;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findBycin(String cinEtud);
}
