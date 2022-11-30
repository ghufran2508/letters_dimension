package com.example.kids_sgr_learn;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final char[] grassLetters = {'a', 'c', 'e', 'w', 'u', 'o', 's', 'z', 'x', 'v', 'n', 'm'};
//    public char[] rootLetters = {'y', 'p', 'g', };

    TextView displayQuestion;
    Button skyBtn, grassBtn, rootBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}