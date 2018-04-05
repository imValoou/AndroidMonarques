package m414.projet.monarchy.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import m414.projet.monarchy.Objects.ListPays;
import m414.projet.monarchy.Objects.Monarch;
import m414.projet.monarchy.R;

import static m414.projet.monarchy.Activities.MonarchActivity.POS_PAYS;

public class MonarchFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param";

    // TODO: Rename and change types of parameters
    private Monarch Roi;
    private int position;

    public MonarchFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MonarchFragment newInstance(int position) {
        MonarchFragment fragment = new MonarchFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getArguments() != null) {
            position = getArguments().getInt(ARG_PARAM1);
            Roi = ListPays.getInstance().get(POS_PAYS).getRois().get(position);
        }
        View rootView = inflater.inflate(R.layout.monarch_layout, container, false);

        // Inflate the layout for this fragment
        // (2) : Récupération des TextView de notre layout
        TextView tvNom = (TextView) rootView.findViewById(R.id.NomRoi);
        TextView tvDate = (TextView) rootView.findViewById(R.id.DateRoi);
        TextView tvTexte = (TextView) rootView.findViewById(R.id.TexteRoi);
        ImageView image = (ImageView) rootView.findViewById(R.id.ImgRoi);


        //(3) : Renseignement des valeurs
        tvNom.setText(Roi.getNom());
        tvDate.setText(Roi.getDate());
        tvTexte.setText(Roi.getTexte());
        image.setImageResource(Roi.getImg());

        return rootView;
    }
}