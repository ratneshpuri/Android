package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0 ; //TRACKS FOR TEAM A
    int scoreTeamB=0; //TRACKS FRO TEAM B

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * When plus 3 is clicked increases the value by 3.
     */
    public void addThreeForTeamA(View view){
        scoreTeamA =scoreTeamA +3;
        displayForTeamA(scoreTeamA );
    }
    /**
     * When plus 2 is clicked increases the value by 2.
     */
    public void addTwoForTeamA(View view){
        scoreTeamA =scoreTeamA+2;
        displayForTeamA(scoreTeamA);
    }
    /**
     * When FREE THROW is clicked increases the value by 1.
     */
    public void addOneForTeamA(View view){
        scoreTeamA =scoreTeamA+1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score){
        TextView scoreView=(TextView)findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * When plus 3 is clicked increases the value by 3.
     */
    public void addThreeForTeamB(View view){
        scoreTeamB =scoreTeamB +3;
        displayForTeamB(scoreTeamB );
    }
    /**
     * When plus 2 is clicked increases the value by 2.
     */
    public void addTwoForTeamB(View view){
        scoreTeamB =scoreTeamB +2;
        displayForTeamB(scoreTeamB );
    }
    /**
     * When FREE THROW is clicked increases the value by 1.
     */
    public void addOneForTeamB(View view){
        scoreTeamB =scoreTeamB +1;
        displayForTeamB(scoreTeamB );
    }
    /**
     * When RESET button is clicked
     */
    public void reset(View view){
        scoreTeamB=0;
        scoreTeamA=0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
