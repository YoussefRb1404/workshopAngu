package tn.esprit.twin3.service;

import org.springframework.stereotype.Service;
import tn.esprit.twin3.entity.Bloc;
import tn.esprit.twin3.entity.Foyer;
import tn.esprit.twin3.entity.Universite;
import tn.esprit.twin3.repository.BlocRepository;
import tn.esprit.twin3.repository.FoyerRepository;
import tn.esprit.twin3.repository.UniversiteRepository;

import java.util.List;

@Service
public class FoyerService implements FoyerInterface {
    private final FoyerRepository foyerRepository;
    private final UniversiteRepository universiteRepository;

    public FoyerService(FoyerRepository foyerRepository, UniversiteRepository universiteRepository) {
        this.foyerRepository = foyerRepository;
        this.universiteRepository = universiteRepository;
    }
    @Override
    public Foyer addFoyer(Foyer f) {

        return foyerRepository.save(f);
    }
    @Override
    public Foyer updateFoyer(Foyer f) {

        return foyerRepository.save(f);
    }
    @Override
    public void removeFoyer (long idFoyer) {

        foyerRepository.deleteById(idFoyer);
    }
    @Override
    public Foyer retrieveFoyer (long idFoyer) {
        return foyerRepository.findById(idFoyer).get();

    }
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }
    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {

        Universite universite = universiteRepository.findById(idUniversite).orElseThrow();
        foyer.setUniversite(universite);
        Foyer savedFoyer = foyerRepository.save(foyer);
        universite.setFoyer(savedFoyer);
        universiteRepository.save(universite);
        return savedFoyer;
    }
}
