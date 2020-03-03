package com.example.ssl_h8_roomview;
//https://www.youtube.com/watch?v=JLwW5HivZg4&t=322s OSA 5

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

//ViewModelista yhteys UI:hin
//VieModelista pitää saada yhteys repositoryyn

public class Fragmentti2ViewModel extends AndroidViewModel {

    private RWRepository rwRepository;
    private LiveData<List<RWEntity>> listRWLiveData; //1.3.2020 lisätty private


    public Fragmentti2ViewModel(@NonNull Application application) {
        super(application);
        this.rwRepository = new RWRepository(application);
        this.listRWLiveData =rwRepository.haeRWLista();
    }
    // TODO: Implement the ViewModel


    public LiveData<List<RWEntity>> getListRWLiveData() {
        return listRWLiveData;
    }
}
