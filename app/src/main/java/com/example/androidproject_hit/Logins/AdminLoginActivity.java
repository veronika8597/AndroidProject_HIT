package com.example.androidproject_hit.Logins;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidproject_hit.R;
import com.example.androidproject_hit.TrainingType;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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

        AdminLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                Intent intent = new Intent(AdminLoginActivity.this, .class);
                startActivity(intent);*/
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