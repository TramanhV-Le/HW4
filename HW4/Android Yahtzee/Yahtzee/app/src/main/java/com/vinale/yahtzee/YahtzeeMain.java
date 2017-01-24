package com.vinale.yahtzee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Date;
import java.util.Random;

public class YahtzeeMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yahtzee_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Random rand = new Random();
                int pickedNum = rand.nextInt(6);
                int image[] = {R.drawable.die1, R.drawable.die2, R.drawable.die3,
                               R.drawable.die4, R.drawable.die5, R.drawable.die6};

                ImageView iv1 = (ImageView) findViewById(R.id.imageView);
                iv1.setImageResource(image[pickedNum]);
                pickedNum = rand.nextInt(6);
                ImageView iv2 = (ImageView) findViewById(R.id.imageView);
                iv2.setImageResource(image[pickedNum]);
                pickedNum = rand.nextInt(6);
                ImageView iv3 = (ImageView) findViewById(R.id.imageView);
                iv3.setImageResource(image[pickedNum]);
                pickedNum = rand.nextInt(6);
                ImageView iv4 = (ImageView) findViewById(R.id.imageView);
                iv4.setImageResource(image[pickedNum]);
                pickedNum = rand.nextInt(6);
                ImageView iv5 = (ImageView) findViewById(R.id.imageView);
                iv5.setImageResource(image[pickedNum]);
                pickedNum = rand.nextInt(6);

                try {
                    Thread.sleep(300);
                }
                catch (InterruptedException ex) {;}

            }

        });

    };
}
