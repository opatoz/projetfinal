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
public class FichierStockBrut {
    
    
     public static StockBrut[] lire(String dir) {

        Path dirPath = Paths.get(dir);
        String nomDuFichier = "StockBrut.txt";
        Path filePath = dirPath.resolve(nomDuFichier);
        String[] elementsDeStockBrut;
        if (Files.exists(filePath)) {
            try {
                String contenu_du_fichier = new String(Files.readAllBytes(filePath));
                elementsDeStockBrut = contenu_du_fichier.split("\n");
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture du message !");
                e.printStackTrace();
                elementsDeStockBrut = new String[0];
            }
        } else {
            elementsDeStockBrut = new String[0];
        }
        int nombreDeStockBrut = elementsDeStockBrut.length / 5;
        StockBrut[] lots = new StockBrut[nombreDeStockBrut];

        for (int i = 0; i < nombreDeStockBrut; i++) {
            String refLot = elementsDeStockBrut[i * 5];
            String type = elementsDeStockBrut[i * 5 + 1];
            String materiaux = elementsDeStockBrut[i * 5 + 2];
            float quantiteDisponible = Float.valueOf(elementsDeStockBrut[i * 5 + 3]);
            float coutUnitaire = Float.valueOf(elementsDeStockBrut[i * 5 + 4]);
        

            StockBrut lot = new StockBrut(refLot, type, materiaux, quantiteDisponible, coutUnitaire);
            lots[i] = lot;
        }
        return lots;
    }

    public static void enregistrer(String dir, StockBrut[] lots) {

        String contenu = "";
        int nombreDeElementsDeLots = lots.length;
        for (int i = 0; i < nombreDeElementsDeLots; i++) {
            contenu = contenu + lots[i].getrefLot() + "\n";
            contenu = contenu + lots[i].gettype() + "\n";
            contenu = contenu + lots[i].getmateriaux() + "\n";
            contenu = contenu + lots[i].getquantiteDispo() + "\n";
            contenu = contenu + lots[i].getprixUnitaire() ;
            

            if (i < nombreDeElementsDeLots - 1) {
                contenu = contenu + "\n";
            }
        }
        Path dirPath = Paths.get(dir);
        String nomDuFichier = "StockBrut.txt";
        Path filePath = dirPath.resolve(nomDuFichier);

        try {
            Files.write(filePath, contenu.getBytes());
        } catch (IOException e) {
            System.out.println("Erreur lors de l'ecriture du fichier !");
            e.printStackTrace();
        }
    }
    
    
    
}
