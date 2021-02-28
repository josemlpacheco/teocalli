package com.example.teocalli.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teocalli.R;
import com.example.teocalli.SignupActivity;
import com.example.teocalli.recoveryPassword.RecoveryActivity;
import com.example.teocalli.root.App;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    EditText userName;
    EditText password;
    Button signupButton;
    Button loginButton;
    TextView recoveryLink;

    @Inject
    LoginActivityMVP.Presenter presenter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplication()).getComponent().inject(this);

        userName = findViewById(R.id.txt_userName);
        password = findViewById(R.id.txt_password);
        signupButton = findViewById(R.id.btn_signup);
        loginButton = findViewById(R.id.btn_login);
        recoveryLink = findViewById(R.id.label_recovery);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginButtonClicked();
            }
        });

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

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    public void redirectToRegisterView() {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public void redirectToRecoveryView() {
        Intent intent = new Intent(this, RecoveryActivity.class);
        startActivity(intent);
    }

    @Override
    public String getUserName() {
        return this.userName.getText().toString();
    }

    @Override
    public String getPassword() {
        return this.password.getText().toString();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this,"Error,user not available",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this,"Error, user or password cannot be empty",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserLoggedIn() {
        Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show();
    }
}