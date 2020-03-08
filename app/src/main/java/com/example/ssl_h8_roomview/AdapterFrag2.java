package com.example.ssl_h8_roomview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

//tämä on eri lailla kuin videon esimerkissä...

//public class AdapterFrag2 extends ArrayAdapter<String> {
public class AdapterFrag2 extends ArrayAdapter<LiveData<List<RWEntity>>>{
//public class AdapterFrag2 extends AdapterView<AdapterFrag2.AdapterFrag> { //videolla extends recylerView.Adapter
    private Context context;
    //ArrayList<String> arraylist; //ArrayList onko eri kuin datasetti??
    //ArrayList<RWEntity> arraylist; //menikö  nyt sinne tietokannan puolelle suoraan
    LiveData<List<RWEntity>> arraylist;

    //tämä on video esimerkissä nimetty Holderiksi... ja tänne on mäpätty ne R.id...
    public AdapterFrag2(@NonNull Context context, int resource,@NonNull List objects){
        super(context, resource, objects);
        this.context=context;
        //this.arraylist = (ArrayList<String>)objects;
        //this.arraylist = (ArrayList<RWEntity>)objects; //menikö tämä nyt jo datan puolelle...?
        this.arraylist = (LiveData<List<RWEntity>>)objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.list_item,parent,false);//Tällä yhdistettän adapteri listaan (xml-tiedoston nimi)
        LinearLayout linearLayout = (LinearLayout) v; //tällä muutetaan hyppysissä olevan view:n tyyppi vastaamaan layoutin todellista tyyppiä (?)
        TextView listItem = v.findViewById(R.id.textViewListItem); //yksittäinen listan rivi
        //listItem.setText(arraylist.get(position).
        //listItem.setText(arraylist.observe(););
        //Kaikki data on ViewModelissa...?? sen kun saisi jotenkin tähän...
        //listItem.setText(arraylist.observe();

        return v;

    }
}
