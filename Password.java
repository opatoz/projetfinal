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
public class Password {

    private String id;
    private String password;
    private Password[] passwords = new Password[0];
    private String Nom;
    private String Prenom;
    private String descriptif;

    public Password(String id, String password, String Nom, String Prenom, String descriptif) {
        this.id = id;
        this.password = password;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.descriptif = descriptif;

        this.passwords = new Password[0];
    }

    public String getid() {
        return this.id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getpassword() {
        return this.password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return this.Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return this.Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getdescriptif() {
        return this.descriptif;
    }

    public void setdescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public Password[] getListePasswords() { // recuperer
        return this.passwords;
    }

    public void setListePassword(Password[] passwords) { // modifier 
        this.passwords = passwords;
    }

    public void ajouterPassword(Password id) {
        int tailleTableauPaswword = this.passwords.length;
        Password[] nouveauTableauPassword = new Password[tailleTableauPaswword + 1];
        for (int i = 0; i < tailleTableauPaswword; i++) {
            nouveauTableauPassword[i] = this.passwords[i];
        }
        nouveauTableauPassword[tailleTableauPaswword] = id;
        this.passwords = nouveauTableauPassword;

    }

    public void supprimerPassword(Password id) {
        int tailleTableauPaswword = this.passwords.length;
        boolean rechercherPassword = false;

        for (int k = 0; k < tailleTableauPaswword; k++) {
            if (id.getid().equals(passwords[k].getid())) {
                rechercherPassword = true;
            }
        }
        if (rechercherPassword) {
            Password[] supprimeTableauPassword = new Password[tailleTableauPaswword - 1];
            int j = supprimeTableauPassword.length - 1;

            boolean dejaSupprime = false;

            for (int i = tailleTableauPaswword - 1; i >= 0; i--) {
                if (dejaSupprime
                        || !id.getid().equals(
                                passwords[i].getid())) {
                    supprimeTableauPassword[j] = passwords[i];
                    j--;
                } else {
                    dejaSupprime = true;
                }
            }
            this.passwords = supprimeTableauPassword;
        }

    }

    public void afficheid() {
        System.out.println("===== Compte =====");
        System.out.println("Compte : " + this.id);
        System.out.println("Mot de passe : " + this.password);
        System.out.println("Compte : " + this.Nom);
        System.out.println("Compte : " + this.Prenom);
        System.out.println("Compte : " + this.descriptif);

        System.out.println("");

        System.out.println("==================");
    }

    public void afficheGammeParRef() {
        System.out.println("=====Compte=====");
        System.out.println("Compte : " + this.id);
        System.out.println("============================");
    }

}
