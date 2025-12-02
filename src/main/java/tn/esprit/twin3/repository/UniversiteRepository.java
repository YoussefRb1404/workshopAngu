package tn.esprit.twin3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.twin3.entity.Universite;
@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {
    Universite findUniversiteByNomUniversite(String nomUniversite);

}
