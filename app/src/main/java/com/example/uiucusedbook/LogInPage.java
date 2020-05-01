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
    private EditText password;
    private Button submitInfo;
    private boolean testMode = false;
    private int attemptAllowed = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_page);
        email = findViewById(R.id.emailofLogIn);
        password = findViewById(R.id.passwordofLogIn);
        submitInfo = findViewById(R.id.loginofLogin);
        error = findViewById(R.id.)

        submitInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                accountCheck(email.getText().toString(), password.getText().toString());
            }
        });
    }
    public void accountCheck(String emailInput, String passwordInput) {
        if((emailInput == "Test" && passwordInput == "CS125")) {
            Intent intent = new Intent(LogInPage.this, MainActivity.class);
            startActivity(intent);
        } else if(testMode) {
            Intent intent = new Intent(LogInPage.this, MainActivity.class);
            startActivity(intent);
        } else {
            attemptAllowed--;
            if (attemptAllowed == 0) {
                e
                submitInfo.setEnabled(false);
            }
        }

    }
}
/**@Override
public void onClick(final View v) {
//Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
Intent signInIntent = new Intent(LogInPage.this, SignIn.class);
startActivity(signInIntent);
}*/