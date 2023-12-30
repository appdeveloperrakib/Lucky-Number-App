package com.appdeveloperrakib.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView tv_result;
    Button bt_ShareResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_result =findViewById(R.id.tv_luckyNumber);
        bt_ShareResult = findViewById(R.id.btn_share);

        //Reciving data from Main Activity

        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");

        //Generating Random Numbers

        int random_number = generateRandomNumbers();
        tv_result.setText(""+random_number);

        //Share Result

        bt_ShareResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                shareData(userName,random_number);

            }
        });



    }
    //-----------OnCreate End-------

    public int generateRandomNumbers(){

        Random random = new Random();
        int upper_limit = 1000;

        int randomNumberGenerated = random.nextInt(upper_limit);

        return randomNumberGenerated;

    }

    public void shareData(String userName, int randomNUmber){
        //Implicit Intent

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");


        //Additional Info
        intent.putExtra(Intent.EXTRA_SUBJECT,userName+" got lucky today");
        intent.putExtra(Intent.EXTRA_TEXT,"His lucky number is:"+randomNUmber);
        startActivity(Intent.createChooser(intent,"Choose a platform"));



    }







}