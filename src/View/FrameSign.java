package View;

import Controleur.accueil;
import Modele.MemberCustomers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


//--------------------------------------------------------------------------------------------------------------
public class FrameSign extends JFrame {

    public static JPasswordField passwordField = new JPasswordField("Password");
    public static TextField loginField = new TextField("NomUtilisateur");
    public static JPasswordField nouveauMdpField = new JPasswordField("MDP");
    public static TextField nouveauIDField = new TextField("Pseudo");
    public static TextField nouveauFideliteField = new TextField("Fidelite");


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

        //partie pour se creer un compte
        JPanel panelNew = new JPanel();
        panelNew.setLayout(new GridLayout(5,1));
        panelNew.setBounds(600, 400, 300, 200);
        panelNew.setBackground(Color.MAGENTA);
        JLabel labelCreation = new JLabel("creation de compte : ");
        panelNew.add(labelCreation);
        panelNew.add(nouveauMdpField);
        panelNew.add(nouveauIDField);
        panelNew.add(nouveauFideliteField);
        ButtonNew nouveau = new ButtonNew(nouveauIDField.getText(), nouveauIDField.getText(), nouveauFideliteField.getText());
        nouveau.setSize(300,40);
        panelNew.add(nouveau);
        this.add(panelNew);

        //on ajoute maintenant des boutons pour passer à la page suivante, on fait une grille pour les memes raisons
        JPanel panelBouton = new JPanel();
        panelBouton.setLayout(new GridLayout(2,1));
        panelBouton.setBounds(600,220,300,100);
        panelBouton.setBackground(Color.BLACK);

        ButtonConnec conn = new ButtonConnec(loginField.getText(), passwordField.getUIClassID());
        panelBouton.add(conn);

        ButtonSans sans = new ButtonSans();
        panelBouton.add(sans);



        this.add(panelBouton);

    }

//----------------------------------------------------------------------------------------------------------------------------------------------------

    //bouton pour verifier la connexion (test id et password)
    public static class ButtonConnec extends JButton {

        public ButtonConnec(String id, String password){
            setText("Se connecter");
            addActionListener(e -> {
                if(accueil.verifIdentification(FrameSign.loginField.getText(), FrameSign.passwordField.getText())){
                    FrameFilm f2 = new FrameFilm();
                    f2.setVisible(true);
                    MemberCustomers client = accueil.recupFidelite(id, password);
                }

                else{
                    JOptionPane.showMessageDialog(ButtonConnec.this, "Erreur de mot de passe ou d'identifiant");
                }
            });
        }
    }

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //bouton pour acceder aux films sans se connecter
    public static class ButtonSans extends JButton {

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
    public static class ButtonNew extends JButton{
        public ButtonNew(String pseudo, String mdp, String fidelite){
            setText("Créer un nouveau compte");
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    try (Connection connection = DriverManager.getConnection("jdbc:h2:./default")) {
                        try (Statement statement = connection.createStatement()) {
                            int resultSet = statement.executeUpdate("INSERT INTO CLIENTS VALUES (pseudo, mdp, fidelite)");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                    catch (SQLException exception) {
                        System.out.println("IL Y A EU UNE ERREUR");
                        exception.printStackTrace();
                }
                    FrameFilm f2 = new FrameFilm();
                    f2.setVisible(true);
                };
            });
        }
}

//------------------------------------------------------------------------------------------------------------------------------------



    public static void main(String[] args) {


        FrameSign f = new FrameSign();
        f.setVisible(true);


    }

}
