package m414.projet.monarchy.Objects;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ListQuizz {
    private ArrayList<String> Questions;
    private ArrayList<String> Reponses;
    private ArrayList<Invalid> Invalids;

    public ListQuizz(Context context){
        build(context);
    }

    private void build(Context context){
        Questions=new ArrayList<>();
        Reponses=new ArrayList<>();
        Invalids =new ArrayList<>();
        try {
            // Récupération du fichier json

            JSONArray jsonArray = new JSONArray(getJSONFromAsset(context));

            // Récupération des recettes
            for(int i = 0; i < jsonArray.length(); i++) {
                getQuizzFromJSONObject(i,jsonArray.getJSONObject(i),context);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getQuizzFromJSONObject(int pos, JSONObject jsonObject, Context context) throws JSONException {

        //Question
        Questions.add(jsonObject.getString("Question"));

        // Rep
        Reponses.add(jsonObject.getString("Reponse"));

        ArrayList<String> inv = new ArrayList<>();
        for(int i = 0; i < jsonObject.getJSONArray("Autre").length(); i++) {
            inv.add(jsonObject.getJSONArray("Autre").getJSONObject(i).getString("String"));
        }
        Invalids.add(new Invalid(inv));
    }


    //lecture du fichier en string
    private  String getJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("Quizz.json");
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

    public ArrayList<String> getQuestions() {
        return Questions;
    }

    public ArrayList<String> getReponses() {
        return Reponses;
    }

    public ArrayList<Invalid> getInvalids() {
        return Invalids;
    }
}
