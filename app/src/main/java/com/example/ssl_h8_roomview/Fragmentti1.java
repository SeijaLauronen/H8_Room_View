package com.example.ssl_h8_roomview;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
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

    public interface IFragmentti1 { //8.3.2020
        void onButtonPressed(CharSequence inputTxt); //10.3.2020 lisäsin tuon inputTekstin tuohon
    }
    private IFragmentti1 mListener; //8.3.2020
    public Fragmentti1() {
        // Required empty public constructor //9.3.2020 lisätty tämä, auttaako kaatumisiin? AUTTAAAAA
    }

    private Fragmentti1ViewModel mViewModel;

    public static Fragmentti1 newInstance() {
        return new Fragmentti1();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragmentti1_fragment, container, false);
        View v = inflater.inflate(R.layout.fragmentti1_fragment, container, false); //miksi kaatuu jo tässä
        //ennenkuin piirretään, otetaan kiinni komponentit, joita käytettään:editTektit ja buttonit.

        textView = v.findViewById(R.id.inputti);
        buttoni =v.findViewById(R.id.nappi);

        buttoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CharSequence inputTxt = textView.getText();
                mListener.onButtonPressed(inputTxt); //KAATUU jos painaa nappia, ei kaadu enää
                //laitetaankohan save tänne vai välitetäänkö kenties tuo teksti täältä mainlayoutille?
            }
        });


        return  v;
    }

// 9.3.2020 5harjoitustouhu perusteella tämä. tuli runko automatic, kun alkoi kirjoittaa onAt
    //JAAHAS; TÄMÄ KAATAA, laitetaan kommentteihin. Lakkasi kaatumasta kun teki tuon tyhjän konstruktorin!!!!

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context); // 9.3.2020 kaatuu tässä
        if (context instanceof IFragmentti1){
            mListener = (IFragmentti1) context;
        }else {

            throw new RuntimeException(context.toString()
                    + " must implement IFragmentti1");
        }
    }

    //9.3.2020 laitoin varalta tämänkin, 5harjoitustouhu mallin mukaan
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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

        //mViewModel = new ViewModelProvider(this).get(Fragmentti1ViewModel.class); //tälleesti oli videoon 7 asti.
        mViewModel = new ViewModelProvider(getActivity()).get(Fragmentti1ViewModel.class); //videolla 7 laussa selitettiin, miksi tämä parempi un fragmentti
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
