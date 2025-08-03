package com.v2v.dicegameapp;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView diceImage;
    TextView resultText;
    Button rollButton;
    int score = 0;
    Random random;

    // Array of dice images
    int[] diceImages = {
            R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,
            R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceImage = findViewById(R.id.diceImage);
        resultText = findViewById(R.id.resultText);
        rollButton = findViewById(R.id.rollButton);
        random = new Random();

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation rotate = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
                diceImage.startAnimation(rotate);
                int rolledNumber = random.nextInt(6);  // 0 to 5
                diceImage.setImageResource(diceImages[rolledNumber]);

                int diceValue = rolledNumber + 1;
                score += diceValue;

                resultText.setText("Your Score: " + score);
            }
        });
    }
}