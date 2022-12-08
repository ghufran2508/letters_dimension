package com.example.kids_sgr_learn;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    String [] skyLetter = {"d","h","l","k","t","b","f"};
    String [] grassLetter = {"a","c","e","i","m","n","o","r","s","u","v","w","x","z"};
    String [] rootLetter = {"g","j","p","q","y"};

    TextView displayQuestion;
    Button skyBtn, grassBtn, rootBtn, reloadBtn;
    TextView STC, STW, GTC, GTW, RTC, RTW;
    TextView textViewAnswer;
    int skCo = 0, skWr = 0, grCo = 0, grWr = 0, roCo = 0, roWr = 0;
    String answer = "";
    boolean marked = false;
    int rowA,indexA = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayQuestion = findViewById(R.id.txtQuestion);
        skyBtn = findViewById(R.id.skybtn);
        skyBtn.setOnClickListener(this);
        grassBtn = findViewById(R.id.grassbtn);
        grassBtn.setOnClickListener(this);
        rootBtn = findViewById(R.id.rootbtn);
        rootBtn.setOnClickListener(this);
        reloadBtn = findViewById(R.id.reloadBtn);

        textViewAnswer = findViewById(R.id.TextViewAnswer);

        STC = findViewById(R.id.skyTextCorrect);
        STW = findViewById(R.id.skyTextWrong);

        GTC = findViewById(R.id.grassTextCorrect);
        GTW = findViewById(R.id.grassTextWrong);

        RTC = findViewById(R.id.rootTextCorrect);
        RTW = findViewById(R.id.rootTextWrong);

        generateRandomCharacter();

        reloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(marked == true)
                    generateRandomCharacter();
            }
        });


    }

    private void generateRandomCharacter()
    {
        Random rand = new Random();
        int rnd = rand.nextInt(3);
        int index = 0;

        if(rnd == 0)
        {
            index = rand.nextInt(skyLetter.length);
            if(rowA == rnd && indexA == index)
            {
                while(indexA == index)
                {
                    index = rand.nextInt(skyLetter.length);
                }
            }

            displayQuestion.setText(skyLetter[index]);
            answer = "SKY";
        }
        else if(rnd == 1)
        {
            index = rand.nextInt(grassLetter.length);
            if(rowA == rnd && indexA == index)
            {
                while(indexA == index)
                {
                    index = rand.nextInt(grassLetter.length);
                }
            }

            displayQuestion.setText(grassLetter[index]);
            answer = "GRASS";
        }
        else
        {
            index = rand.nextInt(rootLetter.length);
            if(rowA == rnd && indexA == index)
            {
                while(indexA == index)
                {
                    index = rand.nextInt(rootLetter.length);
                }
            }

            displayQuestion.setText(rootLetter[index]);
            answer = "ROOT";
        }

        marked = false;
        rowA = rnd;
        indexA = index;
    }


    @Override
    public void onClick(View view) {
        if(marked == true) return;
        marked = true;
        switch(view.getId())
        {
            case R.id.skybtn:
                if(answer == "SKY")
                {
                    skCo++;
                    textViewAnswer.setText("GREAT");
                    textViewAnswer.setBackgroundColor(getResources().getColor(R.color.purple_200));
                    STC.setText(Integer.toString(skCo));
                }
                else
                {
                    skWr++;
                    textViewAnswer.setText("OOPS");
                    textViewAnswer.setBackgroundColor(getResources().getColor(R.color.teal_700));
                    STW.setText(Integer.toString(skWr));
                }
                break;
            case R.id.grassbtn:
                if(answer == "GRASS")
                {
                    grCo++;
                    textViewAnswer.setText("GREAT");
                    textViewAnswer.setBackgroundColor(getResources().getColor(R.color.purple_200));
                    GTC.setText(Integer.toString(grCo));
                }
                else
                {
                    grWr++;
                    textViewAnswer.setText("OOPS");
                    textViewAnswer.setBackgroundColor(getResources().getColor(R.color.teal_700));
                    GTW.setText(Integer.toString(grWr));
                }
                break;
            case R.id.rootbtn:
                if(answer == "ROOT")
                {
                    roCo++;
                    textViewAnswer.setText("GREAT");
                    textViewAnswer.setBackgroundColor(getResources().getColor(R.color.purple_200));
                    RTC.setText(Integer.toString(roCo));
                }
                else
                {
                    roWr++;
                    textViewAnswer.setText("OOPS");
                    textViewAnswer.setBackgroundColor(getResources().getColor(R.color.teal_700));
                    RTW.setText(Integer.toString(roWr));
                }
                break;
            default:
                break;
        }
    }
}