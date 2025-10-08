package metiers;

import entities.Module;
import entities.typeModule;
import entities.UniteEnseignement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModuleBusiness {
    private static List<Module> modules;
    private static UniteEnseignementBusiness ueb = new UniteEnseignementBusiness(); // accès à la liste d'UE existante

    public ModuleBusiness() {
        modules = new ArrayList<>();

        // Récupération des unités d’enseignement existantes
        List<UniteEnseignement> listeUE = ueb.getListeUE();
        UniteEnseignement ue1 = listeUE.get(0); // Informatique
        UniteEnseignement ue2 = listeUE.get(1); // Mathématiques
        UniteEnseignement ue3 = listeUE.get(2); // Physique

        // Initialisation de quelques modules avec les UEs existantes
        Module m1 = new Module("M001", typeModule.TRANSVERSAL, 30, 3, "Programmation Java");
        m1.setUniteEnseignement(ue1);
        modules.add(m1);

        Module m2 = new Module("M002", typeModule.TRANSVERSAL, 20, 2, "Base de Données");
        m2.setUniteEnseignement(ue1);
        modules.add(m2);

        Module m3 = new Module("M003", typeModule.PROFESSIONNEL, 25, 3, "Systèmes d’exploitation");
        m3.setUniteEnseignement(ue2);
        modules.add(m3);

        Module m4 = new Module("M004", typeModule.RECHERCHE, 15, 1, "Réseaux Informatiques");
        m4.setUniteEnseignement(ue2);
        modules.add(m4);

        Module m5 = new Module("M005", typeModule.RECHERCHE, 40, 4, "Développement Web");
        m5.setUniteEnseignement(ue3);
        modules.add(m5);
    }

    /** Récupère un module par son matricule */
    public Module getModuleByMatricule(String matricule) {
        for (Module m : modules) {
            if (m.getMatricule().equalsIgnoreCase(matricule))
                return m;
        }
        return null;
    }

    /** Ajoute un nouveau module (avec ou sans UE associée) */
    public boolean addModule(Module m) {
        return modules.add(m);
    }

    /** Récupère la liste des modules d’un certain type */
    public List<Module> getModulesByType(typeModule type) {
        List<Module> liste = new ArrayList<>();
        for (Module m : modules) {
            if (m.getType() == type)
                liste.add(m);
        }
        return liste;
    }

    /** Récupère tous les modules d'une UE spécifique */
    public List<Module> getModulesByUniteEnseignement(UniteEnseignement ue) {
        List<Module> liste = new ArrayList<>();
        for (Module m : modules) {
            if (m.getUniteEnseignement() != null && m.getUniteEnseignement().equals(ue))
                liste.add(m);
        }
        return liste;
    }

    /** Supprime un module selon son matricule */
    public boolean deleteModule(String matricule) {
        Iterator<Module> iterator = modules.iterator();
        while (iterator.hasNext()) {
            Module m = iterator.next();
            if (m.getMatricule().equalsIgnoreCase(matricule)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /** Met à jour un module existant selon son matricule */
    public boolean updateModule(String matricule, Module updatedModule) {
        for (int i = 0; i < modules.size(); i++) {
            if (modules.get(i).getMatricule().equalsIgnoreCase(matricule)) {
                modules.set(i, updatedModule);
                return true;
            }
        }
        return false;
    }

    /** Retourne la liste complète des modules */
    public List<Module> getListeModules() {
        return modules;
    }

    /** Remplace complètement la liste des modules */
    public void setModules(List<Module> modules) {
        ModuleBusiness.modules = modules;
    }
}
