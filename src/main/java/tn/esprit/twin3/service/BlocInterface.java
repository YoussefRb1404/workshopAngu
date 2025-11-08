package tn.esprit.twin3.service;

import tn.esprit.twin3.entity.Bloc;

import java.util.List;

public interface BlocInterface {
    Bloc addBloc(Bloc bloc);
    Bloc updateBloc(Bloc bloc);
    void deleteBloc(Long idBloc);
    Bloc viewBloc(Long idBloc);
    List<Bloc> viewAllBloc();
    Bloc viewBlocByNom(String nomBloc);
    List<Bloc> viewBlocByFoyer(String nomFoyer);

}
