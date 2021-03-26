package com.example.alopet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class obs3 extends AppCompatActivity {

    private ImageButton next3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obs3);
        next3=findViewById(R.id.next3);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(obs3.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}