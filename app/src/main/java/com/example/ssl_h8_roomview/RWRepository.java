package com.example.ssl_h8_roomview;

// https://www.youtube.com/watch?v=HhmA9S53XV8 OSA 4

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.ssl_h8_roomview.DB_RW;
import com.example.ssl_h8_roomview.RWDao;
import com.example.ssl_h8_roomview.RWEntity;

import java.util.List;

public class RWRepository {
private RWDao rwDao;
private LiveData<List<RWEntity>> listRWLiveData;

    public RWRepository(Application application){
        DB_RW db = Room.databaseBuilder(application.getApplicationContext(), DB_RW.class,DB_RW.NIMI).build();//tämä on eri tavalla kuin videossa
        this.rwDao =db.rwDao();
        this.listRWLiveData= rwDao.getAllInDescendingOrder();
    }

    //KTS mitä DAOs:ssa on:
    public LiveData<List<RWEntity>> haeRWLista(){
        return listRWLiveData;
    }
//DataAccesObjekti jää elämään, mutta tietokantaobjektin ei tarvitse jäädä...

    public void insert(RWEntity rwEntity){
        new InsertRWEntityAsyncTask(rwDao).execute(rwEntity);
    }
    public void delete(RWEntity rwEntity){
        new DeleteRWEntityAsyncTask(rwDao).execute(rwEntity);
    }

    private static class InsertRWEntityAsyncTask extends AsyncTask<RWEntity, Void, Void>{
    private RWDao rwDao;
        // 2)
        private InsertRWEntityAsyncTask(RWDao rwDao){
            this.rwDao=rwDao;
        }

        //1) kun alkoi kirjoittaa doing tuli nuo automatic:
        @Override
        protected Void doInBackground(RWEntity... rwEntities) {
            rwDao.InsertTaulu(rwEntities[0]); //3
            return null;
        }
    }

    private static class DeleteRWEntityAsyncTask extends AsyncTask<RWEntity, Void, Void>{
        private RWDao rwDao;
        // 2)
        private DeleteRWEntityAsyncTask(RWDao rwDao){
            this.rwDao=rwDao;
        }

        //1) kun alkoi kirjoittaa doing tuli nuo automatic:
        @Override
        protected Void doInBackground(RWEntity... rwEntities) {
            rwDao.DeleteTaulusta(rwEntities[0]); //3
            return null;
        }
    }

}

