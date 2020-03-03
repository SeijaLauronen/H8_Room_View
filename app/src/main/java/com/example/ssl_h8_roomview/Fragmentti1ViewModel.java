package com.example.ssl_h8_roomview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

//ALT + Entterillä saat konstruktorin
public class Fragmentti1ViewModel extends AndroidViewModel {

    private RWRepository rwRepository;
    private LiveData<List<RWEntity>>  listRWLiveData;
    public Fragmentti1ViewModel(@NonNull Application application) {
        super(application);
        this.rwRepository = new RWRepository(application);
        this.listRWLiveData = rwRepository.haeRWLista();
    }
    // TODO: Implement the ViewModel

    //miksi ei ota tätä!! valittaa default constructorista. Höhö, no unohdin kirjottaa void, niin käsitti luokaksi tms
    public void insert (RWEntity rwEntity){

        rwRepository.insert(rwEntity);
    }

    public void delete (RWEntity rwEntity) {
        rwRepository.delete(rwEntity);
    }

    //tarviikohan tätä tähän fragmenttiin
    public LiveData<List<RWEntity>> getListRWLiveData() {
        return listRWLiveData;
    }
}
