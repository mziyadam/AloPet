package com.example.projekpertama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
//https://www.figma.com/file/6KkIct1dJTHe4283vqAo8C/UI-AloPet?node-id=1%3A3
//https://www.figma.com/file/aKbWNTAW0k1EembStZ9xgb/Wireframe-AloPet?node-id=0%3A1
//https://docs.google.com/presentation/d/1QZPIrIXxS7wFkmNLuGK3rEbpSO1fcUUBHBKMe-5UgMU/edit#slide=id.g6bad74673c_0_15
public class MainActivity extends AppCompatActivity {

    private ImageButton btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        etAlas=findViewById(R.id.alas);
        etTinggi=findViewById(R.id.tinggi);
        btnHitung=findViewById(R.id.hitung);
        tv_hasil=findViewById(R.id.hasil);*/
        btnlogin=findViewById(R.id.login1);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

    }
}