package com.example.carbooking.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.annotation.NonNull;
import android.widget.TextView;

import com.example.carbooking.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Car extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mReferencecar;

    private TextView name;
    private TextView price;
    private TextView pers;
    private TextView doors;
    private TextView rate;
    private TextView availability;

    private String currentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        mAuth = FirebaseAuth.getInstance();
        currentId = mAuth.getCurrentUser().getUid();

        mReferencecar = FirebaseDatabase.getInstance().getReference("Cars").child(currentId);

        name = (TextView) findViewById(R.id.btncarname);
        price = (TextView) findViewById(R.id.btnprice);
        pers = (TextView) findViewById(R.id.btnnb_pers);
        doors = (TextView) findViewById(R.id.btndoors);
        rate = (TextView) findViewById(R.id.btnrate);
        availability = (TextView) findViewById(R.id.btnavailability);

        mReferencecar.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    String carname = dataSnapshot.child("carname").getValue().toString();
                    String caravailability = dataSnapshot.child("availability").getValue().toString();
                    String nbdoors = dataSnapshot.child("nbdoors").getValue().toString();
                    String nbpers = dataSnapshot.child("nbpers").getValue().toString();
                    String carprice = dataSnapshot.child("price").getValue().toString();
                    String carrate = dataSnapshot.child("rate").getValue().toString();


                    name.setText("Car name : " + carname);
                    availability.setText("Availability : " + caravailability);
                    price.setText("Price : " + carprice);
                    rate.setText("Rate : " + carrate);
                    doors.setText("Nombre of doors : " + nbdoors);
                    pers.setText("Nombre of persons : " + nbpers);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
}}
