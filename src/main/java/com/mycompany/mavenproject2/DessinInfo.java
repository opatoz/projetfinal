package com.mycompany.mavenproject2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MaFenetre2 extends JFrame {

    private JButton bouton = new JButton("Quitter");

    MaFenetre2() {
        setTitle("Légende Plan Atelier Fabrication");
        setSize(600, 600);
        setLocation(200, 50);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        zoneGraphique = new Paneau2();
        getContentPane().add(zoneGraphique);

        zoneGraphique.add(bouton);

        bouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonActionPerformed(evt);
            }
        });

    }

    private Paneau2 zoneGraphique;

    private void boutonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();

    }

}

class Paneau2 extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* g.drawRoundRect(10, 480, 100, 80, 10, 10);
        g.drawString("Stock Brut", 27, 525);

        g.drawRoundRect(780, 480, 100, 90, 10, 10);
        g.drawString("Stock Produits", 786, 520);
        g.drawString("Finis", 815, 536);
        
        g.drawRoundRect(780, 10, 100, 90, 10, 10);
        g.drawString("Bureau", 811, 50);
        g.drawString("Chef Atelier", 796, 66);
        
        g.drawRoundRect(760, 130, 120, 110, 10, 10);
        g.drawString("Salle de repos", 780, 170);
        g.drawString("Opérateurs", 790, 186);

         */
        g.drawRect(450, 100, 70, 50);
        g.fillOval(450 - 7, 100 - 7, 15, 15);
        g.fillOval(450 + 70 - 7, 100 - 7, 15, 15);
        g.fillOval(450 - 7, 100 + 50 - 7, 15, 15);
        g.fillOval(450 + 70 - 7, 100 + 50 - 7, 15, 15);

        g.drawString("Les machines de type éléctrique sont représentées avec: ", 5, 100);

        g.drawOval(450, 200, 70, 50);

        g.drawString("Les machines de type automatique sont représentées avec: ", 5, 200 + 30);

        g.drawOval(450, 300, 70, 70);

        g.drawString("Les machines de type informatique sont représentées avec: ", 5, 300 + 40);

        g.drawRect(450, 400, 70, 50);
        g.drawLine(450, 400, 450 + 35, 400 - 25);
        g.drawLine(450 + 35, 400 - 25, 450 + 70, 400);

        g.drawString("Les machines de type tri sont représentées avec: ", 5, 400 + 30);

        g.drawRect(450, 500, 70, 50);

        g.drawString("Les machines d'un type différent sont représentées avec: ", 5, 500 + 30);

    }
}

public class DessinInfo {

    public static void main(String args[]) {
        MaFenetre2 f = new MaFenetre2();
        f.setVisible(true);

    }
}
