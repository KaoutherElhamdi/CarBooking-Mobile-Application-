package com.example.carbooking.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carbooking.Models.User;
import com.example.carbooking.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signin extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase;
    private EditText email, password;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        email= (EditText) findViewById(R.id.emailSI);
        password = (EditText) findViewById(R.id.passwordSI);

        findViewById(R.id.btnSignUp2).setOnClickListener(this);
        findViewById(R.id.btnSI).setOnClickListener(this);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // Initialize Firebase Database
        mDatabase = FirebaseDatabase.getInstance();
        ref = mDatabase.getReference("Users");


    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btnSignUp2) {
            Intent intent = new Intent(Signin.this, Signup.class);
            //intent.putExtra("email","salut");
            startActivity(intent);

        }
        else if(v.getId() == R.id.btnSI){
            /*Intent intent = new Intent(Signin.this,MainActivity.class);
            startActivity(intent);*/
            mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                getUser();
                            } else {
                                Toast.makeText(Signin.this,"Verify your adress or your password", Toast.LENGTH_LONG).show();
                            }

                            // ...
                        }
                    });

        }


    }

    private void getUser() {
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.child(mAuth.getCurrentUser().getUid()).getValue(User.class);
//                Toast.makeText(MainSigninActivity.this, user.Mail, Toast.LENGTH_SHORT).show();
                Intent myIntent;

                myIntent = new Intent(Signin.this, MainActivity.class);


                Signin.this.startActivity(myIntent);
                finish();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
