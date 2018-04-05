package m414.projet.monarchy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import m414.projet.monarchy.Objects.ListQuizz;
import m414.projet.monarchy.R;

public class QuizzActivity extends AppCompatActivity {

    private int count=0;
    private RadioButton RB1;
    private RadioButton RB2;
    private RadioButton RB3;
    TextView Question;
    ListQuizz lq;
    private int score=0;

    public static final String SCORE="Position_Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizz_activity);

        lq = new ListQuizz(this);

        RB1=findViewById(R.id.RB1);
        RB2=findViewById(R.id.RB2);
        RB3=findViewById(R.id.RB3);

        Question=findViewById(R.id.Question);

        final Button button = findViewById(R.id.BQuizz);

        populate();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(anyChecked()) {
                    if (RB1.isChecked())
                        score = score + 20;
                    if (count < 2) {
                        count++;
                        populate();
                    } else {
                        Intent intent = new Intent(getApplicationContext(), ResActivity.class);
                        intent.putExtra(SCORE, score);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private void populate()
    {
        Question.setText(lq.getQuestions().get(count));
        RB1.setText(lq.getReponses().get(count));
        RB2.setText(lq.getInvalids().get(count).getInvalid().get(random(lq.getInvalids().get(count).getInvalid().size())));
        RB3.setText(lq.getInvalids().get(count).getInvalid().get(random(lq.getInvalids().get(count).getInvalid().size())));
    }

    private int random(int max)
    {
        return (int)Math.round(Math.random()*(max-1));
    }

    private boolean anyChecked(){
        if(RB1.isChecked() ||RB2.isChecked() || RB3.isChecked())
            return true;
        return false;
    }

    public void onRadioButtonClicked(View view) {
    }
}
