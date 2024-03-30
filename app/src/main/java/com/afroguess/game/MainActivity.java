package com.afroguess.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends Activity {

    private int randomNumber;
    private int attempts;
    private EditText editText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        resultTextView = findViewById(R.id.resultTextView);
        Button button = findViewById(R.id.button);

        randomNumber = generateRandomNumber();
        attempts = 0;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkGuess();
            }
        });
    }

    private int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }

    private void checkGuess() {
        String guessText = editText.getText().toString();
        try
        {
            int guess = Integer.parseInt(guessText);
            if (guess < randomNumber) {
                resultTextView.setText("Higher!");
            } else if (guess > randomNumber) {
                resultTextView.setText("Lower!");
            } else {
                resultTextView.setText("Congratulations! You guessed the number in " + (++attempts) + " attempts.");
            }

            attempts++;
        }
        catch (Exception e)
        {
            resultTextView.setText("Should be a number!");
        }


    }
}
