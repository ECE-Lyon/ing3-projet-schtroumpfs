package Controleur;

import java.sql.*;

public class accueil {
    public boolean verifIdentification(String id, String pasword){
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./default")){
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM CLIENTS WHERE PSEUDO LIKE id")) {
                try (ResultSet resultSet = statement.executeQuery()){
                    while (resultSet.next()){
                        String nom_album = resultSet.getString("TITLE");
                        System.out.println(nom_album);
                    }
                }

            }
        } catch (SQLException exception) {
            System.out.println("IL Y A EU UNE ERREUR");
            exception.printStackTrace();
        }
        return false;
    }
}
