package tn.esprit.twin3.repository;

import org.springframework.data.repository.query.Param;
import tn.esprit.twin3.controller.BlocRestController;
import tn.esprit.twin3.entity.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import jakarta.persistence.*;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {
    @Query(value = "SELECT * FROM bloc WHERE nombloc = nom", nativeQuery = true)
    Bloc ByNomBloc(@Param("nom") String nom);
    @Query("SELECT b FROM Bloc b WHERE b.nomBloc = :nom")
    Bloc ByNomBloc2(@Param("nom") String nom);


    List<Bloc> findByFoyerNomFoyer(String nomFoyer);
    Bloc findByNomBloc(String nom);

}