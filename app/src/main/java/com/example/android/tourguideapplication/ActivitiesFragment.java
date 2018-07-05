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

public class ActivitiesFragment extends Fragment {


    public ActivitiesFragment() {
        // Required empty public constructor
    }


    /*
    creates view using layout
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tourism_list, container, false);

        /*
        creates new array list to pass activities information to the adapter
         */
        final ArrayList<TouristItemsClass> tourItems = new ArrayList<>();

        tourItems.add(new TouristItemsClass(R.string.activity_one_name, R.string.activity_one_address, R.string.activity_one_phone_number, R.drawable.yum_center, R.string.activity_one_web));
        tourItems.add(new TouristItemsClass(R.string.activity_two_name, R.string.activity_two_address, R.string.activity_two_phone_number, R.drawable.louisville_theater, R.string.activity_two_web));
        tourItems.add(new TouristItemsClass(R.string.activity_three_name, R.string.restaurant_three_address, R.string.activity_three_phone_number, R.drawable.kentucky_kingdom, R.string.activity_three_web));

        /*
        creates list view by passing information from the fragment to the adapter
         */
        TouristsListItemsAdapter adapter = new TouristsListItemsAdapter(getActivity(), tourItems, R.color.activitiesColor, R.color.altTextColor);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        /*
        click listener to determine the position of the selected item and display the appropriate web
        page with more information for the selected activity
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int webLink = tourItems.get(position).getPlaceWebId();
                String url = ActivitiesFragment.this.getString(webLink);
                Intent webGo = new Intent(Intent.ACTION_VIEW);
                webGo.setData(Uri.parse(url));
                getActivity().startActivity(webGo);
            }
        });

        return rootView;
    }

}
