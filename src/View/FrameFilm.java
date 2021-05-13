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
        this.setSize(1200, 800);
        this.setLayout(null);

        ArrayList<String> jaquettes = recherche.recupAllFilms();


        JPanel panelIm = new JPanel();
        panelIm.setBounds(350,0,900,400);
        panelIm.setBackground(Color.CYAN);

        for (String nomImage : jaquettes){
            String imgAdr = "imagesFilms\\" + nomImage;
            ImageIcon image = new ImageIcon(imgAdr);
            JLabel label = new JLabel(image, JLabel.CENTER);
            panelIm.add(label);
        }
        this.add(panelIm);


        /*JLabel label1 = new JLabel(im1, JLabel.CENTER);
        panelIm.add(label1);
        JLabel label2 = new JLabel(im2, JLabel.CENTER);
        panelIm.add(label2);
        JLabel label3 = new JLabel(im3, JLabel.CENTER);
        panelIm.add(label3);
        this.add(panelIm);

         */

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
    public class ButtonFilm extends JButton {

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




