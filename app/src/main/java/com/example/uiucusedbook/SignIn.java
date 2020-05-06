package com.example.uiucusedbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignIn extends AppCompatActivity implements View.OnClickListener{
    private ArrayAdapter adapter;
    private Spinner gradeSpinner;
    private Button signInComplete;
    private EditText emailID;
    private EditText password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        gradeSpinner = findViewById(R.id.gradeSpinner);
        adapter = ArrayAdapter.createFromResource(
                this,
                R.array.grade,
                R.layout.spinner_color);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        gradeSpinner.setAdapter(adapter);


        signInComplete = findViewById(R.id.SignInComplete);
        emailID = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput2);
        mAuth = FirebaseAuth.getInstance();
        signInComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                registerUser();
            }
        });

    }
    //Source : http://bit.ly/2WgHIjq/
    // https://www.youtube.com/watch?v=ihZUHD3nYcs
    private void registerUser() {
        String email = emailID.getText().toString().trim();
        String pwd = password.getText().toString().trim();

        if (email.isEmpty()) {
            emailID.setError("Email Required");
            emailID.requestFocus();
            return;
        }
        if (!email.contains("illinois.edu")) {
            emailID.setError("Please use School Email");
            emailID.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailID.setError("Please enter a Valid Email");
            emailID.requestFocus();
            return;
        }
        if(pwd.isEmpty()) {
            password.setError("Password Required");
            password.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                Intent intent = new Intent(SignIn.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            } else {
                if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                    Toast.makeText(getApplicationContext(), "This email is already registered", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
            }
        });
    }


    @Override
    public void onClick(View view) {

    }
}
