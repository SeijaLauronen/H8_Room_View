package com.example.ssl_h8_roomview;

import androidx.lifecycle.LiveData;
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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Fragmentti2 extends Fragment {

    private Fragmentti2ViewModel mViewModel;

    //10.3.2020 kuva 48
    ListView listView;
    ArrayAdapter<String> stringArrayAdapter;



    private LiveData<List<RWEntity>> fraglistRWLiveData; //9.3.2020 tästä en kyllä yhtään tiedä, että tämäkö tänne näin???

    public static Fragmentti2 newInstance() {
        return new Fragmentti2();
    }

    public Fragmentti2() {
        // Required empty public constructor //9.3.2020 lisätty tämä, tarvitseekohan myös silloin kuin ole interfacea?
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragmentti2_fragment, container, false);
        //10.3.2020 kuva 48
        View v = inflater.inflate(R.layout.fragmentti2_fragment, container, false);

        //this.listView=v.findViewById(R.id.listView);

        //kuva 51: siinä android.R.id... miksi ei ota minulla?
        /*
        stringArrayAdapter =new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.id.textViewListItem);
        listView.setAdapter(stringArrayAdapter);
        */
        /*
        AdapterFrag2 adapterFrag2 = new AdapterFrag2(getActivity().getApplicationContext(),R.id.textViewListItem);
        listView.setAdapter(adapterFrag2);
        */
        //ÄH, eikö se listview ole jo tuolla AdapterFrag2:ssa laitettu...
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Videon 6 loppupuolelta, liekö ok
        //AdapterFrag2 adapterFrag2 = new AdapterFrag2(); // tuonnekohan pitäisi saada Livedata...+
        //AdapterFrag2 adapterFrag2 = new AdapterFrag2(getContext(),this, fraglistRWLiveData)
       //TODO: MITÄ TÄHÄN PITÄÄ KIRJOITTAA??  AdapterFrag2 adapterFrag2 = new AdapterFrag2(this.getContext(),1,fraglistRWLiveData);

        //mViewModel = ViewModelProviders.of(this).get(Fragmentti2ViewModel.class);
        // TODO: Use the ViewModel
        //mViewModel = new ViewModelProvider(this).get(Fragmentti2ViewModel.class);// 9.3.2020 vaihdetaan tuo this getActivityyn:
        mViewModel = new ViewModelProvider(getActivity()).get(Fragmentti2ViewModel.class); //videolla 7 alussa selitettiin, miksi tämä parempi kun on fragmentti
        //mViewModel.getListRWLiveData().observe(this, new Observer<List<RWEntity>>() {
        //huom, fragmentissa ei voi laitta this, vaan getViewLifecycleOwner
        mViewModel.getListRWLiveData().observe(getViewLifecycleOwner(), new Observer<List<RWEntity>>() {
            @Override
            public void onChanged(List<RWEntity> rwEntities) {
                //TODO päivitä View

                Toast.makeText(getActivity(), "onChanged FR2", Toast.LENGTH_SHORT).show();

            }
        });


    }

}
