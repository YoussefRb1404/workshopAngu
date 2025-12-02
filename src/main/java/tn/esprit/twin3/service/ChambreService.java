package tn.esprit.twin3.service;

import org.springframework.stereotype.Service;
import tn.esprit.twin3.entity.Chambre;
import tn.esprit.twin3.repository.ChambreRepository;

import java.util.List;

@Service
public class ChambreService implements ChambreInterface {
    private ChambreRepository chambreRepository;
    public ChambreService(ChambreRepository chambreRepository) {this.chambreRepository = chambreRepository;}
    @Override
    public Chambre addChambre(Chambre c){
        return chambreRepository.save(c);
    }
    @Override
    public Chambre updateChambre (Chambre c){
        return chambreRepository.save(c);
    }
    @Override
    public Chambre retrieveChambre (long idChambre){
        return chambreRepository.findById(idChambre).get();
    }
    @Override
    public List<Chambre> retrieveAllChambres(){
        return chambreRepository.findAll();
    }
}
