package com.example.scrollpause;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TaskInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_input);

        EditText task1 = findViewById(R.id.task1);
        EditText task2 = findViewById(R.id.task2);

        Button startTasks = findViewById(R.id.continueTasks);
        Button playAgain = findViewById(R.id.continueScroll);

        startTasks.setOnClickListener(v -> {
            // Gentle affirmation
            Toast.makeText(
                    this,
                    "That’s a lot to do. You’ve got this 💪",
                    Toast.LENGTH_LONG
            ).show();

            // Close app completely
            finishAffinity();
        });

        playAgain.setOnClickListener(v -> {
            // Go back for one last calm game
            Intent intent = new Intent(this, TicTacToeActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
