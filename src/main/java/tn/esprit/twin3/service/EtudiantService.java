package tn.esprit.twin3.service;

import tn.esprit.twin3.entity.Etudiant;
import tn.esprit.twin3.repository.EtudiantRepository;
import java.util.List;

public class EtudiantService implements EtudiantInterface {
    private EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }
    @Override
    public List<Etudiant> addEtudiants (List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }
    @Override
    public Etudiant updateEtudiant (Etudiant e){
        return etudiantRepository.save(e);
    }
    @Override
    public Etudiant retrieveEtudiant(long idEtudiant){
        return etudiantRepository.findById(idEtudiant).get();
    }
    @Override
    public void removeEtudiant(long idEtudiant){
        etudiantRepository.deleteById(idEtudiant);
    }
    @Override
    public List<Etudiant> retrieveAllEtudiants(){
        return etudiantRepository.findAll();
    }
}
