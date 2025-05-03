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
public class ModifierGamme extends javax.swing.JFrame {

    /**
     * Creates new form ModifierGamme
     */
    public ModifierGamme() {
        initComponents();
    }

    public void ModifierGammePartie1() {

        IG_Gamme.gammes = FichierGammes.lire(Atelier_Fabrication.dir);

        String modif = jTextField1.getText();

        int tailleGammes = IG_Gamme.gammes.length;
        boolean test = false;

        for (int k = 0; k < tailleGammes; k++) {
            if (modif.equals(IG_Gamme.gammes[k].getRefGamme())) {
                test = true;
            }
        }
        if (test) {
            this.afficherUneGamme(modif);
        } else {
            jTextArea1.append("Cette gamme n'existe pas" + "\n");
            jTextArea1.append("Try again ;)" + "\n");
            jTextArea1.append("\n");
        }
    }

    public void ModifierGammePartie2() {

        IG_Gamme.gammes = FichierGammes.lire(Atelier_Fabrication.dir);
        String modif = jTextField1.getText();

        Gamme gamme = getGamme(modif); // on récupère la gamme dont la référence est modif

        ;

        String refEquipement = jTextField3.getText();
        if (refEquipement.equals("")) {
            jTextArea1.append("pas d'équipement à rajouter" + "\n");
        } else {
            Machine[] machines = FichierMachines.lire(Atelier_Fabrication.dir);
            Poste[] tabpostes = FichierPostes.lire(Atelier_Fabrication.dir);
            Equipement equipement = null;
            for (int i = 0; i < machines.length; i++) {
                if (refEquipement.equals(machines[i].getReference())) {
                    equipement = machines[i];
                }
            }
            for (int i = 0; i < tabpostes.length; i++) {
                if (refEquipement.equals(tabpostes[i].getReference())) {
                    equipement = tabpostes[i];
                }
            }

            if (equipement == null) {
                jTextArea1.append("Cet equipement n'existe pas" + "\n");
            } else {

                gamme.ajouterEquipement(equipement);
                FichierGammes.enregistrer(Atelier_Fabrication.dir, IG_Gamme.gammes);
            }

        }

        String refEquipement1 = jTextField4.getText();
        if (refEquipement1.equals("")) {
            jTextArea1.append("pas d'équipement à supprimer" + "\n");
        } else {
            Machine[] machines2 = FichierMachines.lire(Atelier_Fabrication.dir);
            Poste[] tabpostes2 = FichierPostes.lire(Atelier_Fabrication.dir);
            Equipement equipement2 = null;
            for (int i = 0; i < machines2.length; i++) {
                if (refEquipement1.equals(machines2[i].getReference())) {
                    equipement2 = machines2[i];
                }
            }
            for (int i = 0; i < tabpostes2.length; i++) {
                if (refEquipement1.equals(tabpostes2[i].getReference())) {
                    equipement2 = tabpostes2[i];
                }
            }

            if (equipement2 == null) {
                System.out.println("Cet équipement n'existe pas" + "\n");
            } else {

                gamme.supprimerEquipement(equipement2);
                FichierGammes.enregistrer(Atelier_Fabrication.dir, IG_Gamme.gammes);
            }
        }

        String refOperation = jTextField6.getText();
        if (refOperation.equals("")) {
            jTextArea1.append("pas d'opération à rajouter" + "\n");
        } else {
            Operation[] operations = FichierOperations.lire(Atelier_Fabrication.dir);

            Operation operation = null;
            for (int i = 0; i < operations.length; i++) {
                if (refOperation.equals(operations[i].getRefOperation())) {
                    operation = operations[i];
                }
            }

            if (operation == null) {
                jTextArea1.append("Cette opération n'existe pas" + "\n");
            } else {
                Gamme gamme10 = getGamme(modif);
                gamme.ajouterOperation(operation);
                FichierGammes.enregistrer(Atelier_Fabrication.dir, IG_Gamme.gammes);
            }
        }

        String refOperation1 = jTextField7.getText();
        if (refOperation1.equals("")) {
            jTextArea1.append("pas d'opération à supprimer" + "\n");
        } else {
            Operation[] operations2 = FichierOperations.lire(Atelier_Fabrication.dir);

            Operation operation2 = null;
            for (int i = 0; i < operations2.length; i++) {
                if (refOperation1.equals(operations2[i].getRefOperation())) {
                    operation2 = operations2[i];
                }
            }

            if (operation2 == null) {
                System.out.println("Cette opération n'existe pas" + "\n");
            } else {
                Gamme gamme11 = getGamme(modif);
                gamme.supprimerOperation(operation2);
                FichierGammes.enregistrer(Atelier_Fabrication.dir, IG_Gamme.gammes);
            }
        }

        jTextArea1.append("Gamme " + modif + " modifiée!" + "\n");
        FichierGammes.enregistrer(Atelier_Fabrication.dir, IG_Gamme.gammes);

    }

    public void afficherUneGamme(String modif) {                                // afficher la gamme dont la référence est modif
        Gamme[] gammes = FichierGammes.lire(Atelier_Fabrication.dir);
        int tailleGammes = IG_Gamme.gammes.length;
        for (int i = 0; i < tailleGammes; i++) {                                       // on parcours tous le tableau
            if (modif.equals(IG_Gamme.gammes[i].getRefGamme())) {                        // mais la seule gamme qui sera affichée doit être la même que saisie par l'utilisateur
                Gamme gamme = IG_Gamme.gammes[i];
                this.afficheGamme(gamme);
            }
        }
    }

    public Gamme getGamme(String reference) {
        Gamme[] gammes = FichierGammes.lire(Atelier_Fabrication.dir);
        Gamme resultat = null;
        int tailleGammes = IG_Gamme.gammes.length;
        for (int i = 0; i < tailleGammes; i++) {
            if (reference.equals(IG_Gamme.gammes[i].getRefGamme())) {
                resultat = IG_Gamme.gammes[i];
                break;                                                          // arreter la boucle dans laquelle on est : on optimise quoi XD
            }
        }
        return resultat;
    }

    public void afficheGamme(Gamme gamme) {
        jTextArea1.append("===== Gamme =====" + "\n");
        jTextArea1.append("Reference de la gamme : " + gamme.getRefGamme() + "\n");

        jTextArea1.append("Ensemble des opérations : " + "\n");
        for (int i = 0; i < gamme.getListeOperation().length; i++) {
            jTextArea1.append(gamme.getListeOperation()[i].getRefOperation() + ", ");
        }
        jTextArea1.append("\n");

        jTextArea1.append("Equipements nécessaires aux opérations : " + "\n");
        for (int i = 0; i < gamme.getListeEquipement().length; i++) {
            jTextArea1.append(gamme.getListeEquipement()[i].getReference() + ", ");
        }
        jTextArea1.append("\n");
        jTextArea1.append("duree de la gamme : " + gamme.dureeGamme() + "\n");
        jTextArea1.append("cout total de la gamme : " + gamme.coutTotalGamme() + "€" + "\n");

        jTextArea1.append("==================" + "\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        BoutonValider = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        BoutonTermine = new javax.swing.JButton();
        BoutonModifier = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gammes");

        jLabel1.setText("Modifier Gamme");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Référence de la Gamme à modifier:");

        jTextField1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BoutonValider.setText("Valider");
        BoutonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonValiderActionPerformed(evt);
            }
        });

        jLabel4.setText("Ajout Equipement");

        jLabel5.setText("Suppression Equipement");

        jTextField3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextField4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("Nouveaux Paramètres:");

        BoutonTermine.setText("Retour");
        BoutonTermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonTermineActionPerformed(evt);
            }
        });

        BoutonModifier.setText("Modifier");
        BoutonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonModifierActionPerformed(evt);
            }
        });

        jLabel8.setText("Ajout Opération");

        jLabel9.setText("Suppression Opération");

        jTextField6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextField7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jTextField1)
                            .addGap(18, 18, 18)
                            .addComponent(BoutonValider))
                        .addComponent(jLabel2)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(83, 83, 83)
                        .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(28, 28, 28)
                        .addComponent(jTextField4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(71, 71, 71)
                        .addComponent(jTextField3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(40, 40, 40)
                        .addComponent(jTextField7)))
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BoutonModifier)
                .addGap(18, 18, 18)
                .addComponent(BoutonTermine)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BoutonValider))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(120, 120, 120)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonTermine)
                    .addComponent(BoutonModifier))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonValiderActionPerformed
        // TODO add your handling code here:
        ModifierGammePartie1();
    }//GEN-LAST:event_BoutonValiderActionPerformed

    private void BoutonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonModifierActionPerformed
        // TODO add your handling code here:
        ModifierGammePartie2();
    }//GEN-LAST:event_BoutonModifierActionPerformed

    private void BoutonTermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonTermineActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BoutonTermineActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModifierGamme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifierGamme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifierGamme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifierGamme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifierGamme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonModifier;
    private javax.swing.JButton BoutonTermine;
    private javax.swing.JButton BoutonValider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
