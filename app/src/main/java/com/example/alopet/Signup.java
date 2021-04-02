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

public class Signup extends AppCompatActivity {

    private EditText etmail;
    private EditText etpw;
    private EditText etpwc;
    private ImageButton signup;
    private ImageButton tologin;
    private FirebaseAuth mAuth;
    private ToggleButton toggle2;
    private ToggleButton toggle1;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            registered();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etmail=findViewById(R.id.mailboxsignup);
        etpw=findViewById(R.id.pwboxsignup);
        etpwc=findViewById(R.id.pwboxsignupconfirm);
        mAuth = FirebaseAuth.getInstance();
        signup=findViewById(R.id.signupbtn);
tologin=findViewById(R.id.tologin);
toggle1=findViewById(R.id.togglebtn1);
toggle2=findViewById(R.id.togglebtn2);
toggle1.setOnClickListener(new View.OnClickListener(){
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
        toggle2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (etpwc.getTransformationMethod().getClass().getSimpleName() .equals("PasswordTransformationMethod")) {
                    etpwc.setTransformationMethod(new SingleLineTransformationMethod());
                }
                else {
                    etpwc.setTransformationMethod(new PasswordTransformationMethod());
                }

                etpwc.setSelection(etpwc.getText().length());
            }
        });
        tologin.setOnClickListener(v->{
            startActivity(new Intent(Signup.this,Login.class));
            finish();
                });
        signup.setOnClickListener(v->{
            String pw = etpw.getText().toString();
            String pwc=etpwc.getText().toString();
            String mail = etmail.getText().toString();
            if(!pw.equals(pwc)){
                pwsame();
            }else{
            mAuth.createUserWithEmailAndPassword(mail,pw)
                    .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            boolean pwunsame=true;


                            if (!task.isSuccessful()&&pwunsame) {
                                emsame();
                            }else {
                                registered();
                            }
                        }
                    });}

        });
    }
    private void pwsame(){
        AlertDialog.Builder alert = new AlertDialog.Builder(Signup.this);
        alert.setTitle("Password confirmation doesn't match!");
        alert.setMessage("Your password confirmation doesn't match. Please try again.");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //do things
                Intent intent = new Intent(Signup.this, Signup.class);
                startActivity(intent);
                finish();
            }
        });
        alert.show();
    }

    private void emsame(){
        AlertDialog.Builder alert = new AlertDialog.Builder(Signup.this);
        alert.setTitle("This email has been used!");
        alert.setMessage("This email has been used. Please use another email.");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //do things
                Intent intent = new Intent(Signup.this, Signup.class);
                startActivity(intent);
                finish();
            }
        });
        alert.show();
    }
    public void registered(){
        AlertDialog.Builder alert = new AlertDialog.Builder(Signup.this);
        alert.setTitle("Registration successful");
        alert.setMessage("Now you can login and use these features on this app.");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //do things
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
        alert.show();
    }
}