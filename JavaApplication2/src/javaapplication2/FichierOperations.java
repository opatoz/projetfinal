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
 * @author yannivtroadec
 */
public class FichierOperations {

    public static Operation[] lire(String dir) {

        Path dirPath = Paths.get(dir);
        String nomDuFichier = "Operations.txt";
        Path filePath = dirPath.resolve(nomDuFichier);
        String[] elementsDeOperations;
        if (Files.exists(filePath)) {
            try {
                String contenu_du_fichier = new String(Files.readAllBytes(filePath));
                elementsDeOperations = contenu_du_fichier.split("\n");
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture du message !");
                e.printStackTrace();
                elementsDeOperations = new String[0];
            }
        } else {
            elementsDeOperations = new String[0];
        }
        int nombreDeOperations = elementsDeOperations.length / 5;
        Operation[] operations = new Operation[nombreDeOperations];

        for (int i = 0; i < nombreDeOperations; i++) {
            String refOperation = elementsDeOperations[i * 5];
            String dOperation = elementsDeOperations[i * 5 + 1];
            String refEquipement = elementsDeOperations[i * 5 + 2];
            float dureeOperation = Float.valueOf(elementsDeOperations[i * 5 + 3]);
            float coutOperation = Float.valueOf(elementsDeOperations[i * 5 + 4]);

            Operation operation = new Operation(refOperation, dOperation, refEquipement, dureeOperation,coutOperation);
            operations[i] = operation;
        }
        return operations;
    }

    public static void enregistrer(String dir, Operation[] operations) {

        String contenu = "";
        int nombreDeElementsDeOperations = operations.length;
        for (int i = 0; i < nombreDeElementsDeOperations; i++) {
            contenu = contenu + operations[i].getRefOperation() + "\n";
            contenu = contenu + operations[i].getdOperation() + "\n";
            contenu = contenu + operations[i].getRefEquipement() + "\n";
            contenu = contenu + operations[i].getdureeOperation()+ "\n";
            contenu = contenu + operations[i].getcoutOperation();

            if (i < nombreDeElementsDeOperations - 1) {
                contenu = contenu + "\n";
            }
        }
        Path dirPath = Paths.get(dir);
        String nomDuFichier = "Operations.txt";
        Path filePath = dirPath.resolve(nomDuFichier);

        try {
            Files.write(filePath, contenu.getBytes());
        } catch (IOException e) {
            System.out.println("Erreur lors de l'ecriture du fichier !");
            e.printStackTrace();
        }
    }

}
