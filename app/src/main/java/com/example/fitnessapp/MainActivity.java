package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username,password,repassword;
    private Button sighup,login;
    DBhelper Dbhelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editTextTextPersonName);

        password = findViewById(R.id.editTextTextPassword);
        repassword = findViewById(R.id.editTextNumberPassword);

        sighup = findViewById(R.id.button);
        login = findViewById(R.id.button2);



        Dbhelp = new DBhelper(this);

        sighup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals("")){
                    Toast.makeText(MainActivity.this, "Fill all the details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(pass.equals(repass)){
                        Boolean result = Dbhelp.checkUser(user);
                        if(result==false){
                            Boolean result1 = Dbhelp.insertData(user,pass);
                            if(result1==true){
                                Toast.makeText(MainActivity.this, "Registration Succssed", Toast.LENGTH_SHORT).show();
                                Intent in = new Intent(getApplicationContext(), form2.class);
                                startActivity(in);

                            }
                            else{
                                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "User Already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Password Dont match", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), form2.class);
                startActivity(in);
            }
        });
    }
}