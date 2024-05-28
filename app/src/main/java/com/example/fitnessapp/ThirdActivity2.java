package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity2 extends AppCompatActivity {

    String buttonvalue;
    Button startbutton;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private Boolean Mtimerunning=false;
    private  long Mtimemillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");

        int intvalue=Integer.valueOf(buttonvalue);


        switch (intvalue){


            case 1:
                setContentView(R.layout.activity_bow);
                break;

            case 2:
                setContentView(R.layout.activity_bridge);
                break;

            case 3:
                setContentView(R.layout.activity_chair);
                break;

            case 4:
                setContentView(R.layout.activity_child);
                break;

            case 5:
                setContentView(R.layout.activity_bow);
                break;

            case 6:
                setContentView(R.layout.activity_bridge);
                break;

            case 7:
                setContentView(R.layout.activity_child);
                break;

            case 8:
                setContentView(R.layout.activity_chair);
                break;

            case 9:
                setContentView(R.layout.activity_bridge);
                break;

            case 10:
                setContentView(R.layout.activity_bow);
                break;

            case 11:
                setContentView(R.layout.activity_child);
                break;

            case 12:
                setContentView(R.layout.activity_chair);
                break;

            case 13:
                setContentView(R.layout.activity_bridge);
                break;

            case 14:
                setContentView(R.layout.activity_bow);
                break;

            case 15:
                setContentView(R.layout.activity_child);
                break;

        }



        startbutton=findViewById(R.id.startbutton);
        mtextview=findViewById(R.id.time);

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Mtimerunning){

                    stopTimer();

                }
                else{

                    startTimer();
                }
            }
        });



    }

    private void stopTimer(){

        countDownTimer.cancel();
        Mtimerunning=false;
        startbutton.setText("START");
    }

    private void startTimer(){

        final CharSequence value1=mtextview.getText();
        String num1= value1.toString();
        String num2=num1.substring(0,2);
        String num3=num1.substring(3,5);

        final int number = Integer.valueOf(num2)*60+Integer.valueOf(num3);
        Mtimemillis=number*1000;

        countDownTimer=new CountDownTimer(Mtimemillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Mtimemillis=millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {

                int newvalue= Integer.valueOf(buttonvalue)+1;
                if(newvalue<=7){
                    Intent intent= new Intent(ThirdActivity2.this,ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }

                else {

                    newvalue=1;
                    Intent intent=new Intent(ThirdActivity2.this, ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }

            }
        }.start();

        startbutton.setText("PAUSE");
        Mtimerunning=true;
    }

    private void updateTimer(){

        int minutes=(int)Mtimemillis/60000;
        int seconds=(int)(Mtimemillis%60000)/1000;


        String timeLeftText="";

        if(minutes<10)
            timeLeftText="0";
        timeLeftText=timeLeftText+minutes+":";

        if(seconds<10)
            timeLeftText="0";
        timeLeftText+=seconds;
        mtextview.setText(timeLeftText);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}