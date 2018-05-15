package com.aavdeev.capitalandproglang;

import java.util.ArrayList;
import java.util.List;

public class BrandCar {
    List<String> getBrandCar(String country) {
        List<String> brands = new ArrayList<>();
        if (country.equals("USA")) {
            brands.add("Ford");
            brands.add("Chevrolet");
            brands.add("Jeep");
        }
        if (country.equals("GERMANY")) {
            brands.add("BMW");
            brands.add("Mersedes");
            brands.add("Audi");
        }
        if (country.equals("ITALY")) {
            brands.add("Ferrary");
            brands.add("Lamborginy");
        }
        return brands;
    }
}
