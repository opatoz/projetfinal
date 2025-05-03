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
public class Operation {

    private String refOperation;
    private String dOperation;
    private String refEquipement;
    private float dureeOperation;
    private float coutOperation;

    /**
     * Construit une instance de type Machine
     *
     * @param refOperation
     * @param dOperation
     * @param refEquipement
     * @param dureeOperation
     * @param coutOperation
     *
     */
    public Operation(String refOperation, String dOperation, String refEquipement, float dureeOperation,float coutOperation) {

        this.refOperation = refOperation;
        this.dOperation = dOperation;
        this.refEquipement = refEquipement;
        this.dureeOperation = dureeOperation;
        this.coutOperation = coutOperation;
    }

    public String getRefOperation() {
        return this.refOperation;
    }

    public void setRefOperation(String refOperation) {
        this.refOperation = refOperation;
    }

    public String getdOperation() {
        return this.dOperation;
    }

    public void setdOperation(String dOperation) {
        this.dOperation = dOperation;
    }

    public String getRefEquipement() {
        return this.refEquipement;
    }

    public void setRefEquipement(String refEquipement) {
        this.refEquipement = refEquipement;
    }

    public float getdureeOperation() {
        return this.dureeOperation;
    }

    public void setdureeOperation(float dureeOperation) {
        this.dureeOperation = dureeOperation;
    }
    
     public float getcoutOperation() {
        return this.coutOperation;
    }

    public void setcoutOperation(float coutOperation) {
        this.coutOperation = coutOperation;
    }
   
    

    public void afficheO() {
        System.out.println("===== Operation =====");
        System.out.println("Reference : " + this.refOperation);
        System.out.println("Designation : " + this.dOperation);
        System.out.println("Reference equipement : " + this.refEquipement);

        System.out.println("Duree : " + this.dureeOperation);

        System.out.println("===================");
    }

    public void afficheMachineParRef() {
        System.out.println("=====Reference Operation=====");
        System.out.println("Reference de l'operation : " + this.refOperation);
        System.out.println("============================");
    }
}
