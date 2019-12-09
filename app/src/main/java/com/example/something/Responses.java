package com.example.something;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Responses extends AppCompatActivity {
    private static int num = 0;
    private static int ask = 0;
    private static int playerNumber = 0;
    private Game something = new Game();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.response);

        final EditText response = findViewById(R.id.response);

        final TextView playerName = findViewById(R.id.playerName);

        rotation();
        playerName.setText(something.getPlayers().get(playerNumber).getName());



        Button button = findViewById(R.id.responseButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println();
                something.getPlayers().get(playerNumber).setResponse(response.getText().toString());
                playerNumber++;

                if (num == something.getPlayers().size() - 2) {
                    num = 0;
                    ask++;
                    if (ask == something.getPlayers().size()) {
                        ask = 0;
                    }
                    Intent myIntent = new Intent(Responses.this, Picker.class);
                    startActivity(myIntent);
                } else {
                    num++;
                    Intent myIntent = new Intent(Responses.this, Responses.class);
                    startActivity(myIntent);
                }
            }
        });
    }

    private void rotation() {
        if (num == ask) {
            playerNumber++;
        }
        if (playerNumber == something.getPlayers().size()) {
            playerNumber = 0;
        }
    }

    public void reset() {
        num = 0;
        ask = 0;
        playerNumber = 0;
    }
}
