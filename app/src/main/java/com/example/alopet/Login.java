package com.example.alopet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private EditText etmail;
    private EditText etpw;
    private ImageButton login;
    private ImageButton tosignup;
    private FirebaseAuth mAuth;
private ToggleButton toggle;

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
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            pass();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

// ...
// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        /*
        etAlas=findViewById(R.id.alas);
        etTinggi=findViewById(R.id.tinggi);
        btnHitung=findViewById(R.id.hitung);
        tv_hasil=findViewById(R.id.hasil);*/
        etmail=findViewById(R.id.mailbox);
        etpw=findViewById(R.id.pwbox);

        login=findViewById(R.id.loginbtn);
        tosignup=findViewById(R.id.tosignup);
        toggle=findViewById(R.id.togglebtn);
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etpw.getTransformationMethod().getClass().getSimpleName() .equals("PasswordTransformationMethod")) {
                    etpw.setTransformationMethod(new SingleLineTransformationMethod());
                }
                else {
                    etpw.setTransformationMethod(new PasswordTransformationMethod());
                }

                etpw.setSelection(etpw.getText().length());
            }
        });
        tosignup.setOnClickListener(v -> {
            tosu();
        });
        login.setOnClickListener(v -> {

            String mail = etmail.getText().toString();
            String pw = etpw.getText().toString();
            mAuth.signInWithEmailAndPassword(mail, pw)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser user = mAuth.getCurrentUser();
                                pass();
                            } else {
                                // If sign in fails, display a message to the user.
                                errmsg();
                            }

                            // ...
                        }
                    });

    });}
    private void errmsg(){
        AlertDialog.Builder alert = new AlertDialog.Builder(Login.this);
        alert.setTitle("Wrong username/password!");
        alert.setMessage("You've input the wrong username/password. Please try again.");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //do things
                Intent intent = new Intent(Login.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
        alert.show();
    }/*
    //create
    private void reload(){
        AlertDialog.Builder alert = new AlertDialog.Builder(Login.this);
        alert.setTitle("Success on create!");
        alert.setMessage("Your account has been created.");
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //do things
                Intent intent = new Intent(Login.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
        alert.show();
    }*/

    private void tosu(){
        Intent intent = new Intent(Login.this, Signup.class);
        startActivity(intent);
        finish();
    }
    private void pass(){
        Intent intent = new Intent(Login.this, Homepage.class);
        startActivity(intent);
        finish();
    }

    public static void signout(){
        FirebaseAuth.getInstance().signOut();
    }
}