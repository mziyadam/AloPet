package com.example.projekpertama;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    private EditText etmail;
    private EditText etpw;
    private ImageButton login;
    private static String uid;
    /*
    public static ArrayList<acc> ac=new ArrayList<acc>(){{add(new acc("admin@admin.com","password"));}};
    private static boolean cek(String mail,String pw){
        for (int i = 0; i < ac.size(); i++) {
            if(mail.equals(ac.get(i).getMail())&&pw.equals(ac.get(i).getPw()))
                return true;
        }
        return false;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*
        etAlas=findViewById(R.id.alas);
        etTinggi=findViewById(R.id.tinggi);
        btnHitung=findViewById(R.id.hitung);
        tv_hasil=findViewById(R.id.hasil);*/
        etmail=findViewById(R.id.mailbox);
        etpw=findViewById(R.id.pwbox);
        login=findViewById(R.id.loginbtn);
        /*try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=alopet;integratedSecurity=true");
            String query;
            PreparedStatement pst;
            Statement st = conn.createStatement();

            login.setOnClickListener(v -> {
                try {
                    ResultSet rs;
                    String mail = etmail.getText().toString();
                    String pw = etpw.getText().toString();
                    boolean login = true;
                    rs = st.executeQuery("exec auth '" + mail + "', '" + pw + "'");
                    while (rs.next()) {
                        uid = rs.getString(1);
                    }
                    if (uid != null) {
                        login = true;
                    } else {
                        errmsg();
                    }
                    //if(mail.equals("tes") && pw.equals("tes")){
                    if(login){pass();}else{
                        errmsg();
                    }
                    //}



                *//*else{
                AlertDialog.Builder alert = new AlertDialog.Builder(Login.this);
                alert.setTitle("Wrong username/password!");
                alert.setMessage("You've input the wrong username/password. Please try again.");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                        Intent intent = new Intent(Login.this, Login.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.show();
            }*//*
                }catch(Exception e){
                    errmsg();
                }
            });}
                catch (Exception e) {
                    errmsg();
            }*/
        login.setOnClickListener(v -> {
                String mail = etmail.getText().toString();
                String pw = etpw.getText().toString();
                if(mail.equals("admin")&&pw.equals("admin"))
                    pass();
                else
                    errmsg();

    });}
    private void errmsg(){
        AlertDialog.Builder alert = new AlertDialog.Builder(Login.this);
        alert.setTitle("Wrong username/password!");
        alert.setMessage("You've input the wrong username/password. Please try again.");
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //do things
                Intent intent = new Intent(Login.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
        alert.show();
    }

    private void pass(){
        Intent intent = new Intent(Login.this, Homepage.class);
        startActivity(intent);
        finish();
    }
}