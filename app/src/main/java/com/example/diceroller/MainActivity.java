package com.example.diceroller;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
            public void on_button_click(View view) {

                TextView result = null;
                try {
                    ImageView Ccongrats = this.findViewById(R.id.imageView);

                    Ccongrats.setVisibility(View.INVISIBLE);
                    Random ran = new Random();
                    int rando = ran.nextInt(6 + 1 - 1) + 1;

                    result = this.findViewById(R.id.textView);
                    EditText input = this.findViewById(R.id.editText);
                    String UserInput = input.getText().toString();
                    int guess = Integer.parseInt(UserInput);



                    TextView score = this.findViewById(R.id.textView2);
                    score.setText("Your Score is: " + Integer.toString(count));
                    result.setText(Integer.toString(rando));

                    if (guess == rando) {
                        count++;
                        Ccongrats.setVisibility(View.VISIBLE);
                    }
                } catch (Exception e) {
                    result.setText("Please enter a number as your guess");
                }
            }


    }

