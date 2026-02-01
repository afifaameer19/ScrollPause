package com.example.scrollpause;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TicTacToeActivity extends AppCompatActivity {

    private String currentPlayer = "X";
    private int moveCount = 0;

    // Tracks how many games user has played in this session
    private static int gamesPlayed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        GridLayout grid = findViewById(R.id.grid);
        grid.removeAllViews();

        for (int i = 0; i < 9; i++) {
            Button btn = new Button(this);
            btn.setText("");
            btn.setTextSize(22f);
            btn.setAllCaps(false);

            btn.setOnClickListener(v -> {
                if (!btn.getText().toString().isEmpty()) return;

                btn.setText(currentPlayer);
                currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                moveCount++;

                // Short, non-stimulating round
                if (moveCount >= 6) {
                    finishRound();
                }
            });

            grid.addView(btn);
        }
    }

    private void finishRound() {
        gamesPlayed++;

        if (gamesPlayed == 1) {
            Toast.makeText(
                    this,
                    "Nice. Let’s pause for a moment.",
                    Toast.LENGTH_SHORT
            ).show();

            startActivity(new Intent(this, TaskInputActivity.class));
            finish();

        } else {
            Toast.makeText(
                    this,
                    "Enjoy your day 🌱 Hope you finish your work.",
                    Toast.LENGTH_LONG
            ).show();

            // Reset for next app launch
            gamesPlayed = 0;

            finishAffinity(); // close entire app
        }
    }
}
