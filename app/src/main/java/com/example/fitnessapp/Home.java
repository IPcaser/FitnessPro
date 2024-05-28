package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button button1, button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//       Toolbar toolbar = findViewById(R.id.toolBar);
//       setSupportActionBar(toolbar);

        button1= findViewById(R.id.startyoga1);
        button2=findViewById(R.id.startyoga2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Home.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Home.this, SecondActivity2.class);
                startActivity(intent);

            }
        });
    }



    public void beforeage18(View view) {

        Intent intent =new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void afterage18(View view) {

        Intent intent =new Intent(this, SecondActivity2.class);
        startActivity(intent);
    }

    public void food(View view) {


        Intent intent =new Intent(this, FoodActivity.class);
        startActivity(intent);

    }
}