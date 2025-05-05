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
public class StockBrut {
    
// Déclaration des attributs     
    private String refLot;
    private String type; 
    private String materiaux;
    private float quantiteDispo; 
    private float prixUnitaire;
    

    /**
     * Construit une instance de type Machine
     *
     * @param refLot
     * @param type
     * @param materiaux
     * @param quantiteDispo
     * @param prixUnitaire
     */
    
    public StockBrut(String refLot, String type, String materiaux, float quantiteDispo, float prixUnitaire) {
       
        this.refLot = refLot;
        this.type = type;
        this.materiaux = materiaux;
        this.quantiteDispo = quantiteDispo;
        this.prixUnitaire = prixUnitaire;
    }

    public String getrefLot() {
        return this.refLot;
    }

    public void setrefLot(String refLot) {
        this.refLot = refLot;
    }

    public String gettype() {
        return this.type;
    }

    public void settype(String type) {
        this.type = type;
    }

    public String getmateriaux() {
        return this.materiaux;
    }

    public void setmateriaux(String materiaux) {
        this.materiaux = materiaux;
    }

    public float getquantiteDispo() {
        return this.quantiteDispo;
    }

    public void setquantiteDispo(float quantiteDispo) {
        this.quantiteDispo = quantiteDispo;
    }

    public float getprixUnitaire() {
        return this.prixUnitaire;
    }

    public void setprixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public void afficheStock() {
        System.out.println("===== Lot =====");
        System.out.println("Référence du lot : " + this.refLot);
        System.out.println("Type du lot : " + this.type);
        System.out.println("Materiaux : (" + this.materiaux);
        System.out.println("Quantité disponible : " + this.quantiteDispo);
        System.out.println("Prix unitaire " + this.prixUnitaire);
        System.out.println("===================");
    }

    public void afficheLotParRef() {
        System.out.println("=====Reference de Lot=====");
        System.out.println("Reference du lot : " + this.refLot);
        System.out.println("============================");
    }
}

