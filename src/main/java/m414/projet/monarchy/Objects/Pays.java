package m414.projet.monarchy.Objects;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pays {

    private String Nom;
    private int Img;
    private ArrayList<Monarch> Rois=new ArrayList<>();

    public Pays(String nom, int img, ArrayList<Monarch> rois) {
        Nom = nom;
        Img = img;
        Rois = rois;
    }

    public ArrayList<Monarch> getRois() {
        return Rois;
    }

    public int getImg() {
        return Img;
    }

    public String getNom() {
        return Nom;
    }

    public void setImg(int img) {
        Img = img;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setRois(ArrayList<Monarch> rois) {
        Rois = rois;
    }
}
