package com.mycompany.mavenproject2;

/**
 *
 * @author Yanniv
 */
public class Poste extends Equipement {

    // Déclaration des variables
    private Machine[] ensembleDeMachines;
    

    public Poste(String refPoste, String dPoste, float coutH, float tpsUtilisation) {
        super(refPoste, dPoste, coutH, tpsUtilisation);
        this.ensembleDeMachines = new Machine[0];
    }

    public float getCoutHorairePoste() {
        return this.coutHoraireUtilisation;
    }

    public void setCoutHorairePoste(float coutH) {
        this.coutHoraireUtilisation = coutH;
    }

    public float getTempsUtilisation() {
        return this.tempsUtilisation;
    }

    public void setTempsUtilisation(float tempsUtilisation1) {
        this.tempsUtilisation = tempsUtilisation1;
    }

    public Machine[] getEnsembleDeMachines() {
        return this.ensembleDeMachines;
    }

    public void setEnsembleDeMachines(Machine[] ensembleDeMachines) {
        this.ensembleDeMachines = ensembleDeMachines;
    }

    public void ajouterMachine(Machine machine) {
        int tailleTableauMachines = this.ensembleDeMachines.length;
        Machine[] nouveauTableauMachine = new Machine[tailleTableauMachines + 1];
        for (int i = 0; i < tailleTableauMachines; i++) {
            nouveauTableauMachine[i] = this.ensembleDeMachines[i];
        }
        nouveauTableauMachine[tailleTableauMachines] = machine;
        this.ensembleDeMachines = nouveauTableauMachine;
    }

    public void supprimerMachine(Machine machine) {
        int tailleTableauMachines = this.ensembleDeMachines.length;
        boolean rechercheMachine = false;                                           // on suppose que la gamme a supprimer n'existe pas

        for (int k = 0; k < tailleTableauMachines; k++) {                                       // on parcours le tableau gammes
            if (machine.getReference().equals(ensembleDeMachines[k].getReference())) {                      // si la gamme à supprimer correspond à une référence dans le tableau
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
                                ensembleDeMachines[i].getReference())) {
                    supprimeTableauMachine[j] = ensembleDeMachines[i];                                    // on insère dans le nouveau tableau les gammes sauf celle à supprimer
                    j--;
                } else {
                    dejaSupprime = true;
                }
            }
            this.ensembleDeMachines = supprimeTableauMachine;
        }
    }

    public void affichePoste() {
        System.out.println("===== Poste =====");
        System.out.println("Reference du poste : " + this.refEquipement);
        System.out.println("Designation du poste : " + this.dEquipement);
        System.out.print("Ensemble des machines : ");
        for (int i = 0; i < this.ensembleDeMachines.length; i++) {
            System.out.print(this.ensembleDeMachines[i].getReference() + " ");
        }
        System.out.println("");
        System.out.println("Cout poste par heure : " + this.coutHoraireUtilisation);
        System.out.println("Vous avez utilise la machine " + this.tempsUtilisation + " heure(s), donc un cout total de : " + this.tempsUtilisation * this.coutHoraireUtilisation + "euros");
        System.out.println("=================");
    }

    public void affichePosteParRef() {
        System.out.println("=====Reference de Poste=====");
        System.out.println("Reference du poste : " + this.refEquipement);
        System.out.println("============================");
    }
}
