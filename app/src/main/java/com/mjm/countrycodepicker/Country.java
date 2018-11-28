package com.mjm.countrycodepicker;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by MJM PC on 1/8/2018.
 */
public class Country {

    public static CountriesPOJO getCountryDetails(Context context, ArrayList<CountriesPOJO> arrayList, String countryIso){
        return getCountry(countryIso, arrayList);
    }

    /**
     * @param countryIso
     * @param arrayList
     * @return
     */
    private static CountriesPOJO getCountry(String countryIso, ArrayList<CountriesPOJO> arrayList){
        for(CountriesPOJO countriesPOJO: arrayList){
            if(countriesPOJO.getCode().toLowerCase().equals(countryIso.toLowerCase())){
                return countriesPOJO;
            }
        }
        return null;
    }
}
