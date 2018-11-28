package com.mjm.countrycodepicker;

import java.io.Serializable;

/**
 * Created by MJM PC on 1/7/2018.
 */
public class CountriesPOJO implements Serializable {

    private String name;
    private String code;
    private String phoneCode;
    private int flag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }
}
