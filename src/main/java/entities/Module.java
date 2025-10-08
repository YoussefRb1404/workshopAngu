package entities;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
@XmlRootElement
public class Module {
    private String matricule;
    private String nom;
    private int coefficient;
    private int volume_horaire ;
    private typeModule type;


    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public typeModule getType() {
        return type;
    }

    public void setType(typeModule type) {
        this.type = type;
    }

    public int getVolume_horaire() {
        return volume_horaire;
    }

    public void setVolume_horaire(int volume_horaire) {
        this.volume_horaire = volume_horaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Module(String matricule, typeModule type, int volume_horaire, int coefficient, String nom) {
        this.matricule = matricule;
        this.type = type;
        this.volume_horaire = volume_horaire;
        this.coefficient = coefficient;
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return coefficient == module.coefficient && volume_horaire == module.volume_horaire && Objects.equals(matricule, module.matricule) && Objects.equals(nom, module.nom) && type == module.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule, nom, coefficient, volume_horaire, type);
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public UniteEnseignement getUniteEnseignement() { return uniteEnseignement; }
    public void setUniteEnseignement(UniteEnseignement uniteEnseignement) {
        this.uniteEnseignement = uniteEnseignement;
    }

    public Module() {
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "code_ue", referencedColumnName = "code") // clé étrangère vers UniteEnseignement
    private UniteEnseignement uniteEnseignement;
}
