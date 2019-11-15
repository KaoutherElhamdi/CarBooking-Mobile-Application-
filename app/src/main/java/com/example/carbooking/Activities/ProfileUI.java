 package com.example.carbooking.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.carbooking.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

 public class ProfileUI extends AppCompatActivity {

     private FirebaseAuth mAuth;
     private DatabaseReference mReference;

     private TextView firstname;
     private TextView lastname;
     private TextView email;
     private TextView phone;

     private String currentUserUid;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_profile_ui);

         mAuth = FirebaseAuth.getInstance();
         currentUserUid = mAuth.getCurrentUser().getUid();

         mReference = FirebaseDatabase.getInstance().getReference("Users").child(currentUserUid);

         firstname = (TextView) findViewById(R.id.btnname);
         email = (TextView) findViewById(R.id.btnemail);
         phone = (TextView) findViewById(R.id.btnnumber);
         lastname = (TextView) findViewById(R.id.btnlname);

         mReference.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                 if (dataSnapshot.exists()){
                     String fname = dataSnapshot.child("fName").getValue().toString();
                     String lname = dataSnapshot.child("lName").getValue().toString();
                     String userphone = dataSnapshot.child("phone").getValue().toString();
                     String useremail = dataSnapshot.child("email").getValue().toString();


                     firstname.setText("First name : " + fname);
                     lastname.setText("Last name : " + lname);
                     phone.setText("Phone number : " + userphone);
                     email.setText("Email adress : " + useremail);
                 }


             }

             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }
         });


     }

 }

/*
         mReference.child(currentUserUid).addListenerForSingleValueEvent(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 User tUser = dataSnapshot.getValue(User.class);
                 displayUserData(tUser);
             }

             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }
         });


     }

     private void displayUserData(User user) {
         Utils.localUid = mAuth.getUid();
         firstname.setText(user.getfName());
         email.setText(user.getEmail());
         phone.setText(user.getPhone());
         lastname.setText(user.getlName());

     }
 }*/
