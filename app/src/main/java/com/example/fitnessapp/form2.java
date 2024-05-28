package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class form2 extends AppCompatActivity {
    private EditText username , password;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form2);

        username = findViewById(R.id.editTextTextPersonName4);
        password = findViewById(R.id.editTextTextPassword4);
        button = findViewById(R.id.button7);

        DBhelper dbhelp = new DBhelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals("")){
                    Toast.makeText(form2.this, "Fill all the details", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean result = dbhelp.checkUsernamePassword(user,pass);
                    if(result==true){
                        Intent in = new Intent(getApplicationContext(), Home.class);
                        startActivity(in);
                    }
                    else {
                        Toast.makeText(form2.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}