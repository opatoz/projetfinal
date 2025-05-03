/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author yannivtroadec
 */
public class StockProduitsFinis {
    
// Déclaration des attributs     
    private String refLot;
    private String refProduit;
    private String type; 
    private String destinataire;
    private String etat;
    private float nmbreproduitdanslot; 
    
    

    /**
     * Construit une instance de type Machine
     *
     * @param refLot
     * @param refProduit
     * @param type
     * @param destinataire
     * @param etat
     * @param nmbreproduitdanslot
     */
    
    public StockProduitsFinis (String refLot, String refProduit, String type, float nmbreproduitdanslot, String destinataire, String etat) {
       
        this.refLot = refLot;
        this.refProduit = refProduit;
        this.type = type;
        this.destinataire = destinataire;
        this.etat = etat;
        this.nmbreproduitdanslot = nmbreproduitdanslot;
    }

    public String getrefLot() {
        return this.refLot;
    }

    public void setrefLot(String refLot) {
        this.refLot = refLot;
    }

    public String getrefProduit() {
        return this.refProduit;
    }

    public void setrefProduit(String refProduit) {
        this.refProduit = refProduit;
    }
    
      public String gettype() {
        return this.type;
    }

    public void settype(String type) {
        this.type = type;
    }

    public String getdestinataire() {
        return this.destinataire;
    }

    public void setdestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getetat() {
        return this.etat;
    }

    public void setetat(String etat) {
        this.etat = etat;
    }
    
     public float getnmbreproduitdanslot() {
        return this.nmbreproduitdanslot;
    }

    public void setnmbreproduitdanslot(float nmbreproduitdanslot) {
        this.nmbreproduitdanslot = nmbreproduitdanslot;
    }

    public void afficheStock() {
        System.out.println("===== Lot =====");
        System.out.println("Référence du lot : " + this.refLot);
        System.out.println("Référence du produit : " + this.refProduit);
        System.out.println("Type du produit : " + this.type);
        System.out.println("Destinataire : (" + this.destinataire);
        System.out.println("Etat : " + this.etat);
        System.out.println("Nombre de produit dans le lot " + this.nmbreproduitdanslot);
        System.out.println("===================");
    }

    public void afficheMachineParRef() {
        System.out.println("=====Reference de Lot=====");
        System.out.println("Reference du lot : " + this.refLot);
        System.out.println("============================");
    }
}

