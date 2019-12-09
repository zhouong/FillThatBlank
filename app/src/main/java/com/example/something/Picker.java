package com.example.something;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Picker extends AppCompatActivity {
    private static int count = 0;
    private static int playerNumber = 0;
    private static int ask = 0;
    private int player1;
    private int player2;
    private int player3;
    private Game something;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picker);

        Button response1 = findViewById(R.id.response1);
        Button response2 = findViewById(R.id.response2);
        Button response3 = findViewById(R.id.response3);

        response3.setVisibility(View.GONE);

        playerNumber = 0;
        rotation();
        response1.setText(something.getPlayers().get(playerNumber).getResponse());
        player1 = playerNumber;

        response1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                something.getPlayers().get(player1).addPoints();
                Intent myIntent = new Intent(Picker.this, Points.class);
                startActivity(myIntent);
                finish();
            }
        });

        playerNumber++;
        rotation();
        response2.setText(something.getPlayers().get(playerNumber).getResponse());
        player2 = playerNumber;

        response2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                something.getPlayers().get(player2).addPoints();
                Intent myIntent = new Intent(Picker.this, Points.class);
                startActivity(myIntent);
                finish();
            }
        });

        if (something.getPlayers().size() == 4) {
            response3.setVisibility(View.VISIBLE);
            playerNumber++;
            rotation();
            response3.setText(something.getPlayers().get(playerNumber).getResponse());
            player3 = playerNumber;

            response3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    something.getPlayers().get(player3).addPoints();
                    Intent myIntent = new Intent(Picker.this, Points.class);
                    startActivity(myIntent);
                }
            });
        }
    }

    private void rotation() {
        count++;

        if (playerNumber == ask) {
            playerNumber++;
        }

        if (ask == something.getPlayers().size()) {
            ask = 0;
        }

        if (playerNumber == something.getPlayers().size()) {
            playerNumber = 0;
        }

        if (count == something.getPlayers().size() - 1) {
            ask++;
        }

        if (count == something.getPlayers().size() - 1) {
            count = 0;
        }
    }

    public void reset() {
        count = 0;
        ask = 0;
        playerNumber = 0;
    }
}
