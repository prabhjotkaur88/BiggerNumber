package com.example.biggernumber;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int num1;
    private int num2;
    private int scores;
    private int maxLives;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scores = 0;
        maxLives = 5;
        pickNumbers();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





    public void leftButtonClick(View view) {

            if (num1 > num2) {
                scores++;
                TextView messageID = (TextView) findViewById(R.id.messageID);
                messageID.setText("Congratulations! You are correct");
            } else if (maxLives <=0)
            {

                TextView maxLivesID = (TextView) findViewById(R.id.maxLivesID);
                maxLivesID.setText("Game Over!");

            }

            else
            {
                TextView messageID = (TextView) findViewById(R.id.messageID);
                messageID.setText("You are wrong!");
                TextView maxLivesID = (TextView) findViewById(R.id.maxLivesID);
                maxLives--;
                maxLivesID.setText("Lives:" + maxLives);

            }

            pickNumbers();


        }





    public void rightButtonClick(View view) {


        if (num2 > num1) {
            scores++;
            TextView messageID = (TextView) findViewById(R.id.messageID);
            messageID.setText("Congratulations! You are correct");



        }

        else if (maxLives<=0) {


            TextView maxLivesID = (TextView) findViewById(R.id.maxLivesID);
            maxLivesID.setText("Game Over!");





        }




        else  {
            TextView messageID = (TextView) findViewById(R.id.messageID);
            messageID.setText("You are wrong!");
            TextView maxLivesID = (TextView) findViewById(R.id.maxLivesID);
            maxLives--;
            maxLivesID.setText("Lives:" + maxLives);

        }

        pickNumbers();

    }







    private void pickNumbers() {

            TextView scoreID = (TextView) findViewById(R.id.scoreID);
            scoreID.setText("Scores:" + scores);
            Random randy = new Random();
            num1 = randy.nextInt(100);
            num2 = randy.nextInt(100);

            Button left = (Button) findViewById(R.id.leftButton);
            Button right = (Button) findViewById(R.id.rightButton);

            left.setText(String.valueOf(num1));
            right.setText(String.valueOf(num2));

        }
    }
