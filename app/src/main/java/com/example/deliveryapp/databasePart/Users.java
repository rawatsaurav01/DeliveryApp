package com.example.deliveryapp.databasePart;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Users {
    @PrimaryKey
    public int id;

    @ColumnInfo(name="user_name")
    public String user_name;

    @ColumnInfo(name="contactNo")
    public String contactNo;

    @ColumnInfo(name="gender")
    public String gender;

    public Users(int id, String user_name, String contactNo, String gender) {
        this.id = id;
        this.user_name = user_name;
        this.contactNo = contactNo;
        this.gender = gender;
    }
}
