package com.example.sayalvaidya.trackurride;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.sayalvaidya.trackurride.Mileage;

import com.example.sayalvaidya.trackurride.utils.DatabaseConnection;

public class MainActivity extends AppCompatActivity {

    DatabaseConnection db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseConnection(this);
    }



    public void change(View v)
    {
        Intent i = new Intent(this, choice.class);
        startActivity(i);
    }
    public void change1(View v)
    {
        Intent i = new Intent(this, choice.class);
        startActivity(i);
    }
}
