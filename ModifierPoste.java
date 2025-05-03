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
public class ModifierPoste extends javax.swing.JFrame {

    /**
     * Creates new form ModifierPoste
     */
    public ModifierPoste() {
        initComponents();
    }

    public void modifierPostePartie1() {

        IG_Poste.tabpostes = FichierPostes.lire(Atelier_Fabrication.dir);

        String modif = jTextField1.getText();

        int taillePostes = IG_Poste.tabpostes.length;

        boolean test = false;

        for (int k = 0; k < taillePostes; k++) {
            if (modif.equals(IG_Poste.tabpostes[k].getReference())) {
                test = true;
            }
        }

        if (test) {
            this.afficherUnPoste8(modif);
        } else {
            jTextArea1.append("Cet poste n'existe pas" + "\n");
            jTextArea1.append("Try again ;)" + "\n");
        }
    }

    public void modifierPostePartie2() {

        IG_Poste.tabpostes = FichierPostes.lire(Atelier_Fabrication.dir);
        String modif = jTextField1.getText();

        Poste poste = getPoste(modif);

        String newdPoste = jTextField3.getText();
        
        poste.setDEquipement(newdPoste);

        try {
            float newDuree = Float.parseFloat(jTextField6.getText());
            float newcoutH = Float.parseFloat(jTextField7.getText());
            
        
        Poste poste3 = getPoste(modif);
        poste.setTempsUtilisation(newDuree);

        
        Poste poste4 = getPoste(modif);
        poste.setCoutHorairePoste(newcoutH);

        String refEquipement = jTextField4.getText();

        if (refEquipement.equals("")) {
            jTextArea1.append("pas d'équipement à rajouter" + "\n");
        } else {
            String refMachine = jTextField4.getText();
            Machine[] machines = FichierMachines.lire(Atelier_Fabrication.dir);
            Machine machine = null;
            for (int i = 0; i < machines.length; i++) {
                if (refMachine.equals(machines[i].getReference())) {
                    machine = machines[i];
                }
            }
            if (machine == null) {
                jTextArea1.append("Cette machine n'existe pas");
            } else {
                
                poste.ajouterMachine(machine);
                FichierPostes.enregistrer(Atelier_Fabrication.dir, IG_Poste.tabpostes);
            }
        }

        String refEquipement2 = jTextField5.getText();

        if (refEquipement2.equals("")) {
            jTextArea1.append("pas d'équipement à supprmier" + "\n");
        } else {

            String refMachine2 = jTextField5.getText();
            Machine[] machines2 = FichierMachines.lire(Atelier_Fabrication.dir);
            Machine machine2 = null;

            for (int i = 0; i < machines2.length; i++) {
                if (refMachine2.equals(machines2[i].getReference())) {
                    machine2 = machines2[i];
                }
            }
            if (machine2 == null) {
                jTextArea1.append("Cette machine n'existe pas" + "\n");
            } else {
                
                poste.supprimerMachine(machine2);
                FichierPostes.enregistrer(Atelier_Fabrication.dir, IG_Poste.tabpostes);
            }
        }

        jTextArea1.append("Poste " + modif + " modifié!" + "\n");
        FichierPostes.enregistrer(Atelier_Fabrication.dir, IG_Poste.tabpostes);

            
        } catch (NumberFormatException e) {
            jTextArea1.append("Modification impossible" + "\n");
            jTextArea1.append("Vérifiez que la durée et le cout soient bien des nombres." + "\n");
            jTextArea1.append("\n");
        }

        
    }

    public void afficherUnPoste8(String modif) {

        Poste[] postes = FichierPostes.lire(Atelier_Fabrication.dir);
        int taillePostes = IG_Poste.tabpostes.length;
        for (int i = 0; i < taillePostes; i++) {
            if (modif.equals(IG_Poste.tabpostes[i].getReference())) {
                Poste poste = IG_Poste.tabpostes[i];
                affichePoste8(poste);
            }
        }
    }

    public void affichePoste8(Poste poste) {

        jTextArea1.append("===== Poste =====" + "\n");
        jTextArea1.append("Reference du poste : " + poste.getReference() + "\n");
        jTextArea1.append("Designation du poste : " + poste.getDEquipement() + "\n");
        jTextArea1.append("Ensemble des machines : " + "\n");
        for (int i = 0; i < poste.getEnsembleDeMachines().length; i++) {
            jTextArea1.append(poste.getEnsembleDeMachines()[i].getReference() + ", ");
        }
        jTextArea1.append("\n");
        jTextArea1.append("Cout poste par heure : " + poste.getCoutHorairePoste() + "\n");
        jTextArea1.append("Vous avez utilise la machine " + poste.getTempsUtilisation() + " heure(s), donc un cout total de : " + poste.getTempsUtilisation() * poste.getCoutHorairePoste() + " euros" + "\n");
        jTextArea1.append("=================" + "\n");
    }

    public void afficherPostesParRef() {
        jTextArea1.append("Voici les references" + "\n");
        int taillePoste = IG_Poste.tabpostes.length;
        for (int i = 0; i < taillePoste; i++) {
            Poste poste = IG_Poste.tabpostes[i];
            affichePosteParRef(poste);
        }
    }

    public void affichePosteParRef(Poste poste) {
        jTextArea1.append("=====Reference de Poste=====" + "\n");
        jTextArea1.append("Reference du poste : " + poste.getReference() + "\n");
        jTextArea1.append("============================" + "\n");
    }

    public Poste getPoste(String reference) {
        Poste resultat = null;
        int taillePostes = IG_Poste.tabpostes.length;
        for (int i = 0; i < taillePostes; i++) {
            if (reference.equals(IG_Poste.tabpostes[i].getReference())) {
                resultat = IG_Poste.tabpostes[i];
                break; // arreter la boucle dans laquelle on est
            }
        }
        return resultat;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        BoutonTermine = new javax.swing.JButton();
        BoutonModifier = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Postes");

        jLabel1.setText("Modifier Poste");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Référence du Poste à modifier:");

        jTextField1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BoutonValider.setText("Valider");
        BoutonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonValiderActionPerformed(evt);
            }
        });

        jLabel3.setText("Nouveaux Paramètres");

        jLabel5.setText("Désignation");

        jLabel6.setText("Ajout Machine");

        jLabel7.setText("Suppression Machine");

        jLabel8.setText("Durée");

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

        jLabel9.setText("Cout");

        jTextField3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextField4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextField5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextField6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextField7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setText("€");

        jLabel11.setText("h");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BoutonValider)))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BoutonModifier)
                                .addGap(18, 18, 18)
                                .addComponent(BoutonTermine))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BoutonValider))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BoutonTermine)
                            .addComponent(BoutonModifier))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonValiderActionPerformed
        // TODO add your handling code here:
        modifierPostePartie1();
    }//GEN-LAST:event_BoutonValiderActionPerformed

    private void BoutonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonModifierActionPerformed
        // TODO add your handling code here:
        modifierPostePartie2();
    }//GEN-LAST:event_BoutonModifierActionPerformed

    private void BoutonTermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonTermineActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BoutonTermineActionPerformed

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
            java.util.logging.Logger.getLogger(ModifierPoste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifierPoste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifierPoste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifierPoste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifierPoste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonModifier;
    private javax.swing.JButton BoutonTermine;
    private javax.swing.JButton BoutonValider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
