package com.example.mediasferaflash;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private TextInputLayout accountUserName;
    private TextInputLayout accountUserMail;
    private TextInputLayout accountUserPassword;
    private TextInputLayout accountUserConfirmPassword;
    private Button signInBtn;
    private TextView textSignInBtn;
    private TextView signUpBtn;

    private boolean isLoginModeActive;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting_menu, menu);
        return true;
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = findViewById(R.id.toolbar_logo_setting);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.arrow_left_black);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        accountUserName =(TextInputLayout) findViewById(R.id.account_user_name);
        accountUserMail =(TextInputLayout) findViewById(R.id.account_user_mail);
        accountUserPassword =(TextInputLayout) findViewById(R.id.account_user_password);
        accountUserConfirmPassword =(TextInputLayout) findViewById(R.id.account_user_confirm_password);
        signInBtn =(Button) findViewById(R.id.signInBtn);
        textSignInBtn = (TextView) findViewById(R.id.textSignInBtn);
        signUpBtn = (TextView) findViewById(R.id.signUpBtn);


//        signInBtn.setOnClickListener(this);
    }

    private boolean validateName() {
        String nameInput = accountUserName.getEditText().getText().toString().trim();
        if (nameInput.isEmpty()) {
            accountUserName.setError("Пожалуйста введите имя");
            return false;
        } else {
            accountUserName.setError("");
            return true;
        }
    }
    private boolean validateEmail() {
        String emailInput = accountUserMail.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()) {
            accountUserMail.setError("Пожалуйста введите e-mail");
            return false;
        } else {
            accountUserMail.setError("");
            return true;
        }
    }
    private boolean validatePassword() {
        String passwordInput = accountUserPassword.getEditText().getText().toString().trim();
        String confirmPasswordInput = accountUserConfirmPassword.getEditText().getText().toString().trim();
        if (passwordInput.isEmpty()) {
            accountUserPassword.setError("Пожалуйста введите e-mail");
            return false;
        } else if (passwordInput.length() < 7) {
            accountUserPassword.setError("Пароль должен содержать не меньше 7 символов");
            return false;
        } else if (!passwordInput.equals(confirmPasswordInput)) {
            accountUserPassword.setError("Пароли не совпадают");
            return false;
        } else {
            accountUserPassword.setError("");
            return true;
        }
    }

    public void loginSignUpUser(View view) {
        switch (view.getId()) {
            case R.id.signInBtn:
                if (!validateName() || !validateEmail() || !validatePassword()) {
                    return;
                }
                String userInput = "Email: " + accountUserMail.getEditText().getText().toString().trim() + "\n" + "Имя: " + accountUserName.getEditText().getText().toString().trim() + "\n" + "Пассворд: " + accountUserPassword.getEditText().getText().toString().trim();
                Toast.makeText(this, userInput, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void toggleLoginSignInUser(View view) {

        if (isLoginModeActive) {
            isLoginModeActive = false;
            signInBtn.setText("Зарегистрироваться");
            textSignInBtn.setText("Уже есть аккаунт? ");
            signUpBtn.setText("Войдите");
            accountUserConfirmPassword.setVisibility(View.VISIBLE);
            accountUserName.setVisibility(View.VISIBLE);
        } else {
            isLoginModeActive = true;
            signInBtn.setText("Войти");
            textSignInBtn.setText("Нет аккаунта? ");
            signUpBtn.setText("Зарегестрироваться");
            accountUserConfirmPassword.setVisibility(View.GONE);
            accountUserName.setVisibility(View.GONE);
        }

    }
}
