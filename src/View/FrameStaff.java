package View;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

class FrameStaff extends JFrame {

    public static final int largeur=300;
    public static JTextField t4=new JTextField("           ");

    //frame qui permet d'ajouter un nouveau film
    public FrameStaff(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Ajout film :");
        this.setSize(1200, 800);
        this.setLayout(null);

        //demande du nom de film
        JPanel panel1 = new JPanel();
        panel1.setBounds(600,100,largeur,60);
        panel1.setBackground(Color.RED);
        JLabel label1 = new JLabel("Nom du film : ");
        panel1.add(label1);
        JTextField t1=new JTextField("              ");
        panel1.add(t1);
        this.add(panel1);

        //demande de la duree
        JPanel panel2 = new JPanel();
        panel2.setBounds(600,161,largeur,60);
        panel2.setBackground(Color.RED);
        JLabel label2 = new JLabel("Durée (en min) : ");
        panel2.add(label2);
        JTextField t2=new JTextField("      ");
        panel2.add(t2);
        this.add(panel2);

        //demande de la date de sortie
        JPanel panel3 = new JPanel();
        panel3.setBounds(600,282,largeur,60);
        panel3.setBackground(Color.RED);
        JLabel label3 = new JLabel("Date de sortie : ");
        panel3.add(label3);
        JTextField t3 = new JTextField("AAAA/MM/JJ");
        panel3.add(t3);
        this.add(panel3);

        //demande des genres
        JPanel panel4 = new JPanel();
        panel4.setBounds(600,222,largeur,60);
        panel4.setBackground(Color.RED);
        JLabel label4 = new JLabel("Genre.s : ");
        panel4.add(label4);
        panel4.add(t4);
        this.add(panel4);

        //ajout du bouton de fin d'ajout
        JPanel panel5 = new JPanel();
        panel5.setBounds(600,342,largeur,40);
        panel5.setBackground(Color.BLACK);
        ButtonAdd bAdd= new ButtonAdd();
        panel5.add(bAdd);
        this.add(panel5);

    }

    public static class ButtonAdd extends JButton {

        public ButtonAdd() {

            setText("Ajouter");
            addActionListener(e -> {
                boolean test = true;
                String listeGenre = "ANIMATION ACTION SF THRILLER HORREUR AVENTURE FAMILLE FANTASTIQUE";
                String[] listeTeste = FrameStaff.t4.getText().split(" ");
                for (String genre : listeTeste){
                    if (! listeGenre.contains(genre.toUpperCase(Locale.ROOT))){
                        JOptionPane.showMessageDialog(ButtonAdd.this, "Choisir un ou plusieurs genre.s parmis : ANIMATION, ACTION, SF, THRILLER, HORREUR, AVENTURE, FAMILLE, FANTASTIQUE");
                        test = false;
                        break;
                    }
                }
                if (test){
                    JOptionPane.showMessageDialog(ButtonAdd.this, "Film ajouté");
                    //il manque juste ajoutFilmBdd de la partie controleur accueil (non code)
                }
            });
        }


    }

}
