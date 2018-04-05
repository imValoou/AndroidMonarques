package m414.projet.monarchy.Objects;

public class Monarch {

    private String Nom;
    private String Date;
    private String Texte;
    private int Img;

    public Monarch(String nom, String date, String texte, int img) {
        Nom = nom;
        Date = date;
        Texte = texte;
        Img = img;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setImg(int img) {
        Img = img;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setTexte(String texte) {
        Texte = texte;
    }

    public String getNom() {
        return Nom;
    }

    public int getImg() {
        return Img;
    }

    public String getDate() {
        return Date;
    }

    public String getTexte() {
        return Texte;
    }
}
