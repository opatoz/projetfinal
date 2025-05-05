/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author PC Nolan
 */
public class Machine extends Equipement {

    // Déclaration des attributs     
    private String typeMachine;
    private float xPosition;
    private float yPosition;

    /**
     * Construit une instance de type Machine
     *
     * @param refMachine
     * @param dMachine
     * @param type
     * @param x
     * @param y
     * @param coutHM
     * @param tempsUtilisation
     */
    public Machine(String refMachine, String dMachine, String type, float x, float y, float coutHM, float tempsUtilisation) {
        super(refMachine, dMachine, coutHM, tempsUtilisation);
        this.typeMachine = type;
        this.xPosition = x;
        this.yPosition = y;
    }

    public String getTypeMachine() {
        return this.typeMachine;
    }

    public void setTypeMachine(String type) {
        this.typeMachine = type;
    }

    public float getXPosition() {
        return this.xPosition;
    }

    public void setXPosition(float X) {
        this.xPosition = X;
    }

    public float getYPosition() {
        return this.yPosition;
    }

    public void setYPosition(float Y) {
        this.yPosition = Y;
    }

    public float getCoutHoraireMachine() {
        return this.coutHoraireUtilisation;
    }

    public void setCoutHoraireMachine(float coutHM) {
        this.coutHoraireUtilisation = coutHM;
    }

    public float getTempsUtilisation() {
        return this.tempsUtilisation;
    }

    public void setTempsUtilisation(float tempsUtilisation) {
        this.tempsUtilisation = tempsUtilisation;
    }

    public void afficheM() {
        System.out.println("===== Machine =====");
        System.out.println("Code machine : " + this.refEquipement);
        System.out.println("Designation machine : " + this.dEquipement);
        System.out.println("Type de la machine : " + this.typeMachine);
        System.out.println("Les coordonnees de la machine sont : (" + this.xPosition + "," + this.yPosition + ")");
        System.out.println("Cout machine par heure : " + this.coutHoraireUtilisation);
        System.out.println("Vous avez utilise la machine " + this.tempsUtilisation + " heure(s), donc un cout total de : " + this.tempsUtilisation * this.coutHoraireUtilisation + "euros");
        System.out.println("===================");
    }

    public void afficheMachineParRef() {
        System.out.println("=====Reference de Machine=====");
        System.out.println("Reference de la machine : " + this.refEquipement);
        System.out.println("============================");
    }
}
