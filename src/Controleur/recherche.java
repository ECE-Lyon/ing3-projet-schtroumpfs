package Controleur;

import java.sql.*;
import java.util.ArrayList;

public class recherche {
    //methode pour recuperer l'ensemble des films pour les afficher ensuite (autre methode dans vue)
    public ArrayList<String> recupAllFilms(){
        ArrayList<String> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./default")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT IMAGE FROM FILMS")) {
                    while (resultSet.next()) {
                        String result = resultSet.getString("IMAGE");
                        list.add(result);
                    }
                }

            }
        } catch (SQLException exception) {
            System.out.println("IL Y A EU UNE ERREUR");
            exception.printStackTrace();
        }
        return list;
    }


    //recherche pour les films sur le genre
    public ArrayList<String> rechercheGenre(String genre){
        ArrayList<String> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./default")){
            try (PreparedStatement statement = connection.prepareStatement("SELECT IMAGE FROM FILMS WHERE GENRE CONTAINS ?")) {
                statement.setString(1, genre);
                try (ResultSet resultSet = statement.executeQuery()){
                    while (resultSet.next()){
                        String result = resultSet.getString("IMAGE");
                        list.add(result);
                    }
                }

            }
        } catch (SQLException exception) {
            System.out.println("IL Y A EU UNE ERREUR");
            exception.printStackTrace();
        }
        return list;
    }

    //recherche pour les films sur la duree
    public ArrayList<String> rechercheDuree(int time){
        ArrayList<String> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./default")){
            try (PreparedStatement statement = connection.prepareStatement("SELECT IMAGE FROM FILMS WHERE DUREE <= ?")) {
                statement.setInt(1, time);
                try (ResultSet resultSet = statement.executeQuery()){
                    while (resultSet.next()){
                        String result = resultSet.getString("IMAGE");
                        list.add(result);
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
