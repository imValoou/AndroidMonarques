package m414.projet.monarchy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    private TextView Question;
    private ListQuizz lq;
    private int score=0;

    private Animation AnimFondu;
    private Animation AnimReap;

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

        AnimFondu = AnimationUtils.loadAnimation(this, R.anim.fondu);
        AnimFondu.setDuration(500);
        AnimReap = AnimationUtils.loadAnimation(this, R.anim.reap);
        AnimReap.setDuration(500);

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
                        Question.startAnimation(AnimFondu);
                        RB1.startAnimation(AnimFondu);
                        RB2.startAnimation(AnimFondu);
                        RB3.startAnimation(AnimFondu);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Question.startAnimation(AnimReap);
                        RB1.startAnimation(AnimReap);
                        RB2.startAnimation(AnimReap);
                        RB3.startAnimation(AnimReap);
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
