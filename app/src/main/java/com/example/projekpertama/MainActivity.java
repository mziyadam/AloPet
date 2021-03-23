package com.example.projekpertama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etAlas;
    private EditText etTinggi;
    private Button btnHitung;
    private TextView tv_hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAlas=findViewById(R.id.alas);
        etTinggi=findViewById(R.id.tinggi);
        btnHitung=findViewById(R.id.hitung);
        tv_hasil=findViewById(R.id.hasil);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double alas=Double.parseDouble(etAlas.getText().toString());
                Double tinggi=Double.parseDouble(etTinggi.getText().toString());
                Double luas=alas*tinggi/2;
                tv_hasil.setText(luas.toString());
            }
        });

    }
}