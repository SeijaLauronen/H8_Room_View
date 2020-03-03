package com.example.ssl_h8_roomview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

//public class AdapterFrag2 extends ArrayAdapter<String> {
public class AdapterFrag2 extends ArrayAdapter<LiveData<List<RWEntity>>>{
    private Context context;
    //ArrayList<String> arraylist; //ArrayList onko eri kuin datasetti??
    //ArrayList<RWEntity> arraylist; //menikö  nyt sinne tietokannan puolelle suoraan
    LiveData<List<RWEntity>> arraylist;

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
