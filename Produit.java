/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grpb8.atelier_fabrication;

/**
 *
 * @author yannivtroadec
 */
public class Produit {
    
// Déclaration des attributs     
    public String codeProduit;
    public String dproduit;
    public String gammeAssociee;
  
    
    /**
     * Construit une instance de type Produit
     * @param codeProduit 
     * @param dproduit
     
     */
    public Produit(String codeProduit, String dproduit, String gammeAssociee){
      
        this.codeProduit=codeProduit;  
        this.dproduit=dproduit;
         this.gammeAssociee=gammeAssociee;
        
     
    }

    public String getcodeProduit(){
        return this.codeProduit;
    }
    public void setcodeProduit (String codeProduit){
        this.codeProduit=codeProduit;}
    
    public String getdproduit (){
        return this.dproduit;
    }
    public void setdproduit (String dproduit){
        this.dproduit=dproduit;
    }
    
    
    public String getgammeAssociee (){
        return this.gammeAssociee;
    }
    public void setgammeAssociee (String gammeAssociee){
        this.gammeAssociee=gammeAssociee;
    }
    
    
    
    public void afficheP(){
        System.out.println("===== Produit =====");
        System.out.println("Code Produit : " + this.codeProduit);
        System.out.println("Designation produit : " + this.dproduit);
        System.out.println("Gamme associée : " + this.gammeAssociee);
        System.out.println("===================");
    }
        
    public void afficheMachineParRef(){
        System.out.println("=====Reference de Machine=====");
        System.out.println("Reference de la machine : " + this.codeProduit);
        System.out.println("============================");
    }
}
