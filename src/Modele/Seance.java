package Modele;

public class Seance {
    // ATTRIBUTS ET CONSTRUCTEUR xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
    private String horaire;
    private int nbPlacesLibres;
    private String date;

    // GETTER ET SETTER xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public int getNbPlacesLibres() {
        return nbPlacesLibres;
    }

    public void setNbPlacesLibres(int nbPlacesLibres) {
        this.nbPlacesLibres = nbPlacesLibres;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
