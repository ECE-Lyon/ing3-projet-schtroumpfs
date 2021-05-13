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
        this.setSize(1200, 800);
        this.setLayout(null);

        JPanel panelId = new JPanel();
        panelId.setBounds(400,100,300,50);
        panelId.setBackground(Color.CYAN);
        JLabel label1 = new JLabel("Identifiant : ");
        panelId.add(label1);
        panelId.add(loginField);
        this.add(panelId);

        JPanel panelMdp = new JPanel();
        panelMdp.setBounds(710,100,300,50);
        panelMdp.setBackground(Color.CYAN);
        JLabel label2 = new JLabel("Mot de passe : ");
        panelMdp.add(label2);
        panelMdp.add(passwordField);
        this.add(panelMdp);

        JPanel panelBouton = new JPanel();
        panelBouton.setBounds(500,270,360,40);
        panelBouton.setBackground(Color.BLACK);
        ButtonConnec conn = new ButtonConnec();
        panelBouton.add(conn);
        ButtonSans sans = new ButtonSans();
        panelBouton.add(sans);
        this.add(panelBouton);





    }

//----------------------------------------------------------------------------------------------------------------------------------------------------

    //bouton pour verifier la connexion (test id et password)
    public class ButtonConnec extends JButton {

        public ButtonConnec(){
            setText("Connection");
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
                    f2.setVisible(true);;

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
