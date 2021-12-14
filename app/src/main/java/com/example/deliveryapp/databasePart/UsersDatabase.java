package com.example.deliveryapp.databasePart;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Users.class},version = 1,exportSchema = false)
public abstract class UsersDatabase extends RoomDatabase{

    public  abstract com.example.deliveryapp.databasePart.DeliveryAppDAO DeliverAppDAO();

}
