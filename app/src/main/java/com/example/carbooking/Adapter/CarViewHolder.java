package com.example.carbooking.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.carbooking.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class CarViewHolder extends RecyclerView.ViewHolder  {
    //public Button btn0;
    public TextView carName;
    public TextView price;
    public CarViewHolder(@NonNull View itemView) {
        super(itemView);
        carName = (TextView) itemView.findViewById(R.id.car_name);
        price = (TextView) itemView.findViewById(R.id.car_price);
        //btn0 = (Button) itemView.findViewById(R.id.btn0);
    }
}