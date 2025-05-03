package grpb8.atelier_fabrication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MaFenetre extends JFrame {

    private JButton bouton = new JButton("Quitter");

    MaFenetre() {
        setTitle("Plan Atelier Fabrication");
        setSize(900, 600);
        setLocation(200, 50);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        zoneGraphique = new Paneau();
        getContentPane().add(zoneGraphique);

        zoneGraphique.add(bouton);
        bouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonActionPerformed(evt);
            }
        });

    }

    private Paneau zoneGraphique;

    private void boutonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();

    }

}

class Paneau extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawRoundRect(10, 480, 100, 80, 10, 10);
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

        Machine[] machines = FichierMachines.lire(Atelier_Fabrication.dir);

        int TailleMachine = machines.length;
        for (int i = 0; i < TailleMachine; i++) {
            String type = machines[i].getTypeMachine();

            if (type.equals("électrique")) {

                g.drawRect(Math.round(machines[i].getXPosition()), Math.round(machines[i].getYPosition()), 70, 50);
                g.fillOval(Math.round(machines[i].getXPosition()) - 7, Math.round(machines[i].getYPosition()) - 7, 15, 15);
                g.fillOval(Math.round(machines[i].getXPosition()) + 70 - 7, Math.round(machines[i].getYPosition()) - 7, 15, 15);
                g.fillOval(Math.round(machines[i].getXPosition()) - 7, Math.round(machines[i].getYPosition()) + 50 - 7, 15, 15);
                g.fillOval(Math.round(machines[i].getXPosition()) + 70 - 7, Math.round(machines[i].getYPosition()) + 50 - 7, 15, 15);

                g.drawString(machines[i].getReference(), Math.round(machines[i].getXPosition()) + 5, Math.round(machines[i].getYPosition()) + 30);

            } else if (type.equals("automatique")) {

                g.drawOval(Math.round(machines[i].getXPosition()), Math.round(machines[i].getYPosition()), 70, 50);

                g.drawString(machines[i].getReference(), Math.round(machines[i].getXPosition()) + 5, Math.round(machines[i].getYPosition()) + 30);

            } else if (type.equals("informatique")) {

                g.drawOval(Math.round(machines[i].getXPosition()), Math.round(machines[i].getYPosition()), 70, 70);

                g.drawString(machines[i].getReference(), Math.round(machines[i].getXPosition()) + 5, Math.round(machines[i].getYPosition()) + 40);

            } else if (type.equals("tri")) {

                g.drawRect(Math.round(machines[i].getXPosition()), Math.round(machines[i].getYPosition()), 70, 50);
                g.drawLine(Math.round(machines[i].getXPosition()), Math.round(machines[i].getYPosition()), Math.round(machines[i].getXPosition()) + 35, Math.round(machines[i].getYPosition()) - 25);
                g.drawLine(Math.round(machines[i].getXPosition()) + 35, Math.round(machines[i].getYPosition()) - 25, Math.round(machines[i].getXPosition()) + 70, Math.round(machines[i].getYPosition()));

                g.drawString(machines[i].getReference(), Math.round(machines[i].getXPosition()) + 5, Math.round(machines[i].getYPosition()) + 30);

            } else {

                g.drawRect(Math.round(machines[i].getXPosition()), Math.round(machines[i].getYPosition()), 70, 50);

                g.drawString(machines[i].getReference(), Math.round(machines[i].getXPosition()) + 5, Math.round(machines[i].getYPosition()) + 30);
            }

        }
    }
}

public class Dessin {

    public static void main(String args[]) {
        MaFenetre fen = new MaFenetre();
        fen.setVisible(true);

    }
}
