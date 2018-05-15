package com.aavdeev.capitalandproglang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

public class CarBrandActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_brand);
    }

    public void onClickBrandCar(View view) {

        TextView brandsView = findViewById(R.id.viewBrand);
        Spinner countryView = findViewById(R.id.spinner_country);
        String typeView = String.valueOf(countryView.getSelectedItem());

        List<String> cars = BrandsFactory.getCarBrands(typeView);
        StringBuilder brandsContent = new StringBuilder();

        Iterator<String> carIterator = cars.iterator();
        while (carIterator.hasNext()) {
            String carBrand = carIterator.next();
            brandsContent.append(carBrand);
            if (carIterator.hasNext()) {
                brandsContent.append("\n");
            }
        }

        brandsView.setText(brandsContent);
    }
}
