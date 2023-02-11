package com.example.androidproject_hit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Users.Admin;
import Users.Customer;

public class AdminRegisterActivity extends AppCompatActivity {

    private FirebaseAuth adminAuth;
    EditText aEmail, aPassword, aFname, aLname, aToken;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);

        ConstraintLayout constraintLayout = findViewById(R.id.activity_admin_register);

        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();


        aEmail = findViewById(R.id.AdminReg_email_TextInput);
        aPassword= findViewById(R.id.AdminReg_password_TextInput);
        aFname= findViewById(R.id.AdminReg_Fname_TextInput);
        aLname= findViewById(R.id.AdminReg_Lname_TextInput);
        aToken= findViewById(R.id.AdminReg_token_TextInput);

        Register = findViewById(R.id.AdminReg_RegisterButton);
        adminAuth = FirebaseAuth.getInstance();



    }

    public View ButtonRegister(View view) {

        final String email = aEmail.getText().toString();
        final String password = aPassword.getText().toString();
        final String firstName = aFname.getText().toString();
        final String lastName = aLname.getText().toString();
        final String token = aToken.getText().toString();


        if (TextUtils.isEmpty(email)){
            Toast.makeText( AdminRegisterActivity.this,"Enter email", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText( AdminRegisterActivity.this,"Enter password", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(firstName)){
            Toast.makeText( AdminRegisterActivity.this,"Enter first name", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(lastName)){
            Toast.makeText( AdminRegisterActivity.this,"Enter last name", Toast.LENGTH_SHORT).show();
        }
        else if (!token.equals("ADMIN123")){
            Toast.makeText( AdminRegisterActivity.this,"Token incorrect! If you're not an Admin please return to the User registration", Toast.LENGTH_SHORT).show();
        }
        else if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName)){
            adminAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = adminAuth.getCurrentUser();
                                assert user != null;
                                String uid = user.getUid();

                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference myRef = database.getReference("Customer").child(uid);

                                Admin admin = new Admin(email,firstName,lastName, password, token,1);
                                myRef.setValue(admin);
                                Toast.makeText(AdminRegisterActivity.this, "Register Success.",
                                        Toast.LENGTH_SHORT).show();

                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(AdminRegisterActivity.this, "Register failed.",
                                        Toast.LENGTH_SHORT).show();
                            }

                        }

                    });

        }

        return view;
    }
}