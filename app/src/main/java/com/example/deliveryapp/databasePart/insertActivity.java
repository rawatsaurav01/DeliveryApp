package com.example.deliveryapp.databasePart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.deliveryapp.R;

public class insertActivity extends AppCompatActivity {
    EditText etId,etUsername,etContactNo,etGender;
    Button btnSubmit;
    String sid,susername,scontactNo,sgender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        etId=findViewById(R.id.id1);
        etContactNo=findViewById(R.id.contactNo);
        etUsername=findViewById(R.id.username);
        etGender=findViewById(R.id.gender);
        btnSubmit=findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etId.getText().toString().isEmpty()
                        ||etUsername.getText().toString().isEmpty()
                        ||etContactNo.getText().toString().isEmpty()
                        ||etGender.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Fill all details",Toast.LENGTH_SHORT).show();
                }
                else{
                    sid=etId.getText().toString().trim();
                    susername=etUsername.getText().toString().trim();
                    scontactNo=etContactNo.getText().toString().trim();
                    sgender=etGender.getText().toString().trim();

                    UsersRepository usersRepository=new UsersRepository(getApplicationContext());
                    Users users=new Users(Integer.parseInt(sid),susername,scontactNo,sgender);
                    usersRepository.InsertTask(users);

                    etId.setText("");
                    etUsername.setText("");
                    etContactNo.setText("");
                    etGender.setText("");

                }
            }
        });
    }
}