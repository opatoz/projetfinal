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
 * @author yannivtroadec
 */
public class FichierFiabilite {
    
 public static Fiabilite[] lire(String dir) {

        Path dirPath = Paths.get(dir);
        String nomDuFichier = "Fiabilite.txt";
        Path filePath = dirPath.resolve(nomDuFichier);
        String[] elementsDeFiabilite;
        if (Files.exists(filePath)) {
            try {
                String contenu_du_fichier = new String(Files.readAllBytes(filePath));
                elementsDeFiabilite = contenu_du_fichier.split("\n");
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture du message !");
                e.printStackTrace();
                elementsDeFiabilite = new String[0];
            }
        } else {
            elementsDeFiabilite = new String[0];
        }
        int nombreDefia = elementsDeFiabilite.length / 5;
        Fiabilite[] fia = new Fiabilite[nombreDefia];

        for (int i = 0; i < nombreDefia; i++) {
            String refMachine = elementsDeFiabilite[i * 5];
            String date = elementsDeFiabilite[i * 5 + 1];
            String evmnt = elementsDeFiabilite[i * 5 + 2];
            String codeOperateur =elementsDeFiabilite[i * 5 + 3];
            String cause = elementsDeFiabilite[i * 5 + 4];
        

            Fiabilite fiabilite = new Fiabilite(refMachine, date, evmnt, codeOperateur, cause);
            fia[i] = fiabilite;
        }
        return fia;
    }

    public static void enregistrer(String dir, Fiabilite[] fia) {

        String contenu = "";
        int elementsDeFiabilite = fia.length;
        for (int i = 0; i < elementsDeFiabilite; i++) {
            contenu = contenu + fia[i].getrefMachine() + "\n";
            contenu = contenu + fia[i].getdate() + "\n";
            contenu = contenu + fia[i].getevmnt() + "\n";
            contenu = contenu + fia[i].getcodeOperateur() + "\n";
            contenu = contenu + fia[i].getcause() ;
            

            if (i < elementsDeFiabilite - 1) {
                contenu = contenu + "\n";
            }
        }
        Path dirPath = Paths.get(dir);
        String nomDuFichier = "Fiabilite.txt";
        Path filePath = dirPath.resolve(nomDuFichier);

        try {
            Files.write(filePath, contenu.getBytes());
        } catch (IOException e) {
            System.out.println("Erreur lors de l'ecriture du fichier !");
            e.printStackTrace();
        }
    }
    
    
    
}
