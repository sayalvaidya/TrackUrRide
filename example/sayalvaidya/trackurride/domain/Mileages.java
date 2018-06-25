package com.example.sayalvaidya.trackurride.domain;

/**
 * Created by sayalvaidya on 5/1/17.
 */

public class Mileages {
    int V_ID;
    String Initial_km;
    String Final_km;
    String refulled_quantity;
    String Mileage;

    public int getV_ID() {
        return V_ID;
    }

    public void setV_ID(int v_ID) {
        V_ID = v_ID;
    }

    public String getRefulled_quantity() {
        return refulled_quantity;
    }

    public void setRefulled_quantity(String refulled_quantity) {
        this.refulled_quantity = refulled_quantity;
    }

    public String getInitial_km() {
        return Initial_km;
    }

    public void setInitial_km(String initial_km) {
        Initial_km = initial_km;
    }

    public String getFinal_km() {
        return Final_km;
    }

    public void setFinal_km(String final_km) {
        Final_km = final_km;
    }

    public String getMileage() {
        return Mileage;
    }

    public void setMileage(String mileage) {
        Mileage = mileage;
    }
}