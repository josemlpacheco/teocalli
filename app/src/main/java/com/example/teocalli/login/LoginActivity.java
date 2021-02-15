package com.example.teocalli.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.teocalli.R;
import com.example.teocalli.RecoveryActivity;
import com.example.teocalli.SignupActivity;

public class LoginActivity extends AppCompatActivity {

    Button signupButton;
    TextView recoveryLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signupButton = findViewById(R.id.button_signup);
        recoveryLink = findViewById(R.id.link_recovery);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectToRegisterView();
            }
        });

        recoveryLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectToRecoveryView();
            }
        });
    }

    public void redirectToRegisterView() {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public void redirectToRecoveryView() {
        Intent intent = new Intent(this, RecoveryActivity.class);
        startActivity(intent);
    }
}