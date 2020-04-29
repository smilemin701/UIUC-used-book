package com.example.uiucusedbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SignIn extends AppCompatActivity {
    private ArrayAdapter adapter;
    private Spinner gradeSpinner;
    private Button signInComplete;


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
        signInComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                //Implement the system for login/signin dataBase
                Intent LoggedinSucess = new Intent(SignIn.this, MainActivity.class);
                startActivity(LoggedinSucess);
            }
        });

    }



}
