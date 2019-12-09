package com.example.something;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Points extends AppCompatActivity {
    private static int num = 0;
    private int player = 0;
    private Game something = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.points);

        TextView player1 = findViewById(R.id.player1);
        player1.setText(something.getPlayers().get(player).getName() + ": " + something.getPlayers().get(player++).getPoints());

        TextView player2 = findViewById(R.id.player2);
        player2.setText(something.getPlayers().get(player).getName() + ": " + something.getPlayers().get(player++).getPoints());

        TextView player3 = findViewById(R.id.player3);
        player3.setText(something.getPlayers().get(player).getName() + ": " + something.getPlayers().get(player++).getPoints());

        TextView player4 = findViewById(R.id.player4);
        player4.setVisibility(View.GONE);

        if (something.getPlayers().size() == 4) {
            player4.setVisibility(View.VISIBLE);
            player4.setText(something.getPlayers().get(player).getName() + ": " + something.getPlayers().get(player).getPoints());
        }

        Button button = findViewById(R.id.questionButton);
        if (num == something.getRounds() - 1) {
            button.setText("The End");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num == something.getRounds() - 1) {
                    Intent myIntent = new Intent(Points.this, TheEnd.class);
                    startActivity(myIntent);
                    finish();
                } else {
                    num++;
                    Intent myIntent = new Intent(Points.this, Question.class);
                    startActivity(myIntent);
                }
            }
        });
    }

    public void reset() {
        num = 0;
        player = 0;
    }

}
