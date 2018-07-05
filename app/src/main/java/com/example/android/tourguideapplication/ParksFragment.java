package com.example.android.tourguideapplication;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ParksFragment extends Fragment {


    public ParksFragment() {
        // Required empty public constructor
    }

    /*
    creates view using the layout
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tourism_list, container, false);

        /*
        Creates a new array list with information pertaining to the parks
         */
        final ArrayList<TouristItemsClass> tourItems = new ArrayList<>();

        tourItems.add(new TouristItemsClass(R.string.park_one_name, R.string.park_one_address, R.string.park_one_phone_number, R.drawable.jefferson_memorial_forest, R.string.park_one_web));
        tourItems.add(new TouristItemsClass(R.string.park_two_name, R.string.park_two_address, R.string.park_two_phone_number, R.drawable.bernheim_forest, R.string.park_two_web));

        /*
        creates the list view by passing information from the fragment to the adapter
         */
        TouristsListItemsAdapter adapter = new TouristsListItemsAdapter(getActivity(), tourItems, R.color.parksColor, R.color.altTextColor);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        /*
        click listener to determine the position of the selected item and launch the appropriate web
        page with more information for the selected park
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int webLink = tourItems.get(position).getPlaceWebId();
                String url = ParksFragment.this.getString(webLink);
                Intent webGo = new Intent(Intent.ACTION_VIEW);
                webGo.setData(Uri.parse(url));
                getActivity().startActivity(webGo);
            }
        });

        return rootView;
    }
}
