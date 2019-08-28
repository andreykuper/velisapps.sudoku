package com.velisapp.sudoku_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChooseLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_level);

        Button easy_level_button = findViewById(R.id.level_easy_button);
        Button medium_level_button = findViewById(R.id.level_medium_button);
        Button hard_level_button = findViewById(R.id.level_hard_button);

        easy_level_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseLevelActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });

        medium_level_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseLevelActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });

        hard_level_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseLevelActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
    }
}
