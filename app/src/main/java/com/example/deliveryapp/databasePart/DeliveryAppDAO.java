package com.example.deliveryapp.databasePart;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DeliveryAppDAO {
    @Insert
    long insertTask(Users users);

    @Update
    void updateTask(Users users);

    @Delete
    void delete(Users users);

    @Query("select * from users order by id asc")
    List<Users> getAll();
}
