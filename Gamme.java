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
public class Gamme {
    
    private String refGamme;
    private Equipement[] equipements;
    private Operation [] operations;
    
    public Gamme (String refGamme){
        this.refGamme = refGamme;
       
        this.equipements = new Equipement[0];
        this.operations = new Operation[0];
    }
    
    public String getRefGamme(){
        return this.refGamme;
    }
    
    public void setRefGamme (String refGamme){
        this.refGamme=refGamme;
    }
    
    public Equipement[] getListeEquipement(){ // recuperer
        return this.equipements;
    }
    
    public void setListeEquipement(Equipement[] refEquipement){ // modifier 
        this.equipements=refEquipement;
    }
    
      public Operation[] getListeOperation(){ // recuperer
        return this.operations;
    }
    
    public void setListeOperation(Operation[] refOperation){ // modifier 
        this.operations=refOperation;
    }
    
    
    public void ajouterEquipement(Equipement equipement){
        int tailleTableauEquipements = this.equipements.length;
        Equipement[] nouveauTableauEquipement = new Equipement[tailleTableauEquipements+1];
        for (int i=0;i<tailleTableauEquipements;i++){
            nouveauTableauEquipement[i] = this.equipements[i];
        }
        nouveauTableauEquipement[tailleTableauEquipements] = equipement;
        this.equipements = nouveauTableauEquipement;
    }
    
    public void supprimerEquipement (Equipement equipement){
        int tailleTableauEquipement = this.equipements.length;
        boolean rechercherEquipement = false;
        
        for (int k=0;k<tailleTableauEquipement;k++){
            if(equipement.getReference().equals
                    (equipements[k].getReference())){
                rechercherEquipement = true;
            }
        }
        if (rechercherEquipement){
            Equipement[] supprimeTableauEquipement = new Equipement[tailleTableauEquipement-1];
            int j = supprimeTableauEquipement.length-1;
            
            boolean dejaSupprime = false;
            
            for (int i=tailleTableauEquipement-1;i>=0;i--){
                if (dejaSupprime ||
                        !equipement.getReference().equals(
                        equipements[i].getReference() )){
                    supprimeTableauEquipement[j] = equipements[i];
                    j--;
                }
                else{
                    dejaSupprime = true;
                }
            }
            this.equipements = supprimeTableauEquipement;
        } 
    }
    
    public void ajouterOperation(Operation operation){
        int tailleTableauOperations = this.operations.length;
        Operation [] nouveauTableauOperations = new Operation[tailleTableauOperations+1];
        for (int i=0;i<tailleTableauOperations;i++){
            nouveauTableauOperations[i] = this.operations[i];
        }
        nouveauTableauOperations[tailleTableauOperations] = operation;
        this.operations = nouveauTableauOperations;
    }
    
    public void supprimerOperation (Operation operation){
        int tailleTableauOperations = this.operations.length;
        boolean rechercherOperation = false;
        
        for (int k=0;k<tailleTableauOperations;k++){
            if(operation.getRefOperation().equals
                    (operations[k].getRefOperation())){
                rechercherOperation = true;
            }
        }
        if (rechercherOperation){
            Operation[] supprimeTableauOperation = new Operation[tailleTableauOperations-1];
            int j = supprimeTableauOperation.length-1;
            
            boolean dejaSupprime = false;
            
            for (int i=tailleTableauOperations-1;i>=0;i--){
                if (dejaSupprime ||
                        !operation.getRefOperation().equals(
                        operations[i].getRefOperation() )){
                    supprimeTableauOperation[j] = operations[i];
                    j--;
                }
                else{
                    dejaSupprime = true;
                }
            }
            this.operations = supprimeTableauOperation;
        } 
    }

    
    public float dureeGamme(){
    
        float duree;
        duree=0;
        for (int i=0; i<this.operations.length;i++){
        
        duree=duree+this.operations[i].getdureeOperation();
        }
       
    return duree;
    }
    
    public float coutGamme(){
    
    float cout;
    cout=0;
    for (int i=0; i<this.operations.length;i++){
       
        cout=cout+this.operations[i].getcoutOperation();
   }
    return cout;
    }
    
    public float coutTotalGamme(){
    float coutTotal;
    coutTotal=0;
    
     for (int i=0; i<this.operations.length;i++){
       
        coutTotal=coutTotal+this.operations[i].getcoutOperation()*this.operations[i].getdureeOperation();
   }
    
    return coutTotal;
    }
    
    
    public void afficheGamme (){
        System.out.println("===== Gamme =====");
        System.out.println("Reference de la gamme : " + this.refGamme);
        System.out.println("Ensemble des equipements : ");
        for (int i=0;i<this.equipements.length;i++){
            System.out.print(this.equipements[i].getReference() + " ");
        }
        System.out.println("Ensemble des operations : ");
        for (int i=0;i<this.operations.length;i++){
            System.out.print(this.operations[i].getRefOperation() + " ");
        }
        System.out.println("");
        System.out.println("==================");
    }
    
    public void afficheGammeParRef (){
        System.out.println("=====Reference de Gamme=====");
        System.out.println("Reference de la gamme : " + this.refGamme);
        System.out.println("============================");
    }    
}