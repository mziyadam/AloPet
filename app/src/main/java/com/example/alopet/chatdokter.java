package com.example.alopet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class chatdokter extends AppCompatActivity {
private ImageButton bck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatdokter);
        bck=findViewById(R.id.backbt);
        bck.setOnClickListener(v->{

            startActivity(new Intent(chatdokter.this, Homepage.class));

        });
    }
}