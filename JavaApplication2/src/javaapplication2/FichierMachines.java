/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Lucile
 */
public class FichierMachines {

    public static Machine[] lire(String dir) {

        Path dirPath = Paths.get(dir);
        String nomDuFichier = "Machines.txt";
        Path filePath = dirPath.resolve(nomDuFichier);
        String[] elementsDeMachines;
        if (Files.exists(filePath)) {
            try {
                String contenu_du_fichier = new String(Files.readAllBytes(filePath));
                elementsDeMachines = contenu_du_fichier.split("\n");
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture du message !");
                e.printStackTrace();
                elementsDeMachines = new String[0];
            }
        } else {
            elementsDeMachines = new String[0];
        }
        int nombreDeMachines = elementsDeMachines.length / 7;
        Machine[] machines = new Machine[nombreDeMachines];

        for (int i = 0; i < nombreDeMachines; i++) {
            String refMachine = elementsDeMachines[i * 7];
            String dEquipement = elementsDeMachines[i * 7 + 1];
            String typeMachine = elementsDeMachines[i * 7 + 2];
            float XPosition = Float.valueOf(elementsDeMachines[i * 7 + 3]);
            float YPosition = Float.valueOf(elementsDeMachines[i * 7 + 4]);
            float coutHoraireMachine = Float.valueOf(elementsDeMachines[i * 7 + 5]);
            float tempsUtilisation = Float.valueOf(elementsDeMachines[i * 7 + 6]);

            Machine machine = new Machine(refMachine, dEquipement, typeMachine, XPosition, YPosition, coutHoraireMachine, tempsUtilisation);
            machines[i] = machine;
        }
        return machines;
    }

    public static void enregistrer(String dir, Machine[] machines) {

        String contenu = "";
        int nombreDeElementsDeMachines = machines.length;
        for (int i = 0; i < nombreDeElementsDeMachines; i++) {
            contenu = contenu + machines[i].getReference() + "\n";
            contenu = contenu + machines[i].getDEquipement() + "\n";
            contenu = contenu + machines[i].getTypeMachine() + "\n";
            contenu = contenu + machines[i].getXPosition() + "\n";
            contenu = contenu + machines[i].getYPosition() + "\n";
            contenu = contenu + machines[i].getCoutHoraireMachine() + "\n";
            contenu = contenu + machines[i].getTempsUtilisation();

            if (i < nombreDeElementsDeMachines - 1) {
                contenu = contenu + "\n";
            }
        }
        Path dirPath = Paths.get(dir);
        String nomDuFichier = "Machines.txt";
        Path filePath = dirPath.resolve(nomDuFichier);

        try {
            Files.write(filePath, contenu.getBytes());
        } catch (IOException e) {
            System.out.println("Erreur lors de l'ecriture du fichier !");
            e.printStackTrace();
        }
    }
}
