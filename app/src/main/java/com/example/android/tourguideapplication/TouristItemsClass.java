package com.example.android.tourguideapplication;

public class TouristItemsClass {

    /**
     * String resource ID for the location name
     */
    private int mPlaceNameId;

    /**
     * String resource ID for the lcoation address
     */
    private int mPlaceAddressId;

    /**
     * String resource ID for the location phone number
     */
    private int mPlacePhoneNumberId;

    /**
     * Image resource ID for the location
     */
    private int mPlaceImageId;

    /**
     * String resource id for the location web page
     */
    private int mPlaceWebId;

    /**
     * Create a new TourItemsClass object.
     *
     * @param placeNameId        is the string resource ID for the name associated with this place
     * @param placeAddressId     is the string resource Id for the address associated with this place
     * @param placePhoneNumberId is the resource ID for the phone associated with this place
     * @param placeImageId       is the resource ID for the image associated with this place
     * @param placeWebId         is the resource ID for the web page associated with this place
     */
    public TouristItemsClass(int placeNameId, int placeAddressId, int placePhoneNumberId, int placeImageId, int placeWebId) {
        mPlaceNameId = placeNameId;
        mPlaceAddressId = placeAddressId;
        mPlacePhoneNumberId = placePhoneNumberId;
        mPlaceImageId = placeImageId;
        mPlaceWebId = placeWebId;
    }

    /**
     * Get the string resource ID for the location name
     */
    public int getPlaceNameId() {
        return mPlaceNameId;
    }

    /**
     * Get the string resource ID for the location address
     */
    public int getPlaceAddressId() {
        return mPlaceAddressId;
    }

    /**
     * Get the string resource for the location phone number
     */

    public int getPlacePhoneNumberId(){return mPlacePhoneNumberId;}

    /**
     * Return the image resource ID for the location.
     */
    public int getPlaceImageId() {
        return mPlaceImageId;
    }

    /**
     * Return the string resource for the location web page
     */
    public int getPlaceWebId(){return mPlaceWebId;};

}