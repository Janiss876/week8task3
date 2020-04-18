package com.example.week8task3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    TextView bottom;
    TextView money;
    SeekBar slider;
    BottleDispenser bottled = BottleDispenser.getInstance();
    double m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottom = (TextView) findViewById(R.id.bottomText);
        money = (TextView) findViewById(R.id.moneyAmount);
        slider = (SeekBar) findViewById(R.id.slider);

        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                DecimalFormat df = new DecimalFormat("#.##");
                money.setText(df.format(0.02 * progress) + "€");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                m = 0.02 * slider.getProgress();
            }
        });
    }

    public void add(View v) {
        bottled.addMoney(bottom, m);
        slider.setProgress(0);
    }

    public void buy(View v) {
        bottled.buyBottle(1, bottom);
    }

    public void returnMoney(View v) {
        bottled.returnMoney(bottom);
    }
}