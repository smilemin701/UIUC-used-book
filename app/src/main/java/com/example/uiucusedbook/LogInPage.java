package com.example.uiucusedbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInPage extends AppCompatActivity {
    private EditText emailID;
    private EditText password;
    private Button login;
    FirebaseAuth mAuth;
    private Button btnSignin;
    private FirebaseAuth.AuthStateListener authStateListener;


    @Override
    //Source : http://bit.ly/2WgHIjq/
    // https://www.youtube.com/watch?v=ihZUHD3nYcs
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_page);
        emailID = findViewById(R.id.emailofLogIn);
        password = findViewById(R.id.passwordofLogIn);
        login = findViewById(R.id.loginofLogin);
        btnSignin = findViewById(R.id.BtnSignin);
        mAuth = FirebaseAuth.getInstance();
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LogInPage.this, SignIn.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                userLogin();
            }
        });

        /**login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });*/
    }
    private void userLogin() {
        String email = emailID.getText().toString().trim();
        String pwd = password.getText().toString().trim();

        if (email.isEmpty()) {
            emailID.setError("Email is required");
            emailID.requestFocus();
            return;
        }
        if (!email.contains("illinois.edu")) {
            emailID.setError("Use school email");
            emailID.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailID.setError("Please enter a valid email");
            emailID.requestFocus();
            return;
        }
        if(pwd.isEmpty()) {
            password.setError("Password is required");
            password.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}
