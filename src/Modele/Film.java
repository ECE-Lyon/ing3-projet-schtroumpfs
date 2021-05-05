package Modele;

public class Film {

    // ATTRIBUTS ET CONSTRUCTEUR xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    private String nom;
    public String dateSortie;


    public enum GenreFilm {
        FAMILY, ACTION, COMEDY
    }

    private GenreFilm genreFilm;
    private Seance seance;
    public Film() {
    }


    // GETTER ET SETTER xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public GenreFilm getGenreFilm() {
        return genreFilm;
    }

    public void setGenreFilm(GenreFilm genreFilm) {
        this.genreFilm = genreFilm;
    }
}







