package com.example.alopet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

//https://www.figma.com/file/6KkIct1dJTHe4283vqAo8C/UI-AloPet?node-id=1%3A3
//https://www.figma.com/file/aKbWNTAW0k1EembStZ9xgb/Wireframe-AloPet?node-id=0%3A1
//https://docs.google.com/presentation/d/1QZPIrIXxS7wFkmNLuGK3rEbpSO1fcUUBHBKMe-5UgMU/edit#slide=id.g6bad74673c_0_15
public class obs1 extends AppCompatActivity {

    private ImageButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obs1);
/*
        etAlas=findViewById(R.id.alas);
        etTinggi=findViewById(R.id.tinggi);
        btnHitung=findViewById(R.id.hitung);
        tv_hasil=findViewById(R.id.hasil);*/
        next=findViewById(R.id.next1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(obs1.this, obs2.class);
                startActivity(intent);
                finish();
            }
        });

    }
}