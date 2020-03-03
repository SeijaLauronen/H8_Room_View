package com.example.ssl_h8_roomview;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RWDao {
    @Query("Select * from rw_taulu order by id desc")
    LiveData<List<RWEntity>> getAllInDescendingOrder();
    //heti kun rw_taulu:n sisältö muutuu, LiveData päivitää List<RWEntity>:n sisällön, ja aktiviteetille tulee huomautus

    @Insert
    void InsertTaulu(RWEntity rwEntity);
    @Delete
    void DeleteTaulusta(RWEntity rwEntity);

}
