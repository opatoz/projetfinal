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
public class FichierGammes {
    
    public static Gamme[] lire (String dir){
        
        Path dirPath = Paths.get(dir);
        String nomDuFichier = "Gammes.txt";
        Path filePath = dirPath.resolve(nomDuFichier);
        String [] elementsDeGammes; 
        if (Files.exists(filePath)){
            try{
                String contenu_du_fichier = new String(Files.readAllBytes(filePath));  
                elementsDeGammes = contenu_du_fichier.split("\n");                     
		}
            catch (IOException e) {                                                   
                System.out.println("Erreur lors de la lecture du fichier !");             
                e.printStackTrace();                                                   
		elementsDeGammes = new String[0];                                       
            }
        }
        else{
            elementsDeGammes = new String [0];
        }
        int nombreDeGammes = elementsDeGammes.length/3;
        Gamme [] gammes = new Gamme [nombreDeGammes];
        
        Machine [] machines = FichierMachines.lire(dir);
        Poste [] postes = FichierPostes.lire(dir);
        Operation [] operations = FichierOperations.lire(dir);
 
        for (int i=0; i< nombreDeGammes ; i++){
            
            String referenceEquipements = elementsDeGammes[i*3];
            String referenceOperations = elementsDeGammes[i*3+1];
            String refGamme = elementsDeGammes[i*3+2];
            
            Gamme gamme = new Gamme(refGamme);
            if (!referenceEquipements.equals("")){
                String[] tableauRefEquipement = referenceEquipements.split(",");
            
                Equipement [] equipementsDeGamme = new Equipement [tableauRefEquipement.length];

                for (int j=0;j<tableauRefEquipement.length;j++){
                    String refEquipement = tableauRefEquipement[j]; 
                    Equipement equipement = null;
                    for (int k=0; k<machines.length; k++){ 
                        if(machines[k].getReference().equals(refEquipement)){
                            equipement = machines [k];
                            break;
                        }
                    }
                    for (int k=0; k<postes.length; k++){ 
                        if(postes[k].getReference().equals(refEquipement)){
                            equipement = postes [k];
                            break;
                        }
                    }
                    
                    equipementsDeGamme[j]=equipement;
                    
                }
                gamme.setListeEquipement(equipementsDeGamme);
            }
            if (!referenceOperations.equals("")){
                String[] tableauRefOperation = referenceOperations.split(",");
            
                Operation [] operationsDeGamme = new Operation [tableauRefOperation.length];

                for (int j=0;j<tableauRefOperation.length;j++){
                    String refOperation = tableauRefOperation[j]; 
                    Operation operation = null;
                    for (int k=0; k<operations.length; k++){ 
                        if(operations[k].getRefOperation().equals(refOperation)){
                            operation = operations [k];
                            break;
                        }
                    }                    
                    operationsDeGamme[j]=operation;                   
                }
                gamme.setListeOperation(operationsDeGamme);
            }
            gammes [i] = gamme ;  
        }   
        return gammes;   
    }
    
    public static void enregistrer (String dir, Gamme[] gammes){
        
        String contenu = "";
        int nombreDeElementsDeEquipements = gammes.length;
        for (int i=0;i<nombreDeElementsDeEquipements;i++){
            
            
            String refEquipements = "";
            Equipement[] equipements = gammes[i].getListeEquipement();
            for (int j=0;j<equipements.length;j++){
                refEquipements = refEquipements + equipements[j].getReference();
                if(j != equipements.length-1){
                    refEquipements = refEquipements + ",";  
                }
            }
            contenu = contenu + refEquipements+ "\n";
            
            
            String refOperations = "";
            Operation[] operations = gammes[i].getListeOperation();
            for (int j=0;j<operations.length;j++){
                refOperations = refOperations + operations[j].getRefOperation();
                if(j != operations.length-1){
                    refOperations = refOperations + ",";  
                }
            }
            contenu = contenu + refOperations+ "\n"; 
            
            contenu = contenu + gammes[i].getRefGamme();
            
            if (i<nombreDeElementsDeEquipements - 1){
                contenu = contenu + "\n";
            }
        }
        Path dirPath = Paths.get(dir);
        String nomDuFichier = "Gammes.txt";
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
