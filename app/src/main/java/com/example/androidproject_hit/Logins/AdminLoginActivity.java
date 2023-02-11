package com.example.androidproject_hit.Logins;

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

import com.example.androidproject_hit.AdminMainActivity;
import com.example.androidproject_hit.AdminRegisterActivity;
import com.example.androidproject_hit.R;
import com.example.androidproject_hit.RegisterActivity;
import com.example.androidproject_hit.TrainingType;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import Users.Admin;

public class AdminLoginActivity extends AppCompatActivity {

    private FirebaseAuth AdminAuth;
    EditText AdminLEmail, AdminLPassword;
    Button AdminLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        AdminAuth = FirebaseAuth.getInstance();
        AdminLEmail = findViewById(R.id.AdminLoginInput_EmailAddress);
        AdminLPassword = findViewById(R.id.AdminLoginInput_Password);
        AdminLoginButton = findViewById(R.id.AdminLogin_Button);

        ConstraintLayout constraintLayout = findViewById(R.id.AdminLoginLayout);

        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        /// First clickable span
        SpannableString ss1 = new SpannableString("Admin Register");

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View textView1) {
                Intent intent1 = new Intent(AdminLoginActivity.this, AdminRegisterActivity.class);
                startActivity(intent1);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };

        ss1.setSpan(clickableSpan1, 6, 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView textView = (TextView) findViewById(R.id.AdminReg_ClickableTextView);
        textView.setText(ss1);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        textView.setHighlightColor(Color.TRANSPARENT);

        ///Admin Login
        AdminLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminLoginActivity.this, AdminMainActivity.class);

                startActivity(intent);
            }
        });
    }


    public void LoginClick(View V) {
        String email = AdminLEmail.getText().toString().trim();
        String password = AdminLPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)) {
            AdminLEmail.setError("Email is Required");
            return;
        }
        if(TextUtils.isEmpty(password)){
            AdminLPassword.setError("Password is Required");
            return;
        }
        if(password.length() < 6){
            AdminLPassword.setError("Password must be longer than 6 characters");
            return;
        }
        Log.d("LoginClick", "LoginClick: email" +email);
        Log.d("LoginClick", "LoginClick: password" +password);

        AdminAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(AdminLoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = AdminAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(AdminLoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}