package com.example.android.tourguideapplication;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public TabAdapter (Context context, FragmentManager fm){

        super(fm);
        mContext = context;

    }

    /*
    based on position of the active tab, starts and displays the appropriate fragment
     */
    @Override

    public android.support.v4.app.Fragment getItem (int position){
        if (position == 0) {
            return new HistoricPlacesFragment();
        } else if (position == 1) {
            return new ActivitiesFragment();
        } else if (position == 2) {
            return new RestaurantsFragment();
        } else {
            return new ParksFragment();
        }

    }

    @Override

    public int getCount(){
        return 4;
    }

    /*
    sets the displayed name for each tab
     */
    @Override

    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_historical);
        } else if (position == 1) {
            return mContext.getString(R.string.category_activities);
        } else if (position == 2) {
            return mContext.getString(R.string.category_restaurants);
        } else {
            return mContext.getString(R.string.category_parks);
        }
    }


}
