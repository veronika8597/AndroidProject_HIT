package com.example.androidproject_hit;

import static android.app.PendingIntent.getActivity;

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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidproject_hit.Logins.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Users.Customer;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText rEmail, rPassword, rFname, rLname, rPhone, rAge, rWeight, rHeight;
    Spinner rSex;
    Button AgreeAndContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ConstraintLayout constraintLayout = findViewById(R.id.registerTwoLayout);

        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        rEmail = findViewById(R.id.Reg_email);
        rPassword= findViewById(R.id.Reg_password);
        rFname= findViewById(R.id.Reg_Fname);
        rLname= findViewById(R.id.Reg_Lname);
        rPhone = findViewById(R.id.Reg_phone);
        rAge= findViewById(R.id.Reg_age);
        rWeight= findViewById(R.id.Reg_weight);
        rHeight= findViewById(R.id.Reg_height);
        rSex= findViewById(R.id.spinnerSex);

        AgreeAndContinue = findViewById(R.id.Reg_AgreeAndContinue);
        mAuth = FirebaseAuth.getInstance();

        SpannableString ss = new SpannableString("By selecting Agree and continue, I agree to GYMSHARK's Terms of Service and acknowledge the Privacy Policy.");
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Toast.makeText(RegisterActivity.this, "Opens Terms of Service", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Toast.makeText(RegisterActivity.this, "Opens Privacy Policy", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };

        ss.setSpan(clickableSpan1, 53, 72, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(clickableSpan2, 92, 107, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView textView = (TextView) findViewById(R.id.Reg_TermsOfService);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public View ButtonAgreeAndContinue (View view) {

        final String email = String.valueOf(rEmail.getText().toString());
        final String password = String.valueOf(rPassword.getText().toString());
        final String firstName = String.valueOf(rFname.getText().toString());
        final String lastName = String.valueOf(rLname.getText().toString());
        final String phone = String.valueOf(rPhone.getText()).toString();
        final String age = String.valueOf(rAge.getText()).toString();
        final String weight = String.valueOf(rWeight.getText().toString());
        final String height = String.valueOf(rHeight.getText().toString());
        final String sex = String.valueOf(rSex.getSelectedItem().toString());


        if (TextUtils.isEmpty(email)){
            Toast.makeText( RegisterActivity.this,"Enter email", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText( RegisterActivity.this,"Enter password", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(firstName)){
            Toast.makeText( RegisterActivity.this,"Enter first name", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(lastName)){
            Toast.makeText( RegisterActivity.this,"Enter last name", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(phone)){
            Toast.makeText( RegisterActivity.this,"Enter phone number", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(age)){
            Toast.makeText( RegisterActivity.this,"Enter age", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(weight)){
            Toast.makeText( RegisterActivity.this,"Enter weight", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(height)){
            Toast.makeText( RegisterActivity.this,"Enter height", Toast.LENGTH_SHORT).show();
        }else if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName) && !TextUtils.isEmpty(phone) && !TextUtils.isEmpty(age) && !TextUtils.isEmpty(weight) && !TextUtils.isEmpty(height)){
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                assert user != null;
                                String uid = user.getUid();

                                FirebaseDatabase database = FirebaseDatabase.getInstance(); // מביא את החיבור לfirebase
                                DatabaseReference myRef = database.getReference("Customer").child(uid);

                                Customer customer = new Customer(email,firstName,lastName,phone,age,weight,height,sex);
                                myRef.setValue(customer);
                                Toast.makeText(RegisterActivity.this, "Register Success.",
                                        Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(getApplicationContext(),LoginActivity.class));

                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(RegisterActivity.this, "Register failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }

        return view;
    }

/*    public void loadSecondFragment() {

        RegisterTwoFragment fragmentTwo = new RegisterTwoFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.registerTwoLayout, fragmentTwo);
        transaction.commit();
    }*/

}