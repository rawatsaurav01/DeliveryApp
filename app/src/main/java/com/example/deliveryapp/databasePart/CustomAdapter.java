package com.example.deliveryapp.databasePart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deliveryapp.Fragments.Home;
import com.example.deliveryapp.R;

import java.util.ArrayList;
//================myViewHolder starts======================

public class CustomAdapter extends  RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<Users> dataset;
    Class<Home> context;


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvId,tvUsername,tvContactNo,tvGender;
        Button btnTitle;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvId=itemView.findViewById(R.id.tvId);
            this.tvUsername=itemView.findViewById(R.id.tvUsername);
            this.tvContactNo=itemView.findViewById(R.id.tvContactNo);
            this.tvGender=itemView.findViewById(R.id.tvGender);
            this.btnTitle=itemView.findViewById(R.id.btnTitle);
        }
    }
    //================myViewHolder ends======================

    public CustomAdapter(ArrayList<Users>dataset, Class<Home> context){
        this.dataset=dataset;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_student,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TextView tvId=holder.tvId;
        TextView tvUsername=holder.tvUsername;
        TextView tvContactNo=holder.tvContactNo;
        TextView tvGender=holder.tvGender;
        Button btnTitle=holder.btnTitle;

        tvId.setText(dataset.get(position).id+"");
        tvUsername.setText(dataset.get(position).user_name+"");
        tvContactNo.setText(dataset.get(position).contactNo+"");
        tvGender.setText(dataset.get(position).gender+"");
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}

