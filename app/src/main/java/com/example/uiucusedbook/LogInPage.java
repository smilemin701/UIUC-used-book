package com.example.uiucusedbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogInPage extends AppCompatActivity {
    private Button signINButton;
    private Button logInComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_page);
        signINButton = findViewById(R.id.BtnSignin);
        signINButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                Intent signInIntent = new Intent(LogInPage.this, SignIn.class);
                startActivity(signInIntent);
            }
        });
        logInComplete = findViewById(R.id.LogInComplete);
        logInComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                Intent LoggedInSucess = new Intent(LogInPage.this, MainActivity.class);
                startActivity(LoggedInSucess);
            }
        });


    }
}
