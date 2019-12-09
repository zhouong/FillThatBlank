package com.example.something;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TheEnd extends AppCompatActivity {
    private Game something = new Game();
    private Players players= new Players();
    private Responses responses = new Responses();
    private Picker picker = new Picker();
    private Points points = new Points();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theend);

        TextView winner = findViewById(R.id.winnerName);

        winner.setText(something.getWinner().getName());

        Button newGame = findViewById(R.id.newGameButton);
        Button exit = findViewById(R.id.exitButton);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //remove all existing data
                something.setRounds(0);
                something.setPlayers(new ArrayList<Player>());
                players.reset();
                responses.reset();
                picker.reset();
                points.reset();

                //go back to main page
                Intent myIntent = new Intent(TheEnd.this, MainActivity.class);
                startActivity(myIntent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(TheEnd.this, MainActivity.class);
                startActivity(myIntent);
                finish();
            }
        });

    }
}
