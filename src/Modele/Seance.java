package Modele;

public class Seance {
    // ATTRIBUTS ET CONSTRUCTEUR xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
    private String horaire;
    private int nbPlacesLibres;
    private String date;
    private int salle;


    public Seance(int salle, int placesLibres, String horaires){
        this.salle = salle;
        this.nbPlacesLibres = placesLibres;
        this.horaire = horaires;
    }

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

    public int getSalle() {
        return salle;
    }

    public void setSalle(int salle) {
        this.salle = salle;
    }
}
