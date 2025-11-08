package tn.esprit.twin3.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.twin3.entity.Bloc;
import tn.esprit.twin3.repository.BlocRepository;

import java.util.List;

@Service
public class BlocService implements BlocInterface {

    private final BlocRepository blocRepository;

    public BlocService(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
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
}
