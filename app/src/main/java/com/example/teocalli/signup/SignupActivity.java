package com.example.teocalli.signup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.teocalli.R;
import com.example.teocalli.root.App;
import com.example.teocalli.shared.entities.User;

import java.nio.file.attribute.UserPrincipal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

public class SignupActivity extends AppCompatActivity implements SignupMVP.View {
    private SignupMVP.Presenter presenter;
    private EditText edtName;
    private EditText edtLastName;
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        presenter = new SignUpPresenter(this);
        edtName = findViewById(R.id.edtName);
        edtLastName = findViewById(R.id.edtLastName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignUp = findViewById(R.id.btnSignup);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFormValid()) {
                    String[] surNames = edtLastName.getText().toString().split(" ");
                    User user = new User(
                            edtEmail.getText().toString(),
                            edtName.getText().toString(),
                            surNames[0],
                            surNames[1],
                            edtPassword.getText().toString(),
                            2
                    );
                    signUp(user);
                }
            }
        });
    }

    @Override
    public void signUp(User user) {
        presenter.signUp(user);
    }

    @Override
    public void showResult(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
            .setTitle(R.string.error_alert_title).create().show();
    }

    private boolean isFormValid() {
        SignUpValidation validator = new SignUpValidation();
        String[] lastName = edtLastName.getText().toString().split(" ");
        if (TextUtils.isEmpty(edtName.getText())){
            validator.setName(false);
            edtName.setError(getString(R.string.insert_name));
        } else if (TextUtils.isEmpty(edtLastName.getText())) {
            validator.setLastName(false);
            edtLastName.setError(getString(R.string.insert_last_name));
        } else if (lastName.length < 2) {
            validator.setLastName(false);
            edtLastName.setError(getString(R.string.insert_two_surnames));
        } else if (TextUtils.isEmpty(edtEmail.getText())) {
            validator.setEmail(false);
            edtEmail.setError(getString(R.string.insert_email));
        } else if (TextUtils.isEmpty(edtPassword.getText())) {
            validator.setPassword(false);
            edtPassword.setError(getString(R.string.insert_password));
        } else if (!isPasswordValid(edtPassword.getText().toString())) {
            validator.setPassword(false);
            edtPassword.setError(getString(R.string.insert_valid_password));
        } else {
            validator.setEmail(true);
            validator.setName(true);
            validator.setPassword(true);
            validator.setLastName(true);
        }

        return validator.isValid();
    }

    private boolean isPasswordValid(String password) {
        String stringPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=/()=]).*(?<=.{8,18})$";
        Pattern passwordPattern = Pattern.compile(stringPattern);
        Matcher match = passwordPattern.matcher(password);
        return match.matches();
    }
}