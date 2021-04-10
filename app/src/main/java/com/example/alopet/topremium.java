package com.example.alopet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class topremium extends AppCompatActivity {
    private ImageButton[]ib=new ImageButton[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topremium);
        ib[0]=findViewById(R.id.backbt);
        ib[2]=findViewById(R.id.settings);
        ib[3]=findViewById(R.id.inbox);
        ib[4]=findViewById(R.id.home);
        ib[0].setOnClickListener(v->{

            startActivity(new Intent(topremium.this, Homepage.class));
        });
        ib[2].setOnClickListener(v->{
            startActivity(new Intent(topremium.this, Pengaturan.class));
        });
        ib[3].setOnClickListener(v->{

            startActivity(new Intent(topremium.this, inbox.class));
        });
        ib[4].setOnClickListener(v->{

            startActivity(new Intent(topremium.this, Homepage.class));
        });
}}