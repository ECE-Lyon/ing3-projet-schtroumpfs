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
        panelIm.setBounds(0,0,1600,500);
        panelIm.setBackground(Color.RED);

        for (String nomImage : jaquettes){
            String imgAdr = "imagesFilms\\" + nomImage;
            ImageIcon image = new ImageIcon(imgAdr);
            JLabel label = new JLabel(image, JLabel.CENTER);
            panelIm.add(label);
        }
        this.add(panelIm);

        JPanel panelBout = new JPanel();
        panelBout.setBounds(500,450,360,40);
        panelBout.setBackground(Color.orange);
        ButtonFilm bouton = new ButtonFilm();
        ButtonGroup group = new ButtonGroup();
        JRadioButton s = new JRadioButton("Super-Man");
        JRadioButton b = new JRadioButton("Batman");
        JRadioButton t = new JRadioButton("Titanic");
        group.add(s);
        panelBout.add(s);
        group.add(b);
        panelBout.add(b);
        group.add(t);
        panelBout.add(t);
        ButtonFilm boutonFilm = new ButtonFilm();
        panelBout.add(boutonFilm);
        this.add(panelBout);

    }

    //-----------------------------------------------------------------------------------------------------------------
    public static class ButtonFilm extends JButton {

        public ButtonFilm(){
            setText("Valider");
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    FramePay f3 = new FramePay();
                    f3.setVisible(true);


                }
            });

        }

    }
}




