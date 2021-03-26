package com.example.alopet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {
    private static int sto=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {

                Intent intent = new Intent(Splash.this, obs1.class);
                startActivity(intent);
                finish();
            }
        },sto);

    }
}