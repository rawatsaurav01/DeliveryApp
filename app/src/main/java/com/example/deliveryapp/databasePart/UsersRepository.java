package com.example.deliveryapp.databasePart;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.room.Room;

import java.util.List;

public class UsersRepository {

    private  String DB_NAME="myntraShoppingdb";

    private UsersDatabase usersDatabase;
    Context context;

    public UsersRepository(Context context) {
        this.context = context;
        usersDatabase= Room.databaseBuilder(context,UsersDatabase.class,DB_NAME).build();

    }

    //=============INSERT TASK STARTED============
    public void InsertTask(final Users users){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                usersDatabase.DeliverAppDAO().insertTask(users);
                return null;
            }

            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                Toast.makeText(context,users.user_name+"is Inserted",Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }
    //=============INSERT TASK ENDED==============

    //=============Get data task starts===========

    public List<Users>getUsers(){
        List<Users>usersList=usersDatabase.DeliverAppDAO().getAll();
        return usersList;
    }

    //=============Get data task ends===========
}
