package com.example.alopet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Homepage extends AppCompatActivity {
private Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        logout=findViewById(R.id.logoutbtn);
        logout.setOnClickListener(v -> {
            signout();
        });

    }
    public void signout(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(Homepage.this, Login.class);
        startActivity(intent);
        finish();
    }
}