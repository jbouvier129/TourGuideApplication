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

public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    /*
    crates view using layout
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tourism_list, container, false);

        /*
        creates an array list with information pertaining to restaurants
         */
        final ArrayList<TouristItemsClass> tourItems = new ArrayList<>();

        tourItems.add(new TouristItemsClass(R.string.restaurant_one_name, R.string.restaurant_one_address, R.string.restaurant_one_phone_number, R.drawable.indis, R.string.restaurant_one_web));
        tourItems.add(new TouristItemsClass(R.string.restaurant_two_name, R.string.restaurant_two_address, R.string.restaurant_two_phone_number, R.drawable.wild_eggs, R.string.restaurant_two_web));
        tourItems.add(new TouristItemsClass(R.string.restaurant_three_name, R.string.restaurant_three_address, R.string.restaurant_three_phone_number, R.drawable.coals_pizza, R.string.restaurant_three_web));
        tourItems.add(new TouristItemsClass(R.string.restaurant_four_name, R.string.restaurant_four_address, R.string.restaurant_one_phone_number, R.drawable.jeff_rubys, R.string.restaurant_four_web));

        /*
        creates the list view by passing information from the fragment to the adapter
         */
        TouristsListItemsAdapter adapter = new TouristsListItemsAdapter(getActivity(), tourItems, R.color.foodsColor, R.color.defaultTextColor);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        /*
        click listener to determine the position of the selected item and launch the appropriate web
        page with more information for the selected restaurant
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int webLink = tourItems.get(position).getPlaceWebId();
                String url = RestaurantsFragment.this.getString(webLink);
                Intent webGo = new Intent(Intent.ACTION_VIEW);
                webGo.setData(Uri.parse(url));
                getActivity().startActivity(webGo);
            }
        });

        return rootView;
    }

}
