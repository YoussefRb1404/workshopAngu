package tn.esprit.twin3.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.entity.Chambre;
import tn.esprit.twin3.service.ChambreInterface;

import java.util.List;

@RestController
public class ChambreRestController {
ChambreInterface chambreInterface;
public ChambreRestController(ChambreInterface chambreInterface) {this.chambreInterface = chambreInterface;}
    @PostMapping("/chambre")
    public Chambre addChambre(@RequestBody Chambre chambre) {
    return chambreInterface.addChambre(chambre);
    }
    @PutMapping("/chambre")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
    return chambreInterface.updateChambre(chambre);
    }
    @GetMapping
    public List<Chambre> getAllChambre() {
    return chambreInterface.retrieveAllChambres();}
    @GetMapping("/{id_chambre}")
    public Chambre getChambreById(@RequestParam("id_chambre") int idChambre) {
    return chambreInterface.retrieveChambre(idChambre);
    }
}
