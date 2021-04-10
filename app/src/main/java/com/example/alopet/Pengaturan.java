package com.example.alopet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class Pengaturan extends AppCompatActivity {
private ImageButton[]ib=new ImageButton[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);
        ib[0]=findViewById(R.id.backbt);
        ib[1]=findViewById(R.id.logout);
        ib[2]=findViewById(R.id.profile);
        ib[3]=findViewById(R.id.inbox);
        ib[4]=findViewById(R.id.home);
        ib[0].setOnClickListener(v->{

            startActivity(new Intent(Pengaturan.this, Homepage.class));
        });
        ib[1].setOnClickListener(v->{
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(Pengaturan.this, Login.class);
            startActivity(intent);
            finish();
        });
        ib[2].setOnClickListener(v->{
            startActivity(new Intent(Pengaturan.this, profil.class));
        });
        ib[3].setOnClickListener(v->{

            startActivity(new Intent(Pengaturan.this, inbox.class));
        });
        ib[4].setOnClickListener(v->{

            startActivity(new Intent(Pengaturan.this, Homepage.class));
        });

    }
}