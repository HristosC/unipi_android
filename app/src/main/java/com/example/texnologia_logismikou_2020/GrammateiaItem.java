package com.example.texnologia_logismikou_2020;

public class GrammateiaItem {
    private String mCountryName;
    private int mFlagImage;

    public GrammateiaItem(String countryName, int flagImage) {
        mCountryName = countryName;
        mFlagImage = flagImage;
    }

    public String getCountryName() {
        return mCountryName;
    }

    public int getFlagImage() {
        return mFlagImage;
    }
}
