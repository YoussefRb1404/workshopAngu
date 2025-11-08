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
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long idReservation;
    LocalDate date;
    boolean estValide;
    @ManyToMany(mappedBy = "reservations")
    Set<Etudiant> etudiants;

}
