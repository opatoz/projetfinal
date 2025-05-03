/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grpb8.atelier_fabrication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Lucile
 */
public class FichierPostes {

    public static Poste[] lire(String dir) {

        Path dirPath = Paths.get(dir);
        String nomDuFichier = "Postes.txt";
        Path filePath = dirPath.resolve(nomDuFichier);
        String[] elementsDePostes;
        if (Files.exists(filePath)) {
            try {
                String contenu_du_fichier = new String(Files.readAllBytes(filePath));
                elementsDePostes = contenu_du_fichier.split("\n");
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture du fichier !");
                e.printStackTrace();
                elementsDePostes = new String[0];
            }
        } else {
            elementsDePostes = new String[0];
        }
        int nombreDePostes = elementsDePostes.length / 5;
        Poste[] tabpostes = new Poste[nombreDePostes];

        Machine[] machines = FichierMachines.lire(dir);
        for (int i = 0; i < nombreDePostes; i++) {
            String refPoste = elementsDePostes[i * 5];
            String dPoste = elementsDePostes[i * 5 + 1];
            String referenceMachines = elementsDePostes[i * 5 + 2];
            float coutHorairePoste = Float.valueOf(elementsDePostes[i * 5 + 3]);
            float tempsUtilisation = Float.valueOf(elementsDePostes[i * 5 + 4]);

            Poste poste = new Poste(refPoste, dPoste, coutHorairePoste, tempsUtilisation);
            if (!referenceMachines.equals("")) {
                String[] tableauRefMachines = referenceMachines.split(",");

                Machine[] machinesDuPoste = new Machine[tableauRefMachines.length];

                for (int j = 0; j < tableauRefMachines.length; j++) {
                    String refMachine = tableauRefMachines[j];
                    Machine machine = null;
                    for (int k = 0; k < machines.length; k++) {
                        if (machines[k].getReference().equals(refMachine)) {
                            machine = machines[k];
                            break;
                        }
                    }
                    machinesDuPoste[j] = machine;
                }
                poste.setEnsembleDeMachines(machinesDuPoste);
            }
            tabpostes[i] = poste;
        }
        return tabpostes;
    }

    public static void enregistrer(String dir, Poste[] tabpostes) {

        String contenu = "";
        int nombreDeElementsDePostes = tabpostes.length;
        for (int i = 0; i < nombreDeElementsDePostes; i++) {
            contenu = contenu + tabpostes[i].getReference() + "\n";
            contenu = contenu + tabpostes[i].getDEquipement() + "\n";
            String refMachines = "";
            Machine[] machines = tabpostes[i].getEnsembleDeMachines();
            for (int j = 0; j < machines.length; j++) {
                refMachines = refMachines + machines[j].getReference();
                if (j != machines.length - 1) {
                    refMachines = refMachines + ",";
                }
            }
            contenu = contenu + refMachines + "\n";
            contenu = contenu + tabpostes[i].getCoutHorairePoste() + "\n";
            contenu = contenu + tabpostes[i].getTempsUtilisation();

            if (i < nombreDeElementsDePostes - 1) {
                contenu = contenu + "\n";
            }
        }
        Path dirPath = Paths.get(dir);
        String nomDuFichier = "Postes.txt";
        Path filePath = dirPath.resolve(nomDuFichier);

        try {
            Files.write(filePath, contenu.getBytes());
        } catch (IOException e) {
            System.out.println("Erreur lors de l'ecriture du fichier !");
            e.printStackTrace();
        }

    }
}
