package com.example.alopet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class obs2 extends AppCompatActivity {

    private ImageButton next2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obs2);
        next2=findViewById(R.id.next2);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(obs2.this, obs3.class);
                startActivity(intent);
                finish();
            }
        });
    }
}