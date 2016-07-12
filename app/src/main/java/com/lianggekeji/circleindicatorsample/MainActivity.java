package com.lianggekeji.circleindicatorsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lianggekeji.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setCount(8);
    }
}
