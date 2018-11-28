package com.mjm.countrycodepicker;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by MJM PC on 1/8/2018.
 */
public class AutoDetectCountry {

    private static final String TAG = "AutoDetectCountry";
    
    public static CountriesPOJO getCountry(Context context, ArrayList<CountriesPOJO> arrayList){
        CountriesPOJO countriesPOJO;
        String currentCountryIso;// = context.getResources().getConfiguration().locale.getCountry();
//        Log.d(TAG, "setAutoDetectedCountry: localeCountry is" + currentCountryIso);
        // try networkCountryIso
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        //try to get country using Network ISO
        currentCountryIso = telephonyManager.getNetworkCountryIso();
        Log.d(TAG, "setAutoDetectedCountry: networkCountry:" + currentCountryIso);

        //Network ISO can be null if network is not available and phone is not registered to any network. SIM country can be used as other option.
        if (TextUtils.isEmpty(currentCountryIso)) {
            telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            currentCountryIso = telephonyManager.getSimCountryIso();
            Log.d(TAG, "setAutoDetectedCountry: simCountry:" + currentCountryIso);
        }

        //if any of above method found country, then load it.
        if (!TextUtils.isEmpty(currentCountryIso)) {
            Log.d(TAG, "setAutoDetectedCountry: Finally detected country" + currentCountryIso);
            countriesPOJO = Country.getCountryDetails(context, arrayList, currentCountryIso);
        } else {
            Log.d(TAG, "setAutoDetectedCountry:  Could not find the country");
            countriesPOJO = Country.getCountryDetails(context, arrayList, DefaultCountryCode.CODE);
        }

        return countriesPOJO;
    }
}
