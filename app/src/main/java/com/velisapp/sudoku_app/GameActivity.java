package com.velisapp.sudoku_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    final String[] initial_board = {
            "2", "1", "", "", "", "", "4", "", "", "3", "8", "", "4", "", "", "7", "",
            "2", "", "", "","7", "2", "", "", "", "", "", "2", "4", "8", "", "6", "9",
            "", "", "", "", "", "", "", "","", "", "", "", "", "1", "2", "", "3",
            "5", "4", "", "", "", "", "", "5", "8", "", "", "","9", "", "3", "", "",
            "4", "", "2", "8", "", "", "8", "", "", "", "", "5", "7"
    };

    ArrayList<String> current_board;
    GridView gridView;
    GridBoardAdapter gridAdapter;

    int currentValue = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        List<String> l = Arrays.<String>asList(initial_board);
        current_board= new ArrayList<String>(l);

        gridView = (GridView) findViewById(R.id.board_grid);
        gridAdapter = new GridBoardAdapter(this, current_board);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // making sure we're not changing initial input
                if (initial_board[position].equals("")){
                    if (currentValue >=0){
                        setNewValueOnBoard(position);
                    } else {
                        Toast.makeText(getApplicationContext(), "choose a value to insert", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(getApplicationContext(), "initial value can not be change", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button button_value_1 = (Button) findViewById(R.id.button_value_1);
        Button button_value_2 = (Button) findViewById(R.id.button_value_2);
        Button button_value_3 = (Button) findViewById(R.id.button_value_3);
        Button button_value_4 = (Button) findViewById(R.id.button_value_4);
        Button button_value_5 = (Button) findViewById(R.id.button_value_5);
        Button button_value_6 = (Button) findViewById(R.id.button_value_6);
        Button button_value_7 = (Button) findViewById(R.id.button_value_7);
        Button button_value_8 = (Button) findViewById(R.id.button_value_8);
        Button button_value_9 = (Button) findViewById(R.id.button_value_9);
        Button button_erase = (Button) findViewById(R.id.button_erase);

        button_value_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = 1;
            }
        });

        button_value_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = 2;
            }
        });

        button_value_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = 3;
            }
        });

        button_value_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = 4;
            }
        });

        button_value_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = 5;
            }
        });

        button_value_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = 6;
            }
        });

        button_value_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = 7;
            }
        });

        button_value_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = 8;
            }
        });

        button_value_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = 9;
            }
        });

        button_erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = 0;
            }
        });
    }

    private void setNewValueOnBoard(int position){
        if (currentValue == 0) {
            current_board.set(position, "");
        } else{
            current_board.set(position, Integer.toString(currentValue));
        }
        gridAdapter.notifyDataSetChanged();
    }

}
