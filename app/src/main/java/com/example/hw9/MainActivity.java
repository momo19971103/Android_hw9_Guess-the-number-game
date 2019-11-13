package com.example.hw9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private int random;
    private int guessTime;
    int[] Rid = {R.id.button, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
            R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        boolean returnGame = intent.getBooleanExtra("ReturnGame", true);
        guessTime = intent.getIntExtra("guessTime", 0);
        random = intent.getIntExtra("random", 0);

        if (returnGame) {
            random = (int) (Math.random() * 9 + 1);
            intent.putExtra("ReturnGame", false);
        }
        one_To_nineButSet();
        final Button R_button = findViewById(R.id.R_button);
        R_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                random = (int) (Math.random() * 9 + 1);
                guessTime = 0;

            }
        });
    }

    void one_To_nineButSet() {
        for (int i = 1; i < Rid.length; i++) {
            butSet(i);
        }
    }

    void butSet(final int IDNum) {
        final Button button = findViewById(Rid[IDNum]);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("random", random);
                intent.putExtra("InputN", IDNum);
                intent.putExtra("guessTime", guessTime);
                startActivity(intent);
            }
        });
    }
}
