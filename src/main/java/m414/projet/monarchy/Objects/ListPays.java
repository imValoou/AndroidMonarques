package m414.projet.monarchy.Objects;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import m414.projet.monarchy.Activities.PaysActivity;

public class ListPays {

    private ArrayList<Pays> list;

    private ListPays() {
        list=new ArrayList<>();
    }

    public Pays get(int position) {
        return list.get(position);
    }

    public int size() {
        return list.size();
    }

    public void build(Context context) {
        // Création de la liste des diplome
        list=new ArrayList<>();
        try {
            // Récupération du fichier json

            JSONArray jsonArray = new JSONArray(getJSONFromAsset(context));

            // Récupération des recettes
            for(int i = 0; i < jsonArray.length(); i++) {
                list.add(getPaysFromJSONObject(jsonArray.getJSONObject(i),context));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /** Holder */
    private static class SingletonHolder
    {
        /** Instance unique non préinitialisée */
        private final static ListPays instance = new ListPays();
    }

    /** Point d'accès pour l'instance unique du singleton */
    public static ListPays getInstance()
    {
        return ListPays.SingletonHolder.instance;
    }

// fonction pour récuperer un diplome

    private Pays getPaysFromJSONObject(JSONObject jsonObject,Context context) throws JSONException {

        //nom
        String nom = jsonObject.getString("Pays");

        // img
        String nomImg = jsonObject.getString("Img");
        int img= context.getResources().getIdentifier(nomImg, "mipmap",  context.getPackageName());

        ArrayList<Monarch> Rois = new ArrayList<>();
        for(int i = 0; i < jsonObject.getJSONArray("Roi").length(); i++) {
            Monarch r;
            String rNom=jsonObject.getJSONArray("Roi").getJSONObject(i).getString("nom");
            String rDate=jsonObject.getJSONArray("Roi").getJSONObject(i).getString("date");
            String rHf=jsonObject.getJSONArray("Roi").getJSONObject(i).getString("hf");
            String rImg=jsonObject.getJSONArray("Roi").getJSONObject(i).getString("img");
            int iRImg=context.getResources().getIdentifier(rImg, "mipmap", context.getPackageName());
            r=new Monarch(rNom, rDate, rHf, iRImg);
            Rois.add(r);
        }

        return new Pays(nom, img, Rois);
    }


    //lecture du fichier en string
    private  String getJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("Rois.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        Toast.makeText(context,json,Toast.LENGTH_LONG);
        return json;
    }
}