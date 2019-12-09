package com.example.something;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Game something = new Game();
    private int players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView title = findViewById(R.id.title);
        final EditText roundsNumber = findViewById(R.id.roundsNumber);
        final EditText playersNumber = findViewById(R.id.playerNumber);

        title.setText("Fill That Blank!");

        Button button = findViewById(R.id.mainButton);

        //move to next page
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //something.proceed();

                // set roundsNumber & playersNumber
                String playerNum = playersNumber.getText().toString();
                String roundNum = roundsNumber.getText().toString();
                players = Integer.parseInt(playerNum);
                something.setRounds(Integer.parseInt(roundNum));
                for (int i = 0; i < players; i++) {
                    //need to know how to add
                    something.getPlayers().add(0, new Player());
                }
                Intent myIntent = new Intent(MainActivity.this, Players.class);
                startActivity(myIntent);
            }
        });

    }
}
