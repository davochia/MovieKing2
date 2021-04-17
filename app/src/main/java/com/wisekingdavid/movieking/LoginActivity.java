package com.wisekingdavid.movieking;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wisekingdavid.movieking.model.AbstractActivity;


public class LoginActivity extends AbstractActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();

    Button loginButton;
    EditText username, password;


    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initLayout() {
        loginButton = findViewById(R.id.loginButton);
        username = findViewById(R.id.edtUsername);
        password = findViewById(R.id.edtPassword);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Validate Password
                if(username.getText().toString().trim().equals("athtech") &&
                        password.getText().toString().trim().equals("123456")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    // redirecting to main activity with bottom nav
                    Intent intent= new Intent(LoginActivity.this, PopularMoviesActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                }



            }
        });


        Button btnCancel = findViewById(R.id.cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });
    }

    @Override
    protected void runOperations() {

    }

    @Override
    protected void stopOperations() {

    }


}

