package tn.esprit.twin3.service;

import org.springframework.stereotype.Service;
import tn.esprit.twin3.entity.Foyer;
import tn.esprit.twin3.entity.Universite;
import tn.esprit.twin3.repository.FoyerRepository;
import tn.esprit.twin3.repository.UniversiteRepository;

import java.util.List;

@Service
public class UniversiteService implements UniversiteInterface {
    FoyerRepository foyerRepository;
    UniversiteRepository universiteRepository;
    public UniversiteService(FoyerRepository foyerRepository, UniversiteRepository universiteRepository) {
        this.foyerRepository = foyerRepository;
        this.universiteRepository = universiteRepository;

    }
    @Override
    public Universite affecterFoyerAUniversite(Long idFoyer,String nomUniversite) {
        Universite universite = universiteRepository.findUniversiteByNomUniversite(nomUniversite);
        Foyer foyer =foyerRepository.findById(idFoyer).orElseThrow(null);
        universite.setFoyer(foyer);
        return universiteRepository.save(universite);
    }
    @Override
    public Universite desaffecterFoyerAUniversite(Long idUniversite){
        Universite universite = universiteRepository.findById(idUniversite).orElseThrow(null);
        universite.setFoyer(null);
        return universiteRepository.save(universite);
    }
    @Override
    public Universite addUniversite (Universite u){
        return universiteRepository.save(u);
    }
    @Override
    public Universite updateUniversite (Universite u){
        return universiteRepository.save(u);
    }
    @Override
    public  Universite retrieveUniversite (long idUniversite){
        return universiteRepository.findById(idUniversite).get();
    }
    @Override
    public List<Universite> retrieveAllUniversities(){
        return universiteRepository.findAll();
    }


}
