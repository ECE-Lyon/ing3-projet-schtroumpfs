package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;


//--------------------------------------------------------------------------------------------------------------
public class FramePay extends JFrame {

    public static TextField labelSaisiePlaces = new TextField("1");
    public static JLabel l = new JLabel();


    public FramePay() {

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Choix séance :");
        this.setLayout(null);



        JPanel panelSean = new JPanel();
        panelSean.setBounds(500,50,500,40);
        panelSean.setBackground(Color.orange);
        JLabel label1 = new JLabel("Séances disponibles : ");
        panelSean.add(label1);
        ButtonGroup group = new ButtonGroup();
        JRadioButton s = new JRadioButton("18h00 (13 places)");
        JRadioButton b = new JRadioButton("20h00 (complet)");
        JRadioButton t = new JRadioButton("22h00 (2 places)");
        group.add(s);
        panelSean.add(s);
        group.add(b);
        panelSean.add(b);
        group.add(t);
        panelSean.add(t);
        this.add(panelSean);


        JPanel panelNb = new JPanel();
        panelNb.setBounds(500,450,500,40);
        panelNb.setBackground(Color.orange);
        JLabel labelPlace = new JLabel("Saisir nombre de place(s) voulue(s) : ");
        panelNb.add(labelPlace);
        panelNb.add(labelSaisiePlaces);
        ButtonSeance bouton = new ButtonSeance();
        panelNb.add(bouton);
        panelNb.add(l);
        this.add(panelNb);

    }

    //-----------------------------------------------------------------------------------------------------------------
    public class ButtonSeance extends JButton {

        public ButtonSeance() {

            setText("Choix séance");
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Integer n = Integer.parseInt(labelSaisiePlaces.getText());
                        if (n < 11 && n > 0) {
                            l.setText("Prix à payer :");






                        } else {
                            JOptionPane.showMessageDialog(ButtonSeance.this, "Veuillez saisir un nombre de billets entre 1 et 10");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(ButtonSeance.this, "Saisir un nombre SVP");

                    }

                }

            });
        }



    }


}