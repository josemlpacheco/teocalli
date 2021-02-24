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
import com.example.teocalli.RecoveryActivity;
import com.example.teocalli.SignupActivity;
import com.example.teocalli.root.App;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View{

    Button loginButton;
    Button signUpButton;
    EditText userName;
    EditText password;
    TextView labelRecovery;

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
        loginButton = findViewById(R.id.btn_login);
        signUpButton = findViewById(R.id.btn_signup);
        labelRecovery = findViewById(R.id.label_recovery);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                presenter.loginButtonClicked();
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectToRegisterView();
            }
        });

        labelRecovery.setOnClickListener(new View.OnClickListener() {
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
        presenter.getCurrentUser();
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
        Toast.makeText(this,"Error,user not available",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this,"Error, user name or password cannot be empty",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUserLoggedIn() {
        Toast.makeText(this,"Success",Toast.LENGTH_LONG).show();
    }

    @Override
    public void setUserName(String userName) {
        this.userName.setText(userName);
    }

    @Override
    public void setPassword(String password) {
        this.password.setText(password);
    }
}