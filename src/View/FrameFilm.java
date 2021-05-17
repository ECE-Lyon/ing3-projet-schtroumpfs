package View;

import Controleur.recherche;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


//----------------------------------------------------------------------------------------------------------------------------------------

public class FrameFilm extends JFrame {



    FrameFilm() {

        this.setTitle("Choisir le film :");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);

        ArrayList<String> jaquettes = recherche.recupAllFilms();


        JPanel panelIm = new JPanel();
        panelIm.setBounds(-20,0,1600,400);
        panelIm.setBackground(Color.RED);

        JPanel panelBout = new JPanel();
        panelBout.setBounds(0,400,1600,400);
        panelBout.setBackground(Color.orange);
        ButtonGroup group = new ButtonGroup();

        for (String nomImage : jaquettes){
            String imgAdr = "imagesFilms\\" + nomImage;
            ImageIcon image = new ImageIcon(imgAdr);
            JLabel label = new JLabel(image, JLabel.CENTER);
            panelIm.add(label);

            ButtonFilm b = new ButtonFilm(nomImage.split("\\.")[0]);  //ajout des boutons dont le nom est le titre recupéré dans la base de donnée
            group.add(b);
            panelBout.add(b);
        }

        this.add(panelIm);
        //ButtonFilm boutonFilm = new ButtonFilm();
        //panelBout.add(boutonFilm);
        this.add(panelBout);

    }

    //-----------------------------------------------------------------------------------------------------------------
    public static class ButtonFilm extends JButton {

        public ButtonFilm(String nomFilm){
            setText(nomFilm);
            addActionListener(e -> {
                String film = e.getActionCommand();
                FramePay f3 = new FramePay(film);
                f3.setVisible(true);

            });

        }

    }
}




