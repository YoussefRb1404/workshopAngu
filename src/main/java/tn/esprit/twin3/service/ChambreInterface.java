package tn.esprit.twin3.service;

import tn.esprit.twin3.entity.Chambre;

import java.util.List;

public interface ChambreInterface {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre (Chambre c);
    Chambre retrieveChambre (long idChambre);
}
