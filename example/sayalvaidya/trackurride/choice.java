package com.example.sayalvaidya.trackurride;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class choice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }

    public void choice1(View v)
    {
        Intent i = new Intent(this, Mileage.class);
        startActivity(i);
    }

    public void choice2(View v)
    {
        Intent i = new Intent(this, Service.class);
        startActivity(i);
    }

}
