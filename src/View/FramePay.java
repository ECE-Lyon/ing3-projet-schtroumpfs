package View;

import Modele.Seance;

import javax.swing.*;
import java.awt.*;


import java.util.ArrayList;
import java.util.Locale;


import static Controleur.recherche.*;
import static Controleur.seance.recupSeances;


//--------------------------------------------------------------------------------------------------------------
public class FramePay extends JFrame {

    public static JTextArea selectionNbPlaces = new JTextArea("Nombre de places ?");

    public FramePay(String nomFilm) {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Choix séance :");
        this.setLayout(null);

        //ajout de la jaquete du film
        JPanel panelFilm = new JPanel();
        panelFilm.setBounds(0,0,150,400);
        panelFilm.setBackground(Color.PINK.darker());

        String imgAdr = "imagesFilms\\" + nomFilm + ".jpg";
        ImageIcon image = new ImageIcon(imgAdr);
        JLabel labelImage = new JLabel(image, JLabel.CENTER);
        panelFilm.add(labelImage);
        this.add(panelFilm);
        //fin



        //ajout partie supérieure avec des infos
        JPanel panelInfos = new JPanel();
        panelInfos.setBounds(150,0,250,400);
        panelInfos.setBackground(Color.ORANGE);
        panelInfos.setLayout(new GridLayout(3,1));

        JLabel labelTitre = new JLabel(nomFilm.toUpperCase(Locale.ROOT));

        ArrayList<String> listeInfos = recupInfoFilm(nomFilm);
        String genre = listeInfos.get(0);
        String[] listeGenre = genre.split(" ");
        int nbGenre = listeGenre.length;

        JPanel panelGenre = new JPanel();
        panelGenre.setBackground(Color.ORANGE);
        panelGenre.setLayout(new GridLayout(1+nbGenre/2,2));
        JLabel labelGenre = new JLabel("Genres du film : ");
        panelGenre.add(labelGenre);
        for (String s : listeGenre){
            JLabel g = new JLabel(s);
            panelGenre.add(g);
        }

        int nbHeures = Integer.parseInt(listeInfos.get(1)) / 60;
        int nbMin = Integer.parseInt(listeInfos.get(1)) % 60;
        String affDuree = nbHeures + "H " + nbMin + "min";
        JLabel labelDuree = new JLabel("Duree du film : " + affDuree);

        panelInfos.add(labelTitre);
        panelInfos.add(panelGenre);
        panelInfos.add(labelDuree);
        this.add(panelInfos);
        //Fin de la partie d'informations


        //Ajout de la partie conseil
        ArrayList<String> listeConseil = rechercheGenreFctTitre(listeGenre[0], nomFilm.toUpperCase(Locale.ROOT));

        JPanel panelSugg = new JPanel();
        panelSugg.setBounds(0, 400, 400, 50);
        panelSugg.setBackground(Color.PINK);
        panelSugg.add(new JLabel("Vous pourriez aussi aimé: "));
        this.add(panelSugg);

        JPanel panelConseil = new JPanel();
        panelConseil.setBackground(Color.ORANGE);
        panelConseil.setBounds(0, 450, 400, 350);
        panelConseil.setLayout(new GridLayout(2,2 ));
        //recuperation des jaquettes de films similaires
        if (listeConseil.size() < 4){
            for (String s : listeConseil) {
                String adresse = "imagesFilms\\" + s;
                ImageIcon filmConseil = new ImageIcon(adresse);
                JLabel labelFilmConseil = new JLabel(filmConseil, JLabel.CENTER);
                panelConseil.add(labelFilmConseil);
            }
        }
        else {
            for (int k = 0; k < 4; k++){
                String adresse = "imagesFilms\\" + listeConseil.get(k);
                ImageIcon filmConseil = new ImageIcon(adresse);
                JLabel labelFilmConseil = new JLabel(filmConseil, JLabel.CENTER);
                panelConseil.add(labelFilmConseil);
            }
        }
        this.add(panelConseil);

        //fin des conseils



        //Partie des séances
        ArrayList<Seance> listeSeances = recupSeances(nomFilm.toUpperCase(Locale.ROOT));
        int nbSeances = listeSeances.size();
        JPanel panelSeances = new JPanel();
        panelSeances.setBounds(400,0, 1200, 700);
        panelSeances.setBackground(Color.RED);

        if (nbSeances == 0){
            JLabel pasSeance = new JLabel("Désolé aucune séance n'est prévue pour ce film pour le moment");
            panelSeances.add(pasSeance);
        }
        else {
            GridLayout grille = new GridLayout(nbSeances, 4);
            panelSeances.setLayout(grille);

            ButtonGroup groupe = new ButtonGroup(); //ce groupe de boutons permet de ne pas selectionner plusieurs seances

            for (Seance s : listeSeances){
                JLabel salle = new JLabel("salle: " + s.getSalle());
                JLabel nbPlaces = new JLabel(s.getNbPlacesLibres() + " places libres");
                JLabel horaire = new JLabel("horaire: " + s.getHoraire());
                JRadioButton select = new JRadioButton("cette seance me convient");
                select.setBackground(Color.RED);

                groupe.add(select);

                panelSeances.add(salle);
                panelSeances.add(nbPlaces);
                panelSeances.add(horaire);
                panelSeances.add(select);
            }
        }

        this.add(panelSeances);
        //Fin partie des seances



        //partie de la selection du nombre de place et validation
        JLabel demandeNbPlaces = new JLabel("Combien de places voulez vous ?");
        demandeNbPlaces.setBounds(400, 700, 300, 100);
        selectionNbPlaces.setBounds(720, 700, 300, 100);
        selectionNbPlaces.setBackground(Color.CYAN);
        this.add(demandeNbPlaces);
        this.add(selectionNbPlaces);

        ButtonSeance validation = new ButtonSeance();
        validation.setBackground(Color.CYAN);
        validation.setBounds(1050, 700, 300, 100);
        this.add(validation);


    }

//---------------------------------------------------------------------------------------------------------------------
    //creation du bouton de validation qui affiche le prix a payer ou bien une correction a faire sur le nombre de places
    public static class ButtonSeance extends JButton {

        public ButtonSeance() {
            setText("Validation de la sélection");

            addActionListener(e -> {
                try {
                    int n = Integer.parseInt(selectionNbPlaces.getText());
                    if (n < 11 && n > 0) {
                        String prix = String.valueOf(9 * n);
                        JOptionPane.showMessageDialog(ButtonSeance.this, "Veuillez payer " + prix + "€");
                    } else {
                        JOptionPane.showMessageDialog(ButtonSeance.this, "Veuillez saisir un nombre de billets entre 1 et 10");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ButtonSeance.this, "Saisir un nombre SVP");
                }
            });
        }
    }
}