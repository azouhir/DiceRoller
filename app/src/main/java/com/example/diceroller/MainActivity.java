package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
            public void on_button_click(View view) {

                TextView result = null;
                try {
                    ImageView Ccongrats = this.findViewById(R.id.imageView);

                    Ccongrats.setVisibility(View.INVISIBLE);
                    int rando = roll_the_dice();

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

            public int roll_the_dice() {

            Random number = new Random();
            int ran = number.nextInt(6 + 1 - 1) + 1;
            return ran;
            }

            public void on_button_click2 (View view) {

                int ran = roll_the_dice();

                TextView question = (TextView) this.findViewById(R.id.textView3);

                if (ran == 1){
                    question.setText("If you could go anywhere in the world, where would you go?");
                }
                else if (ran == 2){
                    question.setText("If you were stranded on a desert island, what three things would you want to take with you?");
                }
                else if (ran == 3){
                    question.setText("If you could eat only one food for the rest of your life, what would that be?");
                }
                else if (ran == 4){
                    question.setText("If you won a million dollars, what is the first thing you would buy?");
                }
                else if (ran == 5) {
                    question.setText("If you could spaned the day with one fictional character, who would it be?");
                }
                else {
                    question.setText("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
                }
            }
    }

