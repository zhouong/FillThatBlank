package com.example.something;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Players extends AppCompatActivity {
    private Game something = new Game();
    private static int num = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.players);

        // set roundsNumber & playersNumber
        TextView number = findViewById(R.id.number);
        final EditText name = findViewById(R.id.inputName);

        //retrieve number from main activity
        String currentPlayer = Integer.toString(num + 1);
        number.setText(currentPlayer);

        Button button = findViewById(R.id.playersButton);

        //move to next page
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                something.getPlayers().get(num).setName(name.getText().toString());
                if (num == something.getPlayers().size() - 1) {
                    Intent myIntent = new Intent(Players.this, Question.class);
                    startActivity(myIntent);
                } else {
                    num++;
                    Intent myIntent = new Intent(Players.this, Players.class);
                    startActivity(myIntent);
                }
            }
        });

    }

    public void reset() {
        num = 0;
    }
}
