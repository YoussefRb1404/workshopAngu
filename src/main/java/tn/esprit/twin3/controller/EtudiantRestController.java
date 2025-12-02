package tn.esprit.twin3.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.entity.Etudiant;
import tn.esprit.twin3.service.EtudiantInterface;


import java.util.List;

@RestController
public class EtudiantRestController {
    EtudiantInterface etudiantInterface;

   public EtudiantRestController(EtudiantInterface etudiantInterface){this.etudiantInterface = etudiantInterface;}

    @PostMapping("/etudiants/add-list")
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        return etudiantInterface.addEtudiants(etudiants);
    }

    @PutMapping("/etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantInterface.updateEtudiant(etudiant);
    }

    @DeleteMapping("/{id_Etudiant}")
    public void removeEtudiant(@PathVariable("id_Etudiant") long idEtudiant){
        etudiantInterface.removeEtudiant(idEtudiant);
    }
    @GetMapping("/etudiant")
    public List<Etudiant> getEtudiants() {
        return etudiantInterface.retrieveAllEtudiants();
    }
    @GetMapping("/etudiant/id_etudiant")
    public Etudiant getEtudiantById(@RequestParam("id_etudiant") long idEtudiant) {
        return etudiantInterface.retrieveEtudiant(idEtudiant);
    }
}