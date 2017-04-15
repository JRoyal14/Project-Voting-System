package com.example.jezza_000.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jerry Royal on 14/04/2017.
 */

public class AdminActivity extends AppCompatActivity {

    EditText q1, q2, q3, q4;
    RequestQueue requestQueue;
    Button update, logout, back;
    String updateURL = "http://192.168.0.10/update.php";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        q1 = (EditText) findViewById(R.id.Q1);
        q2 = (EditText) findViewById(R.id.Q2);
        q3 = (EditText) findViewById(R.id.Q3);
        q4 = (EditText) findViewById(R.id.Q4);
        update = (Button) findViewById(R.id.update);
        logout = (Button) findViewById(R.id.logout);
        back = (Button) findViewById(R.id.back);


        requestQueue = Volley.newRequestQueue(getApplicationContext());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, updateURL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.println(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> parameters  = new HashMap<String, String>();
                        parameters.put("Q1",q1.getText().toString());
                        parameters.put("Q2",q2.getText().toString());
                        parameters.put("Q3",q3.getText().toString());
                        parameters.put("Q4",q4.getText().toString());


                        return parameters;
                    }
                };
                requestQueue.add(request);
            }

        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Welcome.class));
            }
        });







    }


}
