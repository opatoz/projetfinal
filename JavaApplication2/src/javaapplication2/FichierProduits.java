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
public class FichierProduits {
    
     public static Produit [] lire(String dir){  
        
        Path dirPath = Paths.get(dir);
        String nomDuFichier = "Produits.txt";
        Path filePath = dirPath.resolve(nomDuFichier);
        String [] elementsDeProduits; 
        if (Files.exists(filePath)){
            try{
                String contenu_du_fichier = new String(Files.readAllBytes(filePath));  
                elementsDeProduits = contenu_du_fichier.split("\n");                     
		}
            catch (IOException e) {                                                   
                System.out.println("Erreur lors de la lecture du message !");             
                e.printStackTrace();                                                   
		elementsDeProduits = new String[0];                                       
            }
        }
        else{
            elementsDeProduits = new String [0];
        }
        int nombreDeProduits = elementsDeProduits.length/3;
        Produit [] produits = new Produit [nombreDeProduits];
        
        for (int i=0; i< nombreDeProduits ; i++){
            String codeProduit = elementsDeProduits[i*3];
            String dproduit = elementsDeProduits[i*3+1];
            String gammeAssociee = elementsDeProduits[i*3+2];
            
            
            Produit produits1 = new Produit(codeProduit, dproduit, gammeAssociee);
            produits [i] = produits1 ;                 
        }   
        return produits;
    }
    
    public static void enregistrer(String dir, Produit[] produits){
        
        String contenu = "";
        int nombreDeElementsDeProduits = produits.length;
        for (int i=0;i<nombreDeElementsDeProduits;i++){
            contenu = contenu + produits[i].getcodeProduit()+ "\n";
            contenu = contenu + produits[i].getdproduit()+ "\n";
           
           contenu = contenu + produits[i].getgammeAssociee();
                       
            
            if(i<nombreDeElementsDeProduits - 1){
                contenu = contenu + "\n";
            }
        }
        
        Path dirPath = Paths.get(dir);
        String nomDuFichier = "Produits.txt";
        Path filePath = dirPath.resolve(nomDuFichier);
        
        try {
            Files.write(filePath, contenu.getBytes()); 
        }
        catch (IOException e) {
            System.out.println("Erreur lors de l'ecriture du fichier !");
            e.printStackTrace();
        }        
    }
    
}
