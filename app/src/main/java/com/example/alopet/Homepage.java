package com.example.alopet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class Homepage extends AppCompatActivity {
private ImageButton article;

    private ImageButton inbox;

    private ImageButton profile;

    private ImageButton settings;

    private ImageButton topremium;
    private ImageButton chat;
    private ImageButton []menulain=new ImageButton[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        chat=findViewById(R.id.forum);
        inbox=findViewById(R.id.inbox);
        profile=findViewById(R.id.profile);
        settings=findViewById(R.id.settings);
        topremium=findViewById(R.id.learnmore);
        menulain[0]=findViewById(R.id.chat);
        menulain[1]=findViewById(R.id.petadoption);
        menulain[2]=findViewById(R.id.buysell);
        menulain[3]=findViewById(R.id.petcare);
        topremium.setOnClickListener(R->{
            startActivity(new Intent(Homepage.this, topremium.class));
        });
        article=findViewById(R.id.article);
        article.setOnClickListener(v ->{
            startActivity(new Intent(Homepage.this, Article.class));
        });
        chat.setOnClickListener(R->{
            startActivity(new Intent(Homepage.this, chat.class));
        });
        inbox.setOnClickListener(R->{
            startActivity(new Intent(Homepage.this, inbox.class));
        });
        profile.setOnClickListener(R->{
            startActivity(new Intent(Homepage.this, profil.class));
        });
settings.setOnClickListener(R->{
    startActivity(new Intent(Homepage.this, Pengaturan.class));
});
        menulain[0].setOnClickListener(R->{
            startActivity(new Intent(Homepage.this, chatdokter.class));
        });
        menulain[1].setOnClickListener(R->{
            startActivity(new Intent(Homepage.this, petadoption.class));
        });
        menulain[2].setOnClickListener(R->{
            startActivity(new Intent(Homepage.this, buysell.class));
        });
        menulain[3].setOnClickListener(R->{
            startActivity(new Intent(Homepage.this, petcare.class));
        });
    }
    public void signout(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(Homepage.this, Login.class);
        startActivity(intent);
        finish();
    }
}