package com.example.sayalvaidya.trackurride.domain;

/**
 * Created by sayalvaidya on 5/1/17.
 */

public class Services {
    int S_ID;
    String Servicing_date;
    String Initial_km_S;
    String Final_km_S;
    String Serviced_date;
    String Notes;

    public int getS_ID() {
        return S_ID;
    }

    public void setS_ID(int s_ID) {
        S_ID = s_ID;
    }

    public String getServicing_date() {
        return Servicing_date;
    }

    public void setServicing_date(String servicing_date) {
        Servicing_date = servicing_date;
    }

    public String getInitial_km_S() {
        return Initial_km_S;
    }

    public void setInitial_km_S(String initial_km_S) {
        Initial_km_S = initial_km_S;
    }

    public String getFinal_km_S() {
        return Final_km_S;
    }

    public void setFinal_km_S(String final_km_S) {
        Final_km_S = final_km_S;
    }

    public String getServiced_date() {
        return Serviced_date;
    }

    public void setServiced_date(String serviced_date) {
        Serviced_date = serviced_date;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
}

