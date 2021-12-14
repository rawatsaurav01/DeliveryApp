package com.example.deliveryapp.layoutFiles;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.deliveryapp.R;
import com.example.deliveryapp.layoutFiles.MainPage;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler h=new Handler();
        //syntax of postDelayed(runnable class,delay time)
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(getApplicationContext(), LoginPage.class);
                startActivity(i);
                finish();
            }
        },3000);

    }
}