package com.example.uiucusedbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogInPage extends AppCompatActivity {
    private EditText email;
    private TextView error;
    private TextView error2;
    private EditText password;
    private Button login;
    private boolean onlineMode = false;
    private int attemptAllowed = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_page);
        email = findViewById(R.id.emailofLogIn);
        password = findViewById(R.id.passwordofLogIn);
        login = findViewById(R.id.loginofLogin);
        error = findViewById(R.id.errorDisplayofLogin);
        error2 = findViewById(R.id.errorDisplay2ofLogin);
        /**@Override
        public void onClick(final View v) {
        //Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
        Intent signInIntent = new Intent(LogInPage.this, SignIn.class);
        startActivity(signInIntent);
        }*/
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                accountCheck(email.getText().toString(), password.getText().toString());
            }
        });
    }
    public void accountCheck(String emailInput, String passwordInput) {
        if((emailInput.equals("Test") && passwordInput.equals("MKWL"))) {
            Intent intent = new Intent(LogInPage.this, MainActivity.class);
            startActivity(intent);
        } else if(onlineMode) {
            // Part Interact with server to check id. TODO!!
            Intent intent = new Intent(LogInPage.this, MainActivity.class);
            startActivity(intent);
        } else {
            attemptAllowed--;
            error.setText("Wrong Email or Password, please try again");
            error2.setText("Remaining Attempts: " + attemptAllowed);
            if (attemptAllowed == 0) {
                error.setText("Maximum Attempt Reached");
                error2.setText("You are now Locked Out");
                login.setEnabled(false);
            }
        }

    }
}
