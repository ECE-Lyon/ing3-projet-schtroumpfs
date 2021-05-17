package Controleur;

import Modele.Seance;

import java.sql.*;
import java.util.ArrayList;

public class seance {
    public static ArrayList<Seance> recupSeances(String nomFilm){
        ArrayList<Seance> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./default")){
            try (PreparedStatement statement = connection.prepareStatement("SELECT SALLE, PLACES, HORAIRE FROM SEANCES JOIN FILMS ON ID_FILMS = ID WHERE TITRE LIKE ?")) {
                statement.setString(1, nomFilm);
                try (ResultSet resultSet = statement.executeQuery()){
                    while (resultSet.next()){
                        Seance seance = new Seance(resultSet.getInt("SALLE"), resultSet.getInt("PLACES"), resultSet.getString("HORAIRE"));
                        list.add(seance);
                    }
                }

            }
        } catch (SQLException exception) {
            System.out.println("IL Y A EU UNE ERREUR");
            exception.printStackTrace();
        }
        return list;
    }
}
