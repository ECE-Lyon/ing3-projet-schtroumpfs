package Controleur;

import Modele.MemberCustomers;

import java.sql.*;
import java.util.ArrayList;

public class accueil {

    //methode pour verifier si l'identifiant et le mot de passe inscrits sont dans la base de donnees et sont raccordes
    public static boolean verifIdentification(String id, String password){
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./default")){
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM CLIENTS WHERE PSEUDO LIKE ?")) {
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()){
                    while (resultSet.next()){
                        return resultSet.getString("MDP").equals(password);
                    }
                }

            }
        } catch (SQLException exception) {
            System.out.println("IL Y A EU UNE ERREUR");
            exception.printStackTrace();
            return false;
        }
        return false;
    }

    //methode qui permettra de gerer la fidelite d'un client
    public static MemberCustomers recupFidelite(String id, String password){
        MemberCustomers.MemberType type = null;
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./default")){
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM CLIENTS WHERE PSEUDO LIKE ?")) {
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()){
                    while (resultSet.next()){
                        type = MemberCustomers.MemberType.valueOf(resultSet.getString("FIDELITE"));  //on doit changer le type de ce que l'on recupere dans la bdd pour pouvoir l'affecter
                    }
                }

            }
        } catch (SQLException exception) {
            System.out.println("IL Y A EU UNE ERREUR");
            exception.printStackTrace();
        }

        return new MemberCustomers(type);
    }

    //methode pour la connection en tant que staff du cinema pour ensuite pouvoir ajouter des films...
    private static Boolean verifStaff(String id, String password){
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./default")){
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM STAFF WHERE PSEUDO LIKE ?")) {
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()){
                    while (resultSet.next()){
                        return resultSet.getString("MDP").equals(password);
                    }
                }
            }
        } catch (SQLException exception) {
            System.out.println("IL Y A EU UNE ERREUR");
            exception.printStackTrace();
            return false;
        }
        return false;
    }

    //methode pour ajouter un film dans la bdd
    private static void ajoutFilmBdd(String nom, String type, String date, int duree){
        //faire deux champs pour la duree et operation pour avoir en min
        //nom de l'image c'est le titre + .jpg
        //type -> concatenation avec espace
    }




}
