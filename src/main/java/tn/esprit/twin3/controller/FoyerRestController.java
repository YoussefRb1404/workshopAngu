package tn.esprit.twin3.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.entity.Foyer;
import tn.esprit.twin3.service.FoyerInterface;

import java.util.List;

@RestController
public class FoyerRestController {
    FoyerInterface foyerInterface;

    public FoyerRestController(FoyerInterface foyerInterface) {
        this.foyerInterface = foyerInterface;
    }

    @PostMapping(path = "/foyer")
    Foyer addFoyer(@RequestBody Foyer f) {
        return foyerInterface.addFoyer(f);
    }

    @PutMapping(path = "/foyer")
    Foyer updateFoyer(@RequestBody Foyer f) {
        return foyerInterface.updateFoyer(f);
    }
    @DeleteMapping(path = "/{id_foyer}")
    void removeFoyer(@PathVariable ("id_foyer") Long idFoyer) {
        foyerInterface.removeFoyer(idFoyer);
    }
    @GetMapping(path = "/{id_foyer}")
    Foyer retrieveBloc(@PathVariable ("id_foyer") Long idFoyer) {
        return foyerInterface.retrieveFoyer(idFoyer);
    }
    @GetMapping(path = "/foyer")
    List<Foyer> retrieveAllFoyers() {
        return foyerInterface.retrieveAllFoyers();
    }
    @PostMapping("/{id_universite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable("id_universite") Long idUniversite) {
        return foyerInterface.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }
}