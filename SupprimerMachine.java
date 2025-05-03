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
public class SupprimerMachine extends javax.swing.JFrame {

    /**
     * Creates new form SupprimerMachine
     */
    public SupprimerMachine() {
        initComponents();
    }

    /**public void afficherMachine4() {

        Machine[] machines = FichierMachines.lire(Atelier_Fabrication.dir);
        jTextArea1.append("Voici les differentes machines" + "\n");
        int tailleMachine = machines.length;
        for (int i = 0; i < tailleMachine; i++) {
            Machine machine = machines[i];
            machine.afficheM();
        }
    } 

    public void afficheMachineParRef4() {

        Machine[] machines = FichierMachines.lire(Atelier_Fabrication.dir);
        jTextArea1.append("Voici les references" + "\n");
        int tailleMachine = machines.length;
        for (int i = 0; i < tailleMachine; i++) {
            Machine machine = machines[i];

            afficheMachineParRef4();
        }
    }*/

    public void supprimerMachinePartie1() {

        Machine[] machines = FichierMachines.lire(Atelier_Fabrication.dir);

        String supprime = jTextField1.getText();

        int tailleMachine = machines.length;
        // on suppose que la gamme a supprimer n'existe pas
        boolean test = false;

        for (int k = 0; k < tailleMachine; k++) {                                       // on parcours le tableau gammes
            if (supprime.equals(machines[k].getReference())) {                      // si la gamme à supprimer correspond à une référence dans le tableau
                test = true;                                      // on indique que la gamme à supprimer existe
            }
        }
        if (test) {
            this.afficherMachine(supprime);
        } else {
            jTextArea1.append("Cette machine n'existe pas" + "\n");
            jTextArea1.append("Try again ;)" + "\n");
        }

    }

    public void supprimerMachinePartie2() {

        Machine[] machines = FichierMachines.lire(Atelier_Fabrication.dir);
        String supprime = jTextField1.getText();
        int tailleMachine = machines.length;
        Machine[] machineConserver = new Machine[tailleMachine - 1];                     // on crée un tableau de taille -1
        int j = 0;
        for (int i = 0; i < tailleMachine; i++) {                                       // on parcours le tableau gammes
            if (!supprime.equals(machines[i].getReference())) {
                machineConserver[j] = machines[i];                                    // on insère dans le nouveau tableau les gammes sauf celle à supprimer
                j++;
            }
        }

        machines = machineConserver;                                                  // le nouveau tableau écrase l'ancien
        jTextArea1.append("La machine " + supprime + " a ete suprimee");

        FichierMachines.enregistrer(Atelier_Fabrication.dir, machines);

    }

    public void afficherMachine(String supprime) {

// afficher la gamme dont la référence est modif
        Machine[] machines = FichierMachines.lire(Atelier_Fabrication.dir);
        int tailleMachine = machines.length;
        for (int i = 0; i < tailleMachine; i++) {                                       // on parcours tous le tableau
            if (supprime.equals(machines[i].getReference())) {                        // mais la seule gamme qui sera affichée doit être la même que saisie par l'utilisateur
                Machine machine = machines[i];
                this.afficheM(machine);
            }
        }
    }

    public void afficheMachineParRef2(Machine machine) {
        jTextArea1.append("=====Reference de Machine=====" + "\n");
        jTextArea1.append("Reference de la machine : " + machine.getReference() + "\n");
        jTextArea1.append("============================" + "\n");
    }

    public void afficheM(Machine machine) {
        jTextArea1.append("===== Machine =====" + "\n");
        jTextArea1.append("Code machine : " + machine.getReference() + "\n");
        jTextArea1.append("Designation machine : " + machine.getDEquipement() + "\n");
        jTextArea1.append("Type de la machine : " + machine.getTypeMachine() + "\n");
        jTextArea1.append("Les coordonnees de la machine sont : (" + machine.getXPosition() + "," + machine.getYPosition() + ")" + "\n");
        jTextArea1.append("Cout machine par heure : " + machine.getCoutHoraireMachine() + "\n");
        jTextArea1.append("Vous avez utilise la machine " + machine.getTempsUtilisation() + " heure(s), donc un cout total de : " + machine.getTempsUtilisation() * machine.getCoutHoraireMachine() + "euros" + "\n");
        jTextArea1.append("===================" + "\n");
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        BoutonValider = new javax.swing.JButton();
        BoutonTermine = new javax.swing.JButton();
        BoutonSupprimer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Machines");

        jLabel1.setText("Suppression Machine");

        jLabel2.setText("Référence de la machine à supprimer:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jTextArea1);

        jTextField1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BoutonValider.setText("Valider");
        BoutonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonValiderActionPerformed(evt);
            }
        });

        BoutonTermine.setText("Retour");
        BoutonTermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonTermineActionPerformed(evt);
            }
        });

        BoutonSupprimer.setText("Supprimer");
        BoutonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BoutonValider)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BoutonSupprimer)
                .addGap(18, 18, 18)
                .addComponent(BoutonTermine)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BoutonValider)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonTermine)
                    .addComponent(BoutonSupprimer))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonValiderActionPerformed
        // TODO add your handling code here:
        supprimerMachinePartie1();
    }//GEN-LAST:event_BoutonValiderActionPerformed

    private void BoutonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonSupprimerActionPerformed
        // TODO add your handling code here:
        supprimerMachinePartie2();
    }//GEN-LAST:event_BoutonSupprimerActionPerformed

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
            java.util.logging.Logger.getLogger(SupprimerMachine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupprimerMachine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupprimerMachine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupprimerMachine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupprimerMachine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonSupprimer;
    private javax.swing.JButton BoutonTermine;
    private javax.swing.JButton BoutonValider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
