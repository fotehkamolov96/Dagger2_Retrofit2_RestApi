package com.kamolovproducts.dagger2.modleunivers;

import com.google.gson.annotations.SerializedName;

public class UniverModel {

    @SerializedName("name")
    String countryName;
    @SerializedName("description")
    String capital;
    @SerializedName("local")
    String countryLocal;
    @SerializedName("image")
    String image;


    public UniverModel(String countryName, String capital, String image) {
        this.countryName = countryName;
        this.capital = capital;
        this.image = image;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCapital() {
        return capital;
    }

    public String getImage() {
        return image;
    }

}
