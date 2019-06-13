package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private Button button;
private Button register;
private EditText mail,pass;
private View ProgressView;
    private View FormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button1);
        mail = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        register = findViewById(R.id.btn2);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });
        ProgressView = findViewById(R.id.login_progress);
        FormView = findViewById(R.id.scr);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//codes to store data at login attempt
            String email = mail.getText().toString();
            String password = pass.getText().toString();
            boolean cancel = false;
            View focusView = null;
            //emptiness checking
            if (TextUtils.isEmpty(email)) {
                mail.setError("Email is a must!");
                focusView = mail;
                cancel = true;
            }
            else if (TextUtils.isEmpty(password)){
                pass.setError("password must be provided");
                focusView=pass;
                cancel = true;
            }
            //valid email
                else  if (!isEmailValid(email)){
              mail.setError("Invalid email");
              focusView = mail;
              cancel = true;
            }
                //password length and validation
                else if (!isPasswordValid(password)){
                    pass.setError("password between 8 and 32 characters");
                    focusView = pass;
                    cancel = true;
            }
                if (cancel){
                    focusView.requestFocus();
                }
                else {

                    showProgress(true);
                    startActivity(new Intent(MainActivity.this, DrawerActivity.class));
                }

            }
        });
    }
@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean b) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
        FormView.setVisibility(b ? View.GONE : View.VISIBLE);
        FormView.animate().setDuration(shortAnimTime).alpha(
                b ? 0 : 1).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                FormView.setVisibility(b ? View.GONE : View.VISIBLE);
            }
        });

        ProgressView.setVisibility(b ? View.VISIBLE : View.GONE);
        ProgressView.animate().setDuration(shortAnimTime).alpha(
                b ? 1 : 0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                ProgressView.setVisibility(b ? View.VISIBLE : View.GONE);
            }
        });
    }
else {
        ProgressView.setVisibility(b ? View.VISIBLE : View.GONE);
        FormView.setVisibility(b ? View.GONE : View.VISIBLE);
    }
    }

    private boolean isPasswordValid(String password) {
        return password.length()>8 && password.length()<32;
    }

    private boolean isEmailValid(String email) {
        return email.contains("@") && email.contains(".");
    }
}
