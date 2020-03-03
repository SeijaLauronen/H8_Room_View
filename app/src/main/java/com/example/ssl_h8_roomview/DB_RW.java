package com.example.ssl_h8_roomview;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {RWEntity.class}, version =1)
public abstract class DB_RW extends RoomDatabase {
public static final String NIMI="DB_RW";
private static DB_RW instance;
public abstract RWDao rwDao();

    //create singleton = use synchronized
    public static synchronized DB_RW getInstance(Context context){
        if (instance == null){
            //ei käytetä new:ta, koska abstrakti:
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DB_RW.class, NIMI) //Tämän luokka
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsyncTask(instance).execute();
        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void,Void> {
        private RWDao rwDao;
        private PopulateDBAsyncTask(DB_RW db){
            rwDao=db.rwDao();
        }
        //Ctrl + O tai ala kirjoittaa doing
        @Override
        protected Void doInBackground(Void... voids) {
            RWEntity rwEntity = new RWEntity();
            rwEntity.teksti ="Teksti EKA";
            //rwDao.InsertTaulu(new RWEntity() //ei voinut tehdä tähän suoraan, kun ei taida olla gettereitä ja settereitä
            rwDao.InsertTaulu(rwEntity);
            return null;
        }
    }





}
