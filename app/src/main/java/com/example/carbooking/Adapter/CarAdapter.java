package com.example.carbooking.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carbooking.Activities.Car;
import com.example.carbooking.Activities.MainActivity;
import com.example.carbooking.Models.CarModel;
import com.example.carbooking.R;


import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarViewHolder>  {
    //implements View.OnClickListener

    private Context context;
    private List<CarModel> carList;

    public CarAdapter(List<CarModel> apiObjects){
        this.carList =  apiObjects;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new CarViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder carViewHolder, int i) {
        CarModel car = carList.get(i);
        carViewHolder.carName.setText(car.getCarname());
        carViewHolder.price.setText(car.getPrice()+"");
        //carViewHolder.btn0.setOnClickListener(this);

        carViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, Car.class);
                context.startActivity(in);
            }
        });


//        userViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                onItemClickListener.onLongClick(user.getId());
//                return false;
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }


   /* @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btn0) {
            Intent intent = new Intent(CarViewHolder.this, Car.class);
            startActivity(intent);
    }*/
}
