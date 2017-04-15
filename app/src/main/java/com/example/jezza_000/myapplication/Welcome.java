package com.example.jezza_000.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Welcome extends Activity {

    private Button log_out;
    private Button voting;
    private Button admin;
    private Button answers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);


        admin = (Button) findViewById(R.id.button4);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AdminLoginActivity.class));



            }
        });


        voting = (Button) findViewById(R.id.button2);
        voting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getApplicationContext(),MainActivity.class));

                //Intent intent = new Intent(v.getContext(), MainActivity.class);
               // startActivityForResult(intent, 0);

            }
        });

        log_out = (Button) findViewById(R.id.button);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

        answers = (Button) findViewById(R.id.button3);
        answers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Answers.class));


            }
        });
    }
}
