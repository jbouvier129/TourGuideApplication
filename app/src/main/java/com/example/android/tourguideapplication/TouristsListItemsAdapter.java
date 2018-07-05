package com.example.android.tourguideapplication;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TouristsListItemsAdapter extends ArrayAdapter<TouristItemsClass>{

    private int mColorResourceId;
    private int mAltTextColor;

    /*
    Adapter that accepts information from the fragments to create the displayed view and set attributes.
     */
    public TouristsListItemsAdapter(Context context, ArrayList<TouristItemsClass> tourItems, int colorResourceId, int altTextColor) {
        super(context, 0, tourItems);
        mColorResourceId = colorResourceId;
        mAltTextColor = altTextColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        /*
        gets and sets the various view information and color attributes in the list item based on
        information in the Array List from the active fragment
         */
        TouristItemsClass currentViewItem = getItem(position);

        TextView placeNameTextView = listItemView.findViewById(R.id.place_name);
        placeNameTextView.setText(currentViewItem.getPlaceNameId());

        TextView placeAddressTextView = listItemView.findViewById(R.id.place_address);
        placeAddressTextView.setText(currentViewItem.getPlaceAddressId());

        TextView placePhoneNumberTextView = listItemView.findViewById(R.id.place_phone_number);
        placePhoneNumberTextView.setText(currentViewItem.getPlacePhoneNumberId());

        ImageView imageView = listItemView.findViewById(R.id.place_image);

        imageView.setImageResource(currentViewItem.getPlaceImageId());

        View viewContainer = listItemView.findViewById(R.id.list_item_container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        viewContainer.setBackgroundColor(color);

        int textColor = ContextCompat.getColor(getContext(), mAltTextColor);
        placeAddressTextView.setTextColor(textColor);
        placeNameTextView.setTextColor(textColor);
        placePhoneNumberTextView.setTextColor(textColor);

        return listItemView;
    }
}
