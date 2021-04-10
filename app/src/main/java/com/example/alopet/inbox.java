package com.example.alopet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class inbox extends AppCompatActivity {

    private ImageButton[]ib=new ImageButton[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        ib[0]=findViewById(R.id.backbt);
        ib[2]=findViewById(R.id.settings);
        ib[3]=findViewById(R.id.profile);
        ib[4]=findViewById(R.id.home);
        ib[0].setOnClickListener(v->{

            startActivity(new Intent(inbox.this, Homepage.class));
        });
        ib[2].setOnClickListener(v->{
            startActivity(new Intent(inbox.this, Pengaturan.class));
        });
        ib[3].setOnClickListener(v->{

            startActivity(new Intent(inbox.this, profil.class));
        });
        ib[4].setOnClickListener(v->{

            startActivity(new Intent(inbox.this, Homepage.class));
        });
    }
}