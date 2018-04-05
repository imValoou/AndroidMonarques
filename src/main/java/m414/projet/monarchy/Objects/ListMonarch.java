package m414.projet.monarchy.Objects;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by florian on 16/03/18.
 */

public class ListMonarch {

    private ArrayList<Monarch> list;

    public ListMonarch(ArrayList<Monarch> rois)
    {
        list=new ArrayList<>();
        list=rois;
    }

    public Monarch get(int position) {
        return list.get(position);
    }

    public int size() {
        return list.size();
    }
}
