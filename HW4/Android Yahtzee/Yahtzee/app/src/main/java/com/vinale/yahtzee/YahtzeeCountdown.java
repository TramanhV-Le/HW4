package com.vinale.yahtzee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class YahtzeeCountdown extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yahtzee_countdown);

        ImageView iv = (ImageView)findViewId(R.id.imageView);

    }
}
