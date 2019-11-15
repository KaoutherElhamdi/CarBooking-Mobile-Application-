package com.example.carbooking.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carbooking.Models.User;
import com.example.carbooking.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase;

    private EditText email, password,firstname,lastname,phone;
    private Button signup;
    private DatabaseReference fnameRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // Initialize Firebase Database
        mDatabase = FirebaseDatabase.getInstance();


        email= (EditText) findViewById(R.id.emailSI);
        password = (EditText) findViewById(R.id.password);
        signup = (Button) findViewById(R.id.btnSignUp2);
        firstname = (EditText) findViewById(R.id.fname);
        lastname = (EditText) findViewById(R.id.lname);
        phone = (EditText) findViewById(R.id.phone);

        signup.setOnClickListener(this);
        //mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.btnSignUp2).setOnClickListener(this);

        fnameRef = mDatabase.getReference("Users");

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSignUp2){

            mAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        //Toast.makeText(Signup.this,"Successfully registred", Toast.LENGTH_LONG).show();
                        Toast.makeText(Signup.this,mAuth.getCurrentUser().getEmail(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Signup.this, Signin.class);
                        //intent.putExtra("email","salut");
                        startActivity(intent);

                        savefName(mAuth.getCurrentUser().getUid());
                        finish();
                    }
                    else{
                        Toast.makeText(Signup.this,"error", Toast.LENGTH_LONG).show();

                    }
                }

            });



    }
}

    private void savefName(String uid) {
        User user = new User();

        user.setEmail(email.getText().toString());
        user.setfName(firstname.getText().toString());
        user.setlName(lastname.getText().toString());
        user.setPhone(phone.getText().toString());
        /*fnameRef.child(uid).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Signup.this,mAuth.getCurrentUser().getEmail(), Toast.LENGTH_LONG).show();
                }
            }*/
        fnameRef.child(mAuth.getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(Signup.this, mAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }}