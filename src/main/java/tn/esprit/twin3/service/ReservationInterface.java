package tn.esprit.twin3.service;

import tn.esprit.twin3.entity.Reservation;

import java.util.List;

public interface ReservationInterface {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (Long idReservation);
    Reservation ajouterReservation(long idBloc, long cinEtudiant);
}
