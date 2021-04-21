

public class Film {

    // ATTRIBUTS ET CONSTRUCTEUR xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    private String nom;
    public int nbPlaces;
    public String dateSortie;
    public String heure;


    public enum GenreFilm{FAMILY, ACTION,
    }

    GenreFilm genreFilm;

    public Film(){
    }

    public String getNom() {
        return nom;
    }

    // GETTER ET SETTER xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
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

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}





