package View;

import Modele.Seance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;

import static Controleur.recherche.recupInfoFilm;
import static Controleur.seance.recupSeances;
import static Controleur.recherche.rechercheGenre;


//--------------------------------------------------------------------------------------------------------------
public class FramePay extends JFrame {

    public static TextField labelSaisiePlaces = new TextField("1");
    public static JLabel l = new JLabel();


    public FramePay(String nomFilm) {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Choix séance :");
        this.setLayout(null);

        //ajout de la jaquete du film
        JPanel panelFilm = new JPanel();
        panelFilm.setBounds(0,0,150,400);
        panelFilm.setBackground(Color.RED);

        String imgAdr = "imagesFilms\\" + nomFilm + ".jpg";
        ImageIcon image = new ImageIcon(imgAdr);
        JLabel labelImage = new JLabel(image, JLabel.CENTER);
        panelFilm.add(labelImage);
        this.add(panelFilm);
        //fin

        //ajout partie supérieure avec des infos
        JPanel panelInfos = new JPanel();
        panelInfos.setBounds(150,0,1450,400);
        panelInfos.setBackground(Color.ORANGE);
        panelInfos.setLayout(new GridLayout(3,2));

        JLabel labelTitre = new JLabel(nomFilm.toUpperCase(Locale.ROOT));
        labelTitre.setHorizontalTextPosition(JLabel.CENTER);

        ArrayList<String> listeInfos = recupInfoFilm(nomFilm);
        String genre = listeInfos.get(0);
        JLabel labelGenre = new JLabel("Genres du film : " + genre);
        JLabel labelPrix = new JLabel("Le prix d'une place est : 9€");

        int nbHeures = Integer.parseInt(listeInfos.get(1)) / 60;
        int nbMin = Integer.parseInt(listeInfos.get(1)) % 60;
        String affDuree = String.valueOf(nbHeures) + "H " + String.valueOf(nbMin) + "min";

        JLabel labelDuree = new JLabel("Duree du film : " + affDuree);
        JLabel labelConseils = new JLabel("Vous pourriez aussi aimé : ");

        panelInfos.add(labelTitre);
        panelInfos.add(labelGenre);
        panelInfos.add(labelPrix);
        panelInfos.add(labelDuree);
        panelInfos.add(labelConseils);

        String[] listeGenre = listeInfos.get(0).split(" ");
        ArrayList<String> listeConseil = rechercheGenre(listeGenre[0]);

        JPanel panelConseil = new JPanel();
        panelConseil.setBackground(Color.ORANGE);
        panelConseil.setLayout(new GridLayout(1, 4));
        //recuperation des jaquettes de films similaires
        if (listeConseil.size() < 4){
            for (String s : listeConseil) {
                String adresse = "imagesFilms\\" + s;
                ImageIcon filmConseil = new ImageIcon(imgAdr);
                JLabel labelFilmConseil = new JLabel(image, JLabel.CENTER);
                panelConseil.add(labelImage);
            }
        }
        else {
            for (int k = 0; k < 4; k++){
                String adresse = "imagesFilms\\" + listeConseil.get(k);
                ImageIcon filmConseil = new ImageIcon(imgAdr);
                JLabel labelFilmConseil = new JLabel(image, JLabel.CENTER);
                panelConseil.add(labelImage);
            }
        }

        panelInfos.add(panelConseil);
        this.add(panelInfos);






















//        ArrayList<Seance> listeSeances = recupSeances(nomFilm);
//        JPanel panelSean = new JPanel();
//        panelSean.setBounds(150,0,1600,400);
//        panelSean.setBackground(Color.orange);
//
//        //ajjout de la jaquete du film
//        JPanel panelIm = new JPanel();
//        panelIm.setBounds(0,0,150,400);
//        panelIm.setBackground(Color.RED);
//
//        String imgAdr = "imagesFilms\\" + nomFilm + ".jpg";
//        ImageIcon image = new ImageIcon(imgAdr);
//        JLabel labelImage = new JLabel(image, JLabel.CENTER);
//        panelIm.add(labelImage);
//        this.add(panelIm);
//        //fin ajout
//
//        panelSean.add(new JLabel("Une séance coûte 9€"));
//        JLabel label1 = new JLabel("Séances disponibles : ");
//        panelSean.add(label1);
//        ButtonGroup group = new ButtonGroup();
//        for (Seance seanceK : listeSeances){
//
//        }
//        JRadioButton s = new JRadioButton("18h00 (13 places)");
//        JRadioButton b = new JRadioButton("20h00 (complet)");
//        JRadioButton t = new JRadioButton("22h00 (2 places)");
//        group.add(s);
//        panelSean.add(s);
//        group.add(b);
//        panelSean.add(b);
//        group.add(t);
//        panelSean.add(t);
//        this.add(panelSean);
//
//
//        JPanel panelNb = new JPanel();
//        panelNb.setBounds(500,450,500,40);
//        panelNb.setBackground(Color.orange);
//        JLabel labelPlace = new JLabel("Saisir nombre de place(s) voulue(s) : ");
//        panelNb.add(labelPlace);
//        panelNb.add(labelSaisiePlaces);
//        ButtonSeance bouton = new ButtonSeance();
//        panelNb.add(bouton);
//        panelNb.add(l);
//        this.add(panelNb);

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