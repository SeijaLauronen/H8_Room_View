package com.example.ssl_h8_roomview;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Fragmentti1 extends Fragment {

    private Button buttoni;
    private TextView textView; //editText?

    private Fragmentti1ViewModel mViewModel;

    public static Fragmentti1 newInstance() {
        return new Fragmentti1();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragmentti1_fragment, container, false);
        View v = inflater.inflate(R.layout.fragmentti1_fragment, container, false);
        //ennenkuin piirretään, otetaan kiinni komponentit, joita käytettään:editTektit ja buttonit.
        return  v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = ViewModelProviders.of(this).get(Fragmentti1ViewModel.class);//Katso tämä materiaalista
        //gradlen lifecyle kandee laittaa viimesimpään versioon.
        //implementation 'androidx.lifecycle:lifecycle-extensions:2.0.0' --> 2.2.0
        //'androidx.appcompat:appcompat:1.0.2'
        //androidTestImplementation 'androidx.test.ext:junit:1.1.0'
        //    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.1'

        // TODO: Use the ViewModel
//mViewModel.listRWLiveData.observe();

        mViewModel = new ViewModelProvider(this).get(Fragmentti1ViewModel.class);

        //ei voinut viitata tulleesti listRWLiveData:an, johtuiko ViewProviderin muuttamiseta?
        /*
        mViewModel.listRWLiveData.observe(getViewLifecycleOwner(), new Observer<List<RWEntity>>() {
            @Override
            public void onChanged(List<RWEntity> rwEntities) {

            }
        }); //huom täällä vasta observen loppusulku )
       */
        //Kts kommentit fragmentti2:sta:
        mViewModel.getListRWLiveData().observe(getViewLifecycleOwner(), new Observer<List<RWEntity>>() {
            @Override
            public void onChanged(List<RWEntity> rwEntities) {
                //TODO päivitä view
                //No miten pitää Toasti laittaa fragmentissa??!!
                //Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
                //Toast.makeText(Fragmentti1.this, "onChanged", Toast.LENGTH_SHORT).show();
                // Täältä vinkki: https://stackoverflow.com/questions/10770055/use-toast-inside-fragment
                Toast.makeText(getActivity(), "onChanged FR1", Toast.LENGTH_SHORT).show();

            }
        });

    }

}
