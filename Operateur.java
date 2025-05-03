/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grpb8.atelier_fabrication;

/**
 *
 * @author yannivtroadec
 */
public class Operateur {

    private Machine[] competencesMachines;
    private String code;
    private String nom;
    private String prenom;
    private String etat;

    public Operateur(String code, String nom, String prenom, String etat) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.etat = etat;
        this.competencesMachines = new Machine[0];
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String Nom) {
        this.nom = Nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String Prenom) {
        this.prenom = Prenom;
    }

    public String getEtat() {
        return this.etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Machine[] getCompetences() {
        return this.competencesMachines;
    }

    public void setCompetences(Machine[] competencesMachines) {
        this.competencesMachines = competencesMachines;
    }


 public void ajouterMachine(Machine machine) {
        int tailleTableauMachines = this.competencesMachines.length;
        Machine[] nouveauTableauMachine = new Machine[tailleTableauMachines + 1];
        for (int i = 0; i < tailleTableauMachines; i++) {
            nouveauTableauMachine[i] = this.competencesMachines[i];
        }
        nouveauTableauMachine[tailleTableauMachines] = machine;
        this.competencesMachines = nouveauTableauMachine;
    }

    public void supprimerMachine(Machine machine) {
        int tailleTableauMachines = this.competencesMachines.length;
        boolean rechercheMachine = false;                                           // on suppose que la gamme a supprimer n'existe pas

        for (int k = 0; k < tailleTableauMachines; k++) {                                       // on parcours le tableau gammes
            if (machine.getReference().equals(competencesMachines[k].getReference())) {                      // si la gamme à supprimer correspond à une référence dans le tableau
                rechercheMachine = true;                                            // on indique que la gamme à supprimer existe
            }
        }
        if (rechercheMachine) {
            Machine[] supprimeTableauMachine = new Machine[tailleTableauMachines - 1];
            int j = supprimeTableauMachine.length - 1;

            boolean dejaSupprime = false;

            for (int i = tailleTableauMachines - 1; i >= 0; i--) {
                if (dejaSupprime
                        || !machine.getReference().equals(
                                competencesMachines[i].getReference())) {
                    supprimeTableauMachine[j] = competencesMachines[i];                                    // on insère dans le nouveau tableau les gammes sauf celle à supprimer
                    j--;
                } else {
                    dejaSupprime = true;
                }
            }
            this.competencesMachines = supprimeTableauMachine;
        }
    }






}