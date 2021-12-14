package com.example.deliveryapp.layoutFiles;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deliveryapp.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    Context context;
    ArrayList<ItemDetails> list;

    public RecyclerAdapter(Context context, ArrayList<ItemDetails> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.recycler_view_item,parent,false);

        return new MyViewHolder(v);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerAdapter.MyViewHolder holder, int position) {

        ItemDetails itemDetails= list.get(position);
        System.out.println("The Item Value is..."+list.get(position));
        Log.i("info","sr :");
        Log.i("info",""+itemDetails);
        if(itemDetails!=null) {
            holder.foodName.setText(itemDetails.getFoodName());
            holder.shopName.setText(itemDetails.ShopName());
            holder.price.setText(itemDetails.getPrice());
//            Log.i("info", "sr2 :");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView foodName,shopName,price;


        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            cv=itemView.findViewById(R.id.cv1);
            foodName=itemView.findViewById(R.id.foodName);
            shopName=itemView.findViewById(R.id.shopName);
            price=itemView.findViewById(R.id.price);

        }
    }
}
