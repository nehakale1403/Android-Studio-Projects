package com.example.trymeoriginal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private View windowView;
    private Button tryme;
    private int[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors =new  int[]{Color.CYAN,Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW, Color.MAGENTA, Color.LTGRAY, Color.BLACK};

        windowView = (View) findViewById(R.id.windowViewId);

        tryme = (Button) findViewById(R.id.tryMeButton);
        tryme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int colorsLength = colors.length;
                Random random = new Random();
                int randomNum = random.nextInt(colorsLength);

                windowView.setBackgroundColor(colors[randomNum]);

                //Log.d("TEST" , "Tap");
            }
        });


    }
}
