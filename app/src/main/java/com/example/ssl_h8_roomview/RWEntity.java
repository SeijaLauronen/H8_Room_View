package com.example.ssl_h8_roomview;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rw_taulu")
public class RWEntity {
@PrimaryKey(autoGenerate = true)
public int id;
public String teksti;
}
