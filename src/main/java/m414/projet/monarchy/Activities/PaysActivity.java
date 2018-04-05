package m414.projet.monarchy.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import m414.projet.monarchy.Objects.ListPays;
import m414.projet.monarchy.Objects.Pays;
import m414.projet.monarchy.Adapters.PaysAdapter;
import m414.projet.monarchy.R;

public class PaysActivity extends AppCompatActivity implements PaysAdapter.PaysAdapterListener {

    public final static String PAYS_POS = "m414.projet.monarchy.pos-pays";
    private ListView lv;
    private Button quizz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_pays);

        ListPays mListP= ListPays.getInstance();
        mListP.build(this);

        quizz=findViewById(R.id.Quizz);

        final PaysAdapter adapter = new PaysAdapter(this, mListP);

        lv = findViewById(R.id.PaysLv);

        lv.setAdapter(adapter);

        adapter.addListener(this);

        quizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PaysActivity.this, "Quizz Lancé", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getApplicationContext(), QuizzActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClickNom(Pays item, int position) {
        Intent intent = new Intent(this.getApplicationContext(), MonarchActivity.class);
        intent.putExtra(PAYS_POS,position);
        startActivity(intent);
    }
}
