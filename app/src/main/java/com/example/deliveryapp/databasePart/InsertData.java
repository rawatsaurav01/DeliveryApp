package com.example.deliveryapp.databasePart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.deliveryapp.R;

public class InsertData extends AppCompatActivity {

    Button btnInsert,btnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        btnInsert=findViewById(R.id.btnInsert);
        btnView=findViewById(R.id.btnView);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(InsertData.this, com.example.deliveryapp.databasePart.insertActivity.class);
                startActivity(i);
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(InsertData.this, com.example.deliveryapp.Fragments.Home.class);
                startActivity(i);
            }
        });
//        UsersRepository usersRepository=new UsersRepository(getApplicationContext());
    }
}