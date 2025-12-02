package tn.esprit.twin3.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.entity.Reservation;
import tn.esprit.twin3.service.ReservationInterface;
import tn.esprit.twin3.service.ReservationService;

import java.util.List;

@RestController
public class ReservationRestController {
    ReservationInterface reservationInterface;
    public ReservationRestController(ReservationInterface reservationInterface) {this.reservationInterface = reservationInterface;}
    @PutMapping("/reservation")
    public Reservation updateReservation(@RequestBody Reservation res) {
        return reservationInterface.updateReservation(res);
    }
    @GetMapping("/reservation")
    public List<Reservation> getAllReservations() {
        return reservationInterface.retrieveAllReservation();
    }
    @GetMapping("/{id_reservation}")
    public Reservation getReservation(@RequestParam("id_reservation") long idReservation) {
        return reservationInterface.retrieveReservation(idReservation);
    }

}
