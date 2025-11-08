package tn.esprit.twin3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUser;

    String nom;

    String prenom;

    @Column (length=8)
    long cin;
    @Enumerated(EnumType.STRING)
    typeUser typeUser;

}
