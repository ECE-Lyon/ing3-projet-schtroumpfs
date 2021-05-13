package View;

import Controleur.accueil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;




//--------------------------------------------------------------------------------------------------------------
public class FrameSign extends JFrame {

    public static JPasswordField passwordField = new JPasswordField("Password");
    public static TextField loginField = new TextField("NomUtilisateur");

    //page d'accueil pour se connecter ou non
    public FrameSign() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Connection :");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);


        JPanel panelId = new JPanel();
        panelId.setLayout(new GridLayout(2,1));     //On fait une grille pour aligner les deux champs
        panelId.setBounds(600,100,300,100);
        panelId.setBackground(Color.CYAN);

        //premier champs
        JLabel label1 = new JLabel("Identifiant : ");
        panelId.add(label1);
        panelId.add(loginField);

        //deuxieme champs
        JLabel label2 = new JLabel("Mot de passe : ");
        panelId.add(label2);
        panelId.add(passwordField);

        //ajout des deux champs
        this.add(panelId);

        //on ajoute maintenant des boutons pour passer à la page suivante, on fait une grille pour les memes raisons
        JPanel panelBouton = new JPanel();
        panelBouton.setLayout(new GridLayout(2,1));
        panelBouton.setBounds(600,220,300,100);
        panelBouton.setBackground(Color.BLACK);
        ButtonConnec conn = new ButtonConnec();
        panelBouton.add(conn);
        ButtonSans sans = new ButtonSans();
        panelBouton.add(sans);
        panelBouton.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        this.add(panelBouton);





    }

//----------------------------------------------------------------------------------------------------------------------------------------------------

    //bouton pour verifier la connexion (test id et password)
    public class ButtonConnec extends JButton {

        public ButtonConnec(){
            setText("Se connecter");
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if(accueil.verifIdentification(FrameSign.loginField.getText(), FrameSign.passwordField.getText())){
                        FrameFilm f2 = new FrameFilm();
                        f2.setVisible(true);;}

                    else{JOptionPane.showMessageDialog(ButtonConnec.this, "Erreur de mot de passe ou d'identifiant"); }

                }
            });

        }

    }

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //bouton pour acceder aux films sans se connecter
    public class ButtonSans extends JButton {

        public ButtonSans(){
            setText("Continuer sans se connecter");
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    FrameFilm f2 = new FrameFilm();
                    f2.setVisible(true);

                }
            });

        }

    }


//------------------------------------------------------------------------------------------------------------------------------------





    public static void main(String[] args) {


        FrameSign f = new FrameSign();
        f.setVisible(true);


    }

}
