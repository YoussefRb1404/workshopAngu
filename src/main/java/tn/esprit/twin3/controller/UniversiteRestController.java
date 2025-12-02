package tn.esprit.twin3.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.entity.Universite;
import tn.esprit.twin3.service.UniversiteInterface;

import java.util.List;


@RestController
@RequestMapping("/universite")
public class UniversiteRestController {
    UniversiteInterface universiteInterface;
    public UniversiteRestController(UniversiteInterface universiteInterface) {
        this.universiteInterface = universiteInterface;
    }
    @PutMapping("/foyer/{id-foyer}/{nom-universite}")
    public Universite affacterFoyerAUniversite(@PathVariable("id-foyer") Long idFoyer,@PathVariable("nom-universite") String nomUniversite){
        return  universiteInterface.affecterFoyerAUniversite(idFoyer,nomUniversite);
    }
    @PutMapping("/foyer/{id-universite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable("id-universite") Long idUniversite){
        return universiteInterface.desaffecterFoyerAUniversite(idUniversite);
    }
    @PostMapping()
    public Universite creerUniversite(@RequestBody Universite universite){
        return universiteInterface.addUniversite(universite);
    }
    @PutMapping()
    public Universite updateUniversite(@RequestBody Universite universite){
        return universiteInterface.updateUniversite(universite);
    }
    @GetMapping
    public List<Universite> getAllUniversites(){
        return universiteInterface.retrieveAllUniversities();
    }
    @GetMapping ("{id-universite}")
    public Universite getUniversiteById(@PathVariable("id-universite") Long idUniversite){
        return universiteInterface.retrieveUniversite(idUniversite);
    }

}
