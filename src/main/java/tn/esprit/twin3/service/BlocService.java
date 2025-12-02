package tn.esprit.twin3.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tn.esprit.twin3.entity.Bloc;
import tn.esprit.twin3.entity.Chambre;
import tn.esprit.twin3.entity.Foyer;
import tn.esprit.twin3.entity.Universite;
import tn.esprit.twin3.repository.BlocRepository;
import tn.esprit.twin3.repository.ChambreRepository;
import tn.esprit.twin3.repository.UniversiteRepository;

import java.util.List;

@Service
public class BlocService implements BlocInterface {

    private final BlocRepository blocRepository;
    private final ChambreRepository chambreRepository;

        public BlocService(BlocRepository blocRepository, ChambreRepository chambreRepository) {
            this.blocRepository = blocRepository;
            this.chambreRepository= chambreRepository;
        }

    @Override
    public Bloc addBloc(Bloc bloc) {

        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {

        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(Long idBloc) {

        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc viewBloc(Long idBloc) {
        return blocRepository.findById(idBloc).get();

    }

    @Override
    public List<Bloc> viewAllBloc() {
        return blocRepository.findAll();
    }
    @Override
    public Bloc viewBlocByNom(String nomBloc) {
        return blocRepository.findByNomBloc(nomBloc);
    }
    @Override
    public List <Bloc> viewBlocByFoyer(String nomFoyer) {
        return blocRepository.findByFoyerNomFoyer(nomFoyer);
    }
    @Override
    @Transactional
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
            Bloc bloc = blocRepository.findById(idBloc).orElseThrow();
            List<Chambre> chambres = chambreRepository.findChambreByNum(numChambre);
            for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
        }
        bloc.getChambres().addAll(chambres);

        return bloc;
    }

}
