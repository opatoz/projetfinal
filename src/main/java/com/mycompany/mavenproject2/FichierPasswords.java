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
public class FichierPasswords {

    public static Password[] lire(String dir2) {

        Path dirPath = Paths.get(dir2);
        String nomDuFichier = "Passwords.txt";
        Path filePath = dirPath.resolve(nomDuFichier);
        String[] elementsDePasswords;
        if (Files.exists(filePath)) {
            try {
                String contenu_du_fichier = new String(Files.readAllBytes(filePath));
                elementsDePasswords = contenu_du_fichier.split("\n");
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture du message !");
                e.printStackTrace();
                elementsDePasswords = new String[0];
            }
        } else {
            elementsDePasswords = new String[0];
        }
        int nombreDePasswords = elementsDePasswords.length / 5;
        Password[] passwords = new Password[nombreDePasswords];

        for (int i = 0; i < nombreDePasswords; i++) {
            String id = elementsDePasswords[i * 5];
            String password = elementsDePasswords[i * 5 + 1];
            String Nom = elementsDePasswords[i * 5 + 2];
            String Prenom = elementsDePasswords[i * 5 + 3];
            String descriptif = elementsDePasswords[i * 5 + 4];

            Password password1 = new Password(id, password, Nom, Prenom, descriptif);
            passwords[i] = password1;
        }
        return passwords;
    }

    public static void enregistrer(String dir2, Password[] passwords) {

        String contenu = "";
        int nombreDeElementsDePassword = passwords.length;
        for (int i = 0; i < nombreDeElementsDePassword; i++) {
            contenu = contenu + passwords[i].getid() + "\n";
            contenu = contenu + passwords[i].getpassword() + "\n";
            contenu = contenu + passwords[i].getNom() + "\n";
            contenu = contenu + passwords[i].getPrenom() + "\n";
            contenu = contenu + passwords[i].getdescriptif();

            if (i < nombreDeElementsDePassword - 1) {
                contenu = contenu + "\n";
            }
        }
        Path dirPath = Paths.get(dir2);
        String nomDuFichier = "Passwords.txt";
        Path filePath = dirPath.resolve(nomDuFichier);

        try {
            Files.write(filePath, contenu.getBytes());
        } catch (IOException e) {
            System.out.println("Erreur lors de l'ecriture du fichier !");
            e.printStackTrace();
        }
    }
}
