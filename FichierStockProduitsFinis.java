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
public class FichierStockProduitsFinis {
    
    
      public static StockProduitsFinis[] lire(String dir) {

        Path dirPath = Paths.get(dir);
        String nomDuFichier = "StockProduitsFinis.txt";
        Path filePath = dirPath.resolve(nomDuFichier);
        String[] elementsDeStockProduitsFinis;
        if (Files.exists(filePath)) {
            try {
                String contenu_du_fichier = new String(Files.readAllBytes(filePath));
                elementsDeStockProduitsFinis = contenu_du_fichier.split("\n");
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture du message !");
                e.printStackTrace();
                elementsDeStockProduitsFinis = new String[0];
            }
        } else {
            elementsDeStockProduitsFinis = new String[0];
        }
        int nombreDelots = elementsDeStockProduitsFinis.length / 6;
        StockProduitsFinis[] lots = new StockProduitsFinis[nombreDelots];

        for (int i = 0; i < nombreDelots; i++) {
            String refLot = elementsDeStockProduitsFinis[i * 6];
            String refProduit = elementsDeStockProduitsFinis[i * 6 + 1];
            String type = elementsDeStockProduitsFinis[i * 6 + 2];
            float nmbreproduitsdanslot = Float.valueOf(elementsDeStockProduitsFinis[i * 6 + 3]);
            String destinataire = elementsDeStockProduitsFinis[i * 6 + 4];
            String etat = elementsDeStockProduitsFinis[i * 6 + 5];
        

            StockProduitsFinis lot = new StockProduitsFinis(refLot, refProduit, type, nmbreproduitsdanslot, destinataire, etat);
            lots[i] = lot;
        }
        return lots;
    }

    public static void enregistrer(String dir, StockProduitsFinis[] lots) {

        String contenu = "";
        int nombreDeElementsDeLots = lots.length;
        for (int i = 0; i < nombreDeElementsDeLots; i++) {
            contenu = contenu + lots[i].getrefLot() + "\n";
            contenu = contenu + lots[i].getrefProduit() + "\n";
            contenu = contenu + lots[i].gettype() + "\n";
            contenu = contenu + lots[i].getnmbreproduitdanslot() + "\n";
            contenu = contenu + lots[i].getdestinataire()+ "\n" ;
            contenu = contenu + lots[i].getetat() ;
            

            if (i < nombreDeElementsDeLots - 1) {
                contenu = contenu + "\n";
            }
        }
        Path dirPath = Paths.get(dir);
        String nomDuFichier = "StockProduitsFinis.txt";
        Path filePath = dirPath.resolve(nomDuFichier);

        try {
            Files.write(filePath, contenu.getBytes());
        } catch (IOException e) {
            System.out.println("Erreur lors de l'ecriture du fichier !");
            e.printStackTrace();
        }
    }
    
    
}
