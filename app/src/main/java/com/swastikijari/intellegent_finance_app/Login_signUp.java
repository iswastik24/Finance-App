package com.swastikijari.intellegent_finance_app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_signUp extends AppCompatActivity {
    LinearLayout ll;
    Button btn_login, btn_sin_up;
    EditText user_name, pass_wd;
    private FirebaseAuth auth;
    ProgressBar p;

    // login page hear
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up);


        user_name = findViewById(R.id.userId_editText);
        pass_wd = findViewById(R.id.password_editText);

        p = findViewById(R.id.progressBar);

        btn_login = findViewById(R.id.login);
        btn_sin_up = findViewById(R.id.sign_un);


        //Firebase insilization
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        //getting username and password
        p.setVisibility(View.INVISIBLE);
        // for button login
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String u_name = user_name.getText().toString().trim();
                String p_name = pass_wd.getText().toString().trim();

                if (u_name.isEmpty()) {
                    Toast.makeText(Login_signUp.this, "email is empty", Toast.LENGTH_LONG).show();
                }
                if (p_name.isEmpty()) {
                    Toast.makeText(Login_signUp.this, "password is empty", Toast.LENGTH_LONG).show();
                }
                if (u_name.isEmpty() && p_name.isEmpty()) {
                    Toast.makeText(Login_signUp.this, "Enter email and password", Toast.LENGTH_LONG).show();

                }

                if((u_name.isEmpty() && p_name.isEmpty())|| u_name.isEmpty()||p_name.isEmpty()){

                    Toast.makeText(Login_signUp.this,"Enter the credentials ",Toast.LENGTH_LONG).show();

                }else{
                    p.setVisibility(View.VISIBLE);
                    //Login
                    auth.signInWithEmailAndPassword(u_name, p_name)
                            .addOnCompleteListener(Login_signUp.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    p.setVisibility(View.GONE);
                                    if (!task.isSuccessful()) {
                                        // there was an error
                                        Toast.makeText(Login_signUp.this, "This is Error", Toast.LENGTH_LONG).show();
                                    } else {

                                        Intent intent = new Intent(Login_signUp.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });

                }

            }
        });
        btn_sin_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sign up

                String email = user_name.getText().toString().trim();
                String password = pass_wd.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                p.setVisibility(View.VISIBLE);
                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login_signUp.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(Login_signUp.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                p.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(Login_signUp.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(Login_signUp.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });

            }
        });
    }
}


