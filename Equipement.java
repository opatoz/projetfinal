/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grpb8.atelier_fabrication;

/**
 *
 * @author Lucile
 */
public class Equipement {

    // attributs utiles dans pour Machine et Poste
    protected String refEquipement;
    protected String dEquipement;
    protected float coutHoraireUtilisation;
    protected float tempsUtilisation;

    // constructeur 
    public Equipement(String refEquipement, String dEquipement, float coutHoraireUtilisation, float tempsUtilisation) {
        this.refEquipement = refEquipement;
        this.dEquipement = dEquipement;
        this.coutHoraireUtilisation = coutHoraireUtilisation;
        this.tempsUtilisation = tempsUtilisation;
    }

    public String getReference() {
        return this.refEquipement;
    }

    public void setReference(String reference) {
        this.refEquipement = reference;
    }

    public String getDEquipement() {
        return this.dEquipement;
    }

    public void setDEquipement(String designation) {
        this.dEquipement = designation;
    }
}
