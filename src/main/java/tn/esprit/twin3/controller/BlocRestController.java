package tn.esprit.twin3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.entity.Bloc;
import tn.esprit.twin3.service.BlocInterface;

import java.util.List;


@RestController

public class BlocRestController {
    public BlocRestController(BlocInterface blocInterface) {
        this.blocInterface = blocInterface;
    }


    BlocInterface blocInterface;
    @PostMapping(path = "/bloc")
    Bloc addBloc(@RequestBody Bloc bloc) {
        return blocInterface.addBloc(bloc);
    }
    @PutMapping(path = "/bloc")
    Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocInterface.updateBloc(bloc);
    }
    @DeleteMapping(path = "/{id_bloc}")
    void deleteBloc(@PathVariable ("id_bloc") Long idBloc) {
        blocInterface.deleteBloc(idBloc);
    }
    @GetMapping(path = "/{id_bloc}")
    Bloc viewBloc(@PathVariable ("id_bloc") Long idBloc) {
        return blocInterface.viewBloc(idBloc);
    }
    @GetMapping(path = "/bloc")
    List <Bloc> viewAllBloc() {
        return blocInterface.viewAllBloc();
    }
    @GetMapping(path ="/blocs/{nom_Foyer}")
    List <Bloc> viewBlocByFoyer(@PathVariable("nom_Foyer") String nomFoyer) {
        return blocInterface.viewBlocByFoyer(nomFoyer);
    }
@GetMapping(path ="/bloc/{nom_bloc}" )
Bloc viewBlocByNom(@PathVariable("nom_bloc") String nomBloc) {
        return blocInterface.viewBlocByNom(nomBloc);
}

}
