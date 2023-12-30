package com.appdeveloperrakib.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ed_Name;
    Button bt_get_luckyNumber;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_Name = findViewById(R.id.edit_text);
        bt_get_luckyNumber = findViewById(R.id.button);


        bt_get_luckyNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = ed_Name.getText().toString();
                //Explicit Intent

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                //Passing the name to second activity
                intent.putExtra("name",userName);
                startActivity(intent);

            }
        });



    }
}