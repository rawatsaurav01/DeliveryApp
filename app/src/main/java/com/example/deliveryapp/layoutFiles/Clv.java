package com.example.deliveryapp.layoutFiles;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.deliveryapp.R;

import java.util.ArrayList;

public class Clv extends ArrayAdapter {
    Context cx;
    ArrayList <ItemDetails> al=new ArrayList();
    TextView tv1,tv2;
    ImageView iv1;
    Button b;
    int res;
    public Clv(@NonNull Context context, int resource, ArrayList al) {
        super(context, resource, al);
        cx=context;
        this.al=al;
        this.res=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater li=LayoutInflater.from(cx);

        View v=super.getView(position, convertView, parent);
        tv1=v.findViewById(R.id.itemName1);
        tv2=v.findViewById(R.id.shopName1);
        b=v.findViewById(R.id.deleteIcon);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //alert dialogue should get open to confirm if you want to confirm delete
                AlertDialog.Builder b=new AlertDialog.Builder(cx);
                b.setTitle("Are you sure ?");
                b.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        al.remove(position);
                        notifyDataSetChanged();
                    }
                });
                b.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog ab=b.create();
                ab.show();
            }
        });
        return v;
    }

}
