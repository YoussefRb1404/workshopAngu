package tn.esprit.twin3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEtudiant;

    String nomEt;

    String prenomEt;

    @Column (length=8)
    long cin;
    String ecole;
    LocalDate dateNaissance;
    @ManyToMany
    Set <Reservation> reservations;


}
