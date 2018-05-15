package com.aavdeev.capitalandproglang;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class BrandsFactory {

    private BrandsFactory() { }

    // since class has no fields, so it is stateless
    @NonNull
    static List<String> getCarBrands(@NonNull String country) {
        List<String> brands = new ArrayList<>();
        switch (country) {
            case "USA":
                brands.add("Ford");
                brands.add("Chevrolet");
                brands.add("Jeep");
                break;
            case "GERMANY":
                brands.add("BMW");
                brands.add("Mercedes");
                brands.add("Audi");
                break;
            case "ITALY":
                brands.add("Ferrari");
                brands.add("Lamborghini");
                break;
            default:
                break;
        }
        return brands;
    }
}
