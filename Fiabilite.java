/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grpb8.atelier_fabrication;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.IOException;

/**
 *
 * @author yannivtroadec
 */
public class Fiabilite {
    
// Déclaration des attributs  
    private String refMachine; 
    private String date;
    private String evmnt;
    private String codeOperateur; 
    private String cause;
    

    /**
     * Construit une instance de type Machine
     *
     * @param date
     * @param refMachine
     * @param evmnt
     * @param codeOperateur
     * @param cause
     */
    
    public Fiabilite(String refMachine, String date, String evmnt, String codeOperateur, String cause) {
       
        this.refMachine = refMachine;
        this.date = date;
        this.evmnt = evmnt;
        this.codeOperateur = codeOperateur;
        this.cause = cause;
    }

    public String getdate() {
        return this.date;
    }

    public void setdate(String date) {
        this.date = date;
    }

    public String getrefMachine() {
        return this.refMachine;
    }

    public void setrefMachine(String refMachine) {
        this.refMachine = refMachine;
    }

    public String getevmnt() {
        return this.evmnt;
    }

    public void setevmnt(String evmnt) {
        this.evmnt = evmnt;
    }

    public String getcodeOperateur() {
        return this.codeOperateur;
    }

    public void setcodeOperateur(String codeOperateur) {
        this.codeOperateur = codeOperateur;
    }

    public String getcause() {
        return this.cause;
    }

    public void setcause(String cause) {
        this.cause = cause;
    }

    public void afficheFiabilite() {
        System.out.println("===== Evenement =====");
        System.out.println("Référence dela machine : " + this.refMachine);
        System.out.println("Date : " + this.date);
        System.out.println("Evènement : (" + this.evmnt);
        System.out.println("Code Opérateur : " + this.codeOperateur);
        System.out.println("Cause " + this.cause);
        System.out.println("===================");
    }

    
    public static float diffheures (String date1, String date2){
    
    SimpleDateFormat date = new SimpleDateFormat("ddMMyyyy HH :mm");
    float nmbreHeures=0;
    
    try {
        Date debut = date.parse(date1);
        Date fin = date.parse(date2);
        long diff = debut.getTime()-fin.getTime();
            nmbreHeures= diff/3600000;
    
    }
    catch (Exception ex){
    }
    
    return nmbreHeures;
    }
   
    
  
public static float fiabilite (String refMachine){

    float fiabilite ;
    float dureeArret;
    float dureeMax;
    
    dureeArret=0;
    
            Date today = Calendar.getInstance().getTime();
            SimpleDateFormat datetoday = new SimpleDateFormat("ddMMyyyy HH :mm");
            String date1 = datetoday.format(today);
            String date2 ="01012020 00 :01";
            dureeMax= diffheures (date1,  date2);
            
    
      Fiabilite [] events = FichierFiabilite.lire(Atelier_Fabrication.dir);
      int taillefia = events.length;
      
      int v=0;
      
      for (int i=0; i<taillefia; i++){
    if (refMachine.equals(events[i].getrefMachine())){
       v=v+1;
         }
   }
      
       Fiabilite [] eventsrefMachine= new Fiabilite[v];
        int k =0;
        
   for (int i=0; i<taillefia; i++){
    if (refMachine.equals(events[i].getrefMachine())){
       eventsrefMachine[k]=events[i];
         k=k+1;
         }
   }
   for (int j =0;j<v;j++){
       
          if(eventsrefMachine[j].getevmnt().equals("A")){
          String date3=eventsrefMachine[j].getdate();
          String date4=eventsrefMachine[j+1].getdate();
          dureeArret=Math.abs(dureeArret+diffheures (date4,  date3));
          }
   }

   
    //fiabilite=100*(dureeMax-dureeArret)/dureeMax;                              // valeur brute.
  
    fiabilite= Math.round((100*(dureeMax-(Math.abs(dureeArret)))/dureeMax) * 100) / 100;    //valeur arrondie.
   
 return fiabilite;
}




}