package com.example.alopet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class Homepage extends AppCompatActivity {
private Button logout;
private ImageButton article;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        logout=findViewById(R.id.logoutbtn);
        logout.setOnClickListener(v -> {
            signout();
        });
        article=findViewById(R.id.article);
        article.setOnClickListener(v ->{
            startActivity(new Intent(Homepage.this, Article.class));
        });

    }
    public void signout(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(Homepage.this, Login.class);
        startActivity(intent);
        finish();
    }
}