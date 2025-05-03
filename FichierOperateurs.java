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
public class FichierOperateurs {

    public static Operateur[] lire(String dir) {

        Path dirPath = Paths.get(dir);
        String nomDuFichier = "Operateurs.txt";
        Path filePath = dirPath.resolve(nomDuFichier);
        String[] elementsDeOperateurs;
        if (Files.exists(filePath)) {
            try {
                String contenu_du_fichier = new String(Files.readAllBytes(filePath));
                elementsDeOperateurs = contenu_du_fichier.split("\n");
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture du fichier !");
                e.printStackTrace();
                elementsDeOperateurs = new String[0];
            }
        } else {
            elementsDeOperateurs = new String[0];
        }
        int nombreDeOperateurs = elementsDeOperateurs.length / 5;
        Operateur[] operateurs = new Operateur[nombreDeOperateurs];

        Machine[] competences = FichierMachines.lire(dir);
        for (int i = 0; i < nombreDeOperateurs; i++) {
            String competencesMachines = elementsDeOperateurs[i * 5];
            String code = elementsDeOperateurs[i * 5 + 1];
            String nom = elementsDeOperateurs[i * 5 + 2];
            String prenom = elementsDeOperateurs[i * 5 + 3];
            String etat = elementsDeOperateurs[i * 5 + 4];

            Operateur operateur = new Operateur(code, nom, prenom, etat);
            if (!competencesMachines.equals("")) {
                String[] tableauCompetencesMachines = competencesMachines.split(",");

                Machine[] machinesDeOperateur = new Machine[tableauCompetencesMachines.length];

                for (int j = 0; j < tableauCompetencesMachines.length; j++) {
                    String refMachine = tableauCompetencesMachines[j];
                    Machine machine = null;
                    for (int k = 0; k < competences.length; k++) {
                        if (competences[k].getReference().equals(refMachine)) {
                            machine = competences[k];
                            break;
                        }
                    }
                    machinesDeOperateur[j] = machine;
                }
                operateur.setCompetences(machinesDeOperateur);
            }
            operateurs[i] = operateur;
        }
        return operateurs;
    }

    public static void enregistrer(String dir, Operateur[] taboperateurs) {

        String contenu = "";
        int nombreDeElementsDeOperateurs = taboperateurs.length;
        for (int i = 0; i < nombreDeElementsDeOperateurs; i++) {
            String refMachines = "";
            Machine[] competences = taboperateurs[i].getCompetences();
            for (int j = 0; j < competences.length; j++) {
                refMachines = refMachines + competences[j].getReference();
                if (j != competences.length - 1) {
                    refMachines = refMachines + ",";
                }
            }
            contenu = contenu + refMachines + "\n";
            contenu = contenu + taboperateurs[i].getCode() + "\n";
            contenu = contenu + taboperateurs[i].getNom() + "\n";
            contenu = contenu + taboperateurs[i].getPrenom() + "\n";
            contenu = contenu + taboperateurs[i].getEtat();

            if (i < nombreDeElementsDeOperateurs - 1) {
                contenu = contenu + "\n";
            }
        }
        Path dirPath = Paths.get(dir);
        String nomDuFichier = "Operateurs.txt";
        Path filePath = dirPath.resolve(nomDuFichier);

        try {
            Files.write(filePath, contenu.getBytes());
        } catch (IOException e) {
            System.out.println("Erreur lors de l'ecriture du fichier !");
            e.printStackTrace();
        }
    }
}
