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
    public static JPasswordField nouveauMdpField = new JPasswordField("");
    public static TextField nouveauIDField = new TextField("");
    public static TextField nouveauFideliteField = new TextField("");
    public static JPasswordField staffMDP = new JPasswordField("Password");
    public static TextField staffID = new TextField("NomUtilisateur");


    //page d'accueil pour se connecter ou non
    public FrameSign() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Connection :");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);

        //Partie client
        //partie se connecter ou non
        JPanel panelId = new JPanel();
        panelId.setLayout(new GridLayout(2,1));     //On fait une grille pour aligner les deux champs
        panelId.setBounds(400,100,300,100);
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
        panelBouton.setBounds(400,220,300,100);
        panelBouton.setBackground(Color.BLACK);

        ButtonConnec conn = new ButtonConnec(loginField.getText(), passwordField.getUIClassID());
        panelBouton.add(conn);

        ButtonSans sans = new ButtonSans();
        panelBouton.add(sans);
        this.add(panelBouton);

        //partie pour se creer un compte
        JPanel panelNew = new JPanel();
        panelNew.setLayout(new GridLayout(5,2));
        panelNew.setBounds(400, 400, 300, 200);
        panelNew.setBackground(Color.MAGENTA);

        JLabel labelCreation = new JLabel("Création de compte : ");
        panelNew.add(labelCreation);
        panelNew.add(new JLabel(" "));
        panelNew.add(new JLabel("Identifiant: "));
        panelNew.add(nouveauIDField);
        panelNew.add(new JLabel("mot de passe: "));
        panelNew.add(nouveauMdpField);
        panelNew.add(new JLabel("Fidelite: "));
        panelNew.add(nouveauFideliteField);
        ButtonNew nouveau = new ButtonNew(nouveauIDField.getText(), nouveauIDField.getText(), nouveauFideliteField.getText());
        nouveau.setSize(300,40);
        panelNew.add(nouveau);
        this.add(panelNew);

        //FIN partie client

        //partie staff connection (pas de creation de compte de staff)
        JPanel panelTitre = new JPanel();
        JLabel labelTitre = new JLabel("Connection STAFF");
        panelTitre.setBounds(1000, 350, 300, 50);
        panelTitre.setBackground(Color.PINK);
        panelTitre.add(labelTitre);
        this.add(panelTitre);

        JPanel connectStaff = new JPanel();
        connectStaff.setBounds(1000, 400, 300, 100);
        connectStaff.setLayout(new GridLayout(2,2));
        connectStaff.setBackground(Color.PINK);

        connectStaff.add(new JLabel("Identifiant: "));
        connectStaff.add(staffID);
        connectStaff.add(new JLabel("Mot de passe: "));
        connectStaff.add(staffMDP);

        this.add(connectStaff);

        ButtonStaff staffConnect = new ButtonStaff();
        staffConnect.setBounds(1000, 500, 300, 50);
        this.add(staffConnect);

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
                    MemberCustomers client = accueil.recupFidelite(id);
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
            addActionListener(e -> {
                FrameFilm f2 = new FrameFilm();
                f2.setVisible(true);
            });
        }
    }


//------------------------------------------------------------------------------------------------------------------------------------
    public static class ButtonNew extends JButton {
    public ButtonNew(String pseudo, String mdp, String fidelite) {
        setText("Créer un nouveau compte");
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection connection = DriverManager.getConnection("jdbc:h2:./default")) {
                    try (Statement statement = connection.createStatement()) {
                        PreparedStatement prestatement = connection.prepareStatement("INSERT INTO CLIENTS VALUES (?, ?, ?)");
                        prestatement.setString(1, pseudo);
                        prestatement.setString(2, mdp);
                        prestatement.setString(3, fidelite);
                        int result = statement.executeUpdate(String.valueOf(prestatement));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } catch (SQLException exception) {
                    System.out.println("IL Y A EU UNE ERREUR");
                    exception.printStackTrace();
                }
                FrameFilm f2 = new FrameFilm();
                f2.setVisible(true);
            }
        });
    }
}

//------------------------------------------------------------------------------------------------------------------------------------
//verification de la connection du staff
    public static class ButtonStaff extends JButton {
        public ButtonStaff() {
            setText("Connection du Staff");
            addActionListener(e -> {
                if (accueil.verifStaff(FrameSign.staffID.getText(), FrameSign.staffMDP.getText())) {
                    FrameStaff f3 = new FrameStaff();
                    f3.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(ButtonStaff.this, "Erreur de mot de passe ou d'identifiant");
                }
            }
            );
        }
    }

}
