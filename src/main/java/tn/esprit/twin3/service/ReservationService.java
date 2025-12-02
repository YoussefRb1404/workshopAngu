package tn.esprit.twin3.service;

import org.springframework.stereotype.Service;
import tn.esprit.twin3.entity.Etudiant;
import tn.esprit.twin3.entity.Reservation;
import tn.esprit.twin3.repository.BlocRepository;
import tn.esprit.twin3.repository.ChambreRepository;
import tn.esprit.twin3.repository.EtudiantRepository;
import tn.esprit.twin3.repository.ReservationRepository;

import java.util.List;

@Service
public class ReservationService implements ReservationInterface{
    private ReservationRepository reservationRepository;
    private EtudiantRepository etudiantRepository;
    private BlocRepository blocRepository;
    private ChambreRepository chambreRepository;
    public ReservationService(ReservationRepository reservationRepository,EtudiantRepository etudiantRepository,BlocRepository blocRepository,ChambreRepository chambreRepository)
    {
        this.reservationRepository = reservationRepository;
        this.etudiantRepository = etudiantRepository;
        this.blocRepository = blocRepository;
        this.chambreRepository = chambreRepository;

    }
    @Override
    public Reservation updateReservation (Reservation res){
        return reservationRepository.save(res);
    }
    @Override
    public Reservation retrieveReservation (Long idReservation){
        return reservationRepository.findById(idReservation).get();
    }
    @Override
    public List<Reservation> retrieveAllReservation(){
        return reservationRepository.findAll();
    }
    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {

        // 1. Récupérer l'étudiant
        Etudiant etudiant = etudiantRepository.findBycin(cinEtudiant)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));

        // 2. Vérifier Bloc existe
        blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc introuvable"));

        // 3. Trouver une chambre libre dans ce bloc
        List<Chambre> chambresLibres = chambreRepository.findChambresLibres(idBloc);

        if (chambresLibres.isEmpty()) {
            throw new RuntimeException("Aucune chambre libre dans ce bloc");
        }

        Chambre chambreChoisie = chambresLibres.get(0); // prendre la première libre

        // 4. Créer la réservation
        Reservation reservation = new Reservation();
        reservation.setChambre(chambreChoisie);
        reservation.setEtudiant(etudiant);

        return reservationRepository.save(reservation);
    }
}
