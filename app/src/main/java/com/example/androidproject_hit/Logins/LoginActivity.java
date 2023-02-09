package com.example.androidproject_hit.Logins;

import static java.nio.file.Files.write;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidproject_hit.R;
import com.example.androidproject_hit.RegisterActivity;
import com.example.androidproject_hit.TrainingType;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText lEmail, lPassword;
    Button LoginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        lEmail = findViewById(R.id.LoginInput_EmailAddress);
        lPassword = findViewById(R.id.LoginInput_Password);
        LoginButton = findViewById(R.id.Login_Button);

        ConstraintLayout constraintLayout = findViewById(R.id.AdminLoginLayout);

        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();


        /// First clickable span
        SpannableString ss1 = new SpannableString("Don't have an account? Register");

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View textView1) {
                Intent intent1 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent1);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };

        ss1.setSpan(clickableSpan1, 23, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView textView = (TextView) findViewById(R.id.Register_ClickableTextView);
        textView.setText(ss1);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        textView.setHighlightColor(Color.TRANSPARENT);


        /// Second clickable span
        SpannableString ss2 = new SpannableString("Admin? Click here");

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View textView2) {
                Intent intent2 = new Intent(LoginActivity.this, AdminLoginActivity.class);
                startActivity(intent2);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, TrainingType.class);
                startActivity(intent);
            }
        });

        ss2.setSpan(clickableSpan2, 8, 17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView textView2 = (TextView) findViewById(R.id.Admin_ClickableTextView);
        textView2.setText(ss2);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());

        textView2.setHighlightColor(Color.TRANSPARENT);
    }

    public void LoginClick(View V) {
        String email = lEmail.getText().toString().trim();
        String password = lPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)) {
            lEmail.setError("Email is Required");
            return;
        }
        if(TextUtils.isEmpty(password)){
            lPassword.setError("Password is Required");
            return;
        }
        if(password.length() < 6){
            lPassword.setError("Password must be longer than 6 characters");
            return;
        }
        Log.d("LoginClick", "LoginClick: email" +email);
        Log.d("LoginClick", "LoginClick: password" +password);

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                            
                        }
                    }
                });
    }

}
