package com.aavdeev.capitalandproglang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class CarBrandActivity extends Activity {

    private BrandCar brandList = new BrandCar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_brand);
    }

    public void onClickBrandCar(View view) {

        TextView brands = findViewById(R.id.viewBrand);
        Spinner country = findViewById(R.id.spiner_country);
        String type = String.valueOf(country.getSelectedItem());

        List<String> car = brandList.getBrandCar(type);
        StringBuilder stringBuilder = new StringBuilder();

        for (String carList : car) {
            stringBuilder.append(carList).append("\n");
        }

        brands.setText(stringBuilder);
    }
}
